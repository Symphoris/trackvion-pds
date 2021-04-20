function setup() {
  let d = 75;
  var thick = 10;

  // Sets the screen to be 720 pixels wide and 400 pixels high
  createCanvas(700, 500);
  background(600);
  noSmooth();

  // BATIMENT
  fill(231,168,84);
  rect(20,20,580,330);
   
  // COULOIRS
  fill(254,163,71);
  rect(20,150,600,70);

  //PIECES BAS
  fill(118,179,211);
  rect(30,245,100,100);
  rect(130,245,100,100);
  rect(230,245,100,100);
  rect(330,245,100,100);
  fill(24,160,150);
  rect(435,245,160,100);

  // ENTREE
  fill(34,66,124); 
  rect(600,140,20,90);
  
  // PIECES HAUT
  fill(118,179,211);
  rect(30,25,100,100);
  rect(130,25,100,100);
  rect(230,25,100,100);
  rect(330,25,100,100);
  fill(24,160,150);
  rect(435,25,160,100);
  
  stroke(231,168,84);
  line(60,125,100,125);
  line(160,125,200,125);
  line(260,125,300,125);
  line(360,125,400,125);
  line(490,125,530,125);
  
  line(60,245,100,245);
  line(160,245,200,245);
  line(260,245,300,245);
  line(360,245,400,245);
  line(490,245,530,245);
  
  // JARDIN
  fill(124,252,0);
  rect(20,351,580,190);
  
}