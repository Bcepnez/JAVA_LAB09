import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity {
	public static void main(String[] arg0) {
		Node<Integer> a,b;
		BTSTree<Integer> root;
		ObjectOutputStream oos;
		FileOutputStream fos;
		String filename = "bt.bst";
		ObjectInputStream ois;
		FileInputStream fis;
		
		a = new Node<Integer>(10);
		b = new Node<Integer>(11);
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(b));
		System.out.println(b.compareTo(a));
		root = new BTSTree<Integer>();
		root.add(30);
		System.out.println("Size : "+root.size());
		root.add(20);
		System.out.println("Size : "+root.size());
		root.add(40);
		System.out.println("Size : "+root.size());
		root.add(35);
		System.out.println("Size : "+root.size());
		root.add(25);
		/*Value exists!*/
		root.add(35); 
		System.out.println("Size : "+root.size());
		root.remove(40);
		System.out.println("Size : "+root.size());
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(root);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			root = (BTSTree<Integer>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("root.search(30) : "+root.search(30));
		System.out.println("root.search(40) : "+root.search(40));
		System.out.println("Total Size : "+root.size());
//		root.print();
//		root.printIn();
		System.out.print("Post Order : ");
		root.printPost();
		System.out.println();
		System.out.print("Pre Order : ");
		root.printPre();
		System.out.println();
		System.out.print("In Order : ");
		root.printIn();
	}
}
