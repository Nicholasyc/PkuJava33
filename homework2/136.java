public class Solution {
    public int singleNumber(int[] nums) {
        int n=nums[0];
        for(int i=1;i<nums.length;i++){
            /*for(int j=i;j<nums.length;j++){
                if(nums[i]!=nums[j]&&j==nums.length-1)
                {
                    n=nums[i];
                    break;
                }
                else continue; //��ʱ
            
            int j=i;
            if(nums[i]==nums[j]) continue;
            else{
                n=nums[j];
                break;}    //Wrong Answer
         
           int j=i;
           if(nums[i]^nums[j]==0) continue;  //���������;������Ĳ��������Ͳ��� 
           else{
               n=nums[j];
               break;
           }  */
           
           n=n^nums[i];  //�������ɽ������� a ^ b = b ^ a; 0 ^ a = a
        }
        return n;
    }
}