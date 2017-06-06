package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ExcelOperation.ExcelDataObject;
import ExcelOperation.ExcelIO;
import ExcelOperation.PrintExcel;
import LectureFunction.LectureFunction;

public class Main {
	public static void main(String[] args) 
	{	
		new Main();
	}
	
	Main()
	{
		boolean temp = false;
		ExcelIO excel = new ExcelIO();
		BufferedReader br;
		String selectMenuNum;
		ArrayList<ExcelDataObject> list= excel.bringData();
		LectureFunction lf = new LectureFunction(list);
		while(!temp)
		{
			System.out.println("   ====================================�ð�ǥ ���α׷�=====================================");		
			System.out.println();
			System.out.println("   ========================================�޴�=========================================");
			System.out.println(" <<1.��簭�Ǻ���, 2.�������, 3.��������, 4.���ɰ�����, 5.���ɰ������, 6.�ð�ǥ���, 7.�������� ,8. EXIT>> ");
			System.out.println("   ====================================================================================");
			br = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				System.out.print("�׸��� �����ϼ��� : ");
				selectMenuNum = br.readLine();		
				int numSelec = Integer.parseInt(selectMenuNum);		// String -> Integer ĳ����
				switch(numSelec)
				{
				case 1 : PrintExcel.printExcel(list); break;
				case 2 : lf.ApplyLecture(2); break;
				case 3 : lf.DeleteLecture (3); break;
				case 4 : lf.ApplyLecture(4); break;
				case 5 : lf.DeleteLecture(5); break;
				case 6 : lf.PrintMyTimeTable(); break;
				case 7 : lf.SaveTimeTable(); break;
				case 8 : 					
					temp = true;
					System.out.println("Exit TimeTable");		
					System.exit(0);	
					break;		
				default : System.out.println("���� �޴��Դϴ�"); break;
				}
			}
			catch(IOException e) { e.printStackTrace(); }
			catch(NumberFormatException e) { System.out.println("���ڸ� �Է����ּ���!"); }		// ���ڰ� �ƴ� �� �Է����� ��
		}
	}
	
}
