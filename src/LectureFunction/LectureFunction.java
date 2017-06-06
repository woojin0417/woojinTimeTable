package LectureFunction;

import java.util.ArrayList;
import java.util.Scanner;

import ExcelOperation.ExcelDataObject;
import ExcelOperation.PrintExcel;
import TimeTableOperation.PrintTimeTable;

public class LectureFunction {

	Scanner sc = new Scanner(System.in);
	ArrayList<ExcelDataObject> list;	
	ArrayList<ExcelDataObject> LectureList = new ArrayList<ExcelDataObject>(); //������û�� ������ �ϱ� ���� ����Ʈ
	ArrayList<ExcelDataObject> InterestedList = new ArrayList<ExcelDataObject>(); //���ɰ��� ��Ϲ� ���� �ϱ� ���� ����Ʈ
	
	PrintTimeTable vtt = new PrintTimeTable(LectureList);
	LectureFuntionExceptions cs = new LectureFuntionExceptions();
	
	public LectureFunction(ArrayList<ExcelDataObject> list)
	{
		this.list =list;
	}
	public void DeleteLecture(int mode) //�ð�ǥ���� ���� ����
	{
		switch(mode)
		{
		case 3 :  //���� ����Ʈ���� ���� ����
			System.out.println("������û ����Ʈ");
			PrintExcel.printExcel(LectureList);
			
			System.out.println("������ ���� ��ȣ �����ϼ���. ������ ��ġ ������ 0�� ��������");
			int SelectNum = cs.inputNum(LectureList.size());
			if(SelectNum==0)
			{
				return;
			}
			else if(SelectNum==-1)
			{
				System.out.println("�Է� ������ ������ϴ�. �ʱ�ȭ������ ���ư��ϴ�");
			}
			else
			{
				LectureList.remove(SelectNum-1);
				System.out.println("���� ���� �Ϸ�"); 
			}
			break;
		case 5: //���ɰ��� ����Ʈ���� ���� ����
			System.out.println("���ɰ��� ����Ʈ");
			PrintExcel.printExcel(InterestedList);
			System.out.println("������ ���� ��ȣ �����ϼ���");
			int SelectNum2 = cs.inputNum(InterestedList.size());
			if(SelectNum2==0)
			{
				return;
			}
			else
			{
				InterestedList.remove(SelectNum2-1);
				System.out.println("���� ���� �Ϸ�"); 
			}
			break;
		}
	}
	
	public void ApplyLecture(int mode)  //���� ���
	{
		System.out.println("�����а� ������ �Է��ϼ��� ");		
		String inputMajor = sc.nextLine();
		System.out.println("�м���ȣ�� �Է��ϼ���");
		String inputLNum = sc.nextLine();
		System.out.println("�й��� �Է��ϼ��� ");
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
					if(mode==2)  //���� ��� 
					{						
						LectureList.add(list.get(i));
						if(vtt.settingSchedule(LectureList))
						{
						System.out.println("������û ����Ʈ");
						PrintExcel.printExcel(LectureList);
						}
						else
						{
							System.out.println("�ð��� ��Ĩ�ϴ�");
							LectureList.remove(list.get(i));
						}
					}

					else if(mode==4) //���ɰ��� ���
					{
						if(cs.checkApply(InterestedList, inputMajor, inputLNum, inputDivide))
						{
							InterestedList.add(list.get(i));
							System.out.println("���ɰ��� ����Ʈ");
							PrintExcel.printExcel(InterestedList);	
						}
					}
				}


				return ;
			}

		}
		System.out.println("��ϵ� ���ǰ� �ƴմϴ�.");

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
