package Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    /*! \class KeyMangaer
     *  \brief Clasa contine informatii despre tasetele apasate de user
     */

    private final boolean[] keys;   ///<Vector de flaguri pentru toate testele[0-255]
    public boolean          up;
    public boolean          down;
    public boolean          left;
    public boolean          right;
    public boolean          space;
    public boolean          attack;
    public boolean          reset;


    public KeyManager(){
        keys=new boolean[256];
    }
    //Construim vectorul de flaguri

    /*
      \public void Update()
      \brief Modifica valoarea variabilelor(ex: up,down,...) daca o tasta a fost apasata
     */
    public void Update(){
        up      = keys[KeyEvent.VK_W];
        down    = keys[KeyEvent.VK_S];
        left    = keys[KeyEvent.VK_A];
        right   = keys[KeyEvent.VK_D];
        space   = keys[KeyEvent.VK_SPACE];
        attack  = keys[KeyEvent.VK_K];
        reset   = keys[KeyEvent.VK_T];
    }

    //Atunci cand o tasta este apasata si eliberata
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    /*
        \public void keyPressed(KeyEvent e)
        \ "e" este evenimentul de la tastatura
        \Cand a fost apelata o tasta aceasta va primi 1 in vector
     */
    public void keyPressed(KeyEvent e) { keys[e.getKeyCode()]=true; }
    @Override
    /*  \ public void keyReleased(KeyEvent e)
        \ "e" este evenimentul de la tastatura
        \ brief va retine in vector ca tasta a fost eliberata
     */
    public void keyReleased(KeyEvent e) { keys[e.getKeyCode()]=false; }

}
