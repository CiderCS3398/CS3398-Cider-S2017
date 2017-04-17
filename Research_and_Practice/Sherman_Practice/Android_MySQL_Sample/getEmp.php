<?php 
	require_once('dbConnect.php');
	
	$id = $_POST['user_id'];
	$sql = "SELECT * FROM employee WHERE id=".$id;
	$r = mysqli_query($con,$sql);
	
	$result = array();
	
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"name"=>$row['name'],
			"desg"=>$row['designation'],
			"salary"=>$row['salary']
		));
	echo $row['name'];
	//echo json_encode(array('result'=>$result));
	
	mysqli_close($con);