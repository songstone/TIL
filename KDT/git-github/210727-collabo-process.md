## collaborate process(forking workflow)
- 추후 계속 보완

#### 팀장(처음 시작)
1. repo생성
2. clone생성₩
3. git flow 폴더 생성
4. develop에서 작업 후 add commit
5. remote로 push
	```bash
	$ git push -u origin develop
	```
6. github에서 해당 레포 develop브랜치의 url을 팀원들에게 공유

#### 팀원
1. 이슈 생성
	- 해당 이슈의 기능마다'- [] ' 로체크박스 생성
2. 이슈 만들었으면 fork를 눌러 레포 복제
3. clone생성
4. git flow 폴더 생성
5. 기능개발 시작(feature branch)
6. 기능개발 완료 후 finish까지 진행
7. github에서 pullrequest 생성
	- base: 팀장 repo의 develop branch
	- from: 팀원 repo의 develop branch
8. reviewer 팀장 설정 후 request
