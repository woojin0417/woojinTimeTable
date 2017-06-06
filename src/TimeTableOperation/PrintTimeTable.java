package TimeTableOperation;

import java.util.ArrayList;
import java.util.Iterator;

import ExcelOperation.ExcelDataObject;
import ExcelOperation.ExcelIO;
 
public class PrintTimeTable {

	ArrayList<TimeObject> schedule=new ArrayList<TimeObject>();
	ArrayList<ExcelDataObject> LectureList = new ArrayList<ExcelDataObject>();
	public String mon="";
	public String tue="";
	public String wed="";
	public String thu="";
	public String fri="";
	public PrintTimeTable(ArrayList<ExcelDataObject> LectureList) {
 
		schedule.add(new TimeObject("0���� 00:00 - 00:00","[   ������   ]","[   ȭ����   ]","[   ������   ]","[   �����   ]","[   �ݿ���   ]"));
		schedule.add(new TimeObject("1���� 08:00 - 08:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("2���� 08:30 - 09:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("3���� 09:00 - 09:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("4���� 09:30 - 10:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("5���� 10:00 - 10:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("6���� 10:30 - 11:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("7���� 11:00 - 11:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("8���� 11:30 - 12:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("9���� 12:00 - 12:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("10���� 12:30 - 13:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("11���� 13:00 - 13:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("12���� 13:30 - 14:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("13���� 14:00 - 14:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("14���� 14:30 - 15:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("15���� 15:00 - 15:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("16���� 15:30 - 16:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("17���� 16:00 - 16:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("18���� 16:30 - 17:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("19���� 17:00 - 17:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("20���� 17:30 - 18:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("21���� 18:00 - 18:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("22���� 18:30 - 19:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("23���� 19:00 - 19:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("24���� 19:30 - 20:00", mon, tue, wed, thu, fri));
		this.LectureList=LectureList ;

	}
	// �� , ȭ, ��, ��,�� ���� 
	public boolean settingSchedule(ArrayList<ExcelDataObject> LectureList)
		{
			boolean settingFlag=false;
			for(int i=0;i<LectureList.size();i++)
			{
				if(LectureList.get(i).getClassTime().contains("��"))
				{settingFlag=updateSchedule(i,1);}
				if(LectureList.get(i).getClassTime().contains("ȭ"))
				{settingFlag=updateSchedule(i,2);}
				if(LectureList.get(i).getClassTime().contains("��"))
				{settingFlag=updateSchedule(i,3);}
				if(LectureList.get(i).getClassTime().contains("��"))
				{settingFlag=updateSchedule(i,4);}
				if(LectureList.get(i).getClassTime().contains("��"))
				{settingFlag=updateSchedule(i,5);}
			}
			return settingFlag;
		}
	 	
		public boolean updateSchedule(int i,int day)
		{
			String startTime;
			String finishTime;
			int sIndex;
			int fIndex;
			boolean updateFlag=false;
	 
			startTime=getStartTime(LectureList.get(i).getClassTime());
			finishTime=getFinishTime(LectureList.get(i).getClassTime());
			sIndex=getIndexofStartingSchedule(startTime);
			fIndex=getIndexofFinishingSchedule(finishTime);
	 
			if(checkSchedule(sIndex, fIndex, day)) // ����ִ� ĭ��
			{
				if(day==1)
				{
					for(int j=sIndex;j<fIndex+1;j++)
					{schedule.get(j).mon=LectureList.get(i).getClassName();}
				}
				if(day==2)
				{
					for(int j=sIndex;j<fIndex+1;j++)
					{schedule.get(j).tue=LectureList.get(i).getClassName();}
				}
				if(day==3)
				{
					for(int j=sIndex;j<fIndex+1;j++)
					{schedule.get(j).wed=LectureList.get(i).getClassName();}
				}
				if(day==4)
				{
					for(int j=sIndex;j<fIndex+1;j++)
					{schedule.get(j).thur=LectureList.get(i).getClassName();}
				}
				if(day==5)
				{
					for(int j=sIndex;j<fIndex+1;j++)
					{schedule.get(j).fri=LectureList.get(i).getClassName();}
				}
				updateFlag=true;
				return updateFlag;
			}
			else
			{
				return updateFlag;
			}
		}
	 
		//�ð�ǥ��ġ���� üũ 
		public boolean checkSchedule(int sIndex, int fIndex, int day) // ���۽ð� , ������ �ð� , ����
		{
			boolean checkFlag=false;
			int count=0;
			if(day==1)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{
					if(schedule.get(j).mon.equals(""))
					{count++;}
				}
			}
			if(day==2)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{
					if(schedule.get(j).tue.equals(""))
					{count++;}
				}
			}
			if(day==3)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{
					if(schedule.get(j).wed.equals(""))
					{count++;}
				}
			}
			if(day==4)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{
					if(schedule.get(j).thur.equals(""))
					{count++;}
				}
			}
			if(day==5)
			{
				for(int j=sIndex;j<fIndex+1;j++)
				{
					if(schedule.get(j).fri.equals(""))
					{count++;}
				}
			}
			
			//�ش� ĭ�� ��������� count++�̹Ƿ�,
			//count���� �ʿ��� ĭ���� ���ٸ� ���δ� ����ִٰ� �� �� �ִ�.
			if(count==(fIndex+1)-sIndex) 
			{
				checkFlag=true;
			}
			return checkFlag; //count�� �ʿ��� ĭ���� Ʋ���� �⺻ false 
		}
	 
	 
	 
		public int getIndexofStartingSchedule(String startTime)  //�� �ð�ǥ�� ���۽ð��� ©�����
		{
			int index;
			String tempTime[];
	 
			for(int j=0;j<schedule.size();j++)
			{
				tempTime=schedule.get(j).time.split(" ");
				tempTime[1]=tempTime[1].replaceAll("[^0-9]","");
				if(tempTime[1].equals(startTime))
				{
					index = j;
					return index;				
				}
			}
			return -1;
		}
	 
		public int getIndexofFinishingSchedule(String finishTime) // ���ð�ǥ�� ������ �ð��� ©����� �� 
		{
			int index;
			String tempTime[]; //split���� �ؼ� ���� ���� �� 
	 
			for(int j=0;j<schedule.size();j++)
			{
				tempTime=schedule.get(j).time.split(" ");
				tempTime[3]=tempTime[3].replaceAll("[^0-9]","");
				if(tempTime[3].equals(finishTime)) 
				{
					index = j;
					return index;				
				}
			}
			return -1;
		}
	 
		public String getStartTime(String s)// ���� �������� ���� ���۽ð��� ©�����
		{
			String startTime=s;
			startTime=startTime.replaceAll("[^0-9]", ""); // ���� ���Խ�
			startTime=startTime.substring(0,4);
			return startTime; 
		}
		public String getFinishTime(String s) // ���� �������Ͽ��� ������ �ð� ©�����
		{
			String finishTime=s;
			finishTime=finishTime.replaceAll("[^0-9]", "");
			finishTime=finishTime.substring(4,8);
			return finishTime;
		}
	 
		public void scheduleSave()
		{
			new ExcelIO().fileSave(schedule);
		}
		
		
		public void schedulePrint()
		{
			Iterator<TimeObject> iter = schedule.iterator();
			while(iter.hasNext())
			{
				TimeObject iter_list = iter.next();
				System.out.printf("%-11s",iter_list.time);
				System.out.printf("\t|%-11s",iter_list.mon);
				System.out.printf("\t|%-11s",iter_list.tue);
				System.out.printf("\t|%-11s",iter_list.wed);
				System.out.printf("\t|%-11s",iter_list.thur);
				System.out.printf("\t|%-11s",iter_list.fri);
				System.out.printf("\t|%-11s","");
				System.out.println("");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("");
			}
		}
	}

