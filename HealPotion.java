public class HealPotion extends Item
{
    
    public HealPotion()
    {
        name = "Heiltrank";
        price = 10;
    }
    
    public void use(Creature target)
    {
        target.lives += 20;
        Player.inventory.remove(this);
    }
}
