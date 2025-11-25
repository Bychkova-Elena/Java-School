package school.javacore.multythreading.syncProject.siteVisitCounter.impl;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
