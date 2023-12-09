
package com.company.quotes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author kirill
 */
public class Scheduler {

    /* pass the reference to avoid class duplication */
    public Scheduler(QuotesService qs) {
        this.QS = qs;
    }
    
    
    
    
    
    private ScheduledExecutorService scheduler;
    //private QuotesService QS = new QuotesService();
    private QuotesService QS = null;
    
    public void contextInitialized() {
    scheduler = Executors.newSingleThreadScheduledExecutor();
    //scheduler = Executors.newScheduledThreadPool(1);
    //scheduler.scheduleAtFixedRate((Runnable) new CleanerTask(), 0, 1, TimeUnit.HOURS);
    //scheduler.scheduleAtFixedRate(new CleanerTask(), 0, 5, TimeUnit.MINUTES);
    //scheduler.scheduleAtFixedRate(new CleanerTask(), 5, 1, TimeUnit.SECONDS);
    //ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(new CleanerTask(), 5, 1, TimeUnit.SECONDS);
    
    //ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(CleanerTask, 5, 1, TimeUnit.SECONDS);
    
    scheduler.scheduleAtFixedRate(CleanerTask, 0, 5, TimeUnit.MINUTES);
    //scheduler.schedule(new CleanerTask(), 15, TimeUnit.SECONDS);
}

public void contextDestroyed() {
    scheduler.shutdownNow();
}

/* inline runnable task */
Runnable CleanerTask = () -> {
            
        System.out.println("Running... CleanerTask ");
        
        if (this.QS != null)
            this.QS.deteleDailyQuotes();
            
        };
    
}
