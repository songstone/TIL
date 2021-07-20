## git, iterm의 기본 사용법

#### 기본 용어 정리
- kernel : 하드웨어와 응용프로그래밍을 이어주는 운영체제의 핵심 소프트웨어
- shell : 커널과 사용자를 이어주는 역할
- CLI : Command Line Interface 의 줄임말로 터미널을 이용한 명령으로 실행 제어

#### iterm 기본 명령어 정리
- `$ cd` : 최상위 사용자 디렉토리로 이동한다.
- `cd (디렉토리)' : 해당 디렉토리로 이동한다.
- `ls` : 현재 디렉토리의 하위 디렉토리나 폴더 리스트를 보여준다.
	- `ls -l` : 각 리스트 값의 상세정보를 보여준다.
	- `ls -a` : 숨김파일을 포함한 모든 디렉토리 및 디렉토리를 보여준다.
- `clear` : 터미널 창을 정리해준다.
- `mkdir (이름)` : 새로운 디렉토리 생성
- `touch (이름)` : 새로운 파일 생성
- `mv (파일) (디렉)` : 해당 파일을 다른 디렉토리로 이동시킨다.
	- `mv (파일) (파일2)` : 파일의 이름을 파일2로 변경 시킨다.
- `cp (파일) (디렉)` : 해당 파일의 복사본을 해당 디렉토리에 생성.
	- `cp (파일) (파일2)` : 현재 디렉토리의 파일의 복사본 파일2 생성.
- `rm (파일)` : 현재 디렉토리의 해당 파일 삭제
- `rm -rf (디렉)` : 해당 디렉과 안의 내용을 모두 강제 삭제
- `vi (파일)` : vim으로 해당 파일 열기
- `cat (파일)` : 해당 파일의 내용을 열지 않고 터미널 창에 표시

#### vim
- vim의 기본 모드
	- normal : vim을 처음 열때 모드
	- command : normal모드에서 ':'를 눌러서 사용
	- insert : nornal모드에서 'i'를 눌러서 사용
	- visual : normal모드에서 'v'를 눌러서 사용
- `[링크텍스트](링크url)` : 하이퍼링크 표현
- `![대체텍스트](이미지url)` : 이미지 표현
- `:wq` : 저장 후 종료
- `:q!` : 변경 사항 저장하지 않고 종료

#### git
- VCS(Version Control System)
- git의 구조
	- blob : 작성한 파일의 내용(변경사항을 의미)
	- tree : blob 이나 subtree의 메타정보
	- commit : 변경내용과 메타정보의 스냅샷 개념

#### git commit 까지의 과정 정리(work directory -> stage -> local repo -> remote repo)
1. work directory에서 작업 진행
2. 커밋 할 내용만 stage에 add로 올려놓기
3. prefix를 작성하여 local repo로 커밋
4. git push를 이용하여 remote repo로 푸쉬

#### git 관련 명령어
- `git status` : show git's status
- `git branch` : show brach list
- `git branch (name)` : create branch
- `git switch (name)` : swtich to the branch
- `git add (name)` : add the file to stage
- `git commit` : commit
- `git push (directory : origin main)` : push to remote repo(origin main)
- `git fetch (origin main)` + `git merge FETCH_HEAD' : pull from remote repo(origin main)

#### git repo clone 만들기
1. 깃헙에서 repo 주소 복사
2. repo를 만들 디렉토리로 이동
3. `git clone (주소)` 로 클론 생

#### git branch를 이용하여 코드리뷰 받는 법
1. iterm을 이용해 해당 repo가 있는 디렉토리로 이동한다.
2. `git branch (새 branch 이름)` 명령을 이용해 새로운 branch를 만든다.
3. `git branch` 명령을 통해 현재 선택된 branch를 확인한다.(녹색으로 표시 되어있음)
4. `git switch (branch 이름)`을 통해 새로 만든 branch로 바꾸고 다시 한번 `git branch` 를 이용해 바뀌었는지 확인한다.
5. `touch (새 파일 이름)` 명령을 통해 새로운 파일을 생성한다.
6. 파일을 vi로 열어 작성하고 저장 후에 `git status` 로 확인을 한다.
7. 별 이상이 없다면  `git add (파일 이름)` 을 입력하여 변경 사항을 스테이지로 올린다.
8. `git status` 명령을 통해 잘 올라갔음을 확인 한 후 `git commit` 명령을 통해 prefix를 작성한다.
	- docs : 문서 관련
	- feat : 기능 개발 관련
	- fix : 버그 픽스 관련
	- refactor, conf, test, ...
9. 저장 후 `git status` 명령을 통해 상태를 체크 하고 별 이상이 없다면 `git push -u origin (만든 브랜치 이름)` 을 입력한다.
10. `git status` 로 잘 커밋 되었는지 확인하고 github으로 돌아가 결과를 확인 후 pull request 를 클릭한다.
11. 콜라보레이터를 지정하고 코드리뷰 요청을 보낸다. 
