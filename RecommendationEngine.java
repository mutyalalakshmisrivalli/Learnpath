package learnpath;

import java.util.*;

public class RecommendationEngine {

    private Queue<String> deliveryQueue = new LinkedList<>();
    private PriorityQueue<String> weakModules = new PriorityQueue<>();

    public void addToDelivery(String module) {
        deliveryQueue.add(module);
    }

    public void showDeliveryQueue() {
        System.out.println("Content Delivery Queue:");
        for (String m : deliveryQueue) {
            System.out.println(m);
        }
    }

    public void addWeakModule(String module) {
        weakModules.add(module);
    }

    public void recommendModules() {
        System.out.println("Recommended Modules:");
        while (!weakModules.isEmpty()) {
            System.out.println(weakModules.poll());
        }
    }
}