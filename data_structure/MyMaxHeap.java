package basic;

import com.sun.management.GarbageCollectionNotificationInfo;

import java.util.ArrayList;
import java.util.Collections;

public class MyMaxHeap {
    public ArrayList<Integer> heapArray = null;

    public MyMaxHeap(Integer data){
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insertData(Integer data){
        if(heapArray == null){
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        else {
            heapArray.add(data);

            Integer insertIndex = heapArray.size()-1;
            while (moveUp(insertIndex)) {
                Integer parentIndex = insertIndex/2;
                Collections.swap(heapArray, insertIndex, parentIndex);
                insertIndex = parentIndex;
            }
            return true;
        }
    }

    public boolean moveUp(Integer insertIndex){
        if(insertIndex == 1){
            return false;
        }
        else {
            Integer parentIndex = insertIndex/2;
            if(heapArray.get(insertIndex) > heapArray.get(parentIndex)){
                return true;
            }
            else
                return false;
        }
    }

    public Integer pop(){
        if(heapArray == null){
            return null;
        }
        else{
            Integer returnData = heapArray.get(1);
            heapArray.set(1,heapArray.get(heapArray.size()-1));
            heapArray.remove(heapArray.size()-1);
            Integer popIndex = 1;
            while(moveDown(popIndex)){
                Integer leftIndex = popIndex*2;
                Integer rightIndex = popIndex*2 +1;

                if(rightIndex>=heapArray.size()-1){
                    Collections.swap(heapArray, popIndex, leftIndex);
                    popIndex = leftIndex;
                }
                else{
                    if(heapArray.get(leftIndex)>heapArray.get(rightIndex)) {
                        Collections.swap(heapArray, popIndex, leftIndex);
                        popIndex = leftIndex;
                    }
                    else{
                        Collections.swap(heapArray, popIndex, rightIndex);
                        popIndex = rightIndex;
                    }
                }
            }
            return returnData;
        }
    }

    public boolean moveDown(Integer rootIndex){
        Integer leftChildIndex = rootIndex*2;
        Integer rightChildIndex = rootIndex*2 +1;

        if(leftChildIndex >= heapArray.size()){
            return false;
        }
        else if(rightChildIndex >= heapArray.size()){
            if(heapArray.get(rootIndex) < heapArray.get(leftChildIndex)){
                return true;
            }
            else
                return false;
        }
        else{
            if (heapArray.get(leftChildIndex) > heapArray.get(rightChildIndex)){
                if(heapArray.get(leftChildIndex) > heapArray.get(rootIndex)){
                    return true;
                }
                else
                    return false;
            }
            else {
                if (heapArray.get(rightChildIndex) > heapArray.get(rootIndex)){
                    return true;
                }
                else
                    return false;
            }
        }

    }
}
