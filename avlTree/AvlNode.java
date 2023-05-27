package avlTree;
import java.util.ArrayList;

import tree.Node;



public class AvlNode<T extends Comparable<T>>{

	protected T value;
	protected ArrayList<AvlNode<T>> childs = new ArrayList<>();
	protected AvlNode<T> parent = null;
	protected int height;
	
	public AvlNode(T value) {
		this.value = value;
		this.childs = new ArrayList<>(2);
		childs.add(null);
		childs.add(null);
		this.setChilds(childs);
	}
	
	public AvlNode(T value, AvlNode<T> parent) {
		this.value = value;
		this.parent = parent;
		childs = new ArrayList<>(2);
		childs.add(null); 
		childs.add(null);
		this.setChilds(childs);
	}
	
	

	public AvlNode<T> addNode(AvlNode<T> node) {
		if(node.getValue().compareTo(this.value) > 0) {
			if(this.childs.get(1) != null) {
				this.childs.get(1).addNode(node);
			}else {
				node.setParent(this);
				this.childs.set(1, node);
			}
		}else {
			if(this.childs.get(0) != null) {
				this.childs.get(0).addNode(node);
			}else {
				node.setParent(this);
				this.childs.set(0, node);
			}
		}
		return node;
	}
		
	/*
	 * Regresa cambio de la altura
	 */
	public boolean updateHeight() {
		int heightLeft = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(1).height;
		int heightRith = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(1).height;
		int afterHeight = height;
		this.height = (heightLeft >= heightRith) ? heightLeft : heightRith;
		return afterHeight != height;
	}
	
	/*
	 * devuelve el factor de balanceo, nota: se asume que las alturas de los hijos
	 * son correctas
	 */
	public int calculateFB() {
		int heightLeft = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(1).height;
		int heightRith = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(1).height;
		return heightLeft - heightRith;
	}
	
	/*
	 * Regresa la nueva raiz del subarbol
	 */
	public AvlNode<T> turnRight() {
//		referencias temporales
		AvlNode<T> r = this;
		AvlNode<T> g = (AvlNode<T>) this.childs.get(0);
		AvlNode<T> orphan = (AvlNode<T>) g.childs.get(1);
		
		g.getChilds().set(1, r);
		r.getChilds().set(0, orphan);
		orphan.parent = r;
		g.parent = r.getParent();
		
		if(r.getParent() != null) {
			if(r.getParent().getChilds().get(0) == r) {
				r.getParent().getChilds().set(0, g);
			}else if (r.getParent().getChilds().get(1) == r) {
				r.getParent().getChilds().set(1, g);
			}else {
				throw new IllegalStateException("Arbol mal");  /*temporal, verificamos que el arbol no tenga errores*/
			}
			
		}
		r.parent = g;
		r.updateHeight();
		g.updateHeight();
		return g;
	}
	
	
	public AvlNode<T> turnLeft() {
//		referencias temporales
		AvlNode<T> r = this;
		AvlNode<T> g = (AvlNode<T>) this.childs.get(1);
		AvlNode<T> orphan = (AvlNode<T>) g.childs.get(0);
		
		g.getChilds().set(0, r);
		r.getChilds().set(1, orphan);
		orphan.parent = r;
		g.parent = r.getParent();
		
		if(r.getParent() != null) {
			if(r.getParent().getChilds().get(0) == r) {
				r.getParent().getChilds().set(0, g);
			}else if (r.getParent().getChilds().get(1) == r) {
				r.getParent().getChilds().set(1, g);
			}else {
				throw new IllegalStateException("Arbol mal");  /*temporal, verificamos que el arbol no tenga errores*/
			}
			
		}
		r.parent = g;
		r.updateHeight();
		g.updateHeight();
		return g;
	}
	
	public void ArbolInfijo() {
		if(this.childs.get(0) != null) {
			this.childs.get(0).ArbolInfijo();
		}
		System.out.println(this.toString());
		
		if(this.childs.get(1) != null) {
			this.childs.get(1).ArbolInfijo();
		}
	}
	
	public void ArbolPosfijo() {
	    if (getChilds().get(0) != null) {
	      this.childs.get(0).ArbolInfijo();
	    }
	    
	    if (getChilds().get(1) != null) {
	    	this.childs.get(1).ArbolInfijo();
	    }
	    
	    System.out.println(this.toString());
	 }
	
	public String toString() {
		if(value == null) {
			return "borrado";
		}else {
			return value.toString();
		}	
	}
	
	
	public void drawTree() {
		System.out.println("Dibujando arbol binario Infijo");
		this.ArbolInfijo();
//		System.out.println("Dibujando arbol binario Posfijo");
//		this.ArbolPosfijo();
	}
	
	

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ArrayList<AvlNode<T>> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<AvlNode<T>> childs) {
		this.childs = childs;
	}

	public AvlNode<T> getParent() {
		return parent;
	}

	public void setParent(AvlNode<T> parent) {
		this.parent = parent;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	


}
