<?php
class Home{
	public  $idhome;
	public  $nom;
	public $adresse_ip;
	public $iduser;
	public $imageHome;
	public $pwdhome;
	public function __construct($idhome,$nom,$adresse_ip,$iduser,$imageHome,$pwdhome){
		$this->idhome=$idhome;
		$this->nom=$nom;
		$this->adresse_ip=$adresse_ip;
		$this->iduser=$iduser;
		$this->imageHome=$imageHome;
		$this->pwdhome=$pwdhome;
	}
	public function getidhome(){
		return $this->idhome;
	}
	public function getidnom(){
		return $this->nom;
	}
	public function getadresse_ip(){
		return $this->adresse_ip;
	}
	public function getiduser(){
		return $this->iduser;

	}
	public function getimageHome(){
		return $this->imageHome;
	}
	public function getpwdhome(){
		return $this->pwdhome;
	}
	public function setidhome($idhome){
		$this->idhome=$idhome;
	}
	public function setnom($nom){
		$this->nom=$nom;
	}
	public function setadresse_ip($adresse_ip){
	    $this->adresse_ip=$adresse_ip;
	}
	public function setiduser($iduser){
		$this->iduser=$iduser;

	}
	public function setimageHome($imageHome){
		$this->imageHome=$imageHome;
	}
		public function setpwdhome($pwdhome){
		$this->pwdhome=$pwdhome;
	}
}
?>