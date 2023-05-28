package avlTree;

import java.awt.Color;
import java.awt.Graphics;

public class AvlTree<T extends Comparable<T>> {
	static final int inix = 290, iniy = 0;// el nodo principal apaprece

	private AvlNode<T> root = null;

	public AvlNode<T> addNode(AvlNode<T> node) {
		if (root != null) {
			return root.addNode(node);
		} else {
			return this.root = node;
		}
	}

	public void balance(AvlNode<T> temp) {
		boolean changeHeight;
		int fb;

		while ((temp = temp.getParent()) != null) {
			changeHeight = temp.updateHeight();
			fb = temp.calculateFB();

			if (fb == -2) {
				if (temp.getChilds().get(1).calculateFB() == 1) {
					temp.getChilds().get(1).turnRight();
				}
				AvlNode<T> subRaiz = temp.turnLeft();
				if (temp == root) {
					root = subRaiz;
				}
			} else if (fb == 2) {
				if (temp.getChilds().get(0).calculateFB() == -1) {
					temp.getChilds().get(0).turnLeft();
				}
				AvlNode<T> subRaiz = temp.turnRight();
				if (temp == root) {
					root = subRaiz;
				}
			}
			if (!changeHeight)
				return;
		}
	}

	public void insertNode(int value) {
		AvlNode<Integer> node = new AvlNode<>(value);
		@SuppressWarnings("unchecked")
		AvlNode<T> newNode = addNode((AvlNode<T>) node);
		balance(newNode);
	}

	public AvlNode<T> searchNodeTree(T value) {
		if (root == null) {
			return null;
		}
		return root.searchNode(value);
	}

	public AvlNode<T> lessNode(AvlNode<T> nodo) {
		if (nodo == null) {
			return null;
		} else {
			AvlNode<T> temp = nodo;
			while (temp.getChilds().get(0) != null) {
				temp = temp.getChilds().get(0);
			}
			return temp;
		}
	}

	public AvlNode<T> upNode(AvlNode<T> nodo) {
		if (nodo == null) {
			return null;
		} else {
			AvlNode<T> temp = nodo;
			while (temp.getChilds().get(1) != null) {
				temp = temp.getChilds().get(1);
			}
			return temp;
		}
	}

	public AvlNode<T> removeNodoTree(T value) {
		AvlNode<T> temp = searchNodeTree(value);
		if (temp == null)
			return null;

		while (!temp.isLeaf()) {
			if (temp.getChilds().get(0) != null) {
				AvlNode<T> temp2 = upNode(temp.getChilds().get(0));
				temp.remplaceData(temp2);
				temp = temp2;
			} else {
				AvlNode<T> temp2 = lessNode(temp.getChilds().get(1));
				temp.remplaceData(temp2);
				temp = temp2;
			}
		}

		if (temp.getParent() == null) {
			root = null;
			return temp;
		} else if (temp.getParent().getChilds().get(0) == temp) {
			temp.getParent().getChilds().set(0, null);
			return temp;
		} else {
			temp.getParent().getChilds().set(1, null);
			return temp;
		}
	}

	public boolean removeNode(T value) {
		AvlNode<T> temp = removeNodoTree(value);
		if (temp == null)
			return false;
		balance(temp);
		return true;

	}

	public AvlNode<T> drawTree() {
		return root.drawNodeTree();
	}

	public AvlNode<T> getRoot() {
		return root;
	}

	public void setRoot(AvlNode<T> root) {
		this.root = root;
	}

	public void arbolPreordenGrap(AvlNode<T> node, Graphics g) {
		int distanciaX = 10;
		int distanciaY = 20;
		if (node == null)
			return;

		if (node == root) {
			root.x = 0;
			root.y = 0;
			g.setColor(Color.BLUE);
			g.drawOval(inix + root.x, iniy + root.y, 30, 30);
			g.drawString(root.getValue().toString(), inix + root.x + distanciaX, iniy + root.y + distanciaY);
		}
		if (node != root) {
			System.out.println(node.getParent());
			if (node == node.getParent().getChilds().get(0) ) {
				node.x=node.getParent().x-90;
				node.y=node.getParent().y+75;

				g.drawOval(inix+node.x, iniy+node.y, 30, 30);
				g.drawString(node.getValue().toString(), inix+node.x+distanciaX, iniy+node.y+distanciaY);	
				g.drawLine(inix+node.x+distanciaX, iniy+node.y, inix+node.getParent().x+distanciaX, iniy+node.getParent().y+30);

			}
			if (node == node.getParent().getChilds().get(1)) {
				node.x=node.getParent().x-90;
				node.y=node.getParent().y+75;
				g.drawOval(inix+node.x, iniy+node.y, 30, 30);
				g.drawString(node.getValue().toString(), inix+node.x+distanciaX, iniy+node.y+distanciaY);
				g.drawLine(inix+node.x+distanciaX, iniy+node.y, inix+node.getParent().x+distanciaX, iniy+node.getParent().y+30);
			}
		}
		this.arbolPreordenGrap(node.getChilds().get(0), g);
		this.arbolPreordenGrap(node.getChilds().get(1), g);
	}
}
