<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
    <!--<jsp:directive.page import="com.epam.eshop.model.entities.Cart" />-->
    <jsp:directive.page contentType="text/html; charset=UTF-8"
                        pageEncoding="UTF-8" session="true"/>
    <jsp:output doctype-root-element="html"
                doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
                doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
                omit-xml-declaration="true" />
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>internet SHOP</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css" />
    </head>
    <body>

    <div id="content">
        <c:set var="menu" scope="page"
               value="${pageContext.request.getParameter('menu_id')}" />
        <c:choose>

            <c:when test="${menu == 3}">
                <jsp:directive.include file="/jspf/singup.jspf" />
            </c:when>

            <c:otherwise>
                <c:out value="Ooops..." />
            </c:otherwise>
        </c:choose>
    </div>

    <div id="header">
        <jsp:directive.include file="/jspf/header.jspf" />
    </div>
    <div id="footer">
        <jsp:directive.include file="/jspf/footer.jspf" />
    </div>

    </body>
    </html>
</jsp:root>