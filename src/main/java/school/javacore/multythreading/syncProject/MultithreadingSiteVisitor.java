package school.javacore.multythreading.syncProject;

import school.javacore.multythreading.syncProject.siteVisitCounter.SiteVisitCounter;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter siteVisitCounter;
    private List<Thread> threads = new ArrayList<>();
    private long startTime, endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(siteVisitCounter::incrementVisitCount);
            threads.add(thread);
            thread.start();
        }
    }

    public void waitUntilAllVisited() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        endTime = System.currentTimeMillis();
    }

    public long getTotalTimeOfHandling() {
        return endTime - startTime;
    }
}
