package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    private int size;
    private int maxCapacity;

    private String queueData[];
    private int lastElementIndex;
    private int firstElementIndex;
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        this(5);
    }


    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        this.maxCapacity = capacity;
        queueData = new String[maxCapacity];
        this.size = this.lastElementIndex = this.firstElementIndex = 0;
    }


    private int getIndex(int index){
        return (index+1) % this.maxCapacity;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public boolean isFull() {
        return this.size == this.maxCapacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if(!this.isFull() && obj != null){
            this.size++;
            this.queueData[this.lastElementIndex] = obj;
            this.lastElementIndex = this.getIndex(this.lastElementIndex);
            return true;
        }
        return false;
    }
    @Override
    public String dequeue() {
        if(!this.isEmpty()){
            this.size--;
            String dequeuedString = this.queueData[this.firstElementIndex];
            this.firstElementIndex = this.getIndex(this.firstElementIndex);
            return dequeuedString;
        }
        return null;
    }

    @Override
    public void printAllElements() {
        for (int i = this.firstElementIndex; i <= this.size; i++) {
            System.out.println(this.queueData[i]);
        }
    }
}
