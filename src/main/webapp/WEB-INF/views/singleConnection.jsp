<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Web Task: Connection Details</title>
</head>

<body>
	<div id="main_wrapper">

	<h1>Connection Details</h1>

	<table>
		<tr><td>
			<table>
				<tr>
					<td>Connection:</td>
					<td>${connection.id}</td>
				</tr>
				<tr>
					<td>Username:</td>
					<td>${connection.username}</td>
				</tr>
				<tr>
					<td>User Agent:</td>
					<td>${connection.userAgent}</td>
				</tr>
				<tr>
					<td>Client IP:</td>
					<td>${connection.clientIp}</td>
				</tr>
				<tr>
					<td>Creation Date:</td>
					<td>${connection.creationDate}</td>
				</tr>
			</table>
		</td></tr>
		<tr><td>
		</td></tr>
	</table>
	</div>

</body>
</html>
