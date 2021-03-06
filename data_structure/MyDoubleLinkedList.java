package basic;

public class MyDoubleLinkedList<T> {
    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> MyLinkedList = new MyDoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.printAll();

        System.out.println(MyLinkedList.searchFromHead(3));
        System.out.println(MyLinkedList.searchFromTail(1));
        System.out.println(MyLinkedList.searchFromTail(6));

        MyLinkedList.addNodePrev(7,1);
        MyLinkedList.printAll();
        System.out.println(MyLinkedList.head.next.prev.data);
    }

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean addNodePrev(T data, T isData){
        if(this.head == null){
           this.head = new Node<T>(data);
           this.tail = this.head;
           return true;
        }
        else if(this.head.data == isData){
            Node<T> node = new Node<T>(data);
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            return true;
        }
        else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    Node<T> preNode = node.prev;
                    preNode.next = new Node<T>(data);
                    preNode.next.prev = preNode;
                    preNode.next.next = node;
                    node.prev = preNode.next;
                    return true;
                }else
                    node = node.next;
            }
            return false;
        }

    }
}
