import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.List;
//import java.util.HashList;
//import java.io.HashList;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.IOException;


public class test {
	public static void main(String argv[]){
        String filePathA = "E:\\yuyujava\\word\\A.txt";
		String filePathB = "E:\\yuyujava\\word\\B.txt";
		String filePathUni = "E:\\yuyujava\\word\\UniSet.txt";
		String filePathAnd = "E:\\yuyujava\\word\\AndSet.txt";
		//String filePathTotal = "E:\\yuyujava\\word\\TotalSet.txt";

        readTxtFile(filePathA);
		readTxtFile(filePathB);
		
		total(filePathA,filePathB);
		
		uniSet(filePathA,filePathB);
		andSet(filePathA,filePathB);
		
		//������ذٷֱ�
		List<String> list1 = outList(filePathA);
		List<String> list2 = outList(filePathB);
		List<String> list3 = outList(filePathAnd);
		
		int a,b,c;
		a=list1.size();   //System.out.print(a+"   ");
		b=list2.size();   //System.out.print(b+"   ");
		c=list3.size();   //System.out.print(c+"   ");
		
		double perA=((a-c)*100)/a;   //System.out.print(perA);
		double perB=((b-c)*100)/b;   //System.out.print(perB);
				
		FileWriter uniWriteA = null;
		String pathA = "E:\\yuyujava\\word\\A.txt";		
		try {
			//uniWriteA = new FileWriter(pathA);
			//uniWriteA.("A�ļ�������A�Ҳ�����B�ĵ���ռA�ļ������İٷֱ�Ϊ��  "+perA+"%");
			uniWriteA = new FileWriter(filePathA, true);     
            uniWriteA.write("     A�ļ�������A�Ҳ�����B�ĵ���ռA�ļ������İٷֱ�Ϊ��  "+perA+"%");       
    		uniWriteA.flush();
		} catch (IOException e) {     
            e.printStackTrace();  
		}
		
		FileWriter uniWriteB = null;
		String pathB = "E:\\yuyujava\\word\\B.txt";
		try {
			uniWriteB = new FileWriter(filePathB, true);     
			uniWriteB.write("     B�ļ�������B�Ҳ�����A�ĵ���ռB�ļ������İٷֱ�Ϊ��  "+perB+"%");   
			uniWriteB.flush();
		} catch (IOException e) {     
            e.printStackTrace();
		}     		
    }
    
	//��ȡA.txt��B.txt����
	public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
               
			    if(file.isFile() && file.exists()){ 
				
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                    
					BufferedReader bufferedReader = new BufferedReader(read);
                   
				    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
					
                    read.close();
				}else{
					System.out.println("�ļ������ڣ�");
				}
        } catch (Exception e) {
            System.out.println("���ļ�����");
            e.printStackTrace();
		}     
    }
	
	//�������ļ��е�����ȫ��д��һ��TotalSet.txt�ļ�����
	public static void total(String filePathA,String filePathB){
		try{	
			File totalSet = new File("E:/yuyujava/word/TotalSet.txt");   
		
			FileInputStream fileA = new FileInputStream(filePathA);
			FileInputStream fileB = new FileInputStream(filePathB);
         
			InputStream fileTotal = new SequenceInputStream(fileA,fileB);    
			InputStreamReader fileRead = new InputStreamReader(fileTotal);         
			FileOutputStream fileOut = new FileOutputStream(totalSet,true);         
			OutputStreamWriter fileWrite = new OutputStreamWriter(fileOut);
         
			int a;
			while((a=fileRead.read())!=-1){
				fileWrite.write((char)a);
			}
		
			System.out.println("TotalSet.txt is ok....");
		
			fileRead.close();
			fileWrite.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}  	
	}
	
	//��txt�ļ��е����������list��
	public static List<String> outList(String fileName){
		List<String> list = new ArrayList<>();
		String[] tempStr;
		String lineStr;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new  FileReader(fileName));
			while((lineStr = reader.readLine()) != null){
				tempStr = lineStr.split("[\\s,.;!��������]");
				for(String s:tempStr){
					if(!s.trim().equals("")){
						list.add(s.trim());
					}
				}				
			}
		} catch (Exception e) {
				e.printStackTrace();
				}  
		return list;		
	}
	
	//�����в��ظ������ҳ������UniSet.txt�ļ�����
	public static void uniSet(String filePathA,String filePathB){
	
		List<String> list1 = outList(filePathA);
		List<String> list2 = outList(filePathB);
		List<String> list3 = new ArrayList<>();
		
		list3.addAll(list1);
		for(String s:list2){
			if(list3.contains(s)){
				continue;
				}else{
					list3.add(s);
					}
		}		
			
		FileWriter uniWrite = null;
		String uniPath = "E:\\yuyujava\\word\\UniSet.txt";
		try {
			uniWrite = new FileWriter(uniPath);
			for(String s:list3)
				uniWrite.write(s+"    ");
			
			uniWrite.flush();
		} catch (Exception e) {
				e.printStackTrace();
			}  	
			
			/*
		System.out.print("����uniSet");		
		
		try{
		File totalSet = new File("E:/yuyujava/word/TotalSet.txt");   
		File uniSet = new File("E:/yuyujava/word/UniSet.txt");   
		FileWriter writer = new FileWriter(uniSet,true);
		
		List<String> listTotal = readTxtFile(filePathTotal);		
		List<String> h = new ArrayList<>(listTotal);
		listTotal.clear();  
		listTotal.addAll(h);  
			
			//String filePath = "F:\\test.txt";					
			//String filePathTotal = "E:\\yuyujava\\word\\TotalSet.txt";
			String encoding="GBK";
			File file=new File(filePathTotal);			
			
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			ArrayList<String> s = new ArrayList<String>();
			String lineTxt = null;
			s.add(null);
			System.out.print("�½�arraylist�ɹ�\n");
			
			while((lineTxt = bufferedReader.readLine()) != null){
				System.out.print("��ʼ���s:\n");
				System.out.print(lineTxt);
				/*
				if(!s.contains(lineTxt)) {
					s.add(lineTxt);	
					System.out.print(lineTxt);
				}			
						
			for(String str:s){
				System.out.print("����for....");
				if(s.contains(str)){
					continue;
				}else{
					s.add(str);
					System.out.print(str);
				}				
			}
				
			for(int i = 0;i<s.size();i++) {
				writer.write(s.get(i).toString());
				System.out.print(lineTxt);

			}		
			
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
			}
				

		try {
            //List list = new List();
			List<String> list = new ArrayList<>();
		
            FileWriter writer = new FileWriter(uniSet,true);
           
		    for(int i = 0;i<list.size();i++) {
                writer.write(list.get(i).toString());
            }
             
            writer.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
*/
	}
	
	//�������ظ��ĵ����ҳ��������AndSet.txt�ļ�����
	public static void andSet(String filePathA,String filePathB){
	
		List<String> list1 = outList(filePathA);
		List<String> list2 = outList(filePathB);
		List<String> list3 = new ArrayList<>();
		
		for(String s:list2){
			if(list1.contains(s)){
				list3.add(s);				
				}else{
					continue;
					}
		}	
	
		FileWriter uniWrite = null;
		String uniPath = "E:\\yuyujava\\word\\andSet.txt";
		try {
			uniWrite = new FileWriter(uniPath);
			for(String s:list3)
				uniWrite.write(s+"    ");
			
			uniWrite.flush();
		} catch (Exception e) {
				e.printStackTrace();
			}  
	}	
}