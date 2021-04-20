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
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	
	<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>
        <a href="/tv/health" class="button-refresh">Refresh</a>

         ${health} 
    <div id="carre"> <h1>Welcome, Oussama Bouachrine</h1></div>
 
        
        
          <div id="main1">
      <div id="menu1"  >
             
          <img  class="image" src="/tv/pictures/doctor.png" alt=""/>
           
      </div>

     <div id="contenu1" >
       <a  href="/tv/searchResidents" class = "icon1" title="Search Residents "> <img src="https://img.icons8.com/color/90/000000/search-property.png" /> Search Residents</a> 
       <a  href="/tv/data" class = "icon2" title="Map ">   <img src="https://img.icons8.com/color/96/000000/place-marker.png"/> Map </a>
       <a class = "icon3" title="Medical Statistics">   <img src="https://img.icons8.com/color/96/000000/business-report.png"/>   Statistics</a>
         
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