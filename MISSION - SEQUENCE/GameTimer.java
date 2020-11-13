import java.util.Timer;

public class GameTimer
{
    private long startTime;
    
    public GameTimer()
    {
        startTime = System.currentTimeMillis();
    }
    
    public long getTime()
    {
        return System.currentTimeMillis() - startTime;
    }
}
