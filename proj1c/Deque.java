/**
 * Created by acer on 2016/7/13.
 */
public interface Deque<Item> {
    public void addFirst(Item A);
    public void addLast(Item A);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);

}
