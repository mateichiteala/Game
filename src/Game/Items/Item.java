package Game.Items;
import Game.RefLinks;

import java.awt.*;

public abstract class Item {
    /*! \class Item implementeaza notiunea abstracta din joc cu care se
        \poate interactiona:monstru,turn,dragon,...
     */

    protected float     x;              ///<pozitia pe axa x a itemului pe harta
    protected float     y;              ///<pozitia pe axa y a itemului pe harta
    protected int       width;          ///<latime
    protected int       height;         ///<naltime
    protected Rectangle bounds;
    protected Rectangle normalBounds;
    protected Rectangle attackBounds;
    protected RefLinks  refLink;

    /*! \fn public Item(RefLinks refLink,float x,float y,int width,int height)
        \refLink    -referinte diferite clase
        \x,y        - pozitii pe harta
        \width      - latime
        \height     - inaltime
        \brief Constructor clasa Item
     */

    public Item(RefLinks refLink,float x,float y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.refLink=refLink;//Retine "shortcut-ul"

        normalBounds=new Rectangle(0,0,width,height);
        attackBounds=new Rectangle(0,0,width,height);
        bounds=normalBounds;

    }

    public abstract void Update();
    //Pentru actualizarea starii curente

    public abstract void Draw(Graphics g);
    //Pentru desenarea starii curente

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setNormalBounds(Rectangle normalBounds) {
        this.normalBounds = normalBounds;
    }
    public void setAttackBounds(Rectangle attackBounds) {
        this.attackBounds = attackBounds;
    }

}
