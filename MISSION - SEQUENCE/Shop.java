import java.util.List;
import java.util.Arrays;

public class Shop extends Interface
{
    final List<Item> items = Arrays.asList(new HealPotion());
    
    public Shop()
    {
        name = "Shop";
        set_text("Willkommen im Shop! - WORK IN PROGRESS");
        
        for(Item item : items)
        {
            add_option(item.price + "$ " + item.name);
        }
        add_option("Verlassen");
    }
    
    @Override
    public void optionSelected(int i)
    {
        if(i == options.size())
        {
            Player.go(new World());
        }
        else 
        {
            Item selectedItem = items.get(i);
            if(Player.money >= selectedItem.price)
            {
                Player.money -= selectedItem.price;
                Player.inventory.add(selectedItem);
            }
        }
    }
}
