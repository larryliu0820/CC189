package Ch4;

/**
 * Created by larryliu on 5/23/16.
 */
public class Node {
    public String name;
    private Node[] children;
    public Node[] getAdjacent(){return children;}
    public State state;
}
enum State {Unvisited, Visited, Visiting}
