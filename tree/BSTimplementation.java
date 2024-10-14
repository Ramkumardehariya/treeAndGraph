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
    // 10 8 21 7 27 5 4 3 -1 
    // 100 110 120 115 50 75 70 60 45 30 35 -1

    BSTimplementation(){
        root = null;
    }

    public Node buildTree(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data > root.data){
            root.right = buildTree(root.right, data);
        }
        else{
            root.left = buildTree(root.left, data);
        }

        return root;
    }

    public Node takeInput(Node root){
        System.out.println("Enter a number for made BST: ");
        int data = sc.nextInt();

        while (data != -1) {
            root = buildTree(root, data);
            data = sc.nextInt();
        }

        return root;
    }

    public boolean searchElement(Node root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }

        if(root.data > data){
            return searchElement(root.left, data);
        }
        else{
            return searchElement(root.right, data);
        }
    }

    public Node searchMin(Node root){
        Node temp = root;
        while (temp.right != null || temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public Node deleteElement(Node root, int data){
        if(root == null){
            System.out.println("The data is not present ");
            return root;
        }
        if(root.data == data){
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{
                int mini = searchMin(root.right).data;
                root.data = mini;
                deleteElement(root.right, mini);
            }
        }
        if(root.data > data){
            root.left = deleteElement(root.left, data);
        }
        else{
            root.right = deleteElement(root.right, data);
        }
        return root;
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
                System.out.print(temp.data + " ");
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
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
        System.out.print(root.data + " ");
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
        BSTimplementation b = new BSTimplementation();
        Node node = b.takeInput(b.root);

        b.levelOrderTraversal(node);
        
        System.out.println("Inorder traversal is: ");
        b.inOrderTraversal(node);
        System.out.println();

        System.out.println("PreOrder traversal is: ");
        b.preOrderTraversal(node);
        System.out.println();

        System.out.println("PostOrder traversal is: ");
        b.postOrderTraversal(node);
        System.out.println();

        boolean searchElement = b.searchElement(node, 12);
        System.out.println("Element present or not: "+searchElement);

        b.levelOrderTraversal(node);

        b.deleteElement(node, 50);
        System.out.println();
        System.out.println();
        System.out.println("After deleting element: ");


        b.levelOrderTraversal(node);
        
        System.out.println("Inorder traversal is: ");
        b.inOrderTraversal(node);
        System.out.println();

        System.out.println("PreOrder traversal is: ");
        b.preOrderTraversal(node);
        System.out.println();

        System.out.println("PostOrder traversal is: ");
        b.postOrderTraversal(node);
        System.out.println();
    }
}
