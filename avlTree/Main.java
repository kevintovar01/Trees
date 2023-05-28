package avlTree;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
/*
	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<>();
		AvlNode<Integer> node = new AvlNode<>(80, null);
		
		tree.addNode(node);
		tree.insertNode(30);
		tree.insertNode(20);
		tree.insertNode(50);
		tree.insertNode(100);
		tree.insertNode(40);
		tree.insertNode(101);

		
		tree.drawTree();
		
		tree.removeNode(100);
		tree.removeNode(80);
		tree.removeNode(101);
		System.out.println("------");
		
		tree.drawTree();
		
//		System.out.println(tree.searchNodeTree(80));
 */
	}

