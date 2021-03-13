package Game;

import Game.GameWindow.GameWindow;
import Game.Graphics.Assets;
import Game.Input.KeyManager;
//import Game.Input.MouseInput;
import Game.Input.MouseInput;
import Game.States.*;
import Game.Tiles.Tile;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

/* \Class Game
    \brief Creeaza jocul,starile,threadul pentru joc
 */

public class Game implements Runnable {

    private final GameWindow        wnd;///<Fereastra in care se va desena jocul
    private boolean                 runState;///<Flag cu starea firului de executie
    public static Thread            gameThread;///<Referinta catre thread-ul de update si draw al ferestrei
    private BufferStrategy          bs;///<Referinta catre un mecanism cu care se organizeaza memoria complexa
    public static int               WIDTH;
    public static int               HEIGHT;
    private Graphics                g;///<Contextul grafic

    /*Starile Jocului*/
    private State                   playState;
    private State                   menuState;
    private State                   deathState;
    private State                   settingsState;
    private State                   aboutState;
    private final KeyManager        keyManager;///<obiectul ce gestioneaza intrarile utilizatorului
    private final RefLinks          refLink;
    private final MouseInput        mouseInput;///<obiectul ce gestioneaza intrarile de la mouse
    private final Audio             audio = new Audio("resources/muzica.wav");

    /* \fn public Game(String title,int width,int height)
                \brief Constructorul pentru clasa Game
             */
    public Game(String title,int width,int height){

        /*Obiectul GameWindow este creat dar fereastra nu este construita*/
        wnd         = new GameWindow(title,width,height);
        WIDTH       = width;
        HEIGHT      = height;
        runState    = false;            ///<Arata ca firul de executie este(started/stoped)
        keyManager  = new KeyManager(); ///<Obiectul ce gestioneaza evenimentele de la tastatura
        refLink     = new RefLinks(this);
        mouseInput  = new MouseInput();
    }


    /* \fn public void InitGame()
        \brief Construieste fereastra jocului si diferite stari ale jocului
     */
    private void InitGame(){

        wnd.BuildGameWindow();///<Construiesc fereastra grafica
        wnd.getWndFrame().addKeyListener(keyManager);
        wnd.getCanvas().addMouseListener(mouseInput);
        /*Am adaugat la fereastra de unde se vor lua informatiile de la tastatura si mouse*/

        Assets.Init();///<Se incarca toate elementele grafice(dalele)

        /*Definesc starile programului*/
        aboutState      = new AboutState(refLink);
        deathState      = new DeathState(refLink);
        menuState       = new MenuState(refLink);
        playState       = new PlayState(refLink);

        /* Selectez starea cu care voi incepe jocul*/
        State.SetState(menuState);


    }
    @Override
    public void run() {
        InitGame();///<Initializez obiectul game
        audio.play();
        long oldTime = System.nanoTime();///<retine timpul in nanoSecunde
        long curentTime;///<Timpul curent de executie


        final int framesPerSecond   = 60;///<De cate ori pe secunda se vor apela Update() si Draw()
        final double timeFrame      = 1000000000 / framesPerSecond;///<Durata unui frame in nanoSecunde

        /*Cat timp threadul este pornid facem update si Draw*/
        while (runState){
            curentTime = System.nanoTime();
            if((curentTime-oldTime)>timeFrame){
                Update();
                Draw();
                oldTime = curentTime;
            }
        }
    }

    /* \fn public synchronized void StartGame()
        \brief Creeaza firul de executie si porneste jocul
     */
    public synchronized void StartGame(){
        if(!runState){
            runState = true;///<Am inceput jocul
            gameThread = new Thread(this);///<Vom construi threadul
            gameThread.start(); ///<Threadul este lansat in executie si va executa metoda run()
        }
        else {
            return;///<Threadul este creat si pornit deja
        }
    }


    public synchronized void StopGame(){
        if(runState){
            runState = false;
            try {
                gameThread.join();
                ///<Va opri jocul
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        else{
            return;///<Threadul este deja oprit
        }
    }

    /*! \fn private void Update()
        \brief Verifica starea tastelor si verifica modificarile diferitelor stari
     */
    private void Update(){

        keyManager.Update();///<Verifica starea tastelor

        if(State.GetState()!=null){
            State.GetState().Update();///<Actualizez starea curenta a jocului
        }
    }

    /*! \fn private void Draw()
        \brief Operatia de desenare a jocului
     */
    private void Draw(){
        bs = wnd.getCanvas().getBufferStrategy();

        if(bs == null){
            try {
                wnd.getCanvas().createBufferStrategy(3);///<Se construieste triplu buffer
                return;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        g = bs.getDrawGraphics();
        ///<Se obtine contextul grafic unde se poate desena

        g.clearRect(0,0,wnd.getWndWidth(),wnd.getWndHeight());
        ///<Se sterge ce era pe el

        ///<operatia de desenare
        if(State.GetState() != null){
            State.GetState().Draw(g);
        }

        bs.show();
        ///<Se afiseaza pe ecran

        g.dispose();///<Elibereaza resursele de memorie aferenta contextului grafic
    }

    public int GetWidth() { return wnd.getWndWidth(); }
    public int GetHeight() { return wnd.getWndHeight(); }
    public KeyManager GetKeyManager() { return keyManager; }
    public MouseInput getMouseInput() { return mouseInput; }
    public State getMenuState() { return menuState; }
    public State getPlayState() { return playState; }
    public GameWindow getWnd() { return wnd; }
    public Graphics getG(){ return g; }
    public State getDeathState() { return deathState; }
    public State getAboutState() { return aboutState; }
    public Audio getAudio() { return audio; }
}
