package avlTree;

public class Main {

	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<>();
		AvlNode<Integer> node = new AvlNode<>(80, null);
		
		tree.addNode(node);
		tree.insertNode(new AvlNode<>(30));
		tree.insertNode(new AvlNode<>(20));
		tree.insertNode(new AvlNode<>(50));
		tree.insertNode(new AvlNode<>(100));
		tree.insertNode(new AvlNode<>(40));
		tree.insertNode(new AvlNode<>(101));

		
		tree.drawTree();
		
//		System.out.println(tree.searchNodeTree(80));
	}

}
