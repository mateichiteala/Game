package Game.Items;

import Game.Graphics.Assets;
import Game.Maps.FactoryMakerMap;
import Game.Maps.Map;
import Game.RefLinks;
import Game.States.DeathState;
import Game.States.State;
import Game.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.sql.Time;
import java.time.YearMonth;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;


public class Hero extends Character {
    /*!
        \class Hero extinde clasa Character si este caracterul folosit de user
     */
    private BufferedImage   image;              ///<Referinta catre imaginea curenta a eroului
    private int             index           = 0;
    private int             indexm          = 0;
    private int             index_jump      = 0;
    private int             index_dead      = 0;
   // private int             killed_enemy    = 0;

    /*!
          \fn public Hero(RefLinks refLinks, float x, float y)
          \Constructor clasa Hero
          \reflinks referinta la clasa RefLinks
          \x pozitia initiala pe harta
          \y pozitia initiala pe harta
    */
    public Hero(RefLinks refLinks, float x, float y) {

        super(refLinks, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        life                = 2;
        image               = Assets.skeleton;    ///<Imaginea de start a eroului

        normalBounds.x      = 16;
        normalBounds.y      = 16;
        normalBounds.width  = 16;
        normalBounds.height = 32;

        attackBounds.x      = 10;
        attackBounds.y      = 10;
        attackBounds.width  = 38;
        attackBounds.height = 38;
        maxDY               = 380;

    }

    /*!
      \fn public void Update()
      \brief Actualizeaza pozitia si imaginea eroului
     */
    @Override
    public void Update() {
        canJump             = false;
        normalBounds.x      = (int) x;
        normalBounds.y      = (int) y;

        attackBounds.x      = (int) x;
        attackBounds.y      = (int) y;
        attackBounds.width  = 38;
        attackBounds.height = 38;

        fall();
        GetInput(); ///<Verific daca a fost apelata o tasta
        attacked();
        Move();     ///<Actualizez pozitia

        if (life <= 0) {
            image = Assets.dead.get(index_dead);
            index_dead = index_dead + 1;
            if(index_dead == Assets.dead.size()){
               State.SetState(refLink.GetGame().getDeathState());
               refLink.SetMap(FactoryMakerMap.getMap("8",refLink));
               index_dead = 0;
            }
        }
        else {
            if (refLink.GetKeyManager().right || refLink.GetKeyManager().left
                    || refLink.GetKeyManager().space || refLink.GetKeyManager().attack) {
                if (refLink.GetKeyManager().right) {
                    indexm = 0;
                    index_jump = 0;
                    if (index < Assets.runs.size()) {
                        image = Assets.runs.get(index);
                        index = index + 1;
                    } else
                        index = 0;
                }
                if (refLink.GetKeyManager().left) {
                    index = 0;
                    index_jump = 0;
                    if (indexm < Assets.runsm.size()) {
                        image = Assets.runsm.get(indexm);
                        indexm = indexm + 1;
                    } else
                        indexm = 0;
                }
                if (refLink.GetKeyManager().space) {
                    index = 0;
                    indexm = 0;
                    if (index_jump < Assets.jumps.size()) {
                        image = Assets.jumps.get(index_jump);
                        index_jump = index_jump + 1;
                    } else
                        index_jump = 0;
                }
                if(refLink.GetKeyManager().attack){
                    System.out.println("atac");
                    image = Assets.attack;
                    attack();
                }
            } else
                image = Assets.skeleton;
        }


    }

    /*!
        \fn public boolean canClimb(float s)
        \brief Verific daca obiectul intalnit este un obiect catarabil
     */
    private boolean canClimb(float s) {
        boolean canClimb = false;
        for (int c = 0; c < 4; ++c) {
            int xt = (int) (x + s + c % 2 * 40 - 8) / Tile.TILE_WIDTH;
            int yt = (int) (y + s + c / 2 * 40 + 3) / Tile.TILE_HEIGHT;
            if (refLink.GetMap().GetTile(xt, yt).climb()) canClimb = true;
        }
        return canClimb;
    }

    /*!
        \fn private boolean nextLevel(float s)
        \brief Verific daca eroul a intampinat un obiect care indica ca trebuie
        \sa mearga la nivelul urmator
     */
    private boolean nextLevel(float s) {
        boolean next = false;
        for (int c = 0; c < 4; ++c) {
            int xt = (int) (x + s + c % 2 * 35 - 8) / Tile.TILE_WIDTH;
            int yt = (int) (y + s + c / 2 * 35 + 3) / Tile.TILE_HEIGHT;
            if (refLink.GetMap().GetTile(xt, yt).IsNext()) {
                next = true;
                State.ok = false;
            }
        }
        return next;
    }
    /*!
        \fn private void GetInput()
        \brief Verifica ce taste au fost apasate si cu ce pozitie va fi mutat eroul
     */
    private void GetInput() {

        xMove = 0;
        yMove = 0;
        //Daca nu a fost apelata o tasta eroul nu trebuie sa se deplaseze

        if (nextLevel(speed)) {
            refLink.GetMap().setActivate_level(true);
            refLink.GetMap().setLevel(refLink.GetMap().getLevel());
            if(FactoryMakerMap.index_map == 7)
                System.exit(0);
            FactoryMakerMap.index_map = FactoryMakerMap.index_map + 1;
            String c = Integer.toString(FactoryMakerMap.index_map);
            refLink.SetMap(FactoryMakerMap.getMap(c,refLink));
            x = 200;
            y = 380;
        }
        //Urmatorul nivel

        //Verificare taste
        if (refLink.GetKeyManager().up) {
            if (!collision(-speed)) {
                if (canClimb(-speed))
                    yMove = -speed;
            }
        }
        if (refLink.GetKeyManager().down) {
            if (!collision(+speed)) {
                if (canClimb(+speed))
                    yMove = +speed;
            }
        }
        if (refLink.GetKeyManager().left) {
            if (!collision(-speed)) {
                xMove = -speed;
            }

        }
        if (refLink.GetKeyManager().right) {
            if (!collision(-speed))
                xMove = +speed;
        }
        if (refLink.GetKeyManager().space) {
            if (!collision(-speed)) {
                jump();
                canJump = false;
            }
        }
        if (refLink.GetKeyManager().reset) {
                x = 200;
                y = 660;
        }
    }

    @Override
    /*!
        \fn public void Draw(Graphics g)
        \brief Deseneaza eroul in noua lui pozitie
     */
    public void Draw(Graphics g) { g.drawImage(image, (int) x, (int) y, width, height, null); }

    /*!
        \fn public void attacked
        \brief Verifica daca eraul a fost atacat de enemy
     */
    public void attacked() {
        for (int i = 0; i < refLink.getEnemies().size(); ++i) {
            Enemy aux = refLink.getEnemies().get(i);
            System.out.println(aux.x+"\n");
            System.out.println(aux.y+"\n");
            if(aux.alive) {
                if (normalBounds.intersects(aux.normalBounds))
                    life = life - 1;
            }
        }

    }

    @Override
    public void setLife(int life) { super.setLife(life); }
    public void setImage(BufferedImage bufferedImage){ this.image = bufferedImage; }

    /*!
        \fn public void attack()
        \brief Verifica daca eroul a lovit un inamic
     */
    public void attack(){
            if(refLink.GetKeyManager().attack){
                for (int i = 0; i < refLink.getEnemies().size(); ++i) {
                    Enemy aux = refLink.getEnemies().get(i);
                    if (attackBounds.intersects(aux.normalBounds)) {
                        refLink.getEnemies().get(i).life -= 1;
                    }
                    if(refLink.getEnemies().get(i).life <= 0) {
                        refLink.getEnemies().get(i).alive = false;
                      //  killed_enemy = killed_enemy + 1;
                    }
                }
            }
    }
    /*
    public int getKilled_enemy() {
        return killed_enemy;
    }

     */
}
