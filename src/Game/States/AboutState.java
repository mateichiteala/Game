package Game.States;

import Game.Game;
import Game.Maps.FactoryMakerMap;
import Game.Maps.Map;
import Game.RefLinks;

import java.awt.*;

/*!
    \class AboutState
    \brief Este starea de unde se pot seta on/of pentru muzica
 */
public class  AboutState extends State {

    public Rectangle       playButton= new Rectangle(Game.WIDTH/2 - 45,150,100,50);
    public Rectangle       helpButton= new Rectangle(Game.WIDTH/2 - 45,230,100,50);
    public Rectangle       quitButton = new Rectangle(Game.WIDTH/2 - 45,310,100,50);
    public Map map; ///<Harta curenta

    public AboutState(RefLinks refLinks){
        super(refLinks);
        map = FactoryMakerMap.getMap("9",refLinks);
    }

    /*!
        \fn public void Update()
        \brief Va decide daca user-ul vrea sa porneasca/opreasca muzica sau sa se intorca
        \la starea MenuState
     */
    @Override
    public void Update() {

        if(refLinks.GetMouseInput().play){
            refLinks.GetGame().getAudio().play();
        }
        if(refLinks.GetMouseInput().quit){
            State.SetState(refLinks.GetGame().getMenuState());
            refLinks.SetMap(FactoryMakerMap.getMap("0",refLinks));
        }
        if(refLinks.GetMouseInput().help){
           refLinks.GetGame().getAudio().stop();
        }
        else
            map.Update();
        refLinks.GetMouseInput().play = false;
        refLinks.GetMouseInput().quit = false;
        refLinks.GetMouseInput().help = false;
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        map.Draw(g);
        g.setFont(new Font("Title",Font.BOLD,70));
        g.setColor(Color.red);
        g.drawString("Music", Game.WIDTH/2 - 100,100);

        g.setFont(new Font("ON",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(playButton.x,playButton.y,playButton.width,playButton.height);
        g.fillRect(playButton.x+5,playButton.y+5,playButton.width,playButton.height);
        g.setColor(Color.BLACK);
        g.drawString("ON",playButton.x + 20,playButton.y + 30);
        g2d.draw(playButton);

        g.setFont(new Font("OFF",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(helpButton.x,helpButton.y,helpButton.width,helpButton.height);
        g.fillRect(helpButton.x+5,helpButton.y+5,helpButton.width,helpButton.height);
        g.setColor(Color.BLACK);
        g.drawString("OFF",helpButton.x + 20,helpButton.y + 30);
        g2d.draw(helpButton);


        g.setFont(new Font("BACK",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(quitButton.x,quitButton.y,quitButton.width,quitButton.height);
        g.fillRect(quitButton.x+5,quitButton.y+5,quitButton.width,quitButton.height);
        g.setColor(Color.BLACK);
        g.drawString("BACK",quitButton.x + 20,quitButton.y + 30);
        g2d.draw(quitButton);
    }
}
