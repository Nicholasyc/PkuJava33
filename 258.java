public class Solution {
    public int addDigits(int num) {
        int x = num;
		int sum = 0;
		while(x!=0){
			sum = sum + (x % 10);
			x /= 10;
		}
		if(sum >= 10){
			sum = addDigits(sum);
		}else{
			return sum;
		}
		return sum;
		//�����ǹ�ʽ��������ʱ��̫���
        // if(num == 0){
        //     return num;
        // }
        // return 1 + (num-1) % 9;
    }
}