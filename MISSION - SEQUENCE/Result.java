public class Result extends Interface
{
    Enemy enemy;
    public Result(Enemy enemy)
    {
        this.enemy = enemy;
        
        if(enemy == null)
        {
            name = "Gestorben";
            
            set_text("Du bist gestorben und hast die\nhälfte deines Geldes verloren");
            add_option("Zur Welt");
        }
        else
        {
            name = "Sieg!";
            
            String text = "------------- Du hast gewonnen! --------------\n";
            text += "--------- Belohnung: " + enemy.coinDrop + "$ | Exp: +" + enemy.expDrop + " ---------------";
            set_text(text);
            add_option("Einsammeln und zurück zur Welt");
            Game.player.set_lives(Game.player.max_lives);
        }
        print();
    }
    
    @Override
    public void optionSelected(int i)
    {
        switch(i)
        {
            case 1:
                if(this.enemy != null)
                {
                    Game.player.money += enemy.coinDrop;
                    Game.player.add_exp(enemy.expDrop);
                }
                Player.go(new World());
                break;
        }
    }
}
