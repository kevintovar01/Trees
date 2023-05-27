
package trees;
import trees.tree.binarytree.BinaryNode;
import trees.tree.binarytree.BinaryTree;

/**
 *
 * @author Estudiantes
 */
public class Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();//crea arbol
        BinaryNode<Integer> n1 = new BinaryNode<>(80, null);//crea nodo
        tree.addNode(n1);//agrega nodo al arbol
        n1.addNode(new BinaryNode<>(30));//agrega los otros nodos
        n1.addNode(new BinaryNode<>(40));
        n1.addNode(new BinaryNode<>(50));
        n1.addNode(new BinaryNode<>(35));
        n1.addNode(new BinaryNode<>(20));
        n1.addNode(new BinaryNode<>(150));
        n1.addNode(new BinaryNode<>(120));
        n1.addNode(new BinaryNode<>(115));
        n1.addNode(new BinaryNode<>(117));
        n1.addNode(new BinaryNode<>(130));
        n1.addNode(new BinaryNode<>(140));

        n1.drawTree();//dibuja arbol
        n1.searchNode(25);//busca nodo
        n1.removeNode(40);//elimina nodo
        n1.drawTree();        
    }
}
