package woojinTT;

import java.util.ArrayList;

public class printExcel {

	
	public static void printExcel(ArrayList<DataObject> list ) {
	
		DataObject eo;
		for(int i=0;i<list.size();i++)
		{
			eo = list.get(i);
			System.out.print(i+1 +". ");
			System.out.printf("%-11s",eo.toString());			
			System.out.println("");
		}
	}
}
