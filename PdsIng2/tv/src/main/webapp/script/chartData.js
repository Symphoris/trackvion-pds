
window.onload = function () {

	var dataPoints1 = [];

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	//theme: "light2",
	title:{
		text: "Check Resident Health"
	},
	axisX:{
		valueFormatString: "DD-MM-YYYY hh:mm:ss ",

		crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
	},
	axisY: {
		title: "HeartRateData",
		prefix: " btm",
		interval: 10,
		crosshair: {
			enabled: true
		}
	},
	toolTip:{
		shared:true
	},  
	legend:{
		cursor:"pointer",
		verticalAlign: "bottom",
		horizontalAlign: "left",
		dockInsidePlotArea: true,
		itemclick: toogleDataSeries
	},
	data: [{
		type: "line",
		showInLegend: true,
		name: "Heart Data",
		markerType: "circle",
		xValueFormatString: "DD MMM, YYYY  hh:mm:ss",
		color: "#46a049",
		dataPoints: dataPoints1

	},
	{
		type: "line",
		showInLegend: true,
		name: "Unique Visit",
		lineDashType: "dash",
		dataPoints: [
			
		]
	}]
});
chart.render();

function toogleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	} else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
function updateChart() {
	var medicalData =document.getElementById('data').textContent;
	var d = medicalData+"";
 var words = d.split(",");
var z;
var datax=[];
var datay=[];
for (z=0 ; z<words.length ; z++){
	   var reste = z % 2;
       if (reste == 0) {
    	   datax.push(words[z]);
    	  
       } else {
    	   datay.push(words[z]);
    	   
       }
	
}


	// pushing the new values
	var i;
	var j;
	for (i=0, j=0 ; i<datay.length , j<datax.length ; i++, j++){
		if(parseInt(datay[i],10)>70 || parseInt(datay[i],10)<60 ){
			dataPoints1.push({
				x : new Date(datax[j].replace(" ","T")),
				y: parseInt(datay[i],10),
				markerType: "triangle",  markerColor: "#ff0000" 
			});
		}
		else {
	dataPoints1.push({
		x : new Date(datax[j].replace(" ","T")),
		y: parseInt(datay[i],10),
	});
	}}


	chart.options.data[0].legendText = " Resident A  ";
	chart.render();
}
updateChart();
}




