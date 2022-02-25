## 유용한 git command

- rename : git내에서 이름 변경 커밋을 남길 수 있다.
	```bash
	$ git mv [기존파일명] [변경할파일명]
	```
- undoing : 최신커밋의 내용으로 되될리때 사용한다.
	```bash
	$ git restore [파일명]
	```
- unstaging : 잘못 add한 파일을 stage에서 working directory로 내린다.
	```bash
	$ git reset HEAD [파일명]
	```
- 최신시점의 커밋 수정
	```bash
	$ git commit --amend
	```
- commit 되돌리기 : reset은 비추천, revert를 이용하자
	- revert 사용 시에 삭제된 내역까지 남으므로 작업 이력을 확인 하기 적합하다.
	- 최신시점에서 3commit  전으로 돌아가기
	```bash
	$ git revert --no-commit HEAD~3..
	```
- 원격 branch 삭제 하기
	```bash
	$ git push origin --delete [branch명]
	```
