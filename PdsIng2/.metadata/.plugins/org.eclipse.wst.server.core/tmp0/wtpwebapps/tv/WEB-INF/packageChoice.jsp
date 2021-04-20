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

		<div class="row">
			<div class="col-75">
			<a href="/tv/package" target="_blank">
				<!-- <form action="/tv/package" method="POST">  -->
					<input type="submit" class="button-refresh" value="Basic formula">

				</form>
			</div>
			<div class="col-25">
				<label for="description">The price of this formula is 200euro</label>
			</div>

		</div>

		<div class="row">
			<div class="col-75">
				<form action="/tv/package" method="POST">
					<input type="submit" class="button-refresh" value="Gold formula">
				</form>
			</div>
			<div class="col-25">
				<label for="description">The price of this formula is 300euro</label>
			</div>

		</div>
	</div>

	<div class="row">
		<div class="col-75">
			<form action="/tv/package" method="POST">
				<input type="submit" class="button-refresh" value="Premium formula">
			</form>
		</div>
		<div class="col-25">
			<label for="description">The price of this formula is 400euro</label>
		</div>

	</div>



	<div w3-include-html="/tv/common/footer.html"></div>

	<script>
		includeHTML();
	</script>
</body>
</html>