package basic;

public class MyHash_linearProbing {
    public Slot[] hashTable;
    public MyHash_linearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        int address = hashFunc(key);
        if(hashTable[address] != null){
            while(hashTable[address] != null){
                if(hashTable[address].key == key) {
                    hashTable[address].value = value;
                    return true;
                }
                address += 1;
                if(address > hashTable.length - 1)
                    return false;
            }
            hashTable[address] = new Slot(key,value);
            return true;
        }
        else {
            hashTable[address] = new Slot(key, value);
            return true;
        }
    }

    public String getData(String key){
        int address = hashFunc(key);
        if(hashTable[address] != null){
            while(hashTable[address] != null){
                if(hashTable[address].key == key) {
                    return hashTable[address].value;
                }
                address += 1;
                if (address > this.hashTable.length-1) {
                    return null;
                }
            }
            return null;
        }
        else
            return null;
    }
}
