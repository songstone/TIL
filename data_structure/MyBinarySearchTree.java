package basic;

public class MyBinarySearchTree {
    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data){
        if(head == null){
            this.head = new Node(data);
        }
        else{
            Node findNode = this.head;
            while(true){
                if(data < findNode.value){
                    if(findNode.left!=null){
                        findNode = findNode.left;
                    }
                    else{
                        findNode.left = new Node(data);
                        break;
                    }
                }else
                    if(findNode.right != null){
                        findNode = findNode.right;
                    }
                    else{
                        findNode.right = new Node(data);
                        break;
                    }
            }
        }
        return true;
    }

    public Node search(int data){
        if(this.head == null){
            return null;
        }
        else{
            Node findNode = this.head;
            while(findNode != null){
                if(findNode.value == data){
                    return findNode;
                }else if(data < findNode.value){
                    findNode = findNode.left;
                }else
                    findNode = findNode.right;
            }
            return null;
        }
    }

    public boolean delete(int data){

        boolean searched = true;
        Node currParentNode = this.head;
        Node currNode = this.head;

        if (this.head == null) {
            return false;
        }
        else{
            if(this.head.value == data && this.head.left == null && this.head.right == null){
                this.head = null;
                return true;
            }

            while(currNode != null) {
                if (currNode.value == data) {
                    searched = true;
                    break;
                } else if (currNode.value > data) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if(!searched)
                return false;
            if(currNode.left == null & currNode.right == null){
                if(data < currParentNode.value) {
                    currParentNode.left = null;
                    currNode = null;
                }
                else{
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            }
            else if(currNode.left != null && currNode.right == null){
                if(data < currParentNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                }
                else{
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            }
            else if(currNode.right != null && currNode.left == null){
                if(data < currParentNode.value){
                    currParentNode.left = currNode.right;
                    currNode = null;
                }else{
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }
            else {
                    Node alter = currNode.right;
                    Node alterParent = currNode.right;
                    while (alter.left != null) {
                        alterParent = alter;
                        alter = alter.left;
                    }
                    if(alter.right != null)
                        alterParent.left = alter.right;
                    else
                        alterParent.left = null;

                    if(data<currParentNode.value)
                        currParentNode.left = alter;
                    else
                        currParentNode.right = alter;

                    alter.left = currNode.left;
                    alter.right = currNode.right;
                    currNode = null;

                    return true;
                }
            }
        }
    }
