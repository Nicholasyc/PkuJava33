public class Solution {
    public boolean isPalindrome(String s) {
        boolean res = false;
        //Unicode ���벢��ֻ��Ϊĳ���ַ��򵥶�����һ�����룬���һ���������˹��ࡣ
		///pP ���е�Сд p �� property ����˼����ʾ Unicode ���ԣ����� Unicode �����ʽ��ǰ׺��
		//��д P ��ʾ Unicode �ַ����߸��ַ�����֮һ������ַ�
		//�����Сд aA Ӧ�÷���true
		s = s.toLowerCase();
		String[] sArray = s.trim().split("\\pP|\\pS|\\s+");		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<sArray.length;i++){
		    sb.append(sArray[i]);
		}
// 		for(String str : sArray){
// 			sb.append(str);
// 		}
		
		return sb.toString().equals(sb.reverse().toString());
    }
}