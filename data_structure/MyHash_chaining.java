package basic;

public class MyHash_chaining {
    public Slot[] MyHashtable;

    public MyHash_chaining(Integer size){
        MyHashtable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        public Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key){
        return (int)((key.charAt(0)) % MyHashtable.length);
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(MyHashtable[address] != null){
            Slot findSlot = MyHashtable[address];
            Slot prevSlot = MyHashtable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    findSlot.value = value;
                    return true;
                }
                else{
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        }
        else{
            MyHashtable[address] = new Slot(key,value);
        }
        return true;
    }

    public String getData(String key){
        int address = hashFunc(key);
        if(MyHashtable[address] != null){
            Slot findSlot = MyHashtable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                }
                findSlot = findSlot.next;
            }
            return null;
        }
        else
            return null;
    }
}
