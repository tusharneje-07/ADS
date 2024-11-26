public class ContactApp {
    static class Node{
        String name;
        String phoneno;
        Node left,right;
        Node(String name,String phoneno){
            this.name = name;
            this.phoneno = phoneno;
        }
    }
    Node root;
    public void insert(String name, String phoneno){
        root = insertRec(root,name,phoneno);
    } 

    public Node insertRec(Node root,String name, String phoneno){
        if(root == null){
            Node newNode = new Node(name,phoneno);
            root = newNode;
            return root;
        }

        if(name.compareTo(root.name) < 0){
            root.left = insertRec(root.left,name,phoneno);
        }
        else if(name.compareTo(root.name) > 0){
            root.right = insertRec(root.right, name, phoneno);
        }

        return root;
    }


    public String search(String name){
        Node res = searchRec(root,name);
        if(res!=null){
            return res.phoneno;
        }else{
            return "Contact not found!";
        }
    }

    public Node searchRec(Node root, String name){
        if(root == null || root.name.equals(name)){
            return root;
        }

        if(name.compareTo(root.name) < 0){
            return searchRec(root.left, name);
        }
        else{
            return searchRec(root.right, name);
        }
    }

    public void delete(String name){
        root = deleteRec(root,name);
    }

    public Node deleteRec(Node root,String name){
        if(root==null){
            return root;
        }
        else if(name.compareTo(root.name) < 0){
            return deleteRec(root.left,name);
        }
        else if(name.compareTo(root.name) > 0){
            return deleteRec(root.right,name);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            Node inorderSucc = inorderSucc(root.right);
            root.name = inorderSucc.name;
            root.phoneno = inorderSucc.phoneno;
            deleteRec(root.right, inorderSucc.name);
        }
        return root;
    }

    public Node inorderSucc(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public void update(String name, String newPhone){
        Node contact = searchRec(root, name);
        if(contact!=null){
            contact.phoneno = newPhone;
        }
        else{
            System.out.println("Contact Not Found!");
        }
    }

    public void display(){
        inorder(root);
    }

    public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.name + " - " + root.phoneno + "\n");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ContactApp phoneBook = new ContactApp();

        phoneBook.insert("Tushar", "123456789");
        phoneBook.display();
        phoneBook.update("Tushar", "7028573950");
        phoneBook.display();
    }
}
