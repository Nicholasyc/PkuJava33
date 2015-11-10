public class Solution {
    public String intToRoman(int num) {
        //�����ַ���I��V��X��L��C��D��M
		//��������
		//V ��X ��ߵ�С����ֻ���â�
		//L ��C ��ߵ�С����ֻ����X
		//D ��M ��ߵ�С����ֻ����C
		//������Ϲ����оٳ����п��ܵ��Ȼ������ʱ��ֱ����Ӽ���
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] elements = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			//���Ǳ���������������оٵ���ᷢ�֣������������������ͬ�������
			while (num >= values[i]) {
				num = num - values[i];
				result.append(elements[i]);
			}
		}
		return result.toString();
    }
}