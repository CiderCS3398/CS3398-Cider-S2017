<?php
  require_once('dbConnect.php');

  $username = "default";
  $password = "default";

  if (empty($_POST['username']) || empty($_POST['password'])) {
        // Create some data that will be the JSON response 
        $response["success"] = 0;
        $response["message"] = "One or both of the fields are empty .";
        
        //die is used to kill the page, will not let the code below to be executed. It will also
        //display the parameter, that is the json data which our android application will parse to be //shown to the users
        //echo "post was empty";
        die(json_encode($response));
    }

  if(isset($_POST['username']) && isset($_POST['password']))
  {
    $username = $_POST["username"];
    $password = $_POST["password"];
  }

  try 
  {
    $sql = "SELECT * FROM Users WHERE UserName = ? AND Password = ?";
    if($stmt = $con->prepare($sql))
    {
      $stmt->bind_param("ss", $username, $password);
      //$stmt->bindParam("username", $username);
      //$stmt->bindParam("password", $password);
      $stmt->execute();
      $row = $stmt->fetch();
      if($row > 0)
      {
        $response["success"] = 1;
        $response["message"] = "Login was successful.";
        //echo "success";
        die(json_encode($response));
      }
      else
      {
        $response["success"] = 0;
        $response["message"] = "Invalid username or password.";
        //echo "fail";
        die(json_encode($response));
      }
    }
    
  } catch(PDOException $e) {
    echo '{"error":{"text":'. $e->getMessage() .'}}'; 
  }

?>