<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show</title>
</head>
<body>
	<h1><c:out value="${person.fname}"/>  <c:out value="${person.lname}"/></h1>
	<h3><c:out value="${license.number}"/></h3>
	<h3><c:out value="${license.state}"/></h3>
	<h3><c:out value="${license.expireDate}"/></h3>
</body>
</html>
