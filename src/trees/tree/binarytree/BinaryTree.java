
package trees.tree.binarytree;

import trees.tree.Node;
import trees.tree.Tree;

/**
 * Se supone que dice la altura y el grado del arbol
 * @author Estudiantes
 */
public class BinaryTree <T extends Comparable> extends Tree <T> {

    public BinaryTree() {
        this.setGrade(2);
        this.setHigh(0);
        this.setRoot(null);
    }

    @Override //establece la raiz o agrega nodo nuevo
    public void addNode(Node<T> node) {
        if(getRoot()!=null){
            getRoot().addNode(node);
        }else{
            this.setRoot(node);
        }
    }
    //ignorar solo por extender de tree
    @Override
    public void removeNode(T value){
    }

    @Override
    public void drawTree() {
    }

    @Override
    public void searchNode(T node) {
    }
    
}
