### 웹 서버(WEB Server)
- HTTP 기반 동작
- 정적 리소스 제공
- APACHE, NGINX 등

### 웹 어플리케이션 서버(WAS, WEB Application Server)
- HTTP 기반 동작
- 웹서버 기능 포함 + 프로그램 코드를 실행해서 애플리케이션 로직 수행
- 톰캣, Jetty 등

### 서블릿 컨테이너
- 톰캣처럼 서블릿을 지원하는 WAS
- 서블릿 컨테이너는 서블릿 객체를 생성, 초기화, 호출, 종료하는 생명주기 관리
- 서블릿을 싱글톤으로 관리 -> 공유 변수 사용  주의
- JSP도 서블릿으로 변환되어 사용
- 동시 요청을 위한 멀티 쓰레드 처리 지원

### 멀티 쓰레드
- 쓰레드 : 애플리케이션 코드를 하나하나 순차적으로 실행
- 동시 처리가 필요하면 쓰레드를 추가로 생성해야 한다
- WAS가 멀티 쓰레드 부분을 처리
- 쓰레드 생성 특징
	- 동시 요청 처리 가능
	- 리소스(CPU, 메모리)가 허용될 때 까지 처리 가능
	- 생성 비용이 비싸고 컨텍스트 스위칭 비용 발생
	- 쓰레드 생성에 제한이 없다
- 따라서 **쓰레드 풀**을 통한 쓰레드 할당
	- 쓰레드를 미리 생성하므로 생성 및 종료 비용 절약
	- 응답시간이 빠르다
	- 최대치가 존재하므로 많은 요청이 들어와도 기존 요청은 안전하게 처리
- 맥스 쓰레드 풀 조정
	- 너무 낮으면 -> 시스템 리소스는 여유로우나 사용자의 응답 대기 시간이 길어짐
	- 너무 높으면 -> 임계점 초과하여 서버 자체 다운
	- 애플리케이션 로직 복잡도, CPU, 메모리, IO 리소스 상황에 따른 최적화 필요

### MVC 패턴
- 하나의 서블릿이나 JSP로 처리하던 것을 컨트롤러, 뷰 영역으로 나눈 패턴. 웹 어플리케이션 대부분이 사용
- 컨트롤러 : HTTP 요청을 받아서 **파라미터 검증, 비즈니스 로직 호출, 뷰에 전달할 결과 데이터 모델 세팅**
- 모델 : 뷰에 출력할 데이터를 담는 역할
- 뷰 : 모델에 담긴 데이터를 이용해 화면 그리기

- RequestDispatcher dispatcher.forward() : 다른 서블릿이나 jsp로 이동. 서버 내부에서 재호출하는 개념
- WEB-INF : 해당 경로 안에 리소스는 컨트롤러를 통해서만 호출 가능

### 프론트 컨트롤러
- 프론트 컨틀롤러 서블릿 하나로 클라이언트의 요청을 처리
- 요청에 맞는 컨트롤러를 찾아서 호출
- 공통 로직 처리
- 스프링 웹 MVC의 DispatcherServlet

### 스프링 MVC
#### DispatcherServlet
- 프론트 컨트롤러 역할
- 스프링 MVC에서의 핵심
- 모든 경로에 대해서 매핑("/")
- doDispatch 메서드로 컨트롤러 메서드 호출
	- 핸들러 조회
	- 핸들러 어댑터 조회
	- 핸들러 어댑터 실행
	- 핸들러 실행
	- ModelAndView 반환
	- ViewResolver 호출
	- View 반환
	- 뷰 렌더링
#### 핸들러 매핑, 핸들러 어댑터
- HandlerMapping
	- RequestMappingHandlerMapping : 애노테이션 기반 @RequestMapping 검색
	- BeanNameHandlerMapping : 빈 이름 기반 검색
	- ...
- HandlerAdapter
	- RequestMappingHandlerAdapter : 애너테이션 기반 컨트롤러의 @RequestMapping 처리
	- HttpRequestHandlerAdapter  : HttpRequestHandler 처리
	- SimpleControllerHandlerAdapter : 순수 과거 Controller 인터페이스
	- ...
#### 뷰 리졸버
- BeanNameViewResolver : 빈 이름 기반으로 뷰 반환(엑셀 파일 생성에 이용)
- InternalResourceViewResolver : 뷰 반환
- ...
- view.render() 호출 : JSP의 경우 forward() 호출, 나머지는 그냥 렌더링

### 요청 매핑
- @RequestMapping
	- url과 메서드 지정 하여 경로 매핑
	- 단순 URL 만 지정시 모든 HTTP 메서드 매핑(GET, POST, PUT ...)
	- HTTP 메서드와 결합하여 축약형 제공 : @GetMapping, @PostMapping, ...
	- parmas 로 파리미터를 통한 매핑 조건 지정 가능
	- headers 로 헤더를 통한 매핑 조건 지정 가능
	- Content-Type헤더를 통한 미디어 타입 조건으로 걸 경우 cousumes 이용
	- Accept헤더를 통한 미디어 타입 조건으로 걸 경우 produces 이용
- @PathVariable
	- 경로 변수
	- 리소스 경로에 식별자 등의 데이터를 포함
	- 파라미터로 @PathVariable과 변수명을 지정하여 받을 수 있다.
	- 변수명이 같으면 이름 생략 가능
	- 다중 매핑도 가능

### 요청 파라미터 처리
- @RequestParam
	- 요청 파라미터를 바로 인자로 받을 수 있다.
	- required 속성으로 필수 값을 지정 할 수 있다.
	- defaultValue로 기본값 지정 가능. 빈문자와 null 모두 커버
	- Map, MultiValueMap으로 전체 파라미터를 받을 수 있다.
- @ModelAttribute
	- 스프링이 @ModelAttribute 가 붙은 객체를 생성하여 setter 메서드를 통해 파라미터를 세팅해서 인자로 받을 수 있다.
	- 생략 가능