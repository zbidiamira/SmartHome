<?php
	require_once 'dbconfig.php';
	
	if(isset($_GET["del"])) {
		$id=$_GET["del"];



	$stmt = $DB_con->prepare('DELETE FROM  home WHERE idHome=:id');
$stmt->bindParam(':id', $id); 
		$stmt->execute();
	$home->redirect('../home.php');
	}
?>