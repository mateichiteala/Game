package Game.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class Tile
    \Retine toate dalele intr-un vector si ofera posibilitatea gasirii dupa un id
 */
public class Tile {

    private static final int    NO_TILES            = 32;
    public static Tile[]        tiles               = new Tile[NO_TILES];///<vector pentru tipuri de dale

    public static Tile          grassTile           = new GrassTile(1);     /*!< Dala de tip iarba*/
    public static Tile          underTile           = new UnderTile(2);
    public static Tile          backgroundTile      = new BackGroundTile(3);
    public static Tile          backgroundTile2     = new BackGroundTile2(7);
    public static Tile          ladderTile          = new LadderTile(4);
    public static Tile          stoneTile           = new StoneTile(5);
    public static Tile          backgrounddeadTile  = new BackGroundDeadTile(6);


    public static final int     TILE_WIDTH          = 48;
    public static final int     TILE_HEIGHT         = 48;

    protected BufferedImage     img;///<Imaginea aferenta tipului de dala
    protected final int         id; ///<id-ul unic aferent tipului de dala


    public Tile(BufferedImage image,int id){
        img         = image;///<image e imaginea corspunzatoarei dalei
        this.id     = id;   ///<id-ul dalei
        tiles[id]   = this;///<Pun referinta dalei respective in vectorul de dale
    }

    /*!
        \fn public void Update()
        \Actualizeaza propietatile dalei
     */
    public void Update(){ }

    /*!
        \fn public void Draw(Graphics g,int x,int y)
        \Deseneaza in fereastra dala respectiva
        \x,y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g,int x,int y){
        g.drawImage(img,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }

    /*!
        \fn public boolean IsSolid()
        \brief Daca dala este solida sau nu
     */
    public boolean IsSolid(){ return false; }
    /*!
       \fn public boolean climb()
       \brief Daca dala este catarabila sau nu
    */
    public boolean climb(){ return false; }
    /*!
       \fn public boolean IsNext()
       \brief Daca dala indica trecerea la nivelul urmator
    */
    public boolean IsNext(){return  false;}
    public int GetId(){ return id; }


}
