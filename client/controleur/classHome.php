<?php
class ControlleurHome
{
	private $db;
	
	function __construct($DB_con)
	{
		$this->db = $DB_con;
	}
	
	public function register($home)
	{  
		$idhome=$home->getidhome();
		$nom=$home->getidnom();
		$adresse_ip=$home->getadresse_ip();
		$iduser=$home->getiduser();
		$imageHome=$home->getimageHome();
		$pwdhome=$home->getpwdhome();
		try
		{
			$new_password = MD5($pwdhome);
			
			$stmt = $this->db->prepare("INSERT INTO home(nom,adresseIP,idUser,pwdhome) 
		                                               VALUES(:nom, :adresse_ip , :iduser, :pwdhome)");
												  
			$stmt->bindparam(":nom", $nom);
			$stmt->bindparam(":adresse_ip", $adresse_ip);
			$stmt->bindparam(":iduser", $iduser);
			$stmt->bindparam(":pwdhome", $new_password);										  
				
			$stmt->execute();	
			
			return $stmt;	
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}				
	}
public function redirect($url)
	{
		header("Location: $url");
	}
	public function delete($h){
	
		
	$stmt = $this->db->prepare('DELETE FROM  home WHERE idHome="$h"');

		$stmt->execute();
		
	}
	
}