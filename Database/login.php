<?php
  require "dbConnect.php";
  $user_name = $_POST["user_name"];
  $password = $_POST["password"];
  $qry = "SELECT * FROM Users WHERE UserName = " . $user_name . " AND Password = " . $password . ";";
  $result = mysqli_query($conn, $qry);
  if(mysqli_num_rows($result) > 0) {
    echo "success";
  }
  else {
    echo "fail";
  }

?>