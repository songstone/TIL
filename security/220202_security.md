# 스프링 시큐리티

## 스프링 시큐리티 내부 구조
![security_structure](./img/security_structure.png)
- SecurityContextHolder : SecurityContext를 감싼다, SecurityContext를 제공하는 static 메서드를 지원한다.
- SecurityContext : 접근 주체와 인증에 대한 정보를 담고 있다.
- Authentication : Pricipal 과 GrantAuthority를 제공한다.
- Principal : 유저에 해당하는 정보, 대부분의 경우 Principal로 UserDetails를 반환
- GrantAuthority : ROLE_ADMIN, ROLE_USER 등 Principal이 가지고 있는 권한을 나타낸다. prefix로 'ROLE_'을 붙여준다. 인증 이후 인가 할 떄 사용. 권한이 다수 있을 수 있으므로 Collection의 형태로 제공

## ThreadLocal
- WebMvc 기반에서 1요청은 1스레드, threadLocal 사용 시 각각의 고유한 공간에 SecurityContext 생성
- Security Context 전략
    - MODE_THREADLOCAL : 기본 설정, 같은 스레드 안에서 Security context 공유
    - MODE_INHERITABLETHREADLOCAL : 자식 스레드 까지 공유
    - MODE_GLOBAL : 애플리케이션 전체에서 공유

## PasswordEncoder
- 패스워드의 암호화 저장
- 복호활 할 필요가 없다
- 해시 함수 알고리즘 : 암호화는 쉽지만 복호화는 매우 어렵다
    - 회원가입 시 패스워드를 해시함수로 암호화
    - 로그인 할 때 패스워드를 해시함수로 암호화
    - 두값을 비교 하여 동일하면 암호로 인지
- DelegatingPasswordEncoder : 패스워드 인코더 전략을 선택하여 사용 할 수 있는 대표 인코더, 기본 설정은 Bcrypt
- 종류
    - NoOpPasswordEncoder : 암호화 x 평문으로 사용
    - BcryptPasswordEncoder : Bcrypt 해시 함수, Password를 무작위로 여러번 시도하여 맞추는 해킹을 방지하기 위해 암호를 확인할 때 의도적으로 느리게 설정. 도를 설정할 수 있는데 강도가 높을수록 오랜 시간 소요
    - Pbkdf2PasswordEncoder : NIST(미국표준기술연구소)에 의해서 승인된 알고리즘이고, 미국 정부 시스템에 서도 사용
    - ScryptPasswordEncoder : Pbkdf2와 유사, 무작위로 password를 맞추려고 시도할 때 메모리 사용량을 늘리거나 반대로 메모리 사용량을 줄여서 느린 공격을 실행할 수밖에 없도록 의도적인 방식을 사용. 공격이 매우 어렵고 Pbkdf2보다 안전하다고 평가

## Security Filter
- 필터 : 요청을 컨트롤러에 전달하기전이나 응답에 컨트롤러의 처리값을 전달하기 전을 감싸 처리. doFilter() 구현 필요
- 많은 필터 존재, 각자 다른 기능
- 필터의 추가, 삭제, 순서 변경 가능
- 필터의 순서에 따라 마지막 순서의 필터부터 감싸 첫번째 순서의 필터가 가장 바깥은 감싸는 구조
- 확인해보기(FilterChainProxy에서 doFilterInternal의 filters 브레이크 포인트 걸어보기)
- FilterOrderRegistration 을 통해 오더에 따라 필터 사이 적용 스텝 값은 100(중간에 커스텀 필터를 끼워 넣기)