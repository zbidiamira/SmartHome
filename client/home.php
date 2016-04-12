<?php
include '/model/Home.php';
include '/model/user.php';
require_once '/controleur/dbconfig.php';
if(!$user->is_loggedin())
{   $user->logout();
    $user->redirect('/controleur/logout.php');
}
$user_id = $_SESSION['user_session'];
$stmt = $DB_con->prepare("SELECT * FROM user WHERE iduser=:user_id");
$stmt->execute(array(":user_id"=>$user_id));
$userRow=$stmt->fetch(PDO::FETCH_ASSOC);
if(isset($_POST['btn-']))
{
$user->redirect('/controleur/logout.php');
}
if(isset($_POST['btn-signup']))
{
    $uname = trim($_POST['txt_uname']);
    $adresseip=trim($_POST['adresseip']);
    $upass = trim($_POST['txt_upass']); 
    
    if($uname=="")  {
        $error[] = "provide name home !";    
    }
    else if($adresseip=="")  {
        $error[] = "provide adresseip home !";    
    }
    else if($upass=="") {
        $error[] = "provide password !";
    }
    else if(strlen($upass) < 6){
        $error[] = "Password must be atleast 6 characters"; 
    }
    else
    {
        try
        {
            $stmt = $DB_con->prepare("SELECT nom FROM home WHERE  idUser=:user_id");
            $stmt->execute(array(':user_id'=>$user_id));
            $row=$stmt->fetch(PDO::FETCH_ASSOC);
            
            if($row['nom']==$uname) {
                $error[] = "sorry name home id already taken !";

            }
            else
            {

                $home1=new Home('',$uname,$adresseip,$user_id,'',$upass);
                if($home->register($home1)) {
                    
                   $home->redirect('home.php?joined'); 
                }
            }
        }
        catch(PDOException $e)
        {
            echo $e->getMessage();
        }
    }   
}
?>



<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BASICA! A Free Bootstrap3 HTML5 CSS3 Template by Vactual Art</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
	<link rel="stylesheet" href="css/main.css">
    <link href="css/custom.css" rel="stylesheet">
	
	

    <!-- Custom Fonts & Icons -->
   
	<link rel="stylesheet" href="css/icomoon-social.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<style type="text/css">
  
   
@import url(http://fonts.googleapis.com/css?family=Roboto);

* {
    font-family: 'Roboto', sans-serif;
}

#login-modal .modal-dialog {
    width: 350px;
}

#login-modal input[type=text], input[type=password] {
	margin-top: 10px;
}

#div-login-msg,
#div-lost-msg,
#div-register-msg {
    border: 1px solid #dadfe1;
    height: 30px;
    line-height: 28px;
    transition: all ease-in-out 500ms;
}

#div-login-msg.success,
#div-lost-msg.success,
#div-register-msg.success {
    border: 1px solid #68c3a3;
    background-color: #c8f7c5;
}

#div-login-msg.error,
#div-lost-msg.error,
#div-register-msg.error {
    border: 1px solid #eb575b;
    background-color: #ffcad1;
}

#icon-login-msg,
#icon-lost-msg,
#icon-register-msg {
    width: 30px;
    float: left;
    line-height: 28px;
    text-align: center;
    background-color: #dadfe1;
    margin-right: 5px;
    transition: all ease-in-out 500ms;
}

#icon-login-msg.success,
#icon-lost-msg.success,
#icon-register-msg.success {
    background-color: #68c3a3 !important;
}

#icon-login-msg.error,
#icon-lost-msg.error,
#icon-register-msg.error {
    background-color: #eb575b !important;
}

#img_logo {
    max-height: 100px;
    max-width: 100px;
}

/* #########################################
   #    override the bootstrap configs     #
   ######################################### */

.modal-backdrop.in {
    filter: alpha(opacity=50);
    opacity: .8;
}

.modal-content {
    background-color: #ececec;
    border: 1px solid #bdc3c7;
    border-radius: 0px;
    outline: 0;
}

.modal-header {
    min-height: 16.43px;
    padding: 15px 15px 15px 15px;
    border-bottom: 0px;
}

.modal-body {
    position: relative;
    padding: 5px 15px 5px 15px;
}

.modal-footer {
    padding: 15px 15px 15px 15px;
    text-align: left;
    border-top: 0px;
}

.checkbox {
    margin-bottom: 0px;
}


.btn1 {
	 border-radius: 0px;}
	 
.btn1:focus,
.btn1:active:focus,
.btn1.active:focus,
.btn1.focus,
.btn1:active.focus,
.btn1.active.focus {
    outline: none;
}

.btn1-lg, .btn1-group-lg>.btn1 {
    border-radius: 0px;
}

.btn1-link {
    padding: 5px 10px 0px 0px;
    color: #95a5a6;
}

.btn1-link:hover, .btn1-link:focus {
    color: #2c3e50;
    text-decoration: none;
}


.form-control {
  border-radius: 0px;
}

    </style>
     <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/icomoon-social.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>

</head>

    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
        

    <header class="navbar navbar-inverse navbar-fixed-top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="Basica"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                     <li class="active"><a href="home.php">Home</a></li>
                    <li><a href="about.php">About Us</a></li>
                    <li ><a href="contact.php">Contact</a></li>
                    <li> <a href="controleur/logout.php"   >Logout</a>
                </ul>
            </div>
        </div>
    </header><!--/header-->
<!-- BEGIN # MODAL LOGIN -->
<!--editer >

    <!-->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" align="center">
                
                        		
                        		
		
                              
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <form id="login-form" action="home.php" method="post">
                         <h2>Sign up </h2><hr/>
              <?php
            if(isset($error))
            {
                foreach($error as $error)
                {
                     ?>
                     <div class="alert alert-danger">
                        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                     </div>
                     <?php
                }
            }
            else if(isset($_GET['joined']))
            {
                 ?>
                 <div class="alert alert-info">
                      <i class="glyphicon glyphicon-log-in"></i> enregistrer un nouveau home                 </div>
                 <?php
            }
            ?>
		                <div class="modal-body">
				    		<div id="div-login-msg">
                                <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-login-msg">Entrer votre User Name and Password.</span>
                            </div>
				    		<input  name='txt_uname' class="form-control" type="text" placeholder="Enter your home name" required value="<?php if(isset($error)){echo $uname;}?>">
                            <input  name='adresseip' class="form-control" type="text" placeholder="Enter your home name" required  value="<?php if(isset($error)){echo $adresseip;}?>">
				    		<input  name='txt_upass' class="form-control" type="password" placeholder="Password" required>
                           
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <button name='btn-signup' type="submit" class="btn btn-primary btn1-lg btn-block">ajouter</button>
                            </div>
				    	   
				        </div>
                    </form>
                    <!-- End # Login Form -->
                  
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
        <!-- Page Title -->
		<div class="container">
<?php
 $stmt = $DB_con->prepare("SELECT * FROM home WHERE idUser=:user_id");
$stmt->execute(array(":user_id"=>$user_id));


echo "<br> <br> <br> <br>";

 echo "<div align='center'><h1>MY Homes</h1></div>";
 echo "<table class='table table-striped' style='width: auto;' align='center'>";
 echo "<tr><th>Nom Home</th><th>adresse IP Home</th><th>Camera</th></tr>";

 while($userRow=$stmt->fetch(PDO::FETCH_ASSOC))
 {$id=$userRow['idHome'];
	 echo"<tr> <form method='post'> ";
	 echo"<td>".$userRow['nom']."</td>";
	 echo"<td> <a  href='http://".$userRow['adresseIP']."'>".$userRow['adresseIP']."</a></td></form>";
	 echo"<td><a href='http://".$userRow['adresseIP'].':8081'."'>".$userRow['adresseIP'].':8081'."</a></td>";
     echo"<td><input href='#'   data-toggle='modal'  value='Edit' data-target='#login-modal' type='submit' class='btn btn-success value='Edit'/></td>";  
     echo"<td><a href='controleur/delete.php?del=$id'><input type='submit' class='btn btn-danger' value='Supprimer'/></a></td>";
	  
     echo "</tr>";
 }
 echo "</table>";
 echo "<br><br>";
 echo "<div align='center'><input href='#'   data-toggle='modal'  value='add home' data-target='#login-modal' type='submit' class='btn btn-success value='add home'/></div>";
 
 ?>
 </div>

       <br>  <br>  <br>  <br> 

	    <!-- Footer -->
	    <div class="footer">
	    	<div class="container">
			
		    	<div class="row">
				
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>Contact Us</h3>
		    			<p class="contact-us-details">
	        				<b>Address:</b> 123 Downtown Avenue, Manhattan, New York, United States of America<br/>
	        				<b>Phone:</b> +1 123 45678910<br/>
	        				<b>Fax:</b> +1 123 45678910<br/>
	        				<b>Email:</b> <a href="mailto:info@yourcompanydomain.com">info@yourcompanydomain.com</a>
	        			</p>
		    		</div>				
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>Our Social Networks</h3>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam.</p>
		    			<div>
		    				<img src="img/icons/facebook.png" width="32" alt="Facebook">
		    				<img src="img/icons/twitter.png" width="32" alt="Twitter">
		    				<img src="img/icons/linkedin.png" width="32" alt="LinkedIn">
							<img src="img/icons/rss.png" width="32" alt="RSS Feed">
						</div>
		    		</div>
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>About Our Company</h3>
		    				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci.</p>
		    		</div>

		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">
		    			<div class="footer-copyright">&copy; 2014 <a href="http://www.vactualart.com/portfolio-item/basica-a-free-html5-template/">Basica</a> Bootstrap HTML Template. By <a href="http://www.vactualart.com">Vactual Art</a>.</div>
		    		</div>
		    	</div>
		    </div>
	    </div>

        <!-- Javascripts -->
       
        <script>window.jQuery || document.write('<script src="js/jquery-1.9.1.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
		
		<!-- Scrolling Nav JavaScript -->
		<script src="js/jquery.easing.min.js"></script>
		<script src="js/scrolling-nav.js"></script>		
    </body>
</html>