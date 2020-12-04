public class Creature
{
    public int max_lives;
    public int lives;
    public String name = "Kreatur";
    public int experience = 0;
    
    public Creature()
    {
        
    }
    
    public void set_lvl(int lvl)
    {
        experience = 100*lvl;
        check_for_upgrades();
    }
    
    public void add_exp(int exp)
    {
        experience += exp;
        check_for_upgrades();
    }
    
    public void check_for_upgrades()
    {
        max_lives += get_lvl()/2+1;
        lives = max_lives;
    }
    
    public int get_lvl()
    {
        return experience / 100 + 1;
    }
    
    public void set_lives(int lives)
    {
        if(lives <= 0)
        {
            die();
        }
        else if(lives > max_lives)
        {
            return;
        }
        this.lives = lives;
        
    }
    
    public void die() {}
}
