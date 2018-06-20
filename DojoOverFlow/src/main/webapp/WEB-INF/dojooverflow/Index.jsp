<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Dash-Board</title>
</head>
<body>
	<div class="wrapper">
		<h1>Question Dash-board</h1>
		<table>
			<thead>
				<tr>
					<th>Detail</th>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ed" items="${data}">
				<tr>
					<td><a href="/questions/${ed.key}"><button>Detail</button></a></td>
					<c:forEach var="dt" items="${ed.value}">
						<td><c:out value="${dt}"/></td>
					</c:forEach>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new">New Question</a>
	</div>
</body>
</html>
