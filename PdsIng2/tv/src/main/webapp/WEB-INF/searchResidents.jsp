<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tv/common/styleMain.css" rel="stylesheet">
<link href="/tv/common/notification.css" rel="stylesheet">
<link href="/tv/common/searchResidents.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/tv/pictures/icon.png">
<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
      <script src="/tv/script/chartData.js"></script>
       
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>
	
<a href="/tv/health" class="button-refresh">Return</a>
<a href="/tv/searchResidents" class="button-refresh">Refresh</a>
 
 <h1>Check Resident Health</h1>

 <form action="/tv/searchResidents" method="post">

						<label for="name">Resident Name </label>
						<input type="text" id="name" name="name" placeholder="EX : Oussama Bouachrine" list="namedata">
						<datalist id="namedata">
						     ${residents}
						</datalist>
						  <input type="submit" value="Search" class="icon4" />

		</form>	
		
		
 <div id="contenu1" >
 <div class="informations">
	 ${results}

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