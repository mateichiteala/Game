package Game.Tiles;

import Game.Graphics.Assets;

import java.awt.*;

class BackGroundTile  extends Tile {
    public BackGroundTile(int id) {
        super(Assets.background, id);
    }
    public void Draw(Graphics g, int x, int y){
        g.drawImage(img,x,y,960,480,null);
    }
}
class BackGroundTile2  extends Tile {
    public BackGroundTile2(int id) {
        super(Assets.background2, id);
    }
    public void Draw(Graphics g, int x, int y){
        g.drawImage(img,x,y,960,480,null);
    }
}