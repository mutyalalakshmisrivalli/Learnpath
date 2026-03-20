package learnpath;

public class Module {

    public static String[] modules = {
        "Intro",
        "Basics",
        "OOP",
        "DSA",
        "Project"
    };

    public static void displayModules() {
        System.out.println("Course Modules:");
        for (int i = 0; i < modules.length; i++) {
            System.out.println((i + 1) + ". " + modules[i]);
        }
    }
}