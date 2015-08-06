<?php
	if(!isset($_POST['userID'])){
	   echo "<html><body>
	      <form action='addevent.php' method=POST>
	      <input type=text name='userID'>userID<br>
	      <input type=text name='deviceID'>deviceID<br>
	      <input type=text name='quantity' value='1'>quantity<br>
	      <input type=submit>
	      </form></body></html>";
	}
	else{
	   $userID=$_POST['userID'];
	   $deviceID=$_POST['deviceID'];
	   $quantity=$_POST['quantity'];

	   $link = mysqli_connect('oniddb.cws.oregonstate.edu','kitchenr-db'    ,'nECGSF1HSPp9DiCZ','kitchenr-db');

	   $query = "INSERT INTO WaDa_events (userID,deviceID,quantity) values ('$userID','$deviceID','$quantity')";
	   $result=mysqli_query($link,$query);
	   if(!$result) echo "failed";
	   mysqli_close($link);
	}
?>

