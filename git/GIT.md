## 역사 및 배경지식
- 유닉스 : 대형 컴퓨터 운영체제
- 리눅스 : 리누스 토발즈가 만든 유닉스 기반의 개인용 컴퓨터 OS
- GNU 
	- 리누스 토발즈가 도입한 개념
	- 공개 소프트웨어 프로젝트
	- GNU 프로젝트를 사용하여 새 프로젝트를 만들면 GPL(General Public License) 라이센스를 따르고 그 프로젝트 또한 공개해라
- 협업의 필요성 및 규모 증대
- 리눅스 회사에서 BitKeeper 사용 
	- DVCS : Distribution Version Control System(분산 버전 관리 시스템)
- BitKeeper 유료화 -> 리누스 토발즈가 git을 만든다
- git 역시 GNU이며 GPL라이센스를 따른다

## Github
- hub : 우주의 중심
- github : 개발자들의 중심 놀이터
- git을 이용한 원격 저장소

## 버전 관리 시스템(VCS)
- CVCS : 중압 집중형 버전 관리 시스템
	- SVN
	- 중앙 저장소에서 파일의 버전을 관리
	- 중장 저장소에서만 파일 전체 히스토리 기록
	- 로컬은 파일의 엔드 포인트 변경 이력만 기록
	- 협업 시 잘못 업데이트를 받으면 로컬 수정 이력이 날라감
	- 중앙 저장소가 문제가 생기면 전체 문제
- DVCS : 분산 버전 관리 시스템
	- GIT
	- 로컬, 원격 모두 파일 전체 히스토리를 기록

## 깃 실행 원리
- git init
	- 빈 폴더를 깃을 통한 작업영역으로 활용
	- 변경 감지 시작
- git add
	- 스테이징
	- 변경이 감지된 파일을 인덱스 영역에 추가
	- 인덱스 영역에는 트리 형식의 폴더 밑에 BLOB 형식으로 파일 저장
	- 새로운 파일 추가 OR 파일 변경 시 트리 폴더, BLOB에 변경 되지 않은 이전 버전의 참조 해쉬값을 가진다.
- git commit
	- 영구적으로 저장
	- 헤더 영역에 추가
	- 인덱스 영역의 트리, BLOB 형태로 브랜치에 점을 찍는다 -> 버전

## 설정 정보 확인
- `git config --global user.name song` : username 글로벌 설정
- `git config --global user.email song@naver.com` : email 글로벌 설정
- `git config --list` : 설정 정보 확인

## 되돌리기 : reset
- 직전 커밋 되돌리기
- `git reset (option) (돌아갈 commit 내역 번호)`
- soft
	- add 된 상태로 커밋 전 상태로 되될린다.
	- 커밋 변경 시 사용
- mixed
	- 작업 영역만 남기고 add 하지 않은 상태로 되돌린다.
	- 작업 영역 변경 필요 시 사용
- hard
	- commit 내용와 변경사항을 아예 날린다
	- 아예 전 커밋 상태로 돌아가고 싶을 때 사용

## reflog
- `git reflog`
- 과거 커밋 내역에 대한 로그 
- git reset --hard (로그 내역 번호) 로 과거 커밋 상태로 되돌리기 가능
- 하드 리셋 시킨 후 다시 되돌릴 때 사용
## amend
- `git commit amend -m "message"`
- 로그 번호가 없을 때 commit message 변경 시

## rebase
- `git rebase -i HEAD~3`
- squash
	- s
	- 커밋 찌그러뜨리기
	- 과거 방향으로 찌그러뜨려야 한다
	- 과거의 커밋으로 주 커밋으로 커밋 내역을 모으는 개념
- pick
	- 하나로 합칠 주 커밋 선택
- reword
	- r
	- 커밋 메시지 변경
- drop
	- d
	- 커밋 내역 삭제
- 커밋 내역 정리 할 때

## git branch
- 특정 시점에서 부터 새로운 작업 분기
- 메인 브랜치와 서브 브랜치 merge
	- 3-way-merge : 공통 조상, 현재 main 포인터, 서브 브랜치 포인터 를 비교하여 merge 
	- fast-forwad-merge
		- main 이 변경 되지 않았을 때 서브 브랜치 포인터를 공통조상에 merge
		- main branch pointer 가 서브 브랜치 포인터로 이동

## remote repository 연결
- `git remote add origin (주소)`
	- 원격 저장소 origin으로 으로 연결
- `git remote -v`, `git ls-remote`
	- 원격 저장소 연결 확인
- `git remote rm origin`
	- 원격 저장소 삭제

## remote branch 다운
- `git fetch origin`
- `git checkout -b (브랜치) origin/(브랜치)`

## merge squash 옵션
- `git merge --squash (브랜치)`
	- 브랜치를 합치고 add만 된 상태로 merge
	- 커밋 메시지 새로 작성 가능

