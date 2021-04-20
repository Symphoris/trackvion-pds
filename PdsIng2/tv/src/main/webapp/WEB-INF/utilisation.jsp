<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tv/common/styleMain.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/tv/pictures/icon.png">
<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
<title>TrackVision</title>
</head>

<body>

	<div w3-include-html="/tv/common/${menu}.html"></div>

	<div style="padding-left: 16px">
		<br>
		${optionalMessage}
		<br>
		<br>
	
		
		<div class="container">
		
		<h3>Use my connected objects : </h3>
			<form action="/tv/utilisation" method="post">
			
				<h2>Configure connected baths :</h2>

				<div class="row">
					<div class="col-25">
						<label for="niveauEau">maximum water level:</label>
					</div>
					<div class="col-75">
						<input type="number" id="niveauEau" name="niveauEau"
							placeholder="maximum water level..">
					</div>
				</div>

				<h2>Configure connected bulbs :</h2>

				<div class="row">
					<div class="col-25">
						<label for="actMax">Maximum activity time:</label>
					</div>
					<div class="col-75">
						<input type="number" id="actMax" name="actMax"
							placeholder="Maximum activity time..">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="degreluminosite">Maximum brightness level:</label>
					</div>
					<div class="col-75">
						<input type="number" id="degreluminosite" name="degreluminosite"
							placeholder="Maximum brightness level..">
					</div>
				</div>

				<h2>Configure connected blinds :</h2>

				<div class="row">
					<div class="col-25">
						<label for="dureeOuvertmax">Maximum opening time :</label>
					</div>
					<div class="col-75">
						<input type="number" id="dureeOuvertmax" name="dureeOuvertmax"
							placeholder="Maximum opening time..">
					</div>
				</div>
				<h2>Configure connected Ovens :</h2>

				<div class="row">
					<div class="col-25">
						<label for="durMaxAct">Maximum operating time :</label>
					</div>
					<div class="col-75">
						<input type="number" id="durMaxAct" name="durMaxAct"
							placeholder="Maximum operating time..">
					</div>
				</div>

			
			<h2>Handle my connected bathtub : </h2>
			
				<div class="row">
					<div class="col-25">
						<label for="niveauEau">Bath water level:</label>
					</div>
					<div class="col-75">
						<input type="number" id="niveauEau2" name="niveauEau2"
							placeholder="Bath water level..">
					</div>
				</div>
				
				<div class="row">
					<div class="col-25">
						<label for="degréTemperature">Water temperature :</label>
					</div>
					<div class="col-75">
						<input type="number" id="degreTemperature2" name="degreTemperature2"
							placeholder="Water temperature..">
					</div>
				</div>
				
				<h2>Handle my connected bulbs :</h2>
				
				<div class="row">
					<div class="col-25">
						<label for="off">Turn off / on my connected bulbs:</label>
					</div>
					<div class="col-75">
						<input type="text" id="off" name="off"
							placeholder="ON/OFF..">
					</div>
				</div>
				
				<div class="row">
					<div class="col-25">
						<label for="">Brightness level :</label>
					</div>
					<div class="col-75">
						<input type="number" id="bright" name="bright"
							placeholder="Brightness level..">
					</div>
				</div>
				
				
				<h2>Handle the connected blinds : </h2>
				
				<div class="row">
					<div class="col-25">
						<label for="actMax">Open / Close my connected blinds :</label>
					</div>
					<div class="col-75">
						<input type="text" id="off2" name="off2"
							placeholder="ON/OFF..">
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-25">
						<label for="actMax">Blind Position :</label>
					</div>
					<div class="col-75">
						<input type="number" id="openTime" name="openTime"
							placeholder="Blind Position..">
					</div>
				</div>
				
				<h2>Handle connected ovens : </h2>
				
				<div class="row">
					<div class="col-25">
						<label for="actMax">Switch off / on my plates:</label>
					</div>
					<div class="col-75">
						<input type="text" id="off3" name="off3"
							placeholder="ON/OFF..">
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-25">
						<label for="actMax">Cooking hob temperature:</label>
					</div>
					<div class="col-75">
						<input type="number" id="hobTemp" name="hobTemp"
							placeholder="Ovens temperature">
					</div>
				</div>
				<br><br>
				<div class="row">
					<input type="submit" value="Submit">
				</div>
				
			</form>
		</div>
	</div>

	<div w3-include-html="/tv/common/footer.html"></div>

	<script>includeHTML();</script>

</body>

</html>
