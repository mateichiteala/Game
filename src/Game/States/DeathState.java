package Game.States;

import Game.Game;
import Game.Graphics.Assets;
import Game.Items.Enemy;
import Game.Items.Hero;
import Game.Maps.FactoryMakerMap;
import Game.Maps.Map;
import Game.RefLinks;

import java.awt.*;

/*!
    \class DeathState
    \brief Starea in care se afla user-ul atunci cand eroul a ramas fara vieti
 */
public class DeathState extends State{

    /*!
        replayButton - buton pentru intoarcerea la starea PlayState
     */
    public Rectangle  replayButton= new Rectangle(Game.WIDTH/2 - 45,150,120,50);

    private Map map;///<Harta curenta

    public DeathState(RefLinks refLinks){
        super(refLinks);
        map = FactoryMakerMap.getMap("8",refLinks);///<Construiesc harta jocului
    }

    /*!
        \fn public void Update()
        \brief va decide dupa imputul user-ului daca acesta va reveni la PlayState
     */
    @Override
    public void Update() {
        if(refLinks.GetMouseInput().play){
            State.SetState(refLinks.GetGame().getPlayState());
            refLinks.GetMap().setActivate_level(true);
            refLinks.getHero().setX(200);
            refLinks.getHero().setY(660);
            refLinks.getHero().setLife(2);
            refLinks.getHero().setImage(Assets.skeleton);
            String c = Integer.toString(FactoryMakerMap.index_map);
            refLinks.SetMap(FactoryMakerMap.getMap(c,refLinks));
            refLinks.GetMouseInput().setPlay(false);
        }
        else
            map.Update();
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        map.Draw(g);
        g.setFont(new Font("Title",Font.BOLD,50));
        g.setColor(Color.RED);
        g.drawString("The Dead don't die",Game.WIDTH/2 - 210,100);

        g.setFont(new Font("Replay",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(replayButton.x,replayButton.y,replayButton.width,replayButton.height);
        g.fillRect(replayButton.x+5,replayButton.y+5,replayButton.width,replayButton.height);
        g.setColor(Color.BLACK);
        g.drawString("Reborn",replayButton.x ,replayButton.y + 30);
        g2d.draw(replayButton);
    }
}
