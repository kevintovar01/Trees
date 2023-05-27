
package trees.tree;

import java.util.ArrayList;


/**
 *
 * @author Estudiantes
 */
public abstract class Node <T> extends Tree <T> {
    
    protected T value;
    protected ArrayList<Node> childs = new ArrayList<>();
    protected int level;
    protected Node parent = null;

    

    public Node(T value, int grade, Node parent) {
        this.value = value;
        this.childs = new ArrayList<>(grade);
        this.parent = parent;
    }

    public Node(T value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Node(T value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the childs
     */
    public ArrayList<Node> getChilds() {
        return childs;
    }

    /**
     * @param childs the childs to set
     */
    public void setChilds(ArrayList<Node> childs) {
        this.childs = childs;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
}
