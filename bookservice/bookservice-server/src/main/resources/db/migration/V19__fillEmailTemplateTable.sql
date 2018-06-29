INSERT INTO emailTemplate (emailBody, emailSubject, templateType) VALUES ('<html>
<head>
</head>
<body>
<h2>Welcome to Book Service!!!</h2>
<p>Dear ${recipient.name}, You are registered on book service with username: ${recipient.username}!</p>
<p> To activate your account go to link: ${link}</p>
</body>
</html>', 'Registration on Book Service!!!', 'REGISTRATION');
INSERT INTO emailTemplate (emailBody, emailSubject, templateType) VALUES ('<html>
<head>
</head>
<body>
<h2>Restore Password!!!</h2>
<p>Dear ${recipient.name}, to restore your password input this code in special field:</p>
<h3>${code}</h3>
</body>
</html>', 'Restore Password!!!', 'RESTORE_PASSWORD_CODE');
