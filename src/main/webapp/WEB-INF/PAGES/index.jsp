<%@ page isELIgnored="false"%>
<html>
<head>
<title>StudentApp::Login</title>
</head>
<body>
	<div>
		<h1>Student Application</h1>
		<hr>
		<form action="login" method="post" >
			<h3>login here!</h3>
			<p color="red" >${message}</p>
			<label for="username">	Username:</label><input type="text"	name="username" required ><br> 
			<label for="password">	Password:</label><input	type="text" name="password" required ><br>
			 <input type="submit" value="login" />
		</form>
	</div>
</body>
</html>
