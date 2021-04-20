function draw() {
		stroke(0);
		 var thick = 10;
		 var xValue = document.getElementById('positionX').textContent;
		 var valueX = parseInt(xValue,10);
		 var yValue = document.getElementById('positionY').textContent;
		 var valueY = parseInt(yValue,10);
		 strokeWeight (thick);
		point (valueX,valueY); 
	}
