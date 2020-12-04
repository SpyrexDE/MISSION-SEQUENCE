public class Game
{
    public static Player player;
    Game()
    {
        System.out.print('\u000C');
        
        player = new Player();
        
        player.go(new World());
    }
    
    public static void main(String[] args)
    {
        new Game();
    }
}
