import java.util.ArrayList;
/**
 * Returns three arrays  
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayDeveloper
{
    public static void main(String[] args){
        int[] cards = new int[52];
        //creates deck
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                cards[i*j] = i;
            }
        }
        
        //input function
        //n*2, n+1, n+2, 2*n + 1, 
        AList list1 = new AList(); //n^2
        for(int i=0;i<16;i++){
            list1.add(i, (i*i)%13);
        }
        AList list2 = new AList(); //2n
        for(int i=0;i<16;i++){
            list2.add(i,(2*i)%13);
        }
        AList list3 = new AList(); //2n + 1
        for(int i=0;i<16;i++){
            list3.add(i,((2*i)+3)%13);
        }
        AList list4 = new AList(); //n + 1
        for(int i=0;i<16;i++){
            list4.add(i,(i+1)%13);
        }
        AList list5 = new AList();  //3n + 2
        for(int i=0;i<16;i++){
            list5.add(i,(3*i+2)%13);
        }
        AList list6 = new AList(); //3n
        for(int i=0;i<16;i++){
            list6.add(i,(3*i)%13);
        }
        AList list7 = new AList(); //Truncated n/2
        for(int i=0;i<16;i++){
            list7.add(i,(i/2)%13);
        }
        AList list8 = new AList();  //n+3
        for(int i=0;i<16;i++){
            list8.add(i,(i+3)%13);
        }
        AList list9 = new AList(); //n+2
        for(int i=0;i<16;i++){
            list9.add(i,(i+2)%13);
        }

        AList[] master_list = {list1,list2,list3,list4,list5,list6,list7,list8,list9};
        int l = master_list.length;
        
        //populating the third list
        boolean cont = true;
        ArrayList<Integer> third_list = new ArrayList<Integer>();
        
        int index = 0;
        while(index<l && cont==true){
            for(int j=0;j<16;j++){
                if(index<(l-1)){
                    int one = master_list[index].get(j);
                    int two = master_list[index+1].get(j);
                    third_list.add(j, new Integer((int)Math.pow(2,two)%13));
                } else {
                    int one = master_list[l-1].get(j);
                    int two = master_list[0].get(j);
                    third_list.add(j, new Integer((int)Math.pow(2,two)%13));
                }
            }
            AList three = new AList(third_list);
            boolean good = true;
            for(int i=0;i<13;i++){
                if(index<(l-1)){
                    if((three.count(i)+master_list[index].count(i)+master_list[index+1].count(i))>4){
                       good = false;
                    }
                }
                else{
                    if((three.count(i)+master_list[l-1].count(i)+master_list[0].count(i))>4){
                        good = false;
                    }
                }
            }
            String x = "-------------------------------------";
            if(good==true){
                cont = false;
                three.print("");
                if(index<(l-1)){
                    master_list[index].print("");
                    master_list[index+1].print(x);
                } else{
                    master_list[l-1].print("");
                    master_list[0].print(x);
                }
            
            }
            System.out.println("\n" + index);
            index++;
            third_list.clear();
        }
    }
}
