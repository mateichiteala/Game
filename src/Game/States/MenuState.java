package Game.States;

import Game.Game;
import Game.Graphics.Assets;
import Game.Items.Hero;
import Game.Maps.FactoryMakerMap;
import Game.Maps.Map;
import Game.RefLinks;

import javax.swing.*;
import java.awt.*;

/*!
    \class MenuState extinde clasa State
    \brief va reprezenta starea de unde user-ul va putea da start la campanie
    \schimba sonorizarea sau inchide jocul
 */
public class MenuState extends State {
    /*
        playButton,helpButton,quitButton reprezinta butoanele cu care interactioneaza user-ul
     */
    public Rectangle       playButton = new Rectangle(Game.WIDTH/2 - 45,150,100,50);
    public Rectangle       helpButton = new Rectangle(Game.WIDTH/2 - 45,230,100,50);
    public Rectangle       quitButton = new Rectangle(Game.WIDTH/2 - 45,310,100,50);
    public  Map            map; ///<Harta curenta

    public MenuState(RefLinks refLinks){
        super(refLinks);
        map = FactoryMakerMap.getMap("0",refLinks);///<Construiesc harta jocului
        refLinks.SetMap(map);///<Setam in shortcut current map ca sa fie accesibila si celorlalte clase
    }

    @Override
     /*!
        \fn public void Update()
        \brief Va decide in ce stare ajunge jocul dupa imputurile user-ului
     */
    public void Update() {
        if(refLinks.GetMouseInput().play){
            System.out.println("play");
            State.SetState(refLinks.GetGame().getPlayState());
            refLinks.GetMap().setActivate_level(true);
            FactoryMakerMap.index_map = FactoryMakerMap.index_map +1;
            String c = Integer.toString(FactoryMakerMap.index_map);
            refLinks.SetMap( FactoryMakerMap.getMap(c,refLinks));
            refLinks.GetMouseInput().setPlay(false);
        }
        if(refLinks.GetMouseInput().quit){
            System.exit(0);
        }
        if(refLinks.GetMouseInput().help){
            State.SetState(refLinks.GetGame().getAboutState());
            refLinks.SetMap(FactoryMakerMap.getMap("9",refLinks));
        }
        else
            map.Update();
        refLinks.GetMouseInput().play = false;
        refLinks.GetMouseInput().help = false;
    }

    @Override
    public void Draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        map.Draw(g);
        g.setFont(new Font("Title",Font.BOLD,70));
        g.setColor(Color.black);
        g.drawString("KIDS SEE GHOSTS",Game.WIDTH/2 - 290,100);

        g.setFont(new Font("Play",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(playButton.x,playButton.y,playButton.width,playButton.height);
        g.fillRect(playButton.x+5,playButton.y+5,playButton.width,playButton.height);
        g.setColor(Color.BLACK);
        g.drawString("Play",playButton.x + 20,playButton.y + 30);
        g2d.draw(playButton);

        g.setFont(new Font("Help",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(helpButton.x,helpButton.y,helpButton.width,helpButton.height);
        g.fillRect(helpButton.x+5,helpButton.y+5,helpButton.width,helpButton.height);
        g.setColor(Color.BLACK);
        g.drawString("Help",helpButton.x + 20,helpButton.y + 30);
        g2d.draw(helpButton);

        g.setFont(new Font("Quit",Font.BOLD,30));
        g.setColor(Color.cyan);
        g.fillRect(quitButton.x,quitButton.y,quitButton.width,quitButton.height);
        g.fillRect(quitButton.x+5,quitButton.y+5,quitButton.width,quitButton.height);
        g.setColor(Color.BLACK);
        g.drawString("Quit",quitButton.x + 20,quitButton.y + 30);
        g2d.draw(quitButton);

    }
}
