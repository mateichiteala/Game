package Game;

import Game.Input.KeyManager;
import Game.Input.MouseInput;
import Game.Items.Enemy;
import Game.Items.Hero;
import Game.Maps.Map;
import Game.Tiles.Tile;

import java.util.Vector;

/* \Class RefLinks
    \brief Tine referintele celorlalte clase pentru a le putea accesa mai usor
 */
public class RefLinks {

    private Game                game;                       ///<Referinta catre obiectul game
    private Map                 map;                        ///<Referinta catre harta curenta
    private Hero                hero;                       ///<Referinta catre erou
    private final Vector<Enemy> enemies = new Vector<>();   ///<Referinta catre inamici
    private Tile                tile;

    RefLinks(Game game){
        this.game=game;
    }

    public KeyManager GetKeyManager(){ return game.GetKeyManager(); }
    public MouseInput GetMouseInput(){ return game.getMouseInput(); }
    public int GetWidth() { return game.GetWidth(); }
    public int GetHeight() { return game.GetHeight(); }
    public void SetGame(Game game) { this.game = game; }
    public Game GetGame() { return game; }
    public void SetMap(Map map) { this.map = map; }
    public Map GetMap() { return map; }
    public Tile getTile() { return tile; }
    public Hero getHero() { return hero; }
    public void setHero(Hero hero) { this.hero = hero; }
    public Vector<Enemy> getEnemies() { return enemies; }
    public void addEnemy(Enemy e){ enemies.add(e); }
}
