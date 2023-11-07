<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Welcome to our Movie Store</h1>
        <h3>Make your selection below</h3>
        <!--        <form action="/MovieAppSpring/action" method="post">
                    <select name="action" id="action">
                        <option value="browse">Browse Movies</option>
                        <option value="add">Add movie</option>
                    </select>
                    <button type="submit">Send</button>
                </form>-->

        <form:form modelAttribute = "action" action="/MovieAppSpring/action">
            <form:select path="selectAction" name="action" id="action">
                <form:option value="browse">Browse Movies</form:option>
                <form:option value="add">Add movie</form:option>
            </form:select>
            <button type="submit">Send</button>
        </form:form>

    </body>
</html>