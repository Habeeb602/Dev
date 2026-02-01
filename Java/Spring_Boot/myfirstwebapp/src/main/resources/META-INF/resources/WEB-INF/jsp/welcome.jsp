<html>
<head>
<title>Welcome!!!</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<%@include file="./common/navigation.jspf" %>
	<div class="container">
		<h1>Todo App</h1>
		<h2>Username: ${name}</h2>
		<a href="/list-todo">Manage your todos</a>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>