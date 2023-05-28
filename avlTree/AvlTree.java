package avlTree;


public class AvlTree<T extends Comparable<T>>{
	
	private AvlNode<T> root = null;


	public AvlNode<T> addNode(AvlNode<T> node) {
        if(root!=null){
            return root.addNode(node);
        }else{
            return this.root = node;
        }
//        return node;
    }
	
	public void insertNode(AvlNode<T> node) {
		AvlNode<T> newNode = addNode(node);
		AvlNode<T> temp = newNode;
		boolean changeHeight;
		int fb;
		
		while((temp = temp.getParent()) != null) {
			changeHeight = temp.updateHeight();
			fb = temp.calculateFB();
			
			if(fb == -2) {
				if(temp.getChilds().get(1).calculateFB() == 1) {
					temp.getChilds().get(1).turnRight();
				}
				AvlNode<T> subRaiz = temp.turnLeft();
				if(temp == root) {
					root = subRaiz;
				}
			}else if (fb == 2) {
				if(temp.getChilds().get(0).calculateFB() == -1) {
					temp.getChilds().get(0).turnLeft();
				}
				AvlNode<T> subRaiz = temp.turnRight();
				if(temp == root) {
					root = subRaiz;
				}
			}
			if (!changeHeight) return;
		}
	}
	
	
	public AvlNode<T> searchNodeTree(T value) {
		if(root == null) {
			return null;
		}
		return root.searchNode(value);
	}
	
	public AvlNode<T> drawTree(){
		return root.drawNodeTree();
	}

	
	
	
	
	
	


}
