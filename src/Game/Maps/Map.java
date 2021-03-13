package Game.Maps;

import Game.RefLinks;
import Game.Tiles.Tile;

import java.awt.*;
/*!
    \class Map este o clasa abstracta
    \brief Harta Jocului
 */
public abstract class Map {

    private final RefLinks  refLink;                    ///< O referinta catre un obiect "shortcut"
    protected int           width;                      ///<Latimea in numar de dale
    protected int           height;                     ///<Inaltimea in numar de dale
    protected int[][]       tiles;                      ///<Referinta catre o matrice cu codurile dalelor
    protected int           level           = 0;        ///<ce level este
    protected boolean       activate_level  = false;    ///<Daca schimbam harta

    /*!
        \fn public Map(RefLinks refLinks)
        \brief Constructor Map
        \Incarca harta prin functia LoadWorld()
        \refLinks - referinta la RefLinks
     */
    public Map(RefLinks refLinks){
        this.refLink = refLinks;
        LoadWorld();            ///<incarca harta de start
    }

    public void Update(){ }

    /*!
        \fn public void Draw(Graphics g)
        \Desenare harta
        \"g" unde se realizeaza desenarea
     */
    public void Draw(Graphics g){

        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++) {
            for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++) {
                if (tiles[x][y]!=0)
                {
                    if(tiles[x][y]== 3 || tiles[x][y] == 6)
                        GetTile(x, y).Draw(g, (int) x * 980, (int) y * 480);
                    else
                        GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
                }
            }
        }

    }


    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
           return Tile.backgroundTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta.
     */
    void LoadWorld()
    {

        ///<Se stabileste latimea hartii in numar de dale.
        width = 20;
        ///<Se stabileste inaltimea hartii in numar de dale
        height = 10;
        ///<Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        ///<Se incarca matricea cu coduri
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = harta(y, x);
            }
        }
    }

    /*! \fn abstract int harta(int x ,int y)
        \brief matricea de dale
        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    abstract  int harta(int x,int y);

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public void setActivate_level(boolean activate_level) { this.activate_level = activate_level; }
    public boolean getActivate_level() { return activate_level; }
}
