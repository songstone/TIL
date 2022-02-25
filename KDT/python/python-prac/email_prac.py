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