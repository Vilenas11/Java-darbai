class Block{
float blockWidth;
float blockHeight;
int blockX;
int blockY;
int blockID;
int blockPlace;
PImage imagee;
Block(){
  blockWidth = 32;
  blockHeight = 32;
}
Block(int givenID, int givenPlace){
  blockWidth = 32;
  blockHeight = 32;
  blockID = givenID;
  blockX = 0;
  blockY = 0;
  blockPlace = givenPlace;
  }
 int getBlockID(){
   return blockID;
 }
  int getBlockPlace(){
   return blockPlace;
 }
   int getBlockX(){
   return blockX;
 }
    int getBlockY(){
   return blockY;
 }
 void setBlockID(int givenID){
    blockID = givenID;
 }
 void setSprite(PImage m){
   imagee = m; 
 }
 void setBlockX(int XXX){
     blockX = XXX;
 }
 void setBlockY(int YYY){
     blockY = YYY;
 }
 PImage getImage(){
   return imagee;
 }
  void renderYourself(){
    if(blockID != -1){
      image(imagee, blockX, blockY,blockWidth,blockHeight);
    }
  }
}
