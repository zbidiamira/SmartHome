<?php
require_once 'dbconfig.php';

if($_SESSION['user_session']!="")
{
	$user->redirect('../home.php');
}

	$user->logout();
	$user->redirect('../index.php');

if(!isset($_SESSION['user_session']))
{
	$user->redirect('../index.php');
}