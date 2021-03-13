package Game.Items;

import Game.RefLinks;
import Game.Tiles.Tile;

public  abstract class Character extends Item {
    /*! \class Character extinde clasa Item
     */

    public static final int     DEFAULT_LIFE = 10;
    public static final float   DEFAULT_SPEED = 3.0f;
    public static final int     DEFAULT_CREATURE_WIDTH = 48;    ///<latime imagine caracter
    public static final int     DEFAULT_CREATURE_HEIGHT = 48;   ///<inaltime imagine caracter
    protected boolean           canJump = true;                 ///<Daca poate sari
    protected double            maxDY = 380;                    ///<Cel mai jos punct de pe harta
    protected float             gravity = (float) 0.7;          ///<Gravitate
    public boolean              alive = true;                   ///<Daca caracterul este in viata
    protected int               life;                           ///<Viata curenta
    protected float             speed;                          ///<Viteza
    protected float             xMove;                          ///<Cu cat o sa se miste pe harta pe Ox
    protected float             yMove;                          ///<Cu cat o sa se miste pe harta pe Oy

    public Character(RefLinks refLinks,float x,float y,int width,int height){

        //! Apelam constructor clasa de baza
        super(refLinks,x,y,width,height);

        //! Setam valorile implicite
        life    = DEFAULT_LIFE;
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
    }

    public void Move(){
        MoveX();
        MoveY();
    }
    /*!
     \fn public void MoveX()
     Aduna la pozitia curenta cu cati pixeli trebuie sa se miste pe Ox
     */
    public void MoveX(){ x +=xMove; }

    /*!
      \fn public void MoveY()
      Aduna la pozitia curenta cu cati pixeli trebuie sa se miste pe Oy
      */
    public void MoveY(){ y+=yMove; }

    /*!
        \fn public boolean collision(float s)
        \brief Functia verifica daca caracterul intersecteaza un obiect solid pe harta
        \ float s - viteza caracterului,folosit pentru a anticipa obiectul solid
     */

    public boolean collision(float s){
        boolean solid=false;
        for(int c=0;c<4;++c){
            int xt=(int)(x+s+c%2*30-10)/Tile.TILE_WIDTH;
            int yt=(int)(y+s+c%2*30+10)/Tile.TILE_HEIGHT;
            if(refLink.GetMap().GetTile(xt,yt).IsSolid()) solid=true;
        }
        return solid;
    }
    /*!
        \fn public void jump()
        \brief Functia apelata pentru sarit si verifica daca caracterul are voie sa sara
     */
    public void jump() {
        if (canJump) {
            y -= 60;
        }
    }

    /*!
        \fn public void fall()
        \brief "gravitatea" pentru caractere si indica daca caracterul are dreptul de a sari(canJump)
     */
    public void fall(){
        if(collision(gravity) || collision(-gravity) ) {
            canJump=true;
        }
        else
        {
            y += gravity;
            if (y >= maxDY)
                y = (float) maxDY;
        }
        if(y == 380)
            canJump=true;
    }

    public float getxMove() { return xMove; }
    public float getyMove() { return yMove; }
    public float getSpeed() { return speed; }
    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }
    public void setSpeed(float speed) { this.speed = speed; }
    public void setxMove(float xMove) { this.xMove = xMove; }
    public void setyMove(float yMove) { this.yMove = yMove; }

}
