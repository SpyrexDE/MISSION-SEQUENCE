public class World extends Interface
{
    public World()
    {
        name = "Welt";
        set_text("Du bist in der großen weiten Welt.");
        add_option("Suche den Kampf");
        add_option("Gehe zum Shop");
        add_option("Spiel verlassen");
    }
    
    @Override
    public void optionSelected(int i)
    {
        switch(i)
        {
            case 1:
                Player.go(new Fight());
                break;
            case 2:
                Player.go(new Shop());
                break;
            case 3:
                System.out.print('\u000C');
                System.exit(0);
                break;
        }
    }
}
