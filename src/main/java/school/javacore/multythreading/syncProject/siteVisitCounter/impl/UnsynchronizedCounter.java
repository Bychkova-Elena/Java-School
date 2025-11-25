package school.javacore.multythreading.syncProject.siteVisitCounter.impl;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private static int counter = 0;

    @Override
    public void incrementVisitCount() {
        try {
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
