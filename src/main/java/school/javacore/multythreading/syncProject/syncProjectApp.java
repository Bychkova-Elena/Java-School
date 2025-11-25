package school.javacore.multythreading.syncProject;

import school.javacore.multythreading.syncProject.siteVisitCounter.impl.*;

public class syncProjectApp {
    public static void main(String[] args) {
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        VolatileCounter volatileCounter = new VolatileCounter();
        SynchronizedBlockCounter synchronizedCounter = new SynchronizedBlockCounter();
        AtomicIntegerCounter atomicIntegerCounter = new AtomicIntegerCounter();
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();

        // значение 1000000, время: 68664
        // на маленький значениях работает корректно, начиная с 1000000 теряет данные
        MultithreadingSiteVisitor multithreadingSiteVisitorUnsynchronizedCounter =
                new MultithreadingSiteVisitor(unsynchronizedCounter);
        multithreadingSiteVisitorUnsynchronizedCounter.visitMultithread(1000000);
        multithreadingSiteVisitorUnsynchronizedCounter.waitUntilAllVisited();
        System.out.println("UnsynchronizedCounter time: " +
                multithreadingSiteVisitorUnsynchronizedCounter.getTotalTimeOfHandling());
        System.out.println("UnsynchronizedCounter counter: " + unsynchronizedCounter.getVisitCount());

        // значение 1000000, время: 67438
        // на маленький значениях работает корректно, начиная с 2000000 теряет данные
        MultithreadingSiteVisitor multithreadingSiteVisitorVolatileCounter =
                new MultithreadingSiteVisitor(volatileCounter);
        multithreadingSiteVisitorVolatileCounter.visitMultithread(2000000);
        multithreadingSiteVisitorVolatileCounter.waitUntilAllVisited();
        System.out.println("VolatileCounter time: " +
                multithreadingSiteVisitorVolatileCounter.getTotalTimeOfHandling());
        System.out.println("VolatileCounter counter: " + volatileCounter.getVisitCount());

        // работает намного дольше, значение 5000, время: 527406
        // работает корректно
        MultithreadingSiteVisitor multithreadingSiteVisitorSynchronizedCounter =
                new MultithreadingSiteVisitor(synchronizedCounter);
        multithreadingSiteVisitorSynchronizedCounter.visitMultithread(5000);
        multithreadingSiteVisitorSynchronizedCounter.waitUntilAllVisited();
        System.out.println("SynchronizedCounter time: " +
                multithreadingSiteVisitorSynchronizedCounter.getTotalTimeOfHandling());
        System.out.println("SynchronizedCounter counter: " + synchronizedCounter.getVisitCount());

        // работает намного быстрее синхронизации, значение 1000000, время: 67880
        // работает корректно
        MultithreadingSiteVisitor multithreadingSiteVisitorAtomicIntegerCounter =
                new MultithreadingSiteVisitor(atomicIntegerCounter);
        multithreadingSiteVisitorAtomicIntegerCounter.visitMultithread(2000000);
        multithreadingSiteVisitorAtomicIntegerCounter.waitUntilAllVisited();
        System.out.println("AtomicIntegerCounter time: " +
                multithreadingSiteVisitorAtomicIntegerCounter.getTotalTimeOfHandling());
        System.out.println("AtomicIntegerCounter counter: " + atomicIntegerCounter.getVisitCount());

        // работает как синхронизация, значение 5000, время: 525872
        // работает корректно
        MultithreadingSiteVisitor multithreadingSiteVisitorReentrantLockCounter =
                new MultithreadingSiteVisitor(reentrantLockCounter);
        multithreadingSiteVisitorReentrantLockCounter.visitMultithread(5000);
        multithreadingSiteVisitorReentrantLockCounter.waitUntilAllVisited();
        System.out.println("ReentrantLockCounter time: " +
                multithreadingSiteVisitorReentrantLockCounter.getTotalTimeOfHandling());
        System.out.println("ReentrantLockCounter counter: " + reentrantLockCounter.getVisitCount());
    }
}
