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

public class BSTimplementation {
    Scanner sc = new Scanner(System.in);
    Node root;

    BSTimplementation(){
        root = null;
    }

    public Node buildTree(Node root, int data){
        if(data == -1){
            return null;
        }

        if(data > root.data){
            root.right = buildTree(root.right, data);
        }

        if(data < root.data){
            root.left = buildTree(root.left, data);
        }

        return root;
    }

    public Node takeInput(){
        System.out.println("Enter a number for made BST: ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        return buildTree(root, data);
    }

    public void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if(temp == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.println(temp.data + " ");
                if(root.left != null){
                    q.add(root.left);
                }
                if(root.right != null){
                    q.add(root.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        BSTimplementation b = new BSTimplementation();
        Node root = b.takeInput();

        b.levelOrderTraversal(root);
    }
}
