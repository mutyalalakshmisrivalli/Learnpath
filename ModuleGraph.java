package learnpath;

import java.util.*;

public class ModuleGraph {

    private Map<String, List<String>> graph = new HashMap<>();

    public void addModule(String module) {
        graph.putIfAbsent(module, new ArrayList<>());
    }

    public void addPrerequisite(String module, String prerequisite) {
        graph.get(module).add(prerequisite);
    }

    public void showPrerequisites(String module) {
        System.out.println("Prerequisites for " + module + ":");
        dfs(module, new HashSet<>());
    }

    private void dfs(String module, Set<String> visited) {
        if (!visited.contains(module)) {
            visited.add(module);
            System.out.println(module);
            for (String pre : graph.getOrDefault(module, new ArrayList<>())) {
                dfs(pre, visited);
            }
        }
    }
}