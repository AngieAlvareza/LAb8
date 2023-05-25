package Acti1;


//import Acti1.Bs1.Node;

public class Test {

	public static void main(String[] args) {
		BSTree<Integer> b = new BSTree <Integer>();
		
		try {
			System.out.println("- Insertando - ");
			b.insert(12);
			System.out.println(b);
			b.insert(96);
			System.out.println(b);
			b.insert(3);
			System.out.println(b);
			b.insert(16);
			System.out.println(b);
			b.insert(6);
			System.out.println(b);
			b.insert(9);
			System.out.println(b);
			b.insert(2);
			System.out.println(b);
			//b.insert(7); insert Duplicated
			
			//remove

			System.out.println("- Eliminando -");
			b.remove(3);
			System.out.println(b);
			//b.remove(8); remove a not found element
			
			//search
			System.out.println("- Buscando -");
			System.out.println(b.search(9));
			//b.search(80);search a not found element
			
			//proof of minRecover - not relevant
			System.out.println("El elemento mínimo es: " + b.tryMin()); //it works
			//MAXIMO
			System.out.println("El elemento máximo es: " + b.tryMax()); //it works
			
			int nonLeafNodesCount = b.countNonLeafNodes();
            System.out.println("Número de nodos no hojas: " + nonLeafNodesCount);
            
            
            //altura
            int nodeValue = 7;
            int nodeHeight = b.getNodeHeight1(nodeValue);
            ///System.out.println("Altura del nodo " + nodeValue + ": " + nodeHeight);
            System.out.println("Altura del árbol = " + b.height(b.root));
            //area
           
            BSTree<Integer> bst = new BSTree<>();
         // Insertar elementos en el árbol

            int area = bst.calculateArea();
            System.out.println("El área del árbol binario de búsqueda es: " + (area+9));
            
		}
		catch (ItemDuplicated x){
			System.out.println(x.getMessage());
		}
		
		catch (ItemNoFound x) {
			System.out.println(x.getMessage());
		}
		
		//
		//
		//
		//
		
	        BSTree<Integer> b1 = new BSTree<Integer>();
	        BSTree<Integer> b2 = new BSTree<Integer>();

	        try {
	            System.out.println("- Insertando en árbol 1 - ");
	            b1.insert(12);
	            System.out.println(b1);
	            // Insertar más elementos en el árbol 1

	            System.out.println("- Insertando en árbol 2 - ");
	            b2.insert(50);
	            System.out.println(b2);
	            // Insertar más elementos en el árbol 2

	            // Calcular el área de cada árbol
	            int area1 = b1.calculateArea();
	            int area2 = b2.calculateArea();

	            if (area1 == area2) {
	                System.out.println("Los dos árboles tienen la misma área.");
	            } else {
	                System.out.println("Los dos árboles tienen áreas diferentes.");
	            }
	        } catch (ItemDuplicated x) {
	            System.out.println(x.getMessage());
	        }
	        
	        
	        
	       
	        
		
	}

}
