package Game.Input;

import Game.Game;
import Game.States.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
    /*! \class MouseInput
        \brief Retine informatii(evenimente) venite de la mouse
    */

    public boolean play = false;
    public boolean help = false;
    public boolean quit = false;

    @Override
    /*! \fn public void mousePressed(MouseEvent e)
        \ "e" - evenimentul pentru apasarea maouse-ului
        \ Va verifica in ce pozitie a fost apasata mouse-ul si va seta variabilele play,state sau quit
        \ care vor specifica ce stare urmeaza pentru program
     */
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        //Pozitii mouse

        /*
        public Rectangle playButton= new Rectangle(Game.WIDTH/2 - 45,150,100,50);
        public Rectangle helpButton= new Rectangle(Game.WIDTH/2 - 45,230,100,50);
        public Rectangle quitButton = new Rectangle(Game.WIDTH/2 - 45,310,100,50);
         */

        //PlayButton
        if(mx >= Game.WIDTH/2 - 45 && mx <= Game.WIDTH/2 + 100){
            if(my >= 150 && my<= 200)
                play = true;//Sunt in chenarul play
        }
        //HelpButton
        if(mx >= Game.WIDTH/2 - 45 && mx <= Game.WIDTH/2 + 100){
            if(my >= 230 && my<= 280) {
                help = true;//Sunt in chenarul quit
            }
        }
        //QuitButton
        if(mx >= Game.WIDTH/2 - 45 && mx <= Game.WIDTH/2 + 100){
            if(my >= 310 && my<= 360)
                quit = true;//Sunt in chenarul quit
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
    @Override
    public void mouseClicked(MouseEvent e) { }

    public void setPlay(boolean play) {this.play = play; }
}