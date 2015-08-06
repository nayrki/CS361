<?php
	if(
		isset($_POST['username']) &&
		isset($_POST['password']) &&
		isset($_POST['name'])     &&
		isset($_POST['email'])
	){
	   $username=$_POST['username'];
	   $password=$_POST['password'];
	   $name=$_POST['name'];
	   $email=$_POST['email'];
		$link = mysqli_connect('oniddb.cws.oregonstate.edu','kitchenr-db','nECGSF1HSPp9DiCZ','kitchenr-db');
		if(mysqli_connect_errno()) die('Database error');
	 	$iquery="INSERT INTO WaDa_users (username,password,name,email) VALUES ('$username','$password','$name','$email')";			
		echo $iquery;
		$result=mysqli_query($link,$iquery);
		echo $iquery;		
		if(!$result) die("Insert error");
		echo "User " . $_POST['username']." created successfully";		
		mysqli_close($link);
	}else{
		echo "
			<html>
			<body>
			<form action='newuser.php' method=POST>
			<input type='text' name='username'\> username <br>
			<input type='password' name='password'\> password<br>
			<input type='text' name='name'\> name <br>
			<input type='text' name='email'\> email <br>
			<input type='submit'>
			</form>
			</body>
			</html>
			";
		}
?>

