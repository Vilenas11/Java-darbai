Table table;
int oneTimeUse = 0;
Block[] block = new Block[920];
Player player1 = new Player();
PImage tileSet;
PImage[] img;
boolean left, right, up, down;
String gameState = "SUk";
PImage background;
float pasirinkimas1 = 0;
int pasirinkimas = 0;


void sprites(PImage img[], Block block[]){
tileSet = loadImage("manoTileSetas.png");
int tileSetoKubuSkaicius = (tileSet.width / 32) * (tileSet.height / 32);
int temp1 = 0, temp2 = 0;
for(int i=0; i<tileSetoKubuSkaicius; i++){
    if(temp1 < tileSet.width){
    img[i] = tileSet.get(temp1,0, 32, 32);
    temp1= temp1 + 32;
  }
  else if(temp2 < tileSet.width){
      img[i] = tileSet.get(temp2,32, 32, 32);
      temp2= temp2 + 32;
  }
}

 for(int i = 0; i<tileSetoKubuSkaicius; i++){
        for(int j = 0; j<((width/32)*(height/32)); j++){
              if((block[j].getBlockID() == i)&&(block[j].getBlockID() != -1)){
                  block[j].setSprite(img[i]);
              }

              }
            }
}
void setBlockCoordinates(Block bllk[], int  clmnbr,int  rnbr){
  int temp = 0;
  for(int i = 0; i<rnbr; i++){
      for(int j=0; j<clmnbr;j++){
        
        bllk[temp].setBlockX(j*32);
        bllk[temp].setBlockY(i*32);
        temp++;
        }
      } 

  }
  void drawTheMap(Block blk[]){
 
  for(int i=0; i<((width/32)*(height/32)); i++){
        blk[i].renderYourself();
  }
}
void keyPressed() {
  switch(keyCode) {
  case 65: //left
    left = true;
    break;
  case 87: //up
    up = true;
    break;
  case 68: //right
    right = true;
    break;
  case 83: //down
    down = true;
    break;
  }
}
void keyReleased() {
  switch(keyCode) {
  case 65: //left
    left = false;
    break;
  case 87: //up
    up = false;
    break;
  case 68: //right
    right = false;
    break;
  case 83: //down
    down = false;
    break;
  }
} 
void DoOneTime(Block block[]){
  PImage[] img = new PImage[((width/32)*(height/32))];
   table = loadTable("mapas5.csv");
   int columnNumber = table.getColumnCount();
   int rowNumber = table.getRowCount();
   //int blockNumber = columnNumber * rowNumber;
   int tempNumber = 0;
     for(int j = 0; j <rowNumber; j++){ //issisaugo bloko vieta bei spriteo ID bloku masyve;
           for(int i=0; i<columnNumber; i++){
             block[tempNumber] = new Block(table.getInt(j, i),tempNumber);
             tempNumber++;
           }
     }
     setBlockCoordinates(block, columnNumber, rowNumber);
     sprites(img, block);
}

void setup(){
  smooth(3);
  size(1280,736);
  DoOneTime(block);
  draw();
}
void loadDaMap(){
  //background = loadImage("background.png");
  //image(background, 0 ,0);
 background(115,176,255);
     /*int temp = 0;
     for(int i=16; i<736; i=i+32){
       for(int j=16; j<1280; j=j+32){
           text(block[temp].getBlockY(), j, i);
           temp++;
      }
  }*/
  drawTheMap(block);
}
/*boolean verticalCollision(float y1, float h1, float y2, float h2){
if(){

  }
}*/

void registerAndSaveBlock(Block block[]){
      if(mousePressed == true){
          for(int i=0; i<((width/32)*(height/32)); i++){
                 if(((block[i].getBlockX()+32)>=mouseX) && (block[i].getBlockX()<=mouseX)&&((block[i].getBlockY()+32)>=mouseY)&& (block[i].getBlockY()<= mouseY)){
                        block[i].setBlockID(pasirinkimas);
                 }
          }
      }
}
void draw(){
  if(gameState != "EDIT"){
    
    loadDaMap();
    player1.display();
    player1.update(block);
    textSize(20);
    fill(0);
    text("Norint zemelapi pasidaryti paciam spauskite 'Y'", 10,100);
    if(keyPressed){
       if(key == 'Y'|| key == 'y') gameState = "EDIT";
              
    }
  }
  else if(gameState == "EDIT"){
      if(oneTimeUse == 0){
        for(int i=0; i<((width/32)*(height/32)); i++){
            block[i].setBlockID(-1);
        }
       background(120,70,40);
       oneTimeUse++;
      }
      background(120,70,40);
      drawTheMap(block);
      PImage tilesetasSuzymetas;
      tilesetasSuzymetas = loadImage("tilesetasHeHE.png");
      image(tilesetasSuzymetas, 0, 0);
      textSize(20);
      fill(0);
      text("Norint keisti bloko pasirinkima spauskite U raide", 10, 170);
      text("Jūsų dabartinis bloko pasirinkimas yra: " + pasirinkimas, 10, 200);
      text("Norint pradeti zaisti jusu sukurtoje arenoje, spauskite P raide", 10, 230);
      if(keyPressed){
          if(key == 'u' || key == 'U'){
               pasirinkimas1=pasirinkimas1 +0.1;
               pasirinkimas = round(pasirinkimas1);
              if(pasirinkimas > 9) {pasirinkimas = 0; pasirinkimas1 = 0;}
          }
          if(key == 'p' || key == 'P'){
             gameState = "PlayEdittedMap";
          }
      }
      PImage[] img = new PImage[((width/32)*(height/32))];
      registerAndSaveBlock(block);
      sprites(img, block);
  }
  else if(gameState == "PlayEdittedMap"){
    player1.display();
    player1.update(block);
  
  }
}


  //float d = dist(player1.getPlayerX(), player1.getPlayerY(), block[0].getBlockX(), block[0].getBlockY());
  //player1.gravity();
  /*background(0);
  yspeed+=gravity;
  y+=yspeed;
  Player player1 = new Player(); 
  rect(x,y,player1.getPlayerW(),player1.getPlayerH());
  if(keyPressed){
    if(keyCode == UP) yspeed = -10;
  }
  if(y > 500){
   y = 100;
  }
  /*  for(int i = 0; i<height; i=i+32){
       line(0,i,width,i);
  }
        for(int j =0; j<width; j=j+32){
       line(j, 0, j, height);
    }*/
