package Ch4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by larryliu on 6/5/16.
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the fisrt project.) All of a project's dependencies must be built
 * before the project is. Find a build order that will allow the projects to be built. If there is no valid build
 * order, return an error.
 * EXAMPLE
 * Input:
 *  projects: a, b, c, d, e, f
 *  dependencies:(a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 */
public class Ch4Prob7 {
    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph2 graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    Graph2 buildGraph(String[] projects, String[][] dependencies) {
        Graph2 graph = new Graph2();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

}

class Graph2 {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }
    public ArrayList<Project> getNodes() {return nodes;}
}

class Project {
    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n){ name = n; }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public String getName() {return name;}
    public void incrementDependencies() {dependencies++;}
    public void decrementDependencies() {dependencies--;}

    public ArrayList<Project> getChildren() {return children;}
    public int getDependencies() {return dependencies;}
    public void setState(State st) {state = st;}
    public State getState() {return state;}
}
