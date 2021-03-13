
package Game.Items;

import Game.Graphics.Assets;
import Game.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*!
        \class Enemy extinde clasa Character
        \brief Singurul obiect care poate sa omoare inamicul
     */
public class Enemy extends Character{

    private BufferedImage   image;                  ///<Referinta catre imaginea curenta a inamicului
    private boolean         ok      = false;        ///<Pentru drumul inamicului
    private int             index   = 0;
    private int             left    = 500;
    private int             right   = 700;

    /*!
            \fn public Enemy(RefLinks,float x,float y)
            \brief constructor Enemy
            \refLinks - referinta la clasa RefLinks
            \x - pozitia pe Ox
            \y - pozitia pe Oy
         */
    public Enemy(RefLinks refLinks, float x, float y) {

        //! Apelam constructor clasei e baza
        super(refLinks,x,y,Character.DEFAULT_CREATURE_WIDTH,Character.DEFAULT_CREATURE_HEIGHT);

        life                = 1;
        image               = Assets.enemy.get(0); ///<Imaginea de start a eroului

        normalBounds.x      = 16;
        normalBounds.y      = 16;
        normalBounds.width  = 16;
        normalBounds.height = 32;

        attackBounds.x      = 10;
        attackBounds.y      = 10;
        attackBounds.width  = 38;
        attackBounds.height = 38;

    }

    @Override
    /*!
      \fn public void Update()
      \brief Actualizeaza pozitia si imaginea inamicului
     */
    public void Update() {
        normalBounds.x = (int) x;
        normalBounds.y = (int) y;
        attackBounds.x = (int) x;
        attackBounds.y = (int) y;

        System.out.println(life);
        if (alive) {
            canJump = false;
            xMove = 0;
            yMove = 0;
            fall();
            if (!ok) {
                if (left < x) {
                    if (!collision(-speed))
                        xMove = -speed;
                    if(index < Assets.enemy.size()) {
                        image = Assets.enemy.get(index);
                        index = index + 1;
                    }
                    else
                        index = 0;
                } else
                    ok = true;
            }
            if (ok) {
                if (!collision(-speed))
                        xMove = speed;
                image = Assets.enemy.get(1);
                if (x > right)
                    ok = false;
            }
            if(life == 1){
                image = Assets.enemy.get(8);
            }
            Move();
        }
        else
            image = Assets.tree;
    }

    @Override
    /*!
        \fn public void Draw(Graphics g)
        \brief Deseneaza inamicul in noua lui pozitie
     */
    public void Draw(Graphics g) { g.drawImage(image,(int)x,(int) y,width,height,null); }

    public int getRight() { return right; }
    public int getLeft() { return left; }
    public void setLeft(int left) { this.left = left; }
    public void setRight(int right) { this.right = right; }

}

