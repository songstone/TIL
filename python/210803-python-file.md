### csv
- ,와 개행문자로 구분된 파일
- 엑셀과 흡사한 형태
- ‘로 컬럼을 만들고 개행문자로 행 구분

### 파일 입출력
- 파일 열기 -> 읽고/쓰기 -> 파일 닫기
- open을 이용해 파일 열기
```python
open(‘<파일경로>’,’<모드>’)
``` 
- read나 readline을 이용해 파일 읽기(r 모드로 연다)
- read는 모든 데이터를 읽어서 용량이 큰 파일을 불러오면 느리지만  readline은 한줄씩 읽어와서 속도가 빠르다
- write를 이용해 파일에 데이터를 기록 및 저장
- w모드 사용시 덮어쓰기, a모드 사용시 기존 데이터에 데이터를 추가한다.
- 읽거나 쓰기가 끝나면 파일을 close로 닫아줘야 한다.

### 엑셀 읽기/쓰기
- openpyxl모듈을 이용해 파일을 열어 읽거나 쓴다.
- load_workbook함수 , Workbook클래서 이용
```python
from openpyxl import load_workbook

wb = load_workbook(‘test.xlsx’)
data = wb.active
area = data[‘A1:C3’]
for row in area:
    for cell in row:
        print(cell.value)
```
```python
from openpyxl import Workbook

wb = Workbook()
ws = wb.create_sheet(‘test-sheet’)
ws.append({‘Number’,’Name’})
for i in range(10):
    ws.append([i,str(i) + ‘ data’])
wb.save(‘result2.xlsx’)
```

### 큰 용량 엑셀 파일
- Workbook클래스에 read_only값을 True를 줌으로써 분할해서 한 행씩 가져오게 하여 빠르게 읽어올 수 있다.
- iter_row함수를 사용하여 사용할 것

### 이메일
- smtplib, email 패키지를 이용(MIMEText, MIMEMultipart)
- smtp 서버, smtp 포트, 계정정보 지정
```python
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import smtplib

SMTP_SERVER = 'smtp.gmail.com'
SMTP_PORT = 465
SMTP_USER = 'thdtmdgus888@gmail.com'
SMTP_PASSWORD = 'songstone1!'

def send_mail(name, addr, subject, contents):
    msg = MIMEMultipart('alternative') #### 담는 형태의정보?
    
    msg['From'] = SMTP_USER
    msg['To'] = addr
    msg['Subject'] = name + '님, ' + subject
    
    text = MIMEText(contents, _charset='utf-8') ####단순히 텍스트만 내용에 들어가는 것이 아니기 때문에 attach를 이용해 붙여 넣는 형식으로 작성
    msg.attach(text)

    smtp = smtplib.SMTP_SSL(SMTP_SERVER, SMTP_PORT)
    smtp.login(SMTP_USER,SMTP_PASSWORD)
    smtp.sendmail(SMTP_USER, addr, msg.as_string())
    smtp.close()

contents = '''안녕하세요.
자동으로 보내지는 메일입니다. 
잘 가는게 맞는지 테스트해 봅니다.
'''

send_mail('송승현', '1995song@naver.com','자동화 테스트 메일 입니다.',contents)
```

