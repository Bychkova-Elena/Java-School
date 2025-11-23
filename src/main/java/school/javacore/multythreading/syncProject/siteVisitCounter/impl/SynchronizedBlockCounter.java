package school.javacore.multythreading.syncProject.siteVisitCounter.impl;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private static Integer counter = 0;
    private static final Object lock = new Object();

    @Override
    public void incrementVisitCount() {
        synchronized (lock) {
            try {
                counter++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
