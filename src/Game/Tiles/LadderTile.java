package Game.Tiles;

import Game.Graphics.Assets;

public class LadderTile extends Tile {
    public LadderTile(int id){
        super(Assets.ladder,id);
    }

    @Override
    public boolean climb() {
        return true;
    }
}
