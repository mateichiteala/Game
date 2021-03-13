package Game;

/*!
    \clas Singleton
    \brief Doar o singura instanta a clasei Game va fi creata
 */
public class Singleton {
    private volatile static Game game;
    private Singleton(){
    }
    public static Game getInstance(){

        if(game == null){
            synchronized (Singleton.class){
                if(game == null)
                    game = new Game("KIDS SEE GHOSTS",960,480);
            }
        }
        return game;
    }
}
