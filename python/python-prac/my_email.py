class Email:
    def __init__(self):
        self.from_email = ''
        self.to_email = ''
        self.subject = ''
        self.contents = ''
    
    def send_email(self):
        print('From ' + self.from_email)
        print('To ' + self.to_email)
        print('Subject' + self.subject)
        print('Contents ' + self.contents)