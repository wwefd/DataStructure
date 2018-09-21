//带头尾节点的链表
public class HeadAndTailLinkedList<E> {

    private class Node<E>{
        public E node;
        public Node next;
        public Node(E e, Node next){
            this.node = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return node+"" ;
        }
    }

    private Node<E> head,tail;
    private int size;

    public HeadAndTailLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //查看链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //查看链表长度
    public int getSize(){
        return size;
    }

    //在尾部添加节点
    public void add(E e){
        if(tail == null){
            tail = new Node<E>(e);
            head = tail;
        } else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
    }

    //在头部删除节点
    public E delete(){
        if(size == 0){
            throw new IllegalArgumentException("delete failed,LinkedList is empty");
        }
        Node<E> res = head;
        head = head.next;
        res.next = null;
        size--;
        if(head == null){
            tail = head;
        }
        return res.node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node n = head;
        for (int i=0;i<size;i++){
            sb.append(n);
            n = n.next;
            sb.append("->");
            if (i==size-1){
                sb.append("NULL");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
