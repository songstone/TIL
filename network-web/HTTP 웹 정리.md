## 웹 브라우저 기본 요청 흐름
1. ex) https://www.naver.com?name=song 으로 요청
2. DNS 서버에서 호스트 조회 -> IP 정보
3. HTTP 요청 메시지 생성
4. SOCKET 라이브러리를 통해 TCP / IP 계층에 전달
5. TCP / IP 계층에서 요청 패킷 생성
6. 요청 패킷 전송
7. 서버에서 데이터 수신 후 응답 패킷 전송
8. 응답 패킷 수신 후 HTML 렌더링

## HTTP 특징
- HyperText Transfer Protocol
- 거의 모든 형태의 데이터를 HTTP로 전송
- TCP : http 1.1, 2 기반 프로토콜
- UDP : http 3 기반 프로토콜

### 클라이언트 서버 구조
- Request, Response 구조
- 클라이언트는 서버에 요청을 보내고 응답을 대기
- 서버는 요청에 대한 결과를 만들어서 응답

### 스테이트리스
- 서버가 클라이언트의 상태 보존 x
- 응답 서버를 쉽게 바꿀 수 있어 서버 증설의 용이

### 비연결성
- HTTP 는 기본적으로 연결을 유지하지 않는 모델
- 서버 자원을 효율적으로 사용 가능
- 매 요청마다 TCP / IP 연결을 새로 맺어야 함, HTML 이외에도 자바스크립트, 이미지 등 도 요청 해야함 -> Persistent Connections를 이용하여 최적화

## HTTP 메시지
- 기본 구조
	- start-line 
	- header
	- empty line(CRLF)
	- message body
- start-line
	- request-line(요청) / status-line(응답)
	- request-line : (HTTP 메서드) (요청 대상{절대경로}) (HTTP 버전)
	- status-line : (HTTP 버전) (HTTP 상태 코드) (안내 메시지)
- header
	- HTTP 전송에 필요한 모든 부가정보
	- header-field : (field-name: OWS field-value) 
	- ex) Content-Type: text/html
- message body
	- 실제 전송할 모든 데이터

## HTTP 메서드
- GET : 리소스 조회
- POST : 요청 데이터 처리, 주로 등록에 사용
- PUT : 리소스를 대체, 해당 리소스가 없으면 생성
- PATCH : 리소스 부분 변경
- DELETE : 리소스 삭제
- HEAD : GET과 동일하지만 메시지 부분을 제외하고 상태 줄과 헤더만 반환
- OPTIONS : 대상 리소스에 대한 통신 가능 옵션(메서드)를 설명. 주로 CORS에서 사용
### HTTP 메서드 속성
- 안전(safe) : 호출해도 리소스 자체가 변경 되지 않는가
- 멱등(idempotent) : 몇 번을 호출하든 결과가 같은가
	- 자동 복구 메커니즘과 연관 -> 다시 호출해도 무방
- 캐시가능(cacheable) : 응답 결과 리소스를 캐시해서 사용해도 되는가
	- GET, HEAD, POST, PATCH 캐시가능
	- 캐시 키 고려 등의 이유로 GET, HEAD 정도만 캐시로 사용
### GET(안전, 멱등, 캐시)
- 리소스 조회
- 서버에 전달할 데이터는 쿼리 스트링을 통해서 전달
- 메시지 바디를 이용해서 데이터를 전달 가능하지만 지원하지 않는 곳이 많아서 권장 x
### POST
- 요청 데이터 처리
- **메시지 바디를 통해 서버로 요청 데이터 전달**
- 주로 신규 리소스 등록, 프로세스 처리
- 다른 메서드로 처리하기 애매한 경우
### PUT(멱등)
- 리소스가 있으면 완전히 대체 없으면 생성
- 리소스 덮어쓰기
### PATCH(멱등)
- 리소스 부분 변경
### DELETE(멱등)
- 리소스 제거

## 데이터 전송(클라이언트 -> 서버)
- 정적 데이터 조회
	- 이미지 등의 단순 정적 데이터
	- 쿼리 파라미터 없이 단순한 리소스 경로로 GET으로 조회
- 동적 데이터 조회
	- 게시판과 같은 데이터에서 정렬, 필터 등의 추가 조건
	- 결과를 줄이기 위해 쿼리 파라미터를 사용해서 GET으로 조회
- HTML Form 태그로 데이터 전송
	- form 태그가 submit 되면 브라우저가 form 태그의 데이터를 기반으로 HTTP 메시지 생성 (Content-Type: application/x-www-form-urlencoded)
	- 파일 데이터 전송 시 form 태그의 enctype으로 Content-Type을 multipart/form-data 로 전송
	- GET, POST 지원
  HTTP API 데이터 전송
  - Content-Type :  application/json 을 주로 사용
  - GET, POST, PUT, PATCH ...

## HTTP API 설계 예시
- 행위 보다는 리소스 자체의 개념이 기준
- 신규 리소스 등록
	- POST 기반
		- 최초 요청 시 클라이언트는 신규 등록될 리소스의 경로를 모른다.
		- 서버가 새로 등록된 리소스 URI를 생성(Location: )
		- 서버가 리소스 디렉토리를 관리 -> Collection
		- 대부분 POST 사용
	- PUT 기반
		- 완전한 리소스 대체
		- 최초 요청 시 클라이언트가 신규 등록될 리소스 URI를 알고 있어야 한다.
		- 클라이언트가 직접 리소스의 URI를 지정
		- 클라리언트가 리소스 저장소를 관리 -> Store
- HTML FORM 사용
	- GET, POST 만 지원
	- 동사로 된 컨트롤 URI 이용