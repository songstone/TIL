package basic;

public class MySingleLinkedList<T>{
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node(data);
        }
        else{
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = this.search(isData);

        if(searchedNode == null){
            this.addNode(data);
        }
        else{
            Node<T> node = new Node<T>(data);
            node.next = searchedNode.next;
            searchedNode.next = node;
        }
    }

    public Node search(T isData){
        if(this.head == null)
            return null;
        Node<T> search = this.head;
        while(search != null){
            if(search.data == isData)
                return search;
            else
                search = search.next;
        }
        return null;
    }

    public boolean delNode(T isData){
        if (this.head == null){
            return false;
        }
        else{
            Node<T> node = this.head;
            if(node.data == isData){
                this.head = this.head.next;
                return true;
            }
            else{
                while(node.next != null){
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}