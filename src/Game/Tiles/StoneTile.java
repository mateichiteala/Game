package Game.Tiles;

import Game.Graphics.Assets;

public class StoneTile extends Tile {
    public StoneTile(int id) { super(Assets.stone, id); }

    @Override
    public boolean IsNext() { return true; }
}
