import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			//posX = Integer.parseInt(posStrArr[0]) - 1;
			//posY = Integer.parseInt(posStrArr[1]) - 1;
			posX = Integer.parseInt(posStrArr[0]);
			posY = Integer.parseInt(posStrArr[1]);
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],chessman);
				
						
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
/*	public int[] computerDo() {
		
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			break;
		}
		
		int[] result = { posX+1, posY+1 };
		return result;
	   
	}*/
/*	
	public int[] computerDo(int posX, int posY, String ico) {
		int X,Y;
		        
		int a = 1;
		while (a > 0) {
		
				String[][] board = chessboard.getBoard();
				
				X = posX;
				Y = posY;
				if((board[posX][posY+1]!="ʮ")||(posY+1>Chessboard.BOARD_SIZE-1)){
					for(int i=0;i<Chessboard.BOARD_SIZE-1;i++){
						Y = posY - i;
 						if(board[X][Y] != "ʮ"){
    						continue;
						}else{
							int[] res = {X,Y};
							return res;
						}
					}
				}else{
					X = posX;
					Y = posY+1;
					int[] res = {X,Y};
					return res;
				}
		}

			return computerDo();
	}
*/
public int[] computerDo() {
	//System.out.println("computerDo");
		int X=posX,Y=posY;
		String[][] board=chessboard.getBoard();
		int a=1;
		int i=1;
		//while(a>0){
			
			if(posX+i<=Chessboard.BOARD_SIZE && board[posX+i-1][posY-1].equals("ʮ")){
			X=posX+i;
			Y=posY;
			posX=X;
			posY=Y;
			return new int[]{X,Y};
			}
			//else if(posX+i>=Chessboard.BOARD_SIZE)
			//	break;
			//else
			//	i++;
				
		//}
		
		i=1;
		//while(a>0){
			//System.out.println(board[posX-i][posY].equals("ʮ"));
			if(posX-i>=1 && board[posX-i-1][posY-1].equals("ʮ")){
			X=posX-i;
			Y=posY;
			
			//System.out.println(posX+posY);
			//System.out.println(X+Y);
			posX=X;
			posY=Y;
			return new int[]{X,Y};
			}
			//else if(posX-i<0)
			//	break;
			//else
			//	i++;
		//}
		
		i=1;
		//while(a>0){
			//System.out.println(board[posX][posY+i].equals("ʮ"));
			if(posY+i<=Chessboard.BOARD_SIZE && board[posX-1][posY+i-1].equals("ʮ")){
			X=posX;
			Y=posY+i;
			//System.out.println("posX="+posX+"posY="+posY);
			//System.out.println("X="+X+"Y="+Y);
			posX=X;
			posY=Y+i;
			return new int[]{X,Y};
			}
			//else if(posY+i>=Chessboard.BOARD_SIZE)
			//	break;
			//else
				//i++;
				
		//}
		
		i=1;
		//while(a>0){
			//System.out.println(board[posX][posY-i].equals("ʮ"));
			if(posY-i>=1 && board[posX-1][posY-i-1].equals("ʮ")){
			X=posX;
			Y=posY-i;
			
			//System.out.println(posX+posY);
			//System.out.println(X+Y);
			posX=X;
			posY=Y;
			return new int[]{X,Y};
			}
			//else if(posY-i<0)
			//	break;
			//else
			//	i++;
		//}
		
		//return computerDo();
		if(X==posX && Y==posY){
			X = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		    Y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		
		while (board[posX][posY] != "ʮ") {
			X = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			Y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			break;
		}
		
		
		}
		
			//System.out.println(X+Y);
		int[] result = {X,Y };
		
		return result;
		
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	 
	public boolean isWon(int posX, int posY, String ico) {
		//�ĸ���������һ�����������������ͷ���true
		if (upToDown(posX, posY, ico) == WIN_COUNT
				|| leftToRight(posX, posY, ico) == WIN_COUNT
				|| leftDownToRightUp(posX, posY, ico) == WIN_COUNT
				|| leftUpToRightDown(posX, posY, ico) == WIN_COUNT) {
			return true;
		}

		return false;
	}
	//����
	public int leftToRight(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; posY - i >= 0; i++) {
			if (board[posX][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; posY + i <= Chessboard.BOARD_SIZE; i++) {
			if (board[posX][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//����
	public int upToDown(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; posX - i >= 0; i++) {
			if (board[posX - i][posY].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; posX + i <= Chessboard.BOARD_SIZE; i++) {
			if (board[posX + i][posY].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//���ϵ�����
	public int leftUpToRightDown(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; (posX - i >= 0) && (posY - i >= 0); i++) {
			if (board[posX - i][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; (posX + i <= Chessboard.BOARD_SIZE)
				&& (posY + i <= Chessboard.BOARD_SIZE); i++) {
			if (board[posX + i][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//���µ�����
	public int leftDownToRightUp(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; (posY - i >= 0) && (posX + i <= Chessboard.BOARD_SIZE); i++) {
			if (board[posX + i][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; (posY + i <= Chessboard.BOARD_SIZE) && (posX - i >= 0); i++) {
			if (board[posX - i][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
