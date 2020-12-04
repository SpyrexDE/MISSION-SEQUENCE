import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Fight extends Interface
{
    final List<Enemy> enemies = Arrays.asList(new Slime(), new Slime());
    GameTimer timer;
    Enemy enemy;
    
    final int seqLen = 5;
    List<Integer> sequence = Arrays.asList();
    int replacedIndex;
    int answer;
    
    public Fight()
    {
        name = "Kampf!";
        
        draw();
    }
    
    private void draw()
    {
        if(this.enemy == null)
            this.enemy = getNewRandomEnemy();
        
        String text = "--------- Gegner: " + this.enemy.name + " | Lvl." + this.enemy.get_lvl() + " ------------\n";
        text += "------------------ " + this.enemy.lives + "/"+ this.enemy.max_lives + "❤ ---------------------\n";
        text += "\n               ";
        
        this.sequence = getNewSquence();
        
        int count = 0;
        for(int i : this.sequence)
        {
            if(count == replacedIndex)
                text += " X";
            text += " " + Integer.toString(i);
            count += 1;
        }
        
        
        set_text(text);
        
        
        timer = new GameTimer();
        print();
    }
    
     @Override
     public void intTyped(int i)
     {
         if(i == answer)
         {
             if(this.timer.getTime() < 1000)
             {
                 System.out.println("------------- Zu Wylder Treffer! 5⚡ -------------\n");
                 this.enemy.set_lives(enemy.lives - 5);
             }
             else if(this.timer.getTime() < 2000)
             {
                 System.out.println("---------- Sehr Kritischer Treffer! 4⚡ -----------\n");
                 this.enemy.set_lives(enemy.lives - 4);
             }
             else if(this.timer.getTime() < 4000)
             {
                 System.out.println("-------------- Kritischer Treffer! 3⚡ --------------\n");
                 this.enemy.set_lives(enemy.lives - 3);
             }
             else if(this.timer.getTime() < 5000)
             {
                 System.out.println("-------------- Guter Treffer! 2⚡ --------------\n");
                 this.enemy.set_lives(enemy.lives - 2);
             }
             else
             {
                  System.out.println("------------------ Richtig! 1⚡ ------------------\n");
                  this.enemy.set_lives(enemy.lives - 1);
             }

             
             
             
             try
             {
                 Thread.sleep(1000);
             }
             catch(InterruptedException e){}
             draw();
         }
         else
         {
             System.out.println(answer);
             System.out.println("---------------- Falsch! -> -1❤ ------------\n");
             Game.player.set_lives(Game.player.lives - 1);
             try
             {
                 Thread.sleep(1000);
             }
             catch(InterruptedException e){}
             draw();
         }
     }
    
    private Enemy getNewRandomEnemy()
    {
        Random rnd = new Random();
        int rndInt = rnd.nextInt(enemies.size() - 1);
        int rndLvl = rnd.nextInt(3) * Game.player.get_lvl();
        Enemy enemy = (Enemy) enemies.get(rndInt);
        enemy.set_lvl(rndLvl);
        return enemy;
    }
    
    private List<Integer> getNewSquence()
    {
        Random r = new Random();
        int rInt1 = r.nextInt(this.enemy.get_lvl()*2+1) + 1;
        int rInt2 = r.nextInt(this.enemy.get_lvl()*3+1) + 1;
        
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= seqLen; i++)
        {
            l.add(rInt1 * rInt2 * i);
        }
        
        replacedIndex = r.nextInt(l.size() - 1);
        answer = l.get(replacedIndex);
        l.remove(replacedIndex);
        
        return  l;
    }
}
