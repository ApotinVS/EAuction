<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:c="http://java.sun.com/jsp/jstl/core"
          version="2.0">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Sign-up page</title>
        <link rel="stylesheet" href="/styles/style.css" type="text/css" media="screen" />
    </head>
    <body>
    <div id="signin">
        <form style="width:655px;" name="singupForm" action="Controller" method="post">
            <h1>${text['SING_UP']}</h1>
            <hr />
            <!-- TODO patterns for login, password and email -->
            <input type="hidden" name="command" value="singup" />
            <br /><label>Login:</label> <input type="text" name="login" />
            <span id="advice">You can use letters and number.(no less then 3 characters)</span>
            <br /><label>Password:</label> <input type="password" name="password" />
            <span id="advice">Use at least 3 characters</span>
            <br /><label>Email</label> <input type="email" name="email" />
            <span id="advice">You can use letters and number</span>
            <br /><label>First name:</label> <input type="text" name="firstName" />
            <span id="advice">optional field</span>
            <br /><>Last name:</> <input type="text" name="lastName" />
            <span id="advice">optional field</span>
            <input class="button" type="submit" value="Sign-up" />
        </form>
    </div>
    </body>
    </html>
</jsp:root>