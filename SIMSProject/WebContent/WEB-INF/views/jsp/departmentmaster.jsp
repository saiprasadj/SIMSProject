<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- Icons -->
<link
	href="http://coreui.io/demo/Static_Demo/assets/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="http://coreui.io/demo/Static_Demo/assets/css/simple-line-icons.css"
	rel="stylesheet">
<!-- Main styles for this application -->
<link href="http://coreui.io/demo/Static_Demo/assets/css/style.css"
	rel="stylesheet">

</head>
<body>
	<div class="container-fluid">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-header">
							<strong>Department Master</strong>
						</div>
						<div class="col-sm-6">
							<div class="card-block">
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="name">Name</label> <input type="text"
												class="form-control" id="name" placeholder="Enter your name">
										</div>
									</div>
								</div>
								<!--/row-->
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="ccnumber">Alias</label> <input type="text"
												class="form-control" id="ccnumber"
												placeholder="Enter alias name">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="name">Code</label> <input type="text"
												class="form-control" id="name" placeholder="Enter your name">
										</div>
									</div>
								</div>

							</div>
						</div>
						<div class="col-sm-12">
							<button type="submit" class="btn btn-sm btn-success">
								<i class="fa fa-dot-circle-o"></i> Save
							</button>
							<button type="submit" class="btn btn-sm btn-primary">
								<i class="fa fa-dot-circle-o"></i> Edit
							</button>
							<button type="reset" class="btn btn-sm btn-danger">
								<i class="fa fa-ban"></i> Delete
							</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add department Data</h2>
	<form:form method="POST" commandName="department"
		action="savedepartment">
		<table>
			<%--    <tr>
           <td><form:label path="id">department ID:</form:label></td>
           <td><form:input path="id" value="${department.id}" readonly="true"/></td>
       </tr> --%>
			<tr>
				<td><form:label path="name">department Name:</form:label></td>
				<td><form:input path="name" value="${department.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="alias">department Name:</form:label></td>
				<td><form:input path="alias" value="${department.alias}" /></td>
			</tr>
			<tr>
				<td><form:label path="name">department Name:</form:label></td>
				<td><form:input path="code" value="${department.code}" /></td>
			</tr>
			<%--  <tr>
           <td><form:label path="age">department Age:</form:label></td>
           <td><form:input path="age" value="${department.age}"/></td>
       </tr>
       <tr>
           <td><form:label path="salary">department Salary:</form:label></td>
           <td><form:input path="salary" value="${department.salary}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="address">department Address:</form:label></td>
                    <td><form:input path="address" value="${department.address}"/></td>
       </tr> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty departments}">
		<h2>List departments</h2>
		<table align="left" border="1">
			<tr>
				<th>department ID</th>
				<th>department Name</th>
				<th>department Age</th>
				<th>department Salary</th>
				<th>department Address</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${departments}" var="department">
				<tr>
					<td><c:out value="${department.id}" /></td>
					<td><c:out value="${department.name}" /></td>
					<td><c:out value="${department.age}" /></td>
					<td><c:out value="${department.salary}" /></td>
					<td><c:out value="${department.address}" /></td>
					<td align="center"><a href="edit.html?id=${department.id}">Edit</a>
						| <a href="delete.html?id=${department.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
