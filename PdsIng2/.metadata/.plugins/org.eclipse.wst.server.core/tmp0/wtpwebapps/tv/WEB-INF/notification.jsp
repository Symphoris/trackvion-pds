<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tv/common/styleMain.css" rel="stylesheet">
<link href="/tv/common/notification.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/tv/pictures/icon.png">
<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>
	
<a href="/tv/health" class="button-refresh">Return</a>
<a href="/tv/notification" class="button-refresh">Refresh</a>
<h1>Notifications</h1>
<p>Click on the "close" button to close the alert message.</p>
<p>Click on the "Details" button to get alert and resident details related to the alert.</p>

  <div id="main">
      <div id="menu"  >
           ${message}
      </div>


    
 <h1>Alert and Resident Details </h1>
     <div id="contenu" >
        ${details}   
     </div>
   </div>  

  <div class="notify">
    ${notif}
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/tv/script/notification.js"></script>

  <div id="footer">
	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
		includeHTML();
	</script>

  </div>

</body>
</html>