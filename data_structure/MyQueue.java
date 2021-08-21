package basic;

import java.util.ArrayList;

public class MyQueue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T t){
        queue.add(t);
    }

    public T dequeue(T t){
        if(queue.isEmpty()){
            System.out.println("Error! No Data");
            return null;
        }
        else
            return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
