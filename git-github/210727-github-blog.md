## github 연동 블로그 만들기(hexo, next theme) in Mac

#### 기본 세팅
1. github에서 새 repo 만들기
	- repo 이름은 [username].github.io
	- 옵션 체크 하지말고 그대로 생성
2. node.js 설치
	```bash
	$ brew install node
	```
3. hexo 설치
	```bash
	$ npm install -g hexo-cli
	```
4. dev 폴더 안에 hexo 폴더 생성
	```bash
	$ hexo init [folder-name]
	```
5. 만든 폴더 안에서 재설치
	```bash
	$ npm install
	```
6. 'Next' 테마 다운
	```bash
	$ git clone https://github.com/next-theme/hexo-theme-next themes/next
	```
7. _config.yml 열기
	```bash
	$ vi _config.yml
	```
8. 세부사항 수정
	- title: [블로그 타이틀]
	- subtitle: [부제]
	- description: [간략한 설명]
	- author: [username]
	- url: https://[username].github.io
	- theme: Next
	- deploy:
		type : git
		repo : [위에서 만든 repo 주소]
		branch : main
9. deployer-git 설치
	```bash
	$ npm install hexo-deployer-git --save
	```

#### 포스팅
1. hexo폴더에서 포스팅 혹은 페이지 생성
	```bash
	$ hexo new post [이름]
	```
	```bash
	$ hexo new page [이름]
	```
2. vi 로 md파일 열어서 수정
	```bash
	$ vi source/_posts/[이름].md
	```
3. clean & generate 실행
	```bash
	$ hexo clean && hexo generate
	```
4. hexo server로 server열기
	```bash
	$ hexo server
	```
5. 브라우저를 열어 로컬호스트 서버 주소로 가서 확인
6. 서버닫기 (control + C)
7. clean & deploy 실행
	```bash
	$ hexo clean && hexo deploy
	```
8. 브라우저에서'[username].github.io' 로 가서 확인
