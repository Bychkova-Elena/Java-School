package school.javacore.multythreading.syncProject.siteVisitCounter.impl;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

public class VolatileCounter implements SiteVisitCounter {
    private static volatile int count = 0;

    @Override
    public void incrementVisitCount() {
        try {
            count++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getVisitCount() {
        return count;
    }
}
