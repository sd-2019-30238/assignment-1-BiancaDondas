<!DOCTYPE html>
<html>
<head>
	<title>Books</title>
 <table>
 <tr>
  <th>Title</th> 
  <th>Author</th> 
  <th>Genre</th>
  <th>Release Date</th>
  <th>Description</th>
  
 </tr>
 <?php
$conn = mysqli_connect("localhost", "root", "paroladb", "books");
  // Check connection
  if ($conn->connect_error) {
   die("Connection failed: " . $conn->connect_error);
  } 
  $sql = "SELECT title, author, genre, data, description FROM books";
  $result = $conn->query($sql);
  if ($result->num_rows > 0) {
   // output data of each row
   while($row = $result->fetch_assoc()) {
    echo "<tr><td>" . $row["title"]. "</td><td>" . $row["author"] . "</td><td>"
. $row["data"]. "</td><td>" . $row["description"] . "</td></tr>";
}
echo "</table>";
} else { echo "0 results"; }
$conn->close();
?>
</table>


</head>
</html>
