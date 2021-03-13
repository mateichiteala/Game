package Game.Tiles;

import Game.Graphics.Assets;

import java.awt.image.BufferedImage;

public class UnderTile extends Tile {
    public UnderTile(int id){
        super(Assets.under,id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
