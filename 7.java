public class Solution {
    public int reverse(int x) {
        int result = 0;
		Integer xm = x;//ת����Integer����
		String rex = xm.toString();
		int a = 0;
		StringBuilder sb = new StringBuilder();
		char[] xa = rex.toCharArray();
		if(xa[0] == '-'){
			sb.append('-');
			a = 1;
		}
		for(int i=xa.length-1;i>=a;i--){
			sb.append(xa[i]);
			result = Integer.parseInt(sb.toString());
			//MAX_VALUE�������10������parseInt�ᱨ��
			if(Math.abs(result) > Integer.MAX_VALUE/10 && i==a+1){
//				System.out.println(0);
				return 0;
			}
		}
//		if(xa[0] == '-'){
//			sb.insert(0,'-');
//			sb.deleteCharAt(sb.length()-1);
//		}
//		sb.reverse();
//		rex = sb.toString();
//		result = Integer.parseInt(rex);
//		if(result > Integer.MAX_VALUE){
//			return 0;
//		}
//		System.out.println(result);
//      �ڱȽϵ�ʱ������½�double���ͱ���ȥ�洢result�����Ǻ������Է��ֻ���������ķ���

//		�����ҵıȽ�����Ľⷨ��

//		public static int reverse(int x) {
//	        int result = 0;
//	        while(x!=0){
//	            if (Math.abs(result) > Integer.MAX_VALUE / 10) {         
//	            	return 0;
//	            }
//	            result = result*10 + x%10;
//	            x /= 10;                                    
//	        }
//	        System.out.println(result);
//	        return result;
//	    }
		
		return result;
        
    }
}