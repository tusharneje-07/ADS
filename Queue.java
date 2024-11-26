public class Q3{
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.display();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        queue.dequeue();
        queue.enqueue(100);
        queue.display();
        queue.enqueue(200);
        
    }
}

class Queue{
    int N;
    int[] queue;
    int front, rear;
    public Queue(int maxSize){
        this.N = maxSize;
        this.queue = new int[maxSize];
        this.front = this.rear = -1;
    }

    // Queue Full Condition
    public boolean isFull(){
        return (rear + 1)%N == front;
    }

    // Queue Empty Condition
    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    // EnQueue
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full!");
            return;
        }
        else if (rear == -1 && front == -1){
            rear = front = 0;
            queue[rear] = data;
        }
        else{
            rear = (rear + 1)%N;
            queue[rear] = data;
        }
    }

    // DeQueue
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
        }
        else if(front == rear){
            int data = queue[front];
            front = rear = -1;
            System.out.println("DeQueued : " + data);
        }
        else{
            int data = queue[front];
            front = (front + 1)%N;
            System.out.println("DeQueued : " + data);
        }
    }

    // Display
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue [ ");
        for(int i = 0;i<N;i++){
            System.out.printf("%d | ",queue[i]);
        }
        System.out.print(" ]");
        System.out.println();
    }
}