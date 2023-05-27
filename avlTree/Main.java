package avlTree;

public class Main {

	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<>();
		AvlNode<Integer> node = new AvlNode<>(80, null);
		
		tree.addNode(node);
		node.addNode(new AvlNode<>(30));
		node.addNode(new AvlNode<>(20));
		node.addNode(new AvlNode<>(50));
		node.addNode(new AvlNode<>(60));
		node.addNode(new AvlNode<>(10));
		
		node.drawTree();
		
	}

}
