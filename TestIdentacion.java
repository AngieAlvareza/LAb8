package Acti1;

public class TestIdentacion {
public static void main(String args[]) {
    RepresentacionArbol tree = new RepresentacionArbol();
    tree.root = new Node("SAles");
    tree.root.left = new Node("Domestic");
    tree.root.right = new Node("International");
    tree.root.right.left = new Node("Canada");
    tree.root.right.right = new Node("S America");
    tree.root.right.right.right = new Node("Overseas");
    tree.root.right.right.left = new Node("Africa");
    tree.root.right.right.left.right = new Node("Europa");
    
//    tree.root.right.left = new Node("S America");
//    tree.root.right.left = new Node("Overseas");
//    tree.root.right.left.left = new Node("Africa");
//    tree.root.right.left.left = new Node("Europa");
//    tree.root.right.left.left = new Node("Asia");
//    tree.root.right.left.left = new Node("Australia");
    System.out.println("La representación con paréntesis y sangrías del árbol es: ");
    tree.printTree(tree.root, "");
}}