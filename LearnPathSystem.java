package learnpath;

import java.util.Scanner;

public class LearnPathSystem {

    static Scanner sc = new Scanner(System.in);

    static LearnerManager learnerManager = new LearnerManager();
    static ProgressManager progressManager = new ProgressManager();
    static RecommendationEngine recommendationEngine = new RecommendationEngine();
    static AssessmentManager assessmentManager = new AssessmentManager();
    static ModuleGraph moduleGraph = new ModuleGraph();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== LearnPath System ====");
            System.out.println("1. Admin Portal");
            System.out.println("2. Student Portal");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminPortal();
                    break;
                case 2:
                    studentPortal();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ================= ADMIN PORTAL =================

    public static void adminPortal() {

        while (true) {
            System.out.println("\n==== Admin Portal ====");
            System.out.println("1. Add Module");
            System.out.println("2. Add Module Prerequisite");
            System.out.println("3. Schedule Assessment");
            System.out.println("4. View All Learners");
            System.out.println("5. View Top Learners");
            System.out.println("6. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Module.displayModules();
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Module: ");
                    String module = sc.nextLine();

                    System.out.print("Enter Prerequisite: ");
                    String pre = sc.nextLine();

                    moduleGraph.addModule(module);
                    moduleGraph.addModule(pre);
                    moduleGraph.addPrerequisite(module, pre);

                    System.out.println("Prerequisite Added!");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Assessment Name: ");
                    String test = sc.nextLine();

                    assessmentManager.addAssessment(test);
                    break;

                case 4:
                    learnerManager.displayAllLearners();
                    break;

                case 5:
                    learnerManager.sortLearnersByProgress();
                    break;

                case 6:
                    return;
            }
        }
    }

    // ================= STUDENT PORTAL =================

    public static void studentPortal() {

        while (true) {
            System.out.println("\n==== Student Portal ====");
            System.out.println("1. Register Learner");
            System.out.println("2. View Modules");
            System.out.println("3. Start Learning Module");
            System.out.println("4. View Progress");
            System.out.println("5. Get Recommended Modules");
            System.out.println("6. View Learning History");
            System.out.println("7. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Learner ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    learnerManager.registerLearner(id, name);
                    break;

                case 2:
                    Module.displayModules();
                    break;

                case 3:
                    System.out.print("Enter Learner ID: ");
                    int lid = sc.nextInt();

                    progressManager.completeModule(learnerManager.getLearner(lid));
                    break;

                case 4:
                    System.out.print("Enter Learner ID: ");
                    int pid = sc.nextInt();

                    Learner l = learnerManager.getLearner(pid);

                    if (l != null)
                        System.out.println("Progress: " + l.getProgress() + "%");
                    else
                        System.out.println("Learner not found!");
                    break;

                case 5:
                    recommendationEngine.addWeakModule("Graphs");
                    recommendationEngine.addWeakModule("Recursion");
                    recommendationEngine.recommendModules();
                    break;

                case 6:
                    progressManager.showHistory();
                    break;

                case 7:
                    return;
            }
        }
    }
}