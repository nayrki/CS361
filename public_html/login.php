<?php
	if(isset($_POST['username']) && isset($_POST['password'])){
	   $username=$_POST['username'];
	   $password=$_POST['password'];
	   $link = mysqli_connect('oniddb.cws.oregonstate.edu','kitchenr-db','nECGSF1HSPp9DiCZ','kitchenr-db');
	   if(mysqli_connect_errno()) die('Database error');
	   $query="SELECT userID FROM WaDa_users WHERE username='$username' AND password='$password'";
	   $result=mysqli_query($link,$query);
	   if(!$result) die("Query error");
	   if($result->num_rows==0) echo "INVALID";
	   $row=mysqli_fetch_assoc($result);
	   echo $row['userID'];
	   mysqli_close($link);
	}
	else echo "
	   <html><body>
	   <form action='login.php' method=POST>
	   <input type=text name='username'><br>
	   <input type=password name='password'><br>
	   <input type=submit>
	   </form>
	   </body></html>";
?>

