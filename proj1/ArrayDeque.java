/**
 * Created by acer on 2016/7/13.
 */
public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int size;
    int nextFirst, nextLast;

    public ArrayDeque(){
        size = 0;
        items = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        if(nextFirst == items.length - 1){
            System.arraycopy(items, 0, a, 0, size);
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        else{
            System.arraycopy(items, nextFirst+1, a, 0, items.length-nextFirst-1);
            System.arraycopy(items, 0, a, items.length-nextFirst-1, nextFirst+1);
            nextFirst = a.length - 1;
            nextLast = size;
            items = a;
        }

    }

    public void addFirst(Item A){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = A;
        if(nextFirst == 0)
            nextFirst = items.length - 1;
        else
            nextFirst = nextFirst - 1;
        size = size +1;
    }

    public void addLast(Item A){
        if(size == items.length)
            resize(size * 2);
        items[nextLast] = A;
        if(nextLast == items.length-1)
            nextLast = 0;
        else
            nextLast = nextLast + 1;
        size = size +1;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
    public int size(){
        return(size);
    }
    public void printDeque(){
        if(nextFirst == items.length-1) {
            for (int i = 0; i<size; i++){
                System.out.print(items[i]+"----->");
            }
        }
        else{
            if(nextLast-1 < nextFirst) {
                for (int i = nextFirst + 1; i < items.length; i++)
                    System.out.print(items[i] + "----->");
                for (int i = 0; i < nextLast; i++)
                    System.out.print(items[i] + "----->");
            }
            else{
                for(int i = nextFirst + 1; i < nextLast; i++)
                    System.out.print(items[i] + "----->");
            }
        }
        System.out.println("END");
    }

    public Item removeFirst(){
        size = size -1;
        if(nextFirst == items.length -1){
            nextFirst = 0;
            Item tmp = items[nextFirst];
            items[nextFirst] = null;
            return  tmp;
        }
        else{
            nextFirst = nextFirst + 1;
            Item tmp = items[nextFirst];
            items[nextFirst] = null;
            return tmp;
        }
    }
    public Item removeLast(){
        size = size -1;
        if(nextLast == 0){
            nextLast = items.length - 1;
            Item tmp = items[nextLast];
            items[nextLast] = null;
            return tmp;
        }
        else{
            nextLast = nextLast - 1;
            Item tmp = items[nextLast];
            items[nextLast] = null;
            return tmp;
        }
    }

    public Item get(int index){
        if(size < index + 1){
            System.out.println("Such item does not exist!");
            return null;
        }
        if(nextFirst + 1 + index > items.length - 1)
            return  items[nextFirst + 1 +index - items.length];
        else
            return items[nextFirst + 1 + index];
    }
}
