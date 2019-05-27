package algorithm_per_kind.backtracking;

public class backTrack5 {
	public static void get_array(int num){
		String result = "";
		for(int i=1;i<=num;i++){
			result+=i;
		}
	}
	public static void print_num_composite(int num,boolean[] tag,String result_per,int len,int index){
		if(num==len){
			if(result_per.length()>0)System.out.println(result_per);
			return;
		}
		String a = result_per+index;//must be new String.
		String b = new String(result_per);
		//tag[index]=true;
		print_num_composite(num,tag,a,len+1,index+1);
		//tag[index]=false;
		print_num_composite(num,tag,b,len+1,index+1);
	}
	public static void main(String args[]){
		int num = 3;
		boolean[] tag = new boolean[num+1];
		print_num_composite(num,tag,"",0,1);
	}
}
