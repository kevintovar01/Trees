package avlTree;
import java.awt.Graphics;
import java.util.ArrayList;

public class AvlNode<T extends Comparable<T>>{

	static final int inix=580,iniy=0;// el nodo principal apaprece

	private T value;
	private ArrayList<AvlNode<T>> childs = new ArrayList<>();
	private AvlNode<T> parent = null;
	private int height;
	public int x,y;
	
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
	
	public boolean isLeaf() {
		return this.childs.get(0) == null && this.childs.get(1) == null;
	}
	
	public void remplaceData(AvlNode<T> nodo) {
		T temp = this.value;
		this.value = nodo.value;
		nodo.value = temp;
	}
		
	/*
	 * Regresa cambio de la altura
	 */
	public boolean updateHeight() {
		int heightLeft = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(0).height;
		int heightRith = (this.childs.get(1) == null) ? 0 : 1+this.childs.get(1).height;
		int afterHeight = height;
		this.height = (heightLeft >= heightRith) ? heightLeft : heightRith;
		return afterHeight != height;
	}
	
	/*
	 * devuelve el factor de balanceo, nota: se asume que las alturas de los hijos
	 * son correctas
	 */
	public int calculateFB() {
		int heightLeft = (this.childs.get(0) == null) ? 0 : 1+this.childs.get(0).height;
		int heightRith = (this.childs.get(1) == null) ? 0 : 1+this.childs.get(1).height;
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
		if(orphan != null) {			
			orphan.parent = r;
		}
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
		if(orphan != null) {			
			orphan.parent = r;
		}
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
	
	public AvlNode<T> searchNode(T value) {
		if(value.equals(this.value)) {
			return this;
		}else if(value.compareTo(this.value) > 0){		
			if(this.childs.get(1) != null) {
				return this.childs.get(1).searchNode(value);
			}else {
				return null;
			}
		}else {
			if(this.childs.get(0) != null) {
				return this.childs.get(0).searchNode(value);
			}else {
				return null;
			}
		}
	}
	
	
	
	
	
	public AvlNode<T> drawNodeTree() {
		this.arbolPreorden();
		return null;
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
			this.childs.get(0).ArbolPosfijo();
		}

		if (getChilds().get(1) != null) {
			this.childs.get(1).ArbolPosfijo();
		}

		System.out.println(this.toString());
	}
	
	public void arbolPreorden() {
		System.out.println(this.toString());

		if (getChilds().get(0) != null) {
			this.childs.get(0).arbolPreorden();
		}

		if (getChilds().get(1) != null) {
			this.childs.get(1).arbolPreorden();
		}
	}
	
	public void arbolPreordenGrap(AvlNode<T> node, Graphics g,AvlNode<T> root) {
		System.out.println(this.toString());
		int distanciaX=10;
		int distanciaY=20;
		if(node== root){
			root.x=0;
			root.y=0;
			g.drawOval(inix+root.x, iniy+root.y, 30, 30);
			g.drawString(root.getValue().toString(), inix+root.x+distanciaX, iniy+root.y+distanciaY);
		}else{
			if (getChilds().get(0) != null) {
				node.x=node.getParent().x-90;
				node.y=node.getParent().y+75;
				g.drawOval(inix+node.x, iniy+node.y, 30, 30);
				g.drawString(node.getValue().toString(), inix+node.x+distanciaX, iniy+node.y+distanciaY);	
				g.drawLine(inix+node.x+distanciaX, iniy+node.y, inix+node.getParent().x+distanciaX, iniy+node.getParent().y+30);
				this.childs.get(0).arbolPreordenGrap(node,g,root);
			}
			if (getChilds().get(1) != null) {
				node.x=node.getParent().x+90;
				node.y=node.getParent().y+75;
				g.drawOval(inix+node.x, iniy+node.y, 30, 30);
				g.drawString(node.getValue().toString(), inix+node.x+distanciaX, iniy+node.y+distanciaY);
				g.drawLine(inix+node.x+distanciaX, iniy+node.y, inix+node.getParent().x+distanciaX, iniy+node.getParent().y+30);
				this.childs.get(1).arbolPreordenGrap(node,g,root);
			}
		}
	}

	
	public String toString() {
		if(value == null) {
			return "borrado";
		}else {
			return value.toString();
		}	
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
