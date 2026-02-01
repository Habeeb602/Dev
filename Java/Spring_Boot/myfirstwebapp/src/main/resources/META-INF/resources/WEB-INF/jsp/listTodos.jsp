<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Todo List</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<%@include file="./common/navigation.jspf" %>
	<div class="container">
		<h2>Hello ${name}</h2>
		<h3>Your Todo list:</h3>
		<table border=1 class="table">
			<thead>
				<tr>
					<!-- <th>ID</th> -->
					<th>Description</th>
					<th>Target Date</th>
					<th>Completed?</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ todos}" var="todo">
					<tr>
						<!--  <td>${todo.id }</td> -->
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done }</td>
						<td>
							<a href="delete-todo?id=${todo.id }" class="btn btn-danger">Delete</a>
						</td>
						<td>
							<a href="update-todo?id=${todo.id}" class="btn btn-primary">Update</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add-todo" class="btn btn-success">Add todo</a>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>