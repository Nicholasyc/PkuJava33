public class Solution {
    public int removeDuplicates(int[] nums) {
        
       if (nums.length == 1) {
			return 1;
		}
		int count = 1;
		// int temp = 0;
		int index = 0;// ��¼�����ظ���ʼ��λ��
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] == nums[i]) {
				do {
					i++;
					if (i >= nums.length) {
						return count;
					}
				} while (nums[index] == nums[i]);
			}
            //����һ����һ�������ֺ�index��������ֽ���
			nums[index + 1] = nums[i];
			index = index + 1;
			//ÿ����һ��˵����һ�����ظ�������
			count++;

			// while((nums[index] == nums[i]) && i < nums.length-1){
			// i++;
			//
			// }
			// if(i>1&&(i == nums.length-1)){
			// return count;
			// }

		}

		return count;
    }
}