/**
 * Created by acer on 2016/7/16.
 */
public class OffByN implements CharacterComparator{
    int N;
    OffByN(int N){
        this.N = N;
    }
    public boolean equalChars(char x, char y){
        if(x - y == N|| y - x == N)
            return true;
        return false;
        }
}
