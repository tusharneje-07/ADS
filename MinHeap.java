public class MinHeap{
    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public int parent(int i){
        return (i-1)/2; 
    }

    public void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value){
        if(size == capacity){
            System.out.println("Heap is Full!");
            return;
        }
        heap[size] = value;
        int curr = size;
        size++;

        while(curr > 0 && heap[curr] > heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int minValue(){
        return heap[0];
    }

    public void display(){
        for(int i=0;i<capacity;i++){
            System.out.printf("%d ",heap[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(167);
        minHeap.display();
        minHeap.insert(15);
        minHeap.display();
        minHeap.insert(3);
        minHeap.display();
        minHeap.insert(390);
        minHeap.display();
        minHeap.insert(90);
        minHeap.display();


    }

}