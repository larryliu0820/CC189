package Ch4;

/**
 * Created by larryliu on 5/23/16.
 */
public class Node {
    public Node (int i) {value = i;}
    int value;
    public String name;
    public Node left;
    public Node right;
    private Node[] children;
    public Node[] getAdjacent(){return children;}
    public State state;
}
enum State {Unvisited, Visited, Visiting}
