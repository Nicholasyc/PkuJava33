public class Solution {
    public int majorityElement(int[] nums) {
		
		//��������
		Arrays.sort(nums);
		//��Ҫ���� һ��Ϊ�ź�����������λ��
		return nums[nums.length/2];

	}

}