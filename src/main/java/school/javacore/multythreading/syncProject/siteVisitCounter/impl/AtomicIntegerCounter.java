package school.javacore.multythreading.syncProject.siteVisitCounter.impl;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            atomicInteger.incrementAndGet();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getVisitCount() {
        return atomicInteger.get();
    }
}
