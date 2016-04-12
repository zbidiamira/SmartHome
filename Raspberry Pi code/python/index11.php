<?php
$servername = "localhost";
$username = "root";
$password = "root";
$dbname = "openbravo";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT ID,NAME,PRICESELL,CATEGORY FROM products";
$result = $conn->query($sql);
$res=array();
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
//echo "id: " . $row["ID"]. " - user: " . $row["NAME"]. " " . $row["PRICESELL"]." cat: ".$row[CATEGORY]. "<br>";
   array_push($res,
array('ID'=>$row["ID"],
'NAME'=>$row["NAME"],
'PRICESELL'=>$row["PRICESELL"],
'CATEGORY'=>$row["CATEGORY"]
));
    }

    echo json_encode(array("result"=>$res));

} else {
    echo "0 results";
}
$conn->close();
?>