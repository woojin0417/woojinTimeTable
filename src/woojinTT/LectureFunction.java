package woojinTT;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureFunction {

	Scanner sc = new Scanner(System.in);
	ArrayList<DataObject> list;
	ArrayList<DataObject> LectureList = new ArrayList<DataObject>();
	ArrayList<DataObject> InterestedList = new ArrayList<DataObject>();
	ViewTimeTable vtt = new ViewTimeTable(LectureList);
	Constants cs = new Constants();
	public LectureFunction(ArrayList<DataObject> list)
	{
		this.list =list;
	}
	public void DeleteLecture(int mode)
	{
		switch(mode)
		{
		case 3 :
			System.out.println("수강신청 리스트");
			printExcel.printExcel(LectureList);
			
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
		case 5:
			System.out.println("관심과목 리스트");
			printExcel.printExcel(InterestedList);
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
	
	public void ApplyLecture(int mode)
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
				//예외처리
				if(cs.checkApply(LectureList, inputMajor, inputLNum, inputDivide))
				{	
					if(mode==2)
					{						
						LectureList.add(list.get(i));
						if(vtt.settingSchedule(LectureList))
						{
						System.out.println("수강신청 리스트");
						printExcel.printExcel(LectureList);
						}
						else
						{
							System.out.println("시간이 겹칩니다");
							LectureList.remove(list.get(i));
						}
					}

					else if(mode==4)
					{
						if(cs.checkApply(InterestedList, inputMajor, inputLNum, inputDivide))
						{
							InterestedList.add(list.get(i));
							System.out.println("관심과목 리스트");
							printExcel.printExcel(InterestedList);	
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
