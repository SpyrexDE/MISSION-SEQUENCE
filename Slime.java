public class Slime extends Enemy
{
    public Slime()
    {
        name = "Schleim";
        max_lives = 3;
        lives = max_lives;
        coinDrop = 2;
        expDrop = 25;
    }
    
    @Override
    public void die()
    {
        Game.player.go(new Result(this));
    }
}
