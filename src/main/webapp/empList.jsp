<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사원 정보</title>
	<link rel="stylesheet" href="css/empList.css">
</head>
<body>
${list}
<h3 id = "name">사원 목록</h3>
		<table class = "emp_table">
			<thead>
				
				<tr>
					<td class="iam">사원번호</td>
					<td class="iam">사원 명</td>
					<td class="iam">직책</td>
					<td class="iam">직속 상사</td>
					<td class="iam">급여</td>
					<td class="iam">부서</td>
					<td class="iam">입사일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="emp" items="${emp}">
					<tr>
						<td>${emp.empNo}</td>
						<td>${emp.empName}</td>
						<td>${emp.title.tName}</td>
						<td>${emp.manager.empName}(${emp.manager.empNo})</td>
						<td><fmt:formatNumber value = "${emp.salary}" pattern = "#,###"/></td>
						<td>${emp.dept.deptName }</td>
						<td><fmt:formatDate value="${emp.hireDate}" pattern = "yyyy년 MM월 dd일"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>