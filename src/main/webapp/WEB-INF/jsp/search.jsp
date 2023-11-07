<%-- 
    Document   : search
    Created on : Nov 4, 2023, 10:03:03 PM
    Author     : sho7
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Browse Movies</title>
    </head>
    <body>
        <h1>Search for movies using:</h1>
        <form:form action="/MovieAppSpring/search" modelAttribute="search">
            <form:radiobuttons path="searchBy" items="${searchRadioOptions}"/>
            <br> <br>
            <form:label for="keyword" path="keyword">Keyword:</form:label>
            <form:input type="text" id="keyword" name="keyword" path="keyword"/>
            <br> <br>
            <button type="submit">Search</button>
        </form:form>
    </body>
</html>
