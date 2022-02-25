from my_email import Email
import my_excel
from my_news import News

m_mail = Email()
m_excel = my_excel.Excel()
m_news = News()

newslist = m_news.find_news('fast campus')

m_mail.from_email = 'sample@naver.com'
m_mail.to_email = 'sample@gmail.com'
m_mail.subject = 'Dear. '

for news in newslist:
    m_mail.contents = m_mail.contents + news + '\n'

m_mail.send_email()

m_excel.excel_file = 'result.xlsx'
m_excel.save_to_excel(newslist)
