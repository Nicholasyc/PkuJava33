public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[len] = nums[i];//����������Խ�ǰ��ĸ���
                len++;
            }
        }
//        for(int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
        return len;
    }
}