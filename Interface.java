import java.util.Scanner;
import java.util.ArrayList;

public class Interface
{
    String name = "";
    
    String text;
    String output;
    ArrayList<String> options = new ArrayList<String>();
    
    public void get_input(String text, boolean clear)
    {
        if(clear == true)
            System.out.print('\u000C');
        
        printStatsLine();
        System.out.println(text);
        
        try
        {
            int input = new Scanner(System.in).nextInt();
            if(input > 0 && input <= options.size())
            {
                optionSelected(input); 
            }
            else
            {
                intTyped(input);
            }
        }
        catch(Exception ignore)
        {
           get_input(text, clear);
        }
    }
    
    public void add_option(String text)
    {
        options.add(text);
    }
    
    public void set_text(String text)
    {
        this.text = text;
    }
    
    public void print()
    {
        output = this.text;
        int counter = 0;
        for(String option : options)
        {
            counter += 1;
            String nr = Integer.toString(counter);
            output += "\n" + "(" + nr + ")" + " -> " + option;
        }
        
        get_input(output, true);
    }
    
    public void optionSelected(int i) {}
    
    public void intTyped(int i)
    {
        //If not Overwritten:
        print();
    }
    
    private void printStatsLine()
    {
        System.out.println("»»» " + Player.location.name + "      Lvl:" + Game.player.get_lvl() + "       " + Game.player.lives + "/" + Game.player.max_lives + "❤          $" + Game.player.money);
        System.out.println("----------------------------------------------");
    }
}
