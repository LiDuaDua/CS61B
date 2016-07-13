/**
 * Created by acer on 2016/7/14.
 */
public class ArrayDequeTest {
    public static void main(String[] args){
        ArrayDeque<Integer> array= new ArrayDeque<Integer>();
        if(array.isEmpty()){
            System.out.println("haha");
        }

        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        array.addLast(9);
        array.addLast(10);
        array.addLast(11);
        array.addLast(12);
        array.printDeque();

        array.printDeque();

        array.addLast(13);
        array.printDeque();
        System.out.println(array.get(1));
        System.out.println(array.get(3));
        System.out.println(array.get(5));
        System.out.println(array.get(7));
        System.out.println(array.get(9));
        System.out.println(array.get(11));
        System.out.println(array.get(13));




    }

}
