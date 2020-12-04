import java.util.Arrays;
import java.util.ArrayList;

public class Enemy extends Creature
{
    int coinDrop = 0;
    int expDrop = 0;
    // ArrayList<Object> drops = new ArrayList<Object>(); // Item drops
    
    Enemy()
    {
        
    }
    
    @Override
    public void check_for_upgrades()
    {
        max_lives += get_lvl()+1;
        lives = max_lives;
        coinDrop *= this.get_lvl();
        expDrop *= this.get_lvl();
    }
}
