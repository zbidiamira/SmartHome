 <?php
    } 
else                /* send the submitted data */
    {
    $EmailFrom = isset($_REQUEST['email']);
$EmailTo = "exmpl@gmail.com";
$Name = Trim(stripslashes($_POST['name'])); 
$Subject = Trim(stripslashes($_POST['sujet']));
$Email = Trim(stripslashes($_POST['email'])); 
$Message = Trim(stripslashes($_POST['message'])); 

// validation
$validationOK=true;
if (!$validationOK) {
  print "<meta http-equiv=\"refresh\" content=\"0;URL=error.htm\">";
  exit;
}

// prepare email body text
$Body = "";
$Body .= "Name: ";
$Body .= $Name;
$Body .= "\n";
$Body .= "Sujet: ";
$Body .= $Subject;
$Body .= "\n";
$Body .= "Email: ";
$Body .= $Email;
$Body .= "\n";
$Body .= "Message: ";
$Body .= $Message;
$Body .= "\n";

// send email 
$success = mail($EmailTo, $Subject, $Body, "From: <$EmailFrom>");

// redirect to success page 
if ($success){
  echo '<center><div class="succee">Message envoyé, merci pour votre remarque !</div></center>';
}
else{
   echo '<center><div class="echec">Une erreur est survenue lors de l\'envoi. Veuillez <a href="contact.php"> réessayer </a> s\'il vous plait ! </div></center>   ';
}
    }  
?>