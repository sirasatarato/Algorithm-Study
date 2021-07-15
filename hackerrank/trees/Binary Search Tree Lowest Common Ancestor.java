package hackerrank.trees;

import java.util.Scanner;

class BinarySearchTreeLowestCommonAncestor{
	public static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        
        if (v1 > v2) {          
            int temp = v2;
            v2 = v1;
            v1 = temp;
        }
        
        while (root.data < v1 || root.data > v2) {
            if (root.data < v1) root = root.right;
            else root = root.left;
        }
        
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;

        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }

        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        if (ans != null) System.out.println(ans.data);
    }
}