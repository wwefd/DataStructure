//使用数组实现栈
public class Stack<E> {

    private Array<E> array;

    public Stack(int length){
        array = new Array<>(length);
    }

    public Stack(){
        array = new Array<>();
    }

    //获取栈的容量
    public int getLength(){
        return array.getLength();
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //压栈
    public void push(E e){
        array.addElement(e);
    }

    //出栈
    public E pop(){
        return array.deleteLast();
    }

    //查看栈顶元素
    public E peek(){
        return array.findLast();
    }

    //获取当前栈中元素数量
    public int getSize(){
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i=0;i<array.getSize();i++){
            res.append(array.findElementByIndex(i));
            if(i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
