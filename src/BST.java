import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
//二分搜索树
public class BST<E extends Comparable<E>> {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] nd = {5,3,6,8,4,2};
        //Integer[] nd = {5,3};
        for (int i=0;i<nd.length;i++){
            bst.add(nd[i]);
        }
        bst.preOrder();
        System.out.println("");
        bst.remove(3);
        bst.preOrder();

    }

    private class Node<E>{
        public E val;
        public Node<E> left;
        public Node<E> right;
        public int count;
        public Node(E e){
            this.val = e;
            left=null;
            right=null;
            count=0;
        }
    }

    private Node<E> root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }

    //查看二叉树是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //查看二叉树有多少元素
    public int getSize(){
        return size;
    }

   /* //向二叉搜索树中插入结点
    public void add(E e){
        if (size==0){
            root = new Node<E>(e);
            size++;
        }else {
            add(root,e);
        }
    }

    //私有的插入方法(递归)
    private void add(Node<E> node,E e){
        if (e.equals(node.val)){
            return;
        }else if (e.compareTo(node.val)<0&&node.left==null){
            node.left = new Node<>(e);
            size++;
            return;
        }else if(e.compareTo(node.val)>0&&node.right==null){
            node.right = new Node<>(e);
            size++;
            return;
        }else if (e.compareTo(node.val)<0){
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }*/

    //添加元素改进方法
    public void add(E e){
        root = add(root,e);
    }
    //递归私有方法
    private Node<E> add(Node<E> node,E e){
        if (node==null){
            size++;
            return new Node<E>(e);
        }
        if (e.compareTo(node.val)<0){
            node.left = add(node.left,e);
        }else if (e.compareTo(node.val)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    //查看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }
    //递归私有方法
    private boolean contains(Node<E> node,E e){
        if(node==null){
            return false;
        }
        if (e.compareTo(node.val)<0){
            return contains(node.left,e);
        }else if (e.compareTo(node.val)>0){
            return contains(node.right,e);
        }else return true;
    }

    //先序遍历二分搜索树非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        if(root==null){
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    //先序遍历二分搜索树
    public void preOrder(){
        preOrder(root);
    }
    //递归先序遍历私有方法
    private void preOrder(Node<E> node){
        if (node==null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历二分搜索树非递归
    /*public void inOrderNr(){
        Stack<Node<E>> stack = new Stack<>();
        if(root==null){
            return;
        }
        stack.push(root);
        Node<E> cur = stack.peek();
        while (!stack.isEmpty()){
            while (cur!=null&&cur.left!=null){
                stack.push(cur.left);
                cur.count++;
                cur = stack.peek();
                while (cur!=null&&(cur.left==null||cur.count==1)){
                    System.out.println(stack.pop().val);
                    if (cur.right!=null){
                        stack.push(cur.right);
                        cur = stack.peek();
                    }else if(stack.peek()!=null){
                        cur = stack.peek();
                    } else if(stack.peek()==null) cur = null;
                }
            }
        }
    }*/

    //中序遍历二分搜索树
    public void inOrder(){
        inOrder(root);
    }
    //递归中序遍历私有方法
    private void inOrder(Node<E> node){
        if (node==null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    //后序遍历二分搜索树
    public void lastOrder(){
        lastOrder(root);
    }
    //递归后序遍历私有方法
    private void lastOrder(Node<E> node){
        if (node==null)
            return;
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node.val);
    }

    //广度优先（层序）遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        if (root == null){
            return;
        }
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.val);
            if (cur.left!=null){
                q.add(cur.left);
            }
            if (cur.right!=null){
                q.add(cur.right);
            }
        }
    }

    //寻找最小元素
    public E findMin(){
        if (size==0){
            return null;
        }
        return findMin(root).val;
    }
    private Node<E> findMin(Node<E> node){
        if (node.left==null){
            return node;
        }
        node = findMin(node.left);
        return node;
    }

    //删除最小元素
    public E removeMin(){
        E res = findMin();
        root = removeMin(root);
        return res;
    }
    private Node<E> removeMin(Node<E> node){
        if (node.left==null){
            Node noderight = node.right;
            node.right = null;
            size--;
            return noderight;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //寻找最大元素
    public E findMax(){
        if (size==0){
            return null;
        }
        return findMax(root).val;
    }
    private Node<E> findMax(Node<E> node){
        if (node.right==null){
            return node;
        }
        node = findMax(node.right);
        return node;
    }

    //删除最大元素
    public E removeMax(){
        E res = findMax();
        root = removeMax(root);
        return res;
    }
    private Node<E> removeMax(Node<E> node){
        if (node.right==null){
            Node nodeleft = node.left;
            node.left = null;
            size--;
            return nodeleft;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中任意结点
    public void remove(E e){
        root = remove(root,e);
    }
    private Node<E> remove(Node<E> node,E e){
        if (node==null){
            return null;
        }
        if (e.compareTo(node.val)<0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.val)>0){
            node.right = remove(node.right,e);
            return node;
        }else {//e == node.val
            if (node.left==null){
                //如果左子树为空，将node的右子树代替node
                Node<E> nodeRight = node.right;
                node.right = null;
                size--;
                return nodeRight;
            }
            if (node.right==null){
                //如果右子树为空，将node的左子树代替node
                Node<E> nodeLeft = node.left;
                node.left = null;
                size--;
                return nodeLeft;
            }
            Node<E> lMax = findMax(node.left);//寻找左子树中的最大结点
            lMax.left = removeMin(node.left);//将左子树中最大结点删除
            lMax.right = node.right;
            node.left = null;
            node.right = null;
            return lMax;
        }
    }


}
