public class Player extends Creature
{
    public static int money = 0;
    public static Inventory inventory;
    public static Interface location;
    
    
    public Player()
    {
        inventory = new Inventory();
        money = 0;
        max_lives = 5;
        lives = max_lives;
    }
    
    public static void go(Interface i)
    {
        location = i;
        i.print();
    }
    
    @Override
    public void die()
    {
        this.money = this.money/2;
        this.lives = this.max_lives;
        Game.player.go(new Result(null));
    }
    
    @Override
    public void check_for_upgrades()
    {
        max_lives += get_lvl()/3+1;
        lives = max_lives;
    }
}
