package algorithm_per_kind.backtracking;

public class backTrack4 {
	public static void print_num_composite(int num,boolean[] tag,String result_per){
		if(num==result_per.length()){
			System.out.println(result_per);
			return;
		}
		for(int i=1;i<=num;i++){
			if(tag[i]==false){
				String s = result_per+i;//must be new String.
				tag[i]=true;
				print_num_composite(num,tag,s);
				tag[i]=false;
			}
		}
	}
	public static void main(String args[]){
		int num = 3;
		boolean[] tag = new boolean[num+1];
		print_num_composite(num,tag,"");
	}
}
