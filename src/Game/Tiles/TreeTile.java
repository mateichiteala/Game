package Game.Tiles;

import Game.Graphics.Assets;

public class TreeTile extends Tile {
    public TreeTile(int id)
    {
        super(Assets.tree, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }

    @Override
    public boolean climb() {
        return false;
    }
}
