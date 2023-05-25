package Acti1;

//import Acti1.Bs1.Node;

//Angie Alvarez Code
//Lab 08 Binary Search Tree
public class BSTree <E extends Comparable<E>>{
	
	//node class
	class Node {
		protected E data;
		protected Node left, right;
		
		//Node constructor
		public Node (E data) {
			this (data, null, null);
		}
		
		//Node Constructor with arguments
		public Node (E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	//attribute root
	Node root;
	//area//
    public int calculateArea() {
        int leafCount = countNonLeafNodes();
        int treeHeight = height(root);
        return leafCount * treeHeight;
        //System.out.println(t;
    }
   //sangira
    class Node1 {
        int data;
        Node left, right;

        Node1(int item) {
            data = item;
            left = right = null;
        }
    }
	//constructor
	public BSTree() {
		this.root = null;
	}
	
	//is Empty
	public boolean isEmpty() {
		return this.root == null;
	}
	
	//insertion
	public void insert(E x) throws ItemDuplicated{
		this.root = insertRec(x, this.root);
	}
	private Node insertRec(E x, Node current) throws ItemDuplicated{
		Node res = current;
		if (current == null)
			res = new Node(x);
		else {
			int resC = current.data.compareTo(x);
			if (resC == 0)
				throw new ItemDuplicated("El dato " + x + " ya fue insertado");
			
			if(resC < 0)
				res.right = insertRec(x, current.right);
			else
				res.left = insertRec(x, current.left);
		}
		return res;
	}
	
	//search
	public E search(E x) throws ItemNoFound{
		Node res = searchRec(x, this.root);
		if (res == null)
			throw new ItemNoFound("El dato " + x + "no esta");
		return res.data;
	}
	
	private Node searchRec(E x, Node n) {
		if (n == null)
			return null;
		else {
			int resC = n.data.compareTo(x);
			if (resC < 0)
				return searchRec(x, n.right);
			else if (resC > 0)
				return searchRec(x, n.left);
			else return n;
		}
	}
	
	//remove
	public void remove (E x) throws ItemNoFound{
		this.root = removeRec(x, this.root);
	}
	
	private Node removeRec(E x, Node current) throws ItemNoFound{
		Node res = current;
		if (current == null)
			throw new ItemNoFound(x + " no esta");
		
		int resC = current.data.compareTo(x);
		if (resC < 0)
			res.right = removeRec(x, current.right);
		else if (resC > 0)
			res.left = removeRec(x, current.left);
		else if (current.left != null && current.right != null) {
			res.data = minRecover(current.right).data;
			res.right = minRemove(current.right);
		}
		else
			res = (current.left != null) ? current.left : current.right;
		return res;
	}
	
	//find the minimum element
	private Node minRecover (Node current) {
		Node res = current;
		if (current.left != null)
			res = minRecover(current.left);
		return res;
	}
	
	//trymin
	public E tryMin() {
		Node y = minRecover(this.root);
		return y.data;
	}
	//MAXIMo
	private Node maxRecover (Node current) {
		Node res = current;
		if (current.right != null)
			res = maxRecover(current.right);
		return res;
	}
	
	//try minimum - not relevant
	public E tryMax() {
		Node y = maxRecover(this.root);
		return y.data;
	}
	
	//remove minimum element
	private Node minRemove (Node current) throws ItemNoFound{
		if (current == null)
			throw new ItemNoFound();
		else if (current.left != null) {
			current.left = minRemove(current.left);
			return current;
		}
		else
			return current.right;
	}
	public int countNonLeafNodes() {
	    return countNonLeafNodesRec(root);
	}

	private int countNonLeafNodesRec(Node current) {
	    if (current == null || (current.left == null && current.right == null))
	        return 0;

	    int count = 1; // El nodo actual es no hoja

	    count += countNonLeafNodesRec(current.left); // Recursivamente contar nodos no hojas en el subárbol izquierdo
	    count += countNonLeafNodesRec(current.right); // Recursivamente contar nodos no hojas en el subárbol derecho

	    return count;
	}
	//Metodo para probar la altura 
	public int getNodeHeight(E x) throws ItemNoFound {
	    Node node = searchRec(x, root);
	    if (node == null)
	        throw new ItemNoFound("El dato " + x + " no existe en el árbol.");

	    return getNodeHeightRec(node);
	}

	private int getNodeHeightRec(Node current) {
	    if (current == null)
	        return -1;

	    int leftHeight = getNodeHeightRec(current.left);
	    int rightHeight = getNodeHeightRec(current.right);

	    return Math.max(leftHeight, rightHeight) + 1;
	}
	int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }
	public int getNodeHeight1(E x) throws ItemNoFound {
	    Node node = searchRec(x, root);
	    if (node == null)
	        throw new ItemNoFound("El dato " + x + " no existe en el árbol.");

	    return getNodeHeightRec(node);
	}

	private int getNodeHeightRec1(Node current) {
	    if (current == null)
	        return -1;

	    int leftHeight = getNodeHeightRec(current.left);
	    int rightHeight = getNodeHeightRec(current.right);

	    return Math.max(leftHeight, rightHeight) + 1;
	}
	
	//toString
	public String toString(){
		if (this.isEmpty())
			return "*";
		else
			//return postOrden(this.root);
			return inOrden(this.root);
			//return preOrden(this.root);
	}
	
	
	//inOrden
	private String inOrden (Node current) {
		String res = "";
		if (current.left != null) //left
			res += inOrden(current.left);
		res += current.data.toString() + " - "; //root
		if (current.right != null) 
			res += inOrden(current.right); //right
		return res;
	}
	//preOrden
		private String preOrden (Node current) {
			String res = "";
			res += current.data.toString() + " - "; //root
			if (current.left != null)
				res += preOrden(current.left); //left
			if (current.right != null) 
				res += preOrden(current.right); //right
			return res;
		}	

}

