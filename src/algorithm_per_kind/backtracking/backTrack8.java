package algorithm_per_kind.backtracking;
public class backTrack8 {
    //回溯的非递归问题？
	public static void main(String args[]){
        int[] num = {1,2,3};
        boolean[] tag=new boolean[num.length];
        int path[] = new int [num.length+1];
        int depth=1;
        while(depth>=0){
            if(depth<num.length){
                for(int i=path[depth];i<num.length;i++){
                    if(tag[i]==false){
                        tag[i]=true;
                        path[depth]=i;
                        if(depth==num.length){
                            for(int j:num){
                                System.out.print(j+" ");
                            }
                            System.out.println();
                        }else{
                            depth++;
                        }
                    }
                }
            }else{
                depth--;
                //Arrays.fill(tag,false);
            }
        }
    }
}
