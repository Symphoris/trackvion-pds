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
        <a href="/tv/candidatelist" class="button-refresh">Refresh</a>

	<div style="padding-left:16px">
	
  		<h3>This is the list of our current Candidate : </h3>
		${optionalMessage}
		
		<form method="GET" action="/tv/candidatelist">
		<label>Coefficent Finance</label>
		<input type="number" name="finance" value="finance" placeholder="50"></input>%
		<label>Coefficient Santé</label>
		<input type="number" name="sante" value="sante" placeholder="50"></input>% 
		<input type='submit' value='Changer les coefficients de pondération'>
		</form>
		<div class="row">
			<h4>Coefficient finance : ${financeCoef} % Coefficient santé: ${santeCoef} %</h4>
		</div>
		<table class="distinguishedTable">
			<tr>
				<th>ID</th>
				<th>civility</th>
				<th>Age</th>
				<th>Last name</th>
    			<th>First name</th>
    			<th>Email</th>
    			<th>Profil</th>
    			<th>NoteFinance</th>
    			<th>NoteSante</th>
    			<th>NoteGlobale</th>
    			<th>Action</th>
  			</tr>
  			 
  			${linesTable}
  			
		</table>
	</div>

<div id="footer">
	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
		includeHTML();
	</script>

  </div>

</body>


</html>