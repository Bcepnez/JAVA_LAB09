import java.io.Serializable;

public class Node<E extends Comparable<E>> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	E item;
	Node<E> left,right,root;
	public Node() {
		// TODO Auto-generated constructor stub
		root = null;
		left = null;
		right = null;
		item = null;
	}
	public Node(E itm) {
		this();
		item = itm;
	}
	public void insert(E data) {
		insertNode(root, data);
	}
	private Node<E> insertNode(Node<E> node,E data) {
		if(node==null){
			node = new Node<>(data);
		}else {
			if (node.getRight()!=null) {
				node.setRight(new Node<E>(data));
			}else{
				node.setLeft(new Node<E>(data));
			}
		}
		return node;
	}
	
	public void setParent(Node<E> p)
	{
		this.root = p;
	}
	public void setLeft(Node<E> p) {
		this.left = p;
	}
	public void setRight(Node<E> p) {
		this.right = p;
	}
	public void set(E p){
		this.item = p;
	}
	public Node<E> getParent(){
		return root;
	}
	public Node<E> getRight() {
		return right;
	}
	public Node<E> getLeft(){
		return left;
	}
	public E get(){
		return item;
	}
	public int compareTo (Node<E> n)
	{
		return (this.get().compareTo(n.get()));
	}
	
}




