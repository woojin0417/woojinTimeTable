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
			System.out.println("   ====================================시간표 프로그램=====================================");		
			System.out.println();
			System.out.println("   ========================================메뉴=========================================");
			System.out.println(" <<1.모든강의보기, 2.수업등록, 3.수업삭제, 4.관심과목등록, 5.관심과목삭제, 6.시간표출력, 7.파일저장 ,8. EXIT>> ");
			System.out.println("   ====================================================================================");
			br = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				System.out.print("항목을 선택하세요 : ");
				selectMenuNum = br.readLine();		
				int numSelec = Integer.parseInt(selectMenuNum);		// String -> Integer 캐스팅
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
				default : System.out.println("없는 메뉴입니다"); break;
				}
			}
			catch(IOException e) { e.printStackTrace(); }
			catch(NumberFormatException e) { System.out.println("숫자를 입력해주세요!"); }		// 숫자가 아닌 값 입력했을 때
		}
	}
	
}
