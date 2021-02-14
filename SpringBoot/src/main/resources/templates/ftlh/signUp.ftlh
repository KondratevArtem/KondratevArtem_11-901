<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>VAGODROCH.RU</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/navbar.css" type="text/css">
    <link rel="stylesheet" href="/css/style_logup.css" type="text/css"/>
    <link rel="icon" href="/images/logo.png" type="image/x-icon"/>
    <link rel="shortcut icon" href="/images/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
    <link href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&display=swap" rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="nav transparent navbar-inverse navbar-fixed-top">
        <nav class="navbar-inner navbar-expand-md sticky">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" style="padding-left: 0; margin-left: 0" href="/">
                        <span>VAGODROCH.RU</span>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</header>
<div class="main-signup">
    <div class="main-signup__head">
        <h3>Registration</h3>
    </div>
    <form action="/signUp" method="post">
        <div class="main-signup__middle">
            <div class="middle__form">
                <input type="text" name="name" placeholder="Имя" required="required">
                <input type="text" name="surname" placeholder="Фамилия" required="required">
                <div class="central">
                    <input type="text" name="city" placeholder="Город">
                    <input type="tel" name="number" placeholder="Телефон" pattern="(8|+7)9[0-9]{9}"
                           required="required">
                </div>
                <input type="email" name="email" placeholder="Email" required="required">
                <input type="password" name="password" placeholder="Пароль" required="required">
            </div>
        </div>
        <div class="main-signup__foot">
            <input type="submit" value="ЗАРЕГИСТРИРОВАТЬСЯ">
        </div>
    </form>
</div>
</body>
</html>
