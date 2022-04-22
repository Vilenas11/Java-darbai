class Player{
float playerX, playerY, playerW, playerH;
float speedX, speedY, maxSpeedX, maxSpeedY, gravitySize;
boolean isOnGround = false;
Player(){
  playerX = 100;
  playerY = 0;
  playerW = 32;
  playerH = 64;
  speedX = 0;
  speedY = 0;
  maxSpeedX = 0.5;
  maxSpeedY = 10;
  gravitySize = 0.2;
  }
  float getPlayerX(){
    return playerX;
  }
  float getPlayerY(){
    return playerY;
  }
    float getPlayerW(){
    return playerW;
  }
    float getPlayerH(){
    return playerH;
  }
   void display() {
    fill(0, 255, 50, 100);
    rect(playerX, playerY, playerW, playerH);
  }
  void update(Block blk[]) {
    if(isOnGround == true){
      if(up){
      speedY=-maxSpeedY/1.5;
      isOnGround = false;
      }
    }
    if (left) {
      speedX = speedX-maxSpeedX;
    }
    if (right) {
      speedX = speedX+maxSpeedX;
    }
    if(down){
      speedY = speedY+maxSpeedY/15;
    }
    playerY = playerY + speedY;
    speedY = speedY+gravitySize;
    for(int i = 0; i<920; i++){
      if(  (  (blk[i].getBlockID()!= -1)     &&    (playerY + 64 > blk[i].getBlockY())  )     ){//botom collision
        if(blk[i].getBlockX()< playerX + 32){
             playerY = blk[i].getBlockY() - 64;
             isOnGround = true;
        }
      }
    }
    playerX = playerX + speedX;
    speedX = speedX * 0.90;
    if(playerX < 0){
      playerX = 0;
    }
    if(playerX +32 > width){
      playerX = width - 32;
    }
  }
}
