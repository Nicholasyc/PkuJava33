public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		//���nums1Ϊ�գ���ֱ�ӽ�nums2�����ݿ���nums1��
		if(m == 0){
		    for(int i = 0; i < n; i++){
		        nums1[i] = nums2[i];
		    }    
		}
		
		int max = m+n-1;
		int m1 = m-1;
		
		//��nums2 �� nums1 �Ӻ���ǰ���бȽϣ����ϴ�ķ���nums1����� m+n ��λ��
		s:for(int i = n-1; i >= 0 ; i--){
			for(int j = m1; j >= 0; j--){
				if(nums2[i] > nums1[j]){
					nums1[max] = nums2[i];
					//�´�����m
//					j++;
					max --;
					break;
				}else{
					nums1[max] = nums1[j];
//					i++;
					max --;
					m1 --;
					if(j == 0){
						for(int a=i;a>=0;a--){
							nums1[max] = nums2[a];
							max --;
						}
						break s;
					}
					continue;
				}
			}
			
		}
		
	}
}