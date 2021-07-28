## branching model(git-flow)

#### git flow 설치([https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html))
1. git-flow 툴 설치
	```bash
	$ brew install git-flow-avh
	```
2. repo에서 git-flow 초기화
	```bash
	$ git flow init
	```
3. main branch와 develop branch 지정 후 나머지는 그냥 enter
4. branch 상태 확인
	```bash
	$ git branch
	```

#### 기능 개발(feature branch)
1. 기능개발 시작 선언
	- feature branch 생성
	```bash
	$ git flow feature start [개발할 기능 이름]
	```
2. branch 상태 확인
3. feature branch 위에서 기능 개발등의 작업
4. add, commit, push 까지 실행
5. 기능 개발이 완료 되었으면 종료 선언
	- develop에 merge되고 feature branch는 삭제된다.
	```bash
	$ git flow feature finish [이름]
	```

#### 릴리즈(release branch)
1. 릴리즈 시작 선언
	- release branch 생성
	```bash
	$ git flow release start [버전정보 ex)v1.0]
	```
2. 릴리즈 과정(추후 작성 필요)
	- 
3. 릴리즈 종료 선언
	- main과 develop에 merge되고 release branch는 삭제된다.
	```bash
	$ git flow release fisish [이름]
	```
	- 3개의 commit message가 뜨는데 1,3은 그냥 :wq 실행하여 작성
	- 2번째 commit message에는 버전 정보를 제목으로 적고 내용에 그 기능들을 설명한다.
