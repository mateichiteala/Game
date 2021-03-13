package Game.Tiles;

import Game.Graphics.Assets;

import java.awt.*;

public class BackGroundDeadTile extends Tile {
    public BackGroundDeadTile(int id) {
        super(Assets.backgroundDead, id);
    }

    public void Draw(Graphics g, int x, int y) {
        g.drawImage(img, x, y, 960, 480, null);
    }
}

