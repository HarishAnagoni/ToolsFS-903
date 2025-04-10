<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insurance Report Generation Page</h1>
	<div>
		<fm:form action="searchplans" method="POST" modelAttribute="search">
				<table>
				<tr>
					<td>Plan Name :</td>
					<td>
						<fm:select path="planName">
							<fm:option value="">-select-</fm:option>
							<fm:options items="${names}"/>
						</fm:select>
					</td>
				</tr>
				<tr>
					<td>Plan Status :</td>
					<td>
						<fm:select path="planStatus">
							<fm:option value="">-select-</fm:option>
							<fm:options items="${status}"/>
						</fm:select>
					</td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>
						<fm:select path="citizenGender">
							<fm:option value="">-select-</fm:option>
							<fm:option value="MALE">Male</fm:option>
							<fm:option value="female">Female</fm:option>
						</fm:select>
					</td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td>
						<fm:input path="startDt" type="date"/>
					</td>
				</tr>
				<tr>
					<td>End Date :</td>
					<td>
						<fm:input path="endDt" type="date"/>
					</td>
				</tr>
				<tr>
					<td>
						<a href="./"> Reset </a>
					</td>					
					<td>
						<input type="submit" value="Search"/>
					</td>
				</tr>
				</table>
		</fm:form>
				<hr/>
				<table border="2">
					<thead>
						<tr>
							<th>Cust Number</th><th>Customer Name</th><th>Gender</th><th>Plan Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${list}">
							<tr><td>${r.citizenId}</td><td>${r.citizenName}</td><td>${r.citizenGender}</td><td>${r.planName}</td></tr>
						</c:forEach>
					</tbody>
				</table>
				<hr/>
				<div>Export : <a href="excel">Excel</a> <a href="pdf">PDF</a></div>
	</div>
</body>
</html>