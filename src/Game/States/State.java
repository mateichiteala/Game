package Game.States;


import Game.RefLinks;

import java.awt.*;

/*!
    \class State este abstracta
    \brief folosita pentru starile jocului(New Game,Load Game...)
 */
public abstract class State {

    private static State    previousState   = null;
    private static State    currentState    = null;
    protected RefLinks      refLinks;
    public static boolean   ok              = false;

    public State(RefLinks refLinks){
        this.refLinks = refLinks;
    }

    public static void SetState(State state){
        previousState = currentState;
        currentState  = state;
    }

    public static State GetState(){ return currentState; }
    public abstract void Update();
    /*!
        \public abstract void Draw(Graphics g)
        \brief Deseneaza harta.Aceasta depinde in ce stare se afla jocul.
     */
    public abstract void Draw(Graphics g);
    public void setOk(boolean ok) { State.ok = ok; }
}
