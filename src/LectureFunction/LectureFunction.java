package LectureFunction;

import java.util.ArrayList;
import java.util.Scanner;

import ExcelOperation.ExcelDataObject;
import ExcelOperation.PrintExcel;
import TimeTableOperation.PrintTimeTable;

public class LectureFunction {

	Scanner sc = new Scanner(System.in);
	ArrayList<ExcelDataObject> list;	
	ArrayList<ExcelDataObject> LectureList = new ArrayList<ExcelDataObject>(); //수강신청및 삭제를 하기 위한 리스트
	ArrayList<ExcelDataObject> InterestedList = new ArrayList<ExcelDataObject>(); //관심과목 등록및 삭제 하기 위한 리스트
	
	PrintTimeTable vtt = new PrintTimeTable(LectureList);
	LectureFuntionExceptions cs = new LectureFuntionExceptions();
	
	public LectureFunction(ArrayList<ExcelDataObject> list)
	{
		this.list =list;
	}
	public void DeleteLecture(int mode) //시간표에서 강의 삭제
	{
		switch(mode)
		{
		case 3 :  //수강 리스트에서 강의 삭제
			System.out.println("수강신청 리스트");
			PrintExcel.printExcel(LectureList);
			
			System.out.println("삭제할 과목 번호 선택하세요. 삭제를 원치 않으면 0을 누르세요");
			int SelectNum = cs.inputNum(LectureList.size());
			if(SelectNum==0)
			{
				return;
			}
			else if(SelectNum==-1)
			{
				System.out.println("입력 범위를 벗어났습니다. 초기화면으로 돌아갑니다");
			}
			else
			{
				LectureList.remove(SelectNum-1);
				System.out.println("과목 삭제 완료"); 
			}
			break;
		case 5: //관심과목 리스트에서 강의 삭제
			System.out.println("관심과목 리스트");
			PrintExcel.printExcel(InterestedList);
			System.out.println("삭제할 과목 번호 선택하세요");
			int SelectNum2 = cs.inputNum(InterestedList.size());
			if(SelectNum2==0)
			{
				return;
			}
			else
			{
				InterestedList.remove(SelectNum2-1);
				System.out.println("과목 삭제 완료"); 
			}
			break;
		}
	}
	
	public void ApplyLecture(int mode)  //강의 등록
	{
		System.out.println("개설학과 전공을 입력하세요 ");		
		String inputMajor = sc.nextLine();
		System.out.println("학수번호를 입력하세요");
		String inputLNum = sc.nextLine();
		System.out.println("분반을 입력하세요 ");
		String inputDivide = sc.nextLine();

		for(int i=0;i<list.size();i++)
		{
			if(inputMajor.equals(list.get(i).getMajor()) 
					&& inputLNum.equals(list.get(i).getClassNumber()) 
					&& inputDivide.equals(list.get(i).getClassDivide())
					)
			{
				
				if(cs.checkApply(LectureList, inputMajor, inputLNum, inputDivide))
				{	
					if(mode==2)  //수강 등록 
					{						
						LectureList.add(list.get(i));
						if(vtt.settingSchedule(LectureList))
						{
						System.out.println("수강신청 리스트");
						PrintExcel.printExcel(LectureList);
						}
						else
						{
							System.out.println("시간이 겹칩니다");
							LectureList.remove(list.get(i));
						}
					}

					else if(mode==4) //관심과목 등록
					{
						if(cs.checkApply(InterestedList, inputMajor, inputLNum, inputDivide))
						{
							InterestedList.add(list.get(i));
							System.out.println("관심과목 리스트");
							PrintExcel.printExcel(InterestedList);	
						}
					}
				}


				return ;
			}

		}
		System.out.println("등록된 강의가 아닙니다.");

	}
	
	public void PrintMyTimeTable()
	{
		vtt.schedulePrint();
	}
	public void SaveTimeTable()
	{
		vtt.scheduleSave();
	}
}
