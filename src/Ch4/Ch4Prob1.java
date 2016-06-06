package Ch4;

import java.util.LinkedList;

/**
 * Created by larryliu on 5/25/16.
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Ch4Prob1 {

    boolean search(Graph2 g, Node start, Node end) {
        if (start == end ) return true;

        // operates as Queue
        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) return true;
                        else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
