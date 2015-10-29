<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${message}" />
<form:form method="post" action="purchase/submitItems" modelAttribute="order">
	<table>
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>quantity</th>
	</tr>
	<c:forEach items="${order.itemList}" var="item" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td><form:input path="itemList[${status.index}].name" value="${item.name}"/></td>
			<td><form:input path="itemList[${status.index}].quantity" value="${item.quantity}"/></td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="submit" value="Submit" />
	
</form:form>

</body>
</html>