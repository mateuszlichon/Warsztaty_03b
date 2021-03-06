<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/fragments/headerAdmin.jspf"%>
	<table>
		<tr>
			<td>ID</td>
			<td>Nazwa grupy</td>
			<td>Akcje</td>
		</tr>
		<c:forEach var="g" items="${groups}">
			<tr>
				<td>${g.id}</td>
				<td>${g.name}</td>
				<td><a href="UsersByGroup?groupId=${g.id}">Uzytkownicy</a></td>
				<td><a href="UserGroupsAdminDelete?groupId=${g.id}">Usun grupe</a></td>
				<td><a href="UserGroupsAdminEdit?groupId=${g.id}">Edytuj grupe</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<p>Dodaj grupe</p>
	<form action = 'UserGroupsAdminAdd' method='post'>
		Nazwa
		<input type = 'text' name='name' />
		<input type='submit' />
	</form>
	<%@ include file="/WEB-INF/fragments/footerAdmin.jspf"%>
</body>
</html>