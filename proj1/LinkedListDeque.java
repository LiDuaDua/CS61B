/**
 * Created by acer on 2016/7/13.
 */
public class LinkedListDeque<Item> implements Deque<Item> {
    private int size;
    private Node sentinal;

    public class Node{
        public Item item;
        public Node next;
        public Node front;

        public Node(Item i){
            item = i;
            next = null;
            front = null;
        }

        public Node(Item i, Node F, Node B){
            item = i;
            front = F;
            next = B;
        }
    }

    public LinkedListDeque(){
        size = 0;
        sentinal = new Node(null);
        sentinal.next = sentinal.front = sentinal;
    }

    public LinkedListDeque(Item i){
        size = 1;
        sentinal = new Node(null, null, null);
        sentinal.next = new Node(i, sentinal, sentinal);
        sentinal.front = sentinal.next;
    }

    public void addFirst(Item A){
        size = size + 1;
        sentinal.next = new Node(A, sentinal, sentinal.next);
        sentinal.next.next.front = sentinal.next;
    }

    public void addLast(Item A){
        size = size + 1;
        sentinal.front = new Node(A, sentinal.front, sentinal);
        sentinal.front.front.next = sentinal.front;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

    public int size(){
        return size;
    }
    public void printDeque(){
        if(isEmpty())
            System.out.println("list is empty!!!");
        else{
            Node res = sentinal.next;
            while(res.next != sentinal){
                System.out.print(res.item+"<---->");
                res = res.next;
            }
            System.out.print(res.item);
        }
    }
    public Item removeFirst(){
        size = size - 1;
        Node tmp = sentinal.next;
        sentinal.next = tmp.next;
        tmp.next.front = sentinal;
        tmp.front = tmp.next = null;
        return tmp.item;
    }
    public Item removeLast(){
        size = size - 1;
        Node tmp = sentinal.front;
        sentinal.front = tmp.front;
        tmp.front.next = sentinal;
        tmp.front = tmp.next = null;
        return tmp.item;
    }
    public Item get(int index){
        if(index > size){
            System.out.println("no such item exists!");
            return null;
        }
        Node res = sentinal;
        while(index > 0){
            res = res.next;
            index = index - 1;
        }
        return res.item;
    }

    public Item getRecursive(int index){
        return getNodeRecursive(index).item;
    }

    private Node getNodeRecursive(int index){
        if(index == 0)
            return sentinal;
        return getNodeRecursive(index - 1).next;
    }

}
