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
 
		schedule.add(new TimeObject("0교시 00:00 - 00:00","[   월요일   ]","[   화요일   ]","[   수요일   ]","[   목요일   ]","[   금요일   ]"));
		schedule.add(new TimeObject("1교시 08:00 - 08:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("2교시 08:30 - 09:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("3교시 09:00 - 09:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("4교시 09:30 - 10:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("5교시 10:00 - 10:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("6교시 10:30 - 11:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("7교시 11:00 - 11:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("8교시 11:30 - 12:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("9교시 12:00 - 12:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("10교시 12:30 - 13:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("11교시 13:00 - 13:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("12교시 13:30 - 14:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("13교시 14:00 - 14:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("14교시 14:30 - 15:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("15교시 15:00 - 15:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("16교시 15:30 - 16:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("17교시 16:00 - 16:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("18교시 16:30 - 17:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("19교시 17:00 - 17:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("20교시 17:30 - 18:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("21교시 18:00 - 18:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("22교시 18:30 - 19:00", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("23교시 19:00 - 19:30", mon, tue, wed, thu, fri));
		schedule.add(new TimeObject("24교시 19:30 - 20:00", mon, tue, wed, thu, fri));
		this.LectureList=LectureList ;

	}
	// 월 , 화, 수, 목,금 수업 
	public boolean settingSchedule(ArrayList<ExcelDataObject> LectureList)
		{
			boolean settingFlag=false;
			for(int i=0;i<LectureList.size();i++)
			{
				if(LectureList.get(i).getClassTime().contains("월"))
				{settingFlag=updateSchedule(i,1);}
				if(LectureList.get(i).getClassTime().contains("화"))
				{settingFlag=updateSchedule(i,2);}
				if(LectureList.get(i).getClassTime().contains("수"))
				{settingFlag=updateSchedule(i,3);}
				if(LectureList.get(i).getClassTime().contains("목"))
				{settingFlag=updateSchedule(i,4);}
				if(LectureList.get(i).getClassTime().contains("금"))
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
	 
			if(checkSchedule(sIndex, fIndex, day)) // 비어있는 칸임
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
	 
		//시간표겹치는지 체크 
		public boolean checkSchedule(int sIndex, int fIndex, int day) // 시작시간 , 끝나는 시간 , 요일
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
			
			//해당 칸이 비어있으면 count++이므로,
			//count값이 필요한 칸수랑 같다면 전부다 비어있다고 볼 수 있다.
			if(count==(fIndex+1)-sIndex) 
			{
				checkFlag=true;
			}
			return checkFlag; //count랑 필요한 칸수랑 틀리면 기본 false 
		}
	 
	 
	 
		public int getIndexofStartingSchedule(String startTime)  //내 시간표의 시작시간을 짤라오기
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
	 
		public int getIndexofFinishingSchedule(String finishTime) // 내시간표의 끝나는 시간을 짤라오는 것 
		{
			int index;
			String tempTime[]; //split으로 해서 갖구 오는 것 
	 
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
	 
		public String getStartTime(String s)// 원래 엑셀파일 에서 시작시간만 짤라오기
		{
			String startTime=s;
			startTime=startTime.replaceAll("[^0-9]", ""); // 정수 정규식
			startTime=startTime.substring(0,4);
			return startTime; 
		}
		public String getFinishTime(String s) // 원래 엑셀파일에서 끝나는 시간 짤라오기
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

