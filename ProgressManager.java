package learnpath;

import java.util.*;

public class ProgressManager {

    private LinkedList<String> history = new LinkedList<>();
    private Stack<Integer> undoStack = new Stack<>();

    public void completeModule(Learner learner) {
        undoStack.push(learner.getProgress());
        learner.updateProgress(20);
        history.add("Completed module. Progress = " + learner.getProgress() + "%");
        System.out.println("Module Completed!");
    }

    public void undoProgress(Learner learner) {
        if (!undoStack.isEmpty()) {
            int previous = undoStack.pop();
            System.out.println("Reverted to: " + previous + "%");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void showHistory() {
        System.out.println("Activity History:");
        for (String record : history) {
            System.out.println(record);
        }
    }
}