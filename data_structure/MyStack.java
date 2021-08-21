package basic;

import java.util.ArrayList;

public class MyStack <T>{
    private ArrayList<T> stack = new ArrayList<T>();
    private Integer top = -1;

    public void push(T t){
        stack.add(t);
        top++;
    }

    public T pop(){
        if(stack.isEmpty()){
            System.out.println("Underflow!");
            return null;
        }
        top--;
        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Integer getTop(){
        return top;
    }
}
