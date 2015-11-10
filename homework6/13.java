public class Solution {
    public int romanToInt(String s) {
        char[] elements = s.toCharArray();
		int result = 0;
		//��ȡǰһ������ֵ
		int fore = 0;
		int current = 0;
		//�����������ֵļ�ֵ��
//		Map<String, Integer> values = new HashMap<String, Integer>();
		Map<Character, Integer> values = new HashMap<Character, Integer>();
		values.put('M', 1000);
		values.put('D', 500);
		values.put('C', 100);
		values.put('L', 50);
		values.put('X', 10);
		values.put('V', 5);
		values.put('I', 1);
		
		//��ʼ��fore
		fore = values.get(elements[0]);
		for(int i = 0; i < elements.length; i++){
			//�������ǰһ�����ֱȺ�һ�����ִ��������ǰһ������
			current = values.get(elements[i]);
			if(fore < current){
				result = result + current - 2*fore;
			}else{
				result += current;
			}
			//����ǰһ�����ֵ�ֵ
			fore = current;
		}
		
		return result;
    }
}