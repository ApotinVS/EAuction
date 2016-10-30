<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
          version="2.0">
    <jsp:directive.page import="java.lang.Float" />
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>HEADER</title>
    </head>
    <body>
    <!-- Header file contains logo, menu and
                                                user's panel "INFO"(sing in, sing up, cart, exit)  -->
    <div id="head-container">
        <!-- start LOGO
        <div id="logo">internet
            <div id="logo-shop">SHOP</div>
        </div>
         end LOGO  -->
        <!-- start MENU  -->
        <div id="menu">
            <ul class="header">
                <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('isEnterUser') eq false)
													|| (pageContext.session.getAttribute('isEnterUser') eq null) }">
                        <li><a href="index.jspx?menu_id=1">${text['HOME']}</a></li>
                        <li>|</li>
                        <li><a href="index.jspx?menu_id=2">${text['SING_IN']}</a></li>
                        <li>|</li>
                        <li><a href="index.jspx?menu_id=3">${text['SING_UP']}</a></li>
                        <li>|</li>
                    </c:when>
                    <c:when test="${pageContext.session.getAttribute('isEnterUser') eq true }">
                        <li><a href="index.jspx?menu_id=1">${text['HOME']}</a></li>
                        <li>|</li>
                        <li><a href="Controller?command=getCatalog">${text['CATALOG']}</a></li>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${text['MENU_PROBLEM']}"></c:out>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <!-- end MENU  -->
    </div>

    </body>
    </html>
</jsp:root>