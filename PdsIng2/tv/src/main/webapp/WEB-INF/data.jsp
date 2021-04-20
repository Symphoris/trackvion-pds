<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="/tv/common/styleMain.css" rel="stylesheet">
	<link href="/tv/common/health.css" rel="stylesheet">
	<link href="/tv/common/notification.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="icon" type="image/png" href="/tv/pictures/icon.png">
	<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
	<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
	<script type="text/javascript" src="/tv/script/chartData.js"></script>
	  <script src="/tv/script/notification.js"></script>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	
	<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>
	
<a href="/tv/searchResidents" class="button-refresh">Return</a>
<a href="/tv/data" class="button-refresh">Refresh</a>

<div id="data">${data}</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<div id="chartContainer" style="height: 300px; width: 100%;"></div>
  <div id="footer">
	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
		includeHTML();
	</script>

  </div>

	<META HTTP-EQUIV="Refresh" CONTENT="5; URL=/tv/data">

</body> 


</html>
