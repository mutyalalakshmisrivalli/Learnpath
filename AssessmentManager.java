package learnpath;

public class AssessmentManager {

    private String[] queue = new String[3];
    private int front = -1, rear = -1;

    public void addAssessment(String test) {
        if ((rear + 1) % queue.length == front) {
            System.out.println("Assessment Queue Full!");
            return;
        }

        if (front == -1) front = 0;

        rear = (rear + 1) % queue.length;
        queue[rear] = test;
    }

    public void showAssessments() {
        if (front == -1) {
            System.out.println("No Assessments.");
            return;
        }

        int i = front;
        System.out.println("Scheduled Assessments:");
        while (true) {
            System.out.println(queue[i]);
            if (i == rear) break;
            i = (i + 1) % queue.length;
        }
    }
}