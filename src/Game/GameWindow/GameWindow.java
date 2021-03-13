package Game.GameWindow;

import javax.swing.*;
import java.awt.*;
/*! \class GameWindow
 *  brief Clasa creaza o fereastra pentru joc
 */

public class GameWindow {
    private       JFrame  wndFrame;    //fereastra jocului
    private final String  wndTitle;    //numele ferestrei
    private final int     wndWidth;    //latimea ferestrei in pixeli
    private final int     wndHeight;   //inaltimea ferestrei in pixeli
    private Canvas        canvas;      //tabloul unde se poate desena

    /* \fn public GameWindow(String title,int witdth,int height
        \brief Constructor de initializare al clasei
        \ title-titlu
        \width-latime
        \height-inaltime
     */
    //Constructorul si retinem propietatile
    public GameWindow(String title,int width,int height){
        wndTitle    = title;
        wndWidth    = width;
        wndHeight   = height;
        wndFrame    = null;//Fereastra inca nu este construita
    }
    /*  \fn public void BuildGameWindow()
        \brief Construieste fereastra jocului
     */
    public void BuildGameWindow() {
        if (wndFrame != null) {
            return;//Daca a mai fost construita odata fereastra renuntam la creere
        }

        wndFrame = new JFrame(wndTitle);
        //Alocam memorie pt fereasta jocului si setam titlul prin wndTitle

        wndFrame.setSize(wndWidth, wndHeight);
        //Setam dimensiunea ferestrei de joc

        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Operatia de inchidere a jocului.Atunci cand apasam x se inchide fereastra si programul

        wndFrame.setResizable(false);
        //Se va juca deocamdata in fereastra actuala fara a modifica dimensiunea ferestrei

        wndFrame.setLocationRelativeTo(null);
        //Fereastra va aparea in mijlocul ecranului.Daca dorim sa schimbam apelam wndFrame.setLocation(x,y)...

        wndFrame.setVisible(true);
        //Fereastra va fi vizibila la creere

        canvas = new Canvas();
        //Creeaza obiectul unde putem desena

        canvas.setPreferredSize(new Dimension(wndWidth, wndHeight));
        //Am selectam dimensiunile unde se deseneaza pe fereastra pentru canvas

        canvas.setMaximumSize(new Dimension(wndWidth, wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth, wndHeight));
        canvas.setFocusable(false);
        //Daca fereastra isi va schimba dimensiunea trebuie selectat min si max pentru canvas

        wndFrame.add(canvas);
        //Acum am adaugat obiectul canvas in fereastra

        wndFrame.pack();
        //Apelul pack are ca scop ca atunci se schimba dimensiunea ferestrei
        //Atunci tot ce contine sa fie afisat complet
    }

    public int getWndWidth(){ return wndWidth; }
    public int getWndHeight() { return wndHeight; }
    public Canvas getCanvas() { return canvas; }
    public JFrame getWndFrame() { return wndFrame; }
    public String getWndTitle() { return wndTitle; }

}
