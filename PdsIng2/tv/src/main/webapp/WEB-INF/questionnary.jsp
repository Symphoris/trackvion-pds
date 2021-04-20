
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tv/common/styleMain.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/tv/pictures/icon.png">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


<script type="text/javascript" src="/tv/script/includeHTML.js"></script>
<script type="text/javascript" src="/tv/script/toggleMenu.js"></script>
<script type="text/javascript" src="/tv/script/questionnary.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<title>TrackVision</title>
</head>
<body>
	<div w3-include-html="/tv/common/${menu}.html"></div>

	<!-- question about the state of health -->
	<div style="padding-left: 16px">
		<br> ${optionalMessage}
		<h3>please complete this questionnary</h3>

		<div class="container">
			<form action="/tv/questionnary" method="post">
				<div class="row">
					<label class="col-md-6">Are you sick?</label> <label
						class="col-md-6" id="question" style="display: none;" required>what
						are your pathologie?</label>
				</div>
				<div class="row" id="diseaseRadioDisplay">
					<div class="col-xs-6 col-md-6 col-lg-6">

						<input type="radio" id="diseaseyes" name="isdisease" value="yes"
							onclick="displayDisease()" required> <label for="yes">yes</label>

						<input type="radio" id="athleteNo" name="isdisease" value="No"
							onclick="displayDisease()" checked> <label for="No">No</label>
					</div>

					<div class="col-xs-6 col-md-6 col-lg-6" id="whatdisease"
						style="display: none;">

						<input type="radio" id="hypertension" name="diseasename"
							value="hypertension" checked> <label for="huey">hyper
							tension</label> <input type="radio" id="diabetes" name="diseasename"
							value=diabetes> <label for="dewey">diabetes</label>

					</div>
				</div>

				<div class="row">
					<label class="col-md-6">Are you sporty?</label> <label
						class="col-md-6" id="sport" style="display: none;">what
						frequency?</label>
				</div>

				<div class="row" id="athleteRadioDisplay">
					<div class="col-xs-6 col-md-6 col-lg-6">

						<input type="radio" id="athleteoui" name="athlete" value="yes"
							onclick="displayAthlete()"> <label for="oui">Yes</label>

						<input type="radio" id="athletenon" name="athlete" value="No"
							onclick="displayAthlete()" checked> <label for="non">No</label>
					</div>

					<div class="col-xs-6 col-md-6 col-lg-6" id="athletefreq"
						style="display: none;">
						<input type="radio" id="once a week" name="frequence"
							value="once a week" checked> <label for="huey">once
							a week</label> <input type="radio" id="twice a week" name="frequence"
							value="twice a week"> <label for="dewey">twice a
							week</label> <input type="radio" id="three or more times a week"
							name="frequence" value="three or more times a week"> <label
							for="louie">three or more times a week</label>
					</div>
				</div>
				<br>
				<div class="row">
					<label class="col-xs-6 col-md-6 col-lg-6">Are you allergic?</label>
					<label class="col-xs-6 col-md-6 col-lg-6" id="questionallergie"
						style="display: none;"> what are your allergies? </label>
				</div>

				<div class="row" id="allergieRadioDisplay">
					<div class="col-xs-6 col-md-6 col-lg-6">
						<input type="radio" id="allergieoui" name="allergie" value="yes"
							onclick="displayAllergie()"> <label for="oui">Yes</label>

						<input type="radio" id="allergienon" name="allergie" value="no"
							onclick="displayAllergie()" checked> <label for="non">No</label>
					</div>


					<div class="col-xs-6 col-md-6 col-lg-6" id="allergietype"
						style="display: none;">
						<textarea id="story" name="allergiename" rows="2" cols="5">
										</textarea>
					</div>
				</div>

				<br>
				<div class="row">
					<label class="col-xs-6 col-md-6 col-lg-6"> Are you
						disabled?</label> <label class="col-xs-6 col-md-6 col-lg-6"
						id="questiondisabled" style="display: none;"> what are
						your disabilities? </label>
				</div>

				<div class="row" id="disabledRadioDisplay">
					<div class="col-xs-6 col-md-6 col-lg-6">
						<input type="radio" id="disabledoui" name="disabled" value="yes"
							onclick="displayDisabled()"> <label for="oui">Yes</label>

						<input type="radio" id="allergienon" name="disabled" value="no"
							onclick="displayDisabled()" checked> <label for="non">No</label>
					</div>

					<div class="col-xs-6 col-md-6 col-lg-6" id="disabledtype"
						style="display: none;">
						<input type="checkbox" id="wheelchair" name="whichdisabled"
							value="wheelchair"> <label for="vehicle1"> I'm in
							a wheelchair </label> <input type="checkbox" id="crutch"
							name="whichdisabled" value="crutch"> <label
							for="vehicle1"> I walk on crutches </label> <input
							type="checkbox" id="blind" name="whichdisabled" value="blind">
						<label for="vehicle1"> I am blind</label> <input type="checkbox"
							id="deaf" name="whichdisabled" value="deaf"> <label
							for="vehicle1"> I am deaf</label>

					</div>
				</div>

				<div class="row">
					<label class="col-md-6">how are you going to finance your
						stay ? </label> <label class="col-md-6" id="summax" style="display: none;">
						what is the maximum amount you can pay? </label> <label class="col-md-6"
						id="questionallergie" style="display: none;"> what are
						your allergies </label>
				</div>
				<br>
				<div class="row" id="financeRadioDisplay">
					<div class="col-xs-6 col-md-6 col-lg-6">
						<input type="radio" id="alone" name="finance" value="alone"
							onclick="displayFinance()"> <label for="alone">Alone</label>

						<input type="radio" id="pension" name="finance" value="pension"
							onclick="displayFinance()"> <label
							for="with a pension fund">With a pension fund</label> <input
							type="radio" id="social" name="finance" value="social"
							onclick="displayFinance()"> <label for="social">social
							assistance for accommodation</label>
					</div>

					<div class="col-xs-6 col-md-6 col-lg-6" id="whatpension"
						style="display: none;">
						<select name="agency" id="pet-select">
							<option value="">--Please choose an option--</option>
							<option value="CNAV">CNAV(Régime général de la sécurité
								sociale)</option>
							<option value="MSA">MSA (Mutualité Sociale Agricole)</option>
							<option value="IRCANTEC">IRCANTEC (Institution de
								Retraite Complémentaire des Agents Non Titulaires de l'Etat et
								des Collectivités publiques)</option>
							<option value="CRPN">CRPN (Caisse de retraite du
								personnel navigant professionnel de l'aéronautique civile)</option>
							<option value="CNAVPL">CNAVPL(Caisse Nationale
								d'Assurance Vieillesse des Professions Libérales)</option>
							<option value="RSI">RSI(Régime Social des Indépendants)
							</option>
							<option value="MSA">MSA(Mutualité Sociale Agricole)</option>
							<option value="FSPOEIE">FSPOEIE(Fonds Spécial des
								Ouvriers des Etablissements de l'Etat)</option>
						</select>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6" id="summemax"
						style="display: none;">
						<input type="number" id="summax" name="summax"
							placeholder="Your  maximum amount .." size="50"
							style="width: 100px";">
					</div>
				</div>


				<div class="row">
					<input type="submit" value="Submit">
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
						includeHTML();
					</script>
</body>
</html>