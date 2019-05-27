package algorithm_per_kind.backtracking;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack2 {
	public static void main(String[] args){
			int[] num=new int[]{2,3,7,6};
			int target=9;
			find(num, target, "");
		}
	public static void find(int[] num, int target, String temp){
		if(issolution(temp,target)){
			System.out.println(temp);
			return;
		}
		for(int i=0;i<num.length;i++){
			if(num[i]!=-1){//���ȡ����������ˣ�����Ϊ-1
				int k=num[i];
				num[i]=-1;
				find(num, target, temp+k);
				num[i]=k;
			}
		}
	}

	public static boolean issolution(String temp, int target){
			boolean result=false;
			int count=0;
			for(int i=0;i<temp.length();i++){
				count=count+Integer.valueOf(temp.charAt(i)+"");
			}
			if(count==target)
				result=true;
			return result;
		}
	}

/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/