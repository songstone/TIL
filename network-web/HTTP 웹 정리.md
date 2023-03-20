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

## HTTP 상태 코드
- 클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능
- 2xx(Successful) : 클라이언트 요청 성공적으로 처리
	- 200 : OK 성공적으로 수행
	- 201 : Created 요청 성공해서 새로운 리소스 생성
	- 202 : Accepted 요청 접수 되었으나 아직 처리 되지 않음
	- 204 : No Content 성공적으로 요청 수행했으나 응답 페이로드 본문에 보낼 데이터가 없음 ex) 임시 저장
- 3xx(Redirection) : Location 헤더의 경로로 자동으로 리다이렉트
	- 영구 리다이렉션
		- 301 : Moved Permanently 영구적으로 URI 이동됨. 리다이렉트시 요청 메서드가 GET으로 변경되며 본문이 제거될 수 있음
		- 308 : Permanent Redirect 301과 기능 동일, 리다이렉트시 요청 메서드와 분문 그대로 유지
	- 일시적인 리다이렉션
		- 302 : Found 리다이렉트시 요청 메서드가 GET으로 변경, 본문이 제거 될 수 있음
		- 307 : Temporary Redirect 302와 기능 동일, 리다이렉트시 요청 메서드와 본문 유지
		- 303 : See Other 302와 기능 동일, 리다이렉트시 요청 메서드가 GET으로 변경
		- PRG : Post/Redirect/Get Post 새로고침 후 재요청 방지, Post 결과 처리 후 redirect 로 응답 코드를 줘서 GET으로 결과 페이지로 이동
	- 기타 리다이렉션
		- 304 : Not Modified 캐시 목적으로 사용, 리소스가 수정되지 않았으므로 로컬 캐시를 사용해라
- 4xx(Client Error)
	- 오류 원인 클라이언트, 몇 번을 보내도 계속해서 오류
	- 400 : Bad Request 요청 파라미터,  API 스펙이 맞지 않을 때
	- 401 : Unauthorized 인증 되지 않음. 응답에 WWW-Authenticate 헤더와 함께 인증 방법을 설명
	- 403 : Forbidden 서버가 요청을 이해했지만 승인을 거부함. 인증 자격은 있지만 권한이 부족
	- 404 : Not Found 요청 리소스가 서버에 없음
- 5xx(Server Error)
	- 서버 문제로 오류 발생
	- 500 : Internal Server Error 서버 내부 문제로 오류 발생
	- 503 : Service Unavailable 서비스 이용 불가. 서버의 일시적인 과부하

## HTTP 헤더
- field-name: OWS field-value OWS 의 형식
- field-name은 대소문자 구분이 없다.
- HTTP 전송에 필요한 모든 부가정보
- 표현 : 메시지 본문을 포함한 요청이나 응답에서 전달할 실제 데이터
- 메시지 본문 = 페이로드(payload)
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공

### 표현 헤더 : 요청 및 응답 모두 사용
- Content-Type : 표현 데이터의 형식
	- 미디어 타입, 문자 인코딩 ex) text/html;charset=UTF-8, application/json, image/png
- Content-Encoding : 표현 데이터의 압축 방식 
	- 표현 데이터를 압축하기 위해 사용. 보내는 곳에서 압축 후 인코딩 헤더 추가
- Content-Language : 표현 데이터의 자연 언어 ex) ko, en 
- Content-Length : 표현 데이터의 길이(바이트 단위)

### 협상 헤더(콘텐츠 네고시에이션) : 클라이언트가 선호하는 표현 요청(요청에서만 사용)
- 우선 순위(Quality Values) 존재 : 0~1, 클수록 높은 우선 순위 ex) Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8en;q=0.7
- 여러개 적으면 구체적인 것이 우선 순위를 가진다 ex) text/\*, text/html -> text/html 이 우선순위가 높다. 
- Accept : 클라이언트가 선호하는 미디어 타입
- Accept-Charset : 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding : 클라이언트가 선호하는 압축 인코딩
- Accept-Language : 클라이언트가 선호하는 자연 언어

### 전송 방식 헤더
- 단순 전송 : Content-Length 를 알고 있을 때 한번에 요청하고 한번에 받음
- 압축 전송 : Content-Encoding 데이터를 압축해서 전송하고 받는 쪽에서 해당 헤더 정보로 압축을 해제하여 표시
- 분할 전송 : Transfer-Encoding: chunked 쪼개서 전송. **Content-Length 헤더를 넣으면 안된다.**
- 범위 전송 : Content-Range: bytes 1001-2000 / 2000 범위 별로 쪼개서 전송

### 일반 정보 헤더
- From : 유저 에이전트의 이메일 정보. 잘 사용 되지 않음
- Referer : 이전 웹 페이지의 주소. 유입 경로 분석에 주로 사용. 요청에서 사용
- User-Agent : 웹 브라우저 정보 혹은 유저 에이전트 애플리케이션 정보. 브라우저 별 장애 발생 파악에 이용. 요청에서 사용
- Server : 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보. 응답에서 사용
- Date : 메시지가 발생한 날짜와 시간. 응답에서 사용

### 특별 정보 헤더
- Host : 요청한 호스트 정보(도메인). 필수. 요청에서 사용
- Location : 페이지 리다이렉션. 3xx 에서 자동으로 해당 URL 로 리다이렉트. 201 에서 등록한 리소스의 위치를 반환
- Allow : 허용 가능한 HTTP 메서드
- Retry-After : 503에서 언제 까지 불능인지 정보 전달. 날짝 혹은 초단위

### 인증
- Authorization : 클라이언트 인증 정보를 서버에 전달
- WWW-Authenicate : 401 응답과 함께 사용. 리소스 접근시 필요한 정보

### 쿠키
- Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie : 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달
- 쿠키 사용 이유 : HTTP는 stateless 프로토콜이다. 그에 대한 대안
- 웹 브라우저의 쿠키 저장소에 서버에서 발행한 쿠키 저장. 해당 서버로 요청 시 쿠키 저장소에서 무조건 쿠키를 찾아 자동으로 같이 요청
- 사용처
	- 사용자 로그인 후 세션 관리
	- 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송
	- 네트워크 트래픽 추가 유발
	- 최소한의 정보만 사용(세션 id, 인증 토큰)
	- 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지를 이용
- 보안에 민감한 데이터는 저장하지 말자(주민번호, 신용카드 번호 등등)
- 생명 주기 : Expires, max-age
	- Expires : 만료일이 되면 쿠키 삭제
	- max-age : 초단위로 지정. 0이나 음수 지정 시 쿠키 삭제
	- 세션 쿠키 : 만료 날짜 생략 시 브라우저 종료 시 삭제
	- 용속 쿠키 : 만료 날짜 입력 시 해당 날짜 까지 유지
- 도메인 지정 : Domain
	- 명시 : 명시한 문서 기준 도메인 + 서브 도메인까지 포함
	- 생략 : 현재 문서 기준 도메인 에서만 적용, 서브 도메인은 적용 x
- 경로 : Path
	- 이 경로를 포함한 하위 경로 페이지만 쿠키 접근. 주로 root경로 지정
- 보안
	- Secure : https인 경우에만 전송
	- HttpOnly
		- XSS 공격 방지
		- 자바 스크립트에서 접근 불가(document.cookie)
		- HTTP 전송에만 사용
	- SameSite
		- XSRF 공격 방지
		- 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송

### 캐시
- 캐시가 없으면 계속해서 네트워크를 통한 데이터를 다운로드 받아야 한다.
- 인터넷 네트워크는 느리고 비싸다.
- 캐시 발행 **cache-control: max-age=60 -> 캐시가 60초 동안 유효하다.**
- 재요청 시 브라우저 캐시에 저장된 유효한 캐시를 찾는다.
- 유효시간이 초과되면 다시 서버를 통해 데이터 조회하고 캐시 갱신

#### 캐시 유효시간 초과 처리 최적화
- 유효시간이 지난 기존 데이터의 변경 여부를 판단 필요 -> 검증 헤더 이용
- 최초 요청 시 Last-Modified 헤더 지정 -> 캐시 저장 시 같이 캐시에 저장
- 유효기간 초과 후 재 요청시 **if-modified-since** 헤더에 최종 수정일 요청
- 서버에서 검증 하여 데이터 변경 여부 판단하여 변경 되지 않았으면 304 Not Modified 로 응답(HTTP body를 빼고 응답 -> 네트워크 부하 감소)

### 검증 헤더
- 캐시 데이터와 서버 데이터가 같은지 검증하는 데이터
- Last-Modified + If-Modified-Since : 이후에 데이터가 수정 되었나
	- 데이터 미변경 시 : 304 Not Modifed 헤더 데이터만 전송하고 바디 데이터는 미포함
	- 데이터 변경 시 : 200 OK 모든 데이터 전송
	- 1초 미만 단위로 캐시 조정이 불가능
	- 날짜 기반의 로직 사용
	- 수정 날짜가 다르지만 데이터 결과가 같은 경우나 임의의 캐시 로직 관리가 어려움
- ETag + If-None-Match : 캐시에 임의의 고유한 버전 이름을 달기 ex) ETag: "v1.0"
	- 데이터가 변경되면 Hash값 다시 생성
	- 단순히 ETag 만 보낸다
	- if-None-Match 헤더로  ETag 해시값 서버에 조건부 요청

### 캐시 제어 헤더
- Cache-Control: max-age
	- 캐시 유효 시간, 초 단위
- Cache-Control: no-cache
	- 데이터는 캐시해도 되지만, 항상 원(origin) 서버에 데이터 변경 여부를 검증하고 사용
- Cache-Control: no-store
	- 데이터에 민감한 정보가 있으므로 저장하면 안됨 메모리에서 사용하고 최대한 빠르게 삭제

### 프록시 캐시
- 프록시 캐시 서버에 저장되는 캐시 public
- 사용자 로컬에 저장되는 캐시 private
- 캐시 지시어
	- Cache-Control: public 
		- 응답이 public 캐시에 저장 되어도 된다.
	- Cache-Control: private
		- 응답이 사용자만을 위한 것이다. private 캐시에 저장. 기본값

### 캐시 무효화
- 확실한 캐시 무효화 응답 : 모두 넣기
- **Cache-Control: no-cache, no-store, must-revalidate**
	- must-revalidate 캐시 만료 후 최초 조회시 원서버에서 반드시 검증 필요. 원 서버에 접근 불가 시 항 상 오류가 발생해야 한다(504 Gateway Timeout)
- **Pragma: no-cache** : HTTP 1.0 하위 호환 고려