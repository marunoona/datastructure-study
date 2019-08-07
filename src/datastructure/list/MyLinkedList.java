package datastructure.list;

public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 특정 위치에 새로운 노드를 추가
     * @param index
     * @param newNode
     */
    public void add(int index, Node newNode){
        Node nextNode = null;
        if(index == 0){
            if(this.head == null){
                this.head = new Node();
                this.head.setNext(newNode);
            }else{
                nextNode = this.head.getNext();
                newNode.setNext(nextNode);
                this.head.setNext(newNode);
            }
        }else{
            if(index < 0 || index>this.size-1){
                throw new IndexOutOfBoundsException();
            }

            Node p = this.head;
            for(int i = 0; i < index-1; i++){
                p = p.getNext();
                if(index < this.size)
                    nextNode = p.getNext();
            }
            if(nextNode != null)
                newNode.setNext(nextNode);

            p.setNext(newNode);
        }
        this.size++;
    }
}
