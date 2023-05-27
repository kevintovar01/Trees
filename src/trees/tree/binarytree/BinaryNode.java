package trees.tree.binarytree;

import java.util.ArrayList;
import trees.tree.Node;
import trees.tree.Tree;
import trees.tree.binarytree.BinaryTree;

/**
 *
 * @author Estudiantes
 */
public class BinaryNode<T extends Comparable> extends Node<T> {

  public BinaryNode(T value) {
    super(value);
    ArrayList<Node> childs = new ArrayList<>(2);
    childs.add(null);
    childs.add(null);
    this.setChilds(childs);
  }

  public BinaryNode(T value, Node parent) {
    super(value, parent);
    ArrayList<Node> childs = new ArrayList<>(2);
    childs.add(null);
    childs.add(null);
    this.setChilds(childs);
  }

  @Override
  public void addNode(Node<T> node) {
    if (node.getValue().compareTo(this.getValue()) > 0) {
      if (this.getChilds().get(1) != null) {
        ((BinaryNode) this.getChilds().get(1)).addNode(node); //asigna al nodo hijos
      } else {
        node.setParent(this);
        this.getChilds().set(1, node); //se asigna nodo padre
      }
    } else {
      if (this.getChilds().get(0) != null) {
        ((BinaryNode) this.getChilds().get(0)).addNode(node);
      } else {
        node.setParent(this);
        this.getChilds().set(0, node);
      }
    }
  }

  //aqui va las funciones de eliminar, buscar y dibujar

  //dibuja de ambas formas el arbol
  public void drawTree() {
    System.out.println("Dibujando arbol binario Infijo");
    this.ArbolInfijo();
    System.out.println("Dibujando arbol binario Posfijo");
    this.ArbolPosfijo();
  }

  public String toString() {
    if (value == null) {
      return "borrado";
    } else {
      return value.toString();
    }
  }

  public void ArbolInfijo() {
    if (getChilds().get(0) != null) {
      ((BinaryNode) getChilds().get(0)).ArbolInfijo();
    }
    System.out.println(this.toString());

    if (getChilds().get(1) != null) {
      ((BinaryNode) getChilds().get(1)).ArbolInfijo();
    }
  }

  public void ArbolPosfijo() {
    if (getChilds().get(0) != null) {
      ((BinaryNode) getChilds().get(0)).ArbolInfijo();
    }
    if (getChilds().get(1) != null) {
      ((BinaryNode) getChilds().get(1)).ArbolInfijo();
    }
    System.out.println(this.toString());
  }

  @Override //imprime el resultado de la busqueda
  public void searchNode(T value) {
    if (this.buscarNodo(value) != null) {
      System.out.println("Encontrado");
    } else {
      System.out.println("No encontrado");
    }
  }
  //busca y retorna null si no encuentra nada
  public BinaryNode buscarNodo(T value) {
    if (value.equals(this.value)) {
      return this;
    } else {
      if (((Comparable) value).compareTo(this.value) > 0) {
        if (this.getChilds().get(1) != null) {
          return ((BinaryNode) this.getChilds().get(1)).buscarNodo(value);
        } else {
          return null;
        }
      } else {
        if (this.getChilds().get(0) != null) {
          return ((BinaryNode) this.getChilds().get(0)).buscarNodo(value);
        } else {
          return null;
        }
      }
    }
  }


  public void removeNode(T value) {
    Node<T> nodoAEliminar = buscarNodo(value);
    
    if(nodoAEliminar == null) {
        return;
    }
    
    
    if(nodoAEliminar.getChilds().get(0) != null && nodoAEliminar.getChilds().get(1) != null) {
        BinaryNode<T> sucesor = (BinaryNode<T>) nodoAEliminar.getChilds().get(1);
        while(sucesor.getChilds().get(0) != null) {
            sucesor = (BinaryNode<T>) sucesor.getChilds().get(0);
        }
        
        T datoSucesor = sucesor.getValue();
        removeNode(datoSucesor);
        nodoAEliminar.setValue(datoSucesor);
        sucesor.setValue(null);
        
    }else if (nodoAEliminar.getChilds().get(0) != null) {
        BinaryNode<T> hijo = (BinaryNode<T>) nodoAEliminar.getChilds().get(0);
        //removeNode(hijo.getValue());
        reemplazar(nodoAEliminar, hijo);
    } else if (nodoAEliminar.getChilds().get(1) != null) {
        BinaryNode<T> hijo = (BinaryNode<T>) nodoAEliminar.getChilds().get(1);
       // removeNode(hijo.getValue());
        reemplazar(nodoAEliminar, hijo);
    } else {
        reemplazar(nodoAEliminar, null);
    }
    
    
}

private void reemplazar(Node<T> nodoAEliminar, BinaryNode<T> nodoNuevo) {
    BinaryNode<T> padre = (BinaryNode<T>) nodoAEliminar.getParent();
    if (padre != null) {
        if (nodoAEliminar == padre.getChilds().get(0)) {
            padre.getChilds().set(0, nodoNuevo);
//	            nodoAEliminar.getChilds().set(1, null);
        } else {
            padre.getChilds().set(1, nodoNuevo);
//	            nodoAEliminar.getChilds().set(0, null);
        }
        if (nodoNuevo != null) {
            nodoNuevo.setParent(padre);
        }
    } else {
        nodoNuevo.setParent(null);
    }
}

}
