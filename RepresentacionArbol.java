package Acti1;

//import Acti1.BSTree.Node;

//import Acti1.Bs1.Node;
class Node {
    String data;
    Node left, right;

    public Node(String string) {
        this.data = string;
        left = right = null;
    }
}

public class RepresentacionArbol {
	
	static class Nodo {
        int valor;
        Nodo izquierda;
        Nodo derecha;

        public Nodo(int valor) {
            this.valor = valor;
            izquierda = null;
            derecha = null;
        }
    }

    Node root;

    // Método para imprimir el árbol con indentación
    void printTree(Node node, String indent) {
        if (node == null)
            return;

        System.out.println(indent + "(" + node.data);

        // Aumentar la indentación para los hijos
        String newIndent = indent + "   ";

        // Recorrer el subárbol izquierdo y derecho
        printTree(node.left, newIndent);
        printTree(node.right, newIndent);

        System.out.println(indent + ")");
    }

    
}