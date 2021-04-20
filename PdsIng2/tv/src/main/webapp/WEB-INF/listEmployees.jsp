<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="/tv/common/styleMain.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="icon" type="image/png" href="/tv/pictures/icon.png">
	<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
	<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
	<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>
	
	<div style="padding-left:16px">
	
  		<h3>This is the list of our current employees : </h3>
		${optionalMessage}
		<table class="distinguishedTable">
			<tr>
				<th>ID</th>
				<th>Last name</th>
    			<th>First name</th>
    			<th>Email</th>
    			<th>Action</th>
  			</tr>
  			${linesTable}
		</table>
	</div>

	<div w3-include-html="/tv/common/footer.html"></div>

	<script>includeHTML();</script>
	
</body> 

</html>
