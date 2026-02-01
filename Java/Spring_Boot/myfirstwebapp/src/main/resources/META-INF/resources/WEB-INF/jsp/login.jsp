<html>
<head>
<title>Login Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">
		<h2>Welcome to login page</h2>

		<form method="post">
			<label> Name: </label> <input type="text" name="name" /> <br> <label>
				Password: </label> <input type="password" name="password" /> <br> <input
				type="submit" value="Submit" name="submit" />
		</form>
		<pre>${error}</pre>


	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>