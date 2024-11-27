import java.util.Scanner;

class node_Thread {

    int data;
    node_Thread left;
    node_Thread right;
    Boolean Lthread, Rthread;

    node_Thread(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        Lthread = Rthread = true;
    }
}

class tbst {
    node_Thread root = null;

    void insert(int data) {
        node_Thread newnode = new node_Thread(data);
        if (root == null) {
            root = newnode;
            return;
        }
        node_Thread current = root;
        node_Thread parent = null;
        while (current != null) {
            parent = current;
            if (current.data > data) {
                if (!current.Lthread) {
                    current = current.left;
                } else {
                    break;
                }
            } else {
                if (!current.Rthread) {
                    current = current.right;
                } else {
                    break;
                }
            }

        }
        if (data == parent.data) {
            System.out.println("data alrady exits..");
            return;
        }
        if (data < parent.data) {
            newnode.left = parent.left;
            newnode.right = parent;
            parent.Lthread = false;
            parent.left = newnode;
        } else if (data > parent.data) {
            newnode.left = parent;
            newnode.right = parent.right;
            parent.Rthread = false;
            parent.right = newnode;
        }

    }

    void inorder() {
        if (root == null)
            return;
        System.out.print("inorder traversal is: ");
        node_Thread temp = root;
        while (!temp.Lthread) {
            temp = temp.left;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.Rthread) {
                temp = temp.right;
            } else {
                temp = temp.right;
                while (!temp.Lthread) {

                    temp = temp.left;

                }
            }
        }
        System.out.println(" ");

    }

}

public class threadedBST {

    public static void main(String[] args) {
        tbst ob = new tbst();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Enter your choice:\n1:add node \n2:traverse\n3:exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter a number to insert");
                    int ele = sc.nextInt();
                    ob.insert(ele);
                    break;
                case 2:
                    ob.inorder();
                    break;
            }
        }
        sc.close();
    }

}
