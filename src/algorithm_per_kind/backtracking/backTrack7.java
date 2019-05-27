package algorithm_per_kind.backtracking;

//https://www.cnblogs.com/chinazhangjie/archive/2010/10/22/1858410.html
public class backTrack7 {
    public static void print_all_composition(int num[],int swap_index){
        if(swap_index>=num.length){
            for(int i=0;i<num.length;i++){
                System.out.print(num[i]);
            }
            System.out.println();
        }
        for( int i=swap_index;i<num.length;i++){
            int k = num[swap_index];
            num[swap_index]=num[i];
            num[i]=k;
            print_all_composition(num,swap_index+1);
            num[i]=num[swap_index];
            num[swap_index]=k;
        }
    }
	public static void main(String args[]){
        int[] num = {1,2,3};
        print_all_composition(num,0);
    }
}
