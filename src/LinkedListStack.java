//使用链表来实现栈
public class LinkedListStack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    //查看栈顶元素
    public E peek(){
        return linkedList.getFirst();
    }

    //入栈操作
    public void push(E e){
        linkedList.addNode(e);
    }

    //出栈操作
    public E pop(){
        return linkedList.deleteByIndex(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: top");
        sb.append(linkedList);
        return sb.toString();
    }

    public static void main(String args[]){
        LinkedListStack<Integer> ls = new LinkedListStack<>();
        for(int i=0;i<8;i++){
            ls.push(i);
            System.out.println(ls);
        }
        ls.pop();
        ls.pop();
        System.out.println(ls);

    }
}
