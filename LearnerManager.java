package learnpath;

import java.util.*;

public class LearnerManager {

    HashMap<Integer, Learner> learners = new HashMap<>();

    public void registerLearner(int id, String name) {
        learners.put(id, new Learner(id, name));
        System.out.println("Learner Registered!");
    }

    public Learner getLearner(int id) {
        return learners.get(id);
    }

    public void displayAllLearners() {

        if (learners.isEmpty()) {
            System.out.println("No learners registered.");
            return;
        }

        for (Learner l : learners.values()) {
            System.out.println("ID: " + l.getId() +
                               " Name: " + l.getName() +
                               " Progress: " + l.getProgress() + "%");
        }
    }

    public void sortLearnersByProgress() {

        List<Learner> list = new ArrayList<>(learners.values());

        list.sort((a, b) -> b.getProgress() - a.getProgress());

        System.out.println("==== Sorted Learners ====");

        for (Learner l : list) {
            System.out.println(l.getName() + " - " + l.getProgress() + "%");
        }
    }
}