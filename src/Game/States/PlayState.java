package Game.States;

import Game.Game;
import Game.Items.Enemy;
import Game.Items.Hero;
import Game.Maps.FactoryMakerMap;
import Game.Maps.Map;
import Game.RefLinks;

import java.awt.*;

/*!
    \class PlayState
    \brief starea principala a jocului
 */

public class PlayState extends State{

    private final Hero  hero;       ///<referinta catre obiectul erou controlat de utilizator
    private final Enemy enemy;
    private final Enemy enemy2;
    private  Map        map;        ///<Harta curenta

    public PlayState(RefLinks refLinks){
        super(refLinks);

        enemy   = new Enemy(refLinks,400,660);
        enemy2  = new Enemy(refLinks,400,660);
        refLinks.addEnemy(enemy);
        refLinks.addEnemy(enemy2);

        hero    = new Hero(refLinks,400,660);///<Construiesc eroul
        refLinks.setHero(hero);
        map = refLinks.GetMap();///<Construiesc harta jocului

    }
    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta a jocului in functie de nivel
     */
    @Override
    public void Update() {
        map = refLinks.GetMap();
        hero.Update();
        if(FactoryMakerMap.index_map == 4) {
            if(!ok) {
                enemy.alive = true;
                enemy.setLife(2);
                enemy.setX(400);
                enemy.setY(660);
                enemy.setLeft(500);
                enemy.setRight(700);
                ok = true;
            }
            enemy.Update();
        }
        if(FactoryMakerMap.index_map == 5) {
            if(!ok) {
                enemy.alive = true;
                enemy.setLife(2);
                enemy.setX(600);
                enemy.setY(247);
                enemy.setLeft(562);
                enemy.setRight(632);
                ok = true;
            }
            enemy.Update();
        }
        if(FactoryMakerMap.index_map == 6) {
            if(!ok) {
                enemy.alive = true;
                enemy.setLife(2);
                enemy2.alive = true;
                enemy2.setLife(2);
                enemy.setX(600);
                enemy.setY(660);
                enemy.setLeft(500);
                enemy.setRight(700);

                enemy2.setX(300);
                enemy2.setY(660);
                enemy2.setLeft(250);
                enemy2.setRight(400);

                ok = true;
            }
            enemy.Update();
            enemy2.Update();
        }
        map.Update();
    }

    @Override
    public void Draw(Graphics g) {
        map.Draw(g);
        hero.Draw(g);
        g.setFont(new Font("Life_String",Font.BOLD,20));
        g.setColor(Color.CYAN);
        g.drawString("Life:", 0,20);

        g.setFont(new Font("Life_Number",Font.BOLD,20));
        g.setColor(Color.RED);
        String c = Integer.toString(refLinks.getHero().getLife());
        g.drawString(c,50,20);

        /*
        g.setFont(new Font("Enemy Killed",Font.BOLD,20));
        g.setColor(Color.CYAN);
        g.drawString("Kills:", 80,20);

        g.setFont(new Font("Enemy_number",Font.BOLD,20));
        g.setColor(Color.RED);
        String c2 = Integer.toString(refLinks.getHero().getKilled_enemy());
        g.drawString(c2,140,20);
         */

        if( FactoryMakerMap.index_map >= 4 && FactoryMakerMap.index_map <= 6){
            if(FactoryMakerMap.index_map == 4 || FactoryMakerMap.index_map == 5)
                enemy.Draw(g);
            else {
                enemy.Draw(g);
                enemy2.Draw(g);
            }
        }
    }
}
