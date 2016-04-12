<?php
	require_once 'dbconfig.php';
	if(!empty($_GET["id"])) {
	$query = "UPDATE user set status = 'active' WHERE iduser='" . $_GET["id"]. "'";
	$result =$DB_con->prepare($query);
	$result->execute();
		if(!empty($result)) {
			$_SESSION['user_session'] = $_GET["id"];
			$user->redirect('http://127.0.0.1/BASICA/BASICA/home.php');
			$message = "Your account is activated.";
		} else {
			$message = "Problem in account activation.";

			echo $message;
		}
	}
?>