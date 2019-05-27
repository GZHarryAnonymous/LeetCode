package algorithm_per_kind.backtracking;

public class backTrack6 {
	public static void get_array(int num){
		String result = "";
		for(int i=1;i<=num;i++){
			result+=i;
		}
	}
	public static void print_num_composite(int num,boolean[] tag,int len,int index){
		if(num==len){
			for(int i=1;i<=num;i++){
				if(tag[i])System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		//String a = result_per+index;//must be new String.
		//String b = new String(result_per);
		tag[index]=true;
		print_num_composite(num,tag,len+1,index+1);
		tag[index]=false;
		print_num_composite(num,tag,len+1,index+1);
	}
	public static void main(String args[]){
		int num = 3;
		boolean[] tag = new boolean[num+1];
		print_num_composite(num,tag,0,1);
	}
}
