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

## 명령어
- 설정
	- `git config --global user.name song` : username 글로벌 설정
	- `git config --global user.email song@naver.com` : email 글로벌 설정
	- `git config --list` : 설정 정보 확인