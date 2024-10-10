import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class binaryTreeImplementation {
    Scanner sc = new Scanner(System.in);
    Node root;

    // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

    binaryTreeImplementation(){
        root = null;
    }

    public Node buildTree(Node root){
        System.out.println("Enter a data: ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }
        root = new Node(data);

        System.out.println("Enter a data for left: "+root.data);
        root.left = buildTree(root.left);
        System.out.println("Enter a data for right: "+root.data);
        root.right = buildTree(root.right);

        return root;
    }

    public void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if(node == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(node.data+" ");
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
    }

    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        binaryTreeImplementation b = new binaryTreeImplementation();
        Node node = b.buildTree(b.root);
        System.out.println("Level order traversal is: ");
        b.levelOrderTraversal(node);

        System.out.println("inOrder traversal is: ");
        b.inOrderTraversal(node);
        System.out.println();

        System.out.println("preOrder traversal is: ");
        b.preOrderTraversal(node);
        System.out.println();

        System.out.println("postOrder traversal is: ");
        b.postOrderTraversal(node);
    }
}