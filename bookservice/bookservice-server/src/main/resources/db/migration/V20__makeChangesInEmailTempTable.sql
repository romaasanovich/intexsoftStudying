INSERT INTO emailTemplate (emailSubject, emailBody, templateType) VALUES ('Restore Password!!!', '<html>\n<head>\n</head>\n<body>\n<h2>Restore Password!!!</h2>\n<p>Dear ${recipient.name}, to restore your password go to this link:</p>\n<h3>${link}</h3>\n</body>\n</html>', 'RESTORE_PASSWORD_LINK');
INSERT INTO emailTemplate (emailSubject, emailBody, templateType) VALUES ('Activate account!!!', '<html>\n<head>\n</head>\n<body>\n<h2>Welcome to Book Service!!!</h2>\n<p>Dear ${recipient.name}, to activate your account go to link: ${link}</p>\n</body>\n</html>', 'REACTIVATE');

