import java.io.Serializable;


public class BTSTree<T extends Comparable<T>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Node<T> root;
	public BTSTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	public BTSTree(Node<T> r) {
		// TODO Auto-generated constructor stub
		this();
		root = r;
	}
	private void setRoot(Node<T> r){
		root = r;
	}
	public Node<T> getRoot(){
		return root;
	}
	public void add(T i){
		if(i==null) return;
		System.out.println("Add : "+i);
		Node<T> n = new Node<T>(i);
		add(n);
	}
	public void add(Node<T> n){
		if (root == null) {
			setRoot(n);
			return;
		}
		insert(root,n);
	}
	private void insert(Node<T> node, Node<T> n){
		T a,b;
		if(n==null) return;
		a= (T) node.get();
		b= (T) n.get();
		if(a.compareTo(b)>0)
		{
			if(node.getLeft() == null){
				node.setLeft(n);
				n.setParent(node);
			}else{	insert(node.getLeft(),n);	}
		}
		if(a.compareTo(b)<0)
		{
			if(node.getRight() == null){
				node.setRight(n);
				n.setParent(node);
			}else{	insert(node.getRight(),n);	}
		}
		if(a.compareTo(b)==0){	System.out.println("Value exists!");	}
	}
	public T remove(T v){
		if(root == null) return null;
		System.out.println("Remove : "+v);
		return delete(root,v);
	}
	private T delete(Node<T> n, T v) { 
		T ret; 
		Node<T> p, l, r; r = null; 
		if(n==null) return null; 
		if(n.get().equals(v)) { 
			ret = n.get(); 
			p = n.getParent(); 
			l = n.getLeft(); 
			r = n.getRight(); // arrange child 
			if(l!=null) insert(l,r); 
			else l=r; // connect child and parent 
			l.setParent(p); // determine which child to connect 
			if(p.getLeft()==n) { p.setLeft(l); 	}
			else{ p.setRight(l); } // remove this node, do nothing? 
		} 
		if(n.get().compareTo(v)>0) { // left child 
			ret = delete(n.left,v); 
		} else { // right child 
			ret = delete(n.right,v); 
		} 
		return ret; 
	}
	public T search(T v){
		T ret = null;
		if(root != null) ret = searchNode(root,v);
		return ret;
	}
	public T searchNode(Node<T> n, T v){
		T ret = null;
		if( n == null) return ret;
		if(n.get().equals(v)) return n.get();
		if(n.get().compareTo(v)<0) ret = searchNode(n.getLeft(), v);
		else ret = searchNode(n.getRight(), v);
		return ret;
	}
	public void print() {
		printInorder(this.root);
	}
	private void printInorder(Node<T> node) {
		if (node.get() == null) return; 
        printInorder(node.left); 
        System.out.print(node.get() + " "); 
        printInorder(node.right); 
	}
	private void printPreorder(Node<T> node) { 
        if (node == null) return; 
        System.out.print(node.get() + " "); 
        printPreorder(node.left); 
        printPreorder(node.right); 
    } 
	private void printPostorder(Node<T> node) { 
        if (node == null) return; 
        printPostorder(node.left); 
        printPostorder(node.right); 
        System.out.print(node.get() + " "); 
    } 
	public int size() {
		return(size(root)); 
	}
	private int size(Node<T> node) { 
		if (node == null) return(0);
		else {
			return(size(node.left) + 1 + size(node.right)); 
		} 
	}
}
