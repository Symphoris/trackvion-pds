function showStuff(id) {
	document.getElementById(id).style.display = 'block';

}
function hideStuff(id) {
	document.getElementById(id).style.display = 'none';

}


function displayAthlete(){
	var radios = document.getElementsByName('athlete');
	var valeur;
	for(var i = 0; i < radios.length; i++){
		if(radios[i].checked){
			valeur = radios[i].value;
		}
	}
	if(valeur=='yes'){
		showStuff('athletefreq');
		showStuff('sport');
	}
	else{
		hideStuff('athletefreq');
		hideStuff('sport');
	}
}



function displayDisease(){
	var radios = document.getElementsByName('isdisease');
	var valeur;
	for(var i = 0; i < radios.length; i++){
		if(radios[i].checked){
			valeur = radios[i].value;
		}
	}
	if(valeur=='yes'){
		showStuff('whatdisease');
		showStuff('question');
	}
	else{
		hideStuff('whatdisease');
		hideStuff('question');
	}				
}



function displayAllergie(){
	var radios = document.getElementsByName('allergie');
	var valeur;
	for(var i = 0; i < radios.length; i++){
		if(radios[i].checked){
			valeur = radios[i].value;
		}
	}
	if(valeur=='yes'){
		showStuff('allergietype');
		showStuff('questionallergie');
	}
	else{
		hideStuff('allergietype');
		hideStuff('questionallergie');
	}


}



function displayFinance(){
	var radios = document.getElementsByName('finance');
	var valeur;
	for(var i = 0; i < radios.length; i++){
		if(radios[i].checked){
			valeur = radios[i].value;
		}
	}
	if(valeur=='pension'){
		showStuff('whatpension');
	} else{
		hideStuff('whatpension');
		hideStuff('question');
	}
	
	if (valeur == 'alone'){
		showStuff('summemax');
		
	}else {
		hideStuff('summemax');
		hideStuff('summax');
	}


}

function displayDisabled(){
	var radios = document.getElementsByName('disabled');
	var valeur;
	for(var i = 0; i < radios.length; i++){
		if(radios[i].checked){
			valeur = radios[i].value;
		}
	}
	if(valeur=='yes'){
		showStuff('disabledtype');
		showStuff('questiondisabled');
	}
	else{
		hideStuff('disabledtype');
		hideStuff('questiondisabled');
	}


}


