<?php

class ControlleurUSER
{
	private $db;
	
	function __construct($DB_con)
	{
		$this->db = $DB_con;
	}
	
	public function register($user)
	{   $nom=$user->getnom();
		$id=$user->getiduser();
		$email=$user->getemail();
		$tel=$user->getele();
		$pwd=$user->getpwd();
		$img=$user->getimg();
		try
		{
			$new_password = MD5($pwd);
			
			$stmt = $this->db->prepare("INSERT INTO user(nom,telephone,email,pwd) 
		                                               VALUES(:nom, :tel , :email, :pwd)");
												  
			$stmt->bindparam(":nom", $nom);
			$stmt->bindparam(":email", $email);
			$stmt->bindparam(":tel", $tel);
			$stmt->bindparam(":pwd", $new_password);										  
				
			$stmt->execute();	
			
          $to=$email;
          $subject="Email verification";
           $body='Hi, <br/> <br/> We need to make sure you are human. Please verify your email and get started using your Website account. <br/> <br/> <a href="http://127.0.0.1/projects/BASICA/controleur/activate.php?id=6"</a>';

         $this->Send_Mail($to,$subject,$body);


			return $stmt;	
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}				
	}
	
	public function login($nom,$pwd)

	{

		try
		{
			$stmt = $this->db->prepare("SELECT * FROM user WHERE nom=:nom ");
			$stmt->execute(array(':nom'=>$nom));
			$userRow=$stmt->fetch(PDO::FETCH_ASSOC);
			if($stmt->rowCount() > 0)
			{
				if($userRow['pwd']==MD5($pwd))
				{
					$_SESSION['user_session'] = $userRow['iduser'];
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
	}
	
	public function is_loggedin()
	{
		if(isset($_SESSION['user_session']))
		{
			return true;
		}
	}
	
	public function redirect($url)
	{
		header("Location: $url");
	}
	
	public function logout()
	{
		session_destroy();
		unset($_SESSION['user_session']);
		return true;
	}
	function Send_Mail($to,$subject,$body)
{
require 'class.phpmailer.php';
$from       = "http://127.0.0.1/projects/BASICA/services.php";
$mail       = new PHPMailer();
$mail->IsSMTP(true);            // use SMTP
$mail->IsHTML(true);
$mail->SMTPAuth   = true;                  // enable SMTP authentication
$mail->Host       = "smtp.http://127.0.0.1/projects/BASICA/services.php"; // SMTP host
$mail->Port       =  465;                    // set the SMTP port
$mail->Username   = "ksouri1993@gmail.com";  // SMTP  username
$mail->Password   = "wissem++";  // SMTP password
$mail->SetFrom($from, 'From Name');
$mail->AddReplyTo($from,'From Name');
$mail->Subject    = $subject;
$mail->MsgHTML($body);
$address = $to;
$mail->AddAddress($address, $to);
$mail->Send(); 
}
}
?>