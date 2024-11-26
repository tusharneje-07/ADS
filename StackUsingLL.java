public class StackUsingLL{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        stack.display();
        stack.display();

    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    Node top;
    public Stack(){
        this.top = null;
    }

    // isEmpty()
    public boolean isEmpty(){
        return top == null;
    }
    // push()
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    // pop()
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        else{
            int data = top.data;
            top = top.next;
            System.out.printf("Poped : %d\n",data);
            return data;
        }
    }
    // display()
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return;
        }
        Node currentNode = top;
        System.out.print("Stack => " );
        while(currentNode!=null){
            System.out.printf("%d | ",currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    // peak()
    public int peak(){
        if(isEmpty()){
            return -1;
        }
        return top.data;
    }
}