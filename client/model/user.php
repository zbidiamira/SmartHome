<?php

class User{
	private $iduser;
	private $nom;
	private $tele;
    private $email;
    private $pwd;
    private $img;
	

public function __construct($iduser,$nom,$tele,$email,$pwd,$img){

	$this->iduser=$iduser;
	$this->nom=$nom;
	$this->tele=$tele;
	$this->email=$email;
    $this->pwd=$pwd;
    $this->img=$img;
}

function  getnom(){
return $this->nom;
}
function getiduser(){

	return $this->iduser;
}
function getemail(){
	return $this->email;
}
function getele(){
	return $this->tele;
}

function getpwd(){
	return $this->pwd;
}
function getimg(){
	return $this->img;
}

function  setiduser($iduser){
$this->iduser=$iduser;
}
function  settnom($nom){
$this->nom=$nom;
}
function  settele($tele){
$this->tele=$tele;
}
function  setemail($email){
$this->email=$email;
}
function  setpwd($pwd){
$this->pwd=$pwd;
}

function  setimg($img){
$this->img=$img;
}


}
?>