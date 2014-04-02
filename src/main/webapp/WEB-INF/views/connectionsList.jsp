<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Web Task: Connectons List</title>
</head>

<body>
	<div id="main_wrapper">

        <h1>Connections List</h1>

        <table border="1">
            <c:forEach items="${connections}" var="connection">
                <tr>
                    <td><a href="connection/${connection.id}">Connection with id: ${connection.id}</a></td>
                    <td>${connection.username}</td>
                    <td>${connection.userAgent}</td>
                    <td>${connection.clientIp}</td>
                    <td>${connection.creationDate}</td>
                </tr>
            </c:forEach>
        </table>

	</div>

</body>
</html>
