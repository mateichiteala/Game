package Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = Singleton.getInstance();
        game.StartGame();
        Game game2 = Singleton.getInstance();
        game2.StartGame();
    }
}
