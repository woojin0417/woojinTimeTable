package LectureFunction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ExcelOperation.ExcelDataObject;

public class LectureFuntionExceptions {
	
	public boolean checkApply(ArrayList<ExcelDataObject> LectureList, String inputMajor, String inputLN, String inputD)
	{
		for(int i=0;i<LectureList.size();i++)
		{
			if(LectureList.get(i).getMajor().equals(inputMajor) 
				&& LectureList.get(i).getClassNumber().equals(inputLN)
				&& LectureList.get(i).getClassDivide().equals(inputD)
			)
			{
				System.out.println("이미 수강목록에 있습니다.");
				return false;
			}
			
		}
		return true;
	}
	public int inputNum(int boundaryNum)
	{
		try{
			int i=new Scanner(System.in).nextInt();
			if(i==0)
			{
				return 0;
			}
			if(!(1<=i && i<boundaryNum+1))
			{
			
				return -1;
			}
			else return i;
		}catch (InputMismatchException e) {
			System.out.println("정수만 입력하세요.");
			return -2;
		}
	}
	//public boolean check
}
