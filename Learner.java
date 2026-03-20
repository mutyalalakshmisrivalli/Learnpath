package learnpath;

public class Learner {
    private int id;
    private String name;
    private int progress;

    public Learner(int id, String name) {
        this.id = id;
        this.name = name;
        this.progress = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getProgress() { return progress; }

    public void updateProgress(int value) {
        progress += value;
        if (progress > 100) progress = 100;
    }
}