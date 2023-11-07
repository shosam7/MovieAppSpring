<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
        <style>
            form label, input{
                display: flex;
                flex-direction: column;
            }
        </style>
    </head>
    <body>
        <h1>Please enter details of new movie:</h1>
        <form:form action="/MovieAppSpring/add-success" modelAttribute="movie">
            <label for="title" path="title">Movie Title</label>
            <form:input type="text" id="title" name="title" placeholder="Enter movie title" path="title"/>
            <br>
            <form:label for="actor" path="actor">Lead Actor</form:label>
            <form:input type="text" id="actor" name="actor" placeholder="Enter lead actor name" path="actor"/>
            <br>
            <form:label for="actress" path="actress">Lead Actress</form:label>
            <form:input type="text" id="actress" name="actress" placeholder="Enter lead actress name" path="actress"/>
            <br>
            <form:label for="genre" path="genre">Genre</form:label>
            <form:input type="text" id="genre" name="genre" placeholder="Enter genre" path="genre"/>
            <br>
            <form:label for="year" path="year">Year</form:label>
            <form:input type="text" id="year" name="year" placeholder="Enter release year" path="year"/>
            <br>
            <button type="submit">Add Movie</button>
        </form:form>
    </body>
</html>
