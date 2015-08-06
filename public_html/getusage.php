<?php
	if(!isset($_POST['userID'])){
   		echo "<html><body>
      			<form action='getusage.php' method=POST>
      			<input type=text name='userID'>
      			<input type=submit>
      			</form></body></html>";
	}
	else
	{
		$userID=$_POST['userID'];
		$link=mysqli_connect('oniddb.cws.oregonstate.edu','kitchenr-db','nECGSF1HSPp9DiCZ','kitchenr-db');
		$query="SELECT WaDa_devices.deviceID,gallons,quantity,name,date FROM WaDa_events INNER JOIN WaDa_devices ON WaDa_events.deviceID=WaDa_devices.deviceID WHERE userID='$userID'";
		//echo $query;
		$result=mysqli_query($link,$query);
		while($row=mysqli_fetch_assoc($result)){
		   $deviceID=$row['deviceID'];
		   $gallons=$row['gallons'];
		   $quantity=$row['quantity'];
		   $name=$row['name'];
		   $date=$row['date'];
		   $foutput= "[$deviceID,$gallons,$quantity,$name,$date]";
		   echo $foutput;
		}
		mysqli_close($link);
 	}
?>

