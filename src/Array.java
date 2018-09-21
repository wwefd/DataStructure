//数组实现类
public class Array<E> {
    private E data[];
    private int size;//记录数组中的元素个数，指向第一个空的下标

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("size:%d , length:%d\n",size,data.length));
        res.append("[");
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    //数组扩容
    private void augment(int newLength){
        E[] newData = (E[])new Object[newLength];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    //构造方法初始化数组1
    public Array(int arrlength){
        data = (E[])new Object[arrlength];
        size = 0;
    }

    //构造方法初始化数组2
    public Array(){
        data = (E[])new Object[10];//无参构造方法，默认数组初始长度为10
        size = 0;
    }

    //获取数组中元素个数
    public int getSize(){
        return size;
    }

    //获取数组容量
    public int getLength(){
        return data.length;
    }

    //向数组中添加元素
    public void addElement(E e){
        if(size == data.length){
            //throw new IllegalArgumentException("add failed,arr is full");
            augment(2*data.length);//扩容数组为原来长度的2倍
        }
        data[size] = e;
        size++;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    //向数组中的某个位置添加元素
    public void addElementByIndex(E e,int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("add failed,index is illeagal");
        }
        if(size == data.length){
            augment(2*data.length);//扩容数组为原来长度的2倍
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //修改数组中某个位置的元素为e
    public void updateElementByIndex(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("update failed,index is illeagal");
        }
        data[index] = e;
    }

    //查询数组中某个位置的元素
    public E findElementByIndex(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("find failed,index is illeagal");
        }
        return data[index];
    }

    //查询数组中是否存在某个元素,并返回其所在位置（下标）
    public int findElement(E e){
        for (int i = 0;i < size;i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //查询数组中最后一个元素
    public E findLast(){
        return findElementByIndex(size-1);
    }

    //查询数组中第一个元素
    public E findFirst(){
        return findElementByIndex(0);
    }

    //删除数组中某个位置的元素
    public E deleteElementByIndex(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("delete failed,index is illeagal");
        }
        E val = data[index];
        for (int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        data[size]=null;
        if (size==data.length/4 &&data.length/2!=0){
            augment(data.length/2);//数组缩容
        }
        return val;
    }

    //删除数组中所有的e元素
    public void deletrElement(E e){
        for (int i=0;i<size;i++){
            if(e==data[i]){
                deleteElementByIndex(i);
            }
        }
        if (size==data.length/4 &&data.length/2!=0){
            augment(data.length/2);//数组缩容
        }
    }

    //删除数组中最后一个元素
    public E deleteLast(){
        return deleteElementByIndex(size-1);
    }

    //删除数组中第一个元素
    public E deleteFirst(){
        return deleteElementByIndex(0);
    }

}
