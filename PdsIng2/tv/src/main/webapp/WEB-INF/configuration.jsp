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
		<br> ${optionalMessage}

		<div class="container">


			<form action="/tv/configuration" method="post">



				<h3>Configure my connected objects :</h3>
				<br> <br>
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

				<div class="row">
					<input type="submit" value="Configure">
				</div>



			</form>
		</div>
	</div>

	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
		includeHTML();
	</script>

</body>

</html>
