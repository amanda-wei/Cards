import java.util.ArrayList;
/**
 * Write a description of class List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AList
{
    // instance variables - replace the example below with your own
    int length = 16;
    int[] list = new int[length];
    public AList(){
    }
    public AList(int[] list){
        list = list;
    }
    public AList(ArrayList<Integer> list1){
        for(int i=0;i<length;i++){
            list[i] = list1.get(i).intValue();
        }
    }
    public int count(int card){
        int count = 0;
        for(int i=0;i<length;i++){
            if(list[i] == card){
                count++;
            }
        }
        return count;
    }
    public void add(int pos, int val){
        list[pos] = val;
    }
    public int get(int pos){
        return list[pos];
    }
    public void print(String a){
        for(int i=0;i<length;i++){
            System.out.print(list[i] + " ");
        }
        System.out.println(a);
    }
}
