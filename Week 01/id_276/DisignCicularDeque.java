package linkedlist;

public class DisignCicularDeque {
    int[] elements;
    int rear,front,capacity;
    int mincap = 8;
    public DisignCicularDeque(int k) {
        if (k < 1)
            capacity = mincap;
        capacity = k + 1;
        elements = new int[capacity];
        rear = 0;
        front = 0;
    }

    public boolean insertFront(int value) {
        if (isFull)
            return false;
        a[front] = value;
        front = (front+1)%capacity;
        return true;
    }
    public boolean insertLast(int value) {
        if (isFull)
            return false;
        rear = (rear-1)%capacity;
        a[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front-1+capacity)%capacity；
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        rear = (rear+1)%capacity;
        return true;

    }

    boolean isFull(){
        if ((front+1)%capacity == rear)
            return true;
        return false;
    }

    boolean isEmpty() {
        if (front == rear)
            return true;
        return false;
    }
}
