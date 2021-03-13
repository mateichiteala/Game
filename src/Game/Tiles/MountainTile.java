package Game.Tiles;

import Game.Graphics.Assets;

public class MountainTile extends Tile{

    public MountainTile(int id){
        super(Assets.mountain,id);
    }

    @Override//Pentru coliziune
    public boolean IsSolid() {
        return true;
    }
}
