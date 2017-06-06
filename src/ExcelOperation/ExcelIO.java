package woojinTT;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import woojinTT.DataObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelIO {
	ArrayList<DataObject> list;
	FileInputStream inputExcel;
	FileOutputStream outputExcel;
	XSSFWorkbook workbook;
	XSSFSheet exSheet;
	XSSFRow exRow;
	XSSFCell exCell;
	@SuppressWarnings({ "resource", "deprecation" })
	public ArrayList<DataObject> bringData(){
		
		list=new ArrayList<DataObject>();
		String filepath = "src/Sejong.xlsx";
		try{
			
			inputExcel=new FileInputStream(new File(filepath));
			
			workbook =new XSSFWorkbook(inputExcel);
			

			DataObject eo;
			
			for(int i=0;i<workbook.getNumberOfSheets();i++){
				exSheet = workbook.getSheetAt(i);
				
				for(int row=0;row<exSheet.getPhysicalNumberOfRows();row++){

					exRow = exSheet.getRow(row);
					eo = new DataObject();
					String value;
					
					if(exRow!=null){
						for(int cell=0;cell<exRow.getPhysicalNumberOfCells();cell++){
							
							exCell = exRow.getCell(cell);
							
							if(true){
								value="";
								
								switch(exCell.getCellType()){
								case XSSFCell.CELL_TYPE_FORMULA:
									value = exCell.getCellFormula();
									break;
								case XSSFCell.CELL_TYPE_NUMERIC:
									value =""+ exCell.getNumericCellValue();
									break;
								case XSSFCell.CELL_TYPE_STRING:
									value =""+exCell.getStringCellValue();
									break;
								case XSSFCell.CELL_TYPE_BLANK:
									value =" ";
									break;
								case XSSFCell.CELL_TYPE_ERROR:
									value=exCell.getErrorCellValue()+"";
									break;
								default:
									value = new String();
									break;
								}//swith(exCell)
								//값 가져오기
								
								
								switch(cell){
								case 0:
									eo.setMajor(value);
									break;
								case 1:
									eo.setClassNumber(value);
									break;
								case 2:
									eo.setClassDivide(value);
									break;
								case 3:
									eo.setClassName(value);
									break;
								case 4:
									eo.setClassCompletion(value);
									break;
								case 5:
									eo.setClassCredit(value);
									break;
								case 6:
									eo.setStudentGrade(value);
									break;
								case 7:
									eo.setProfessorName(value);
									break;
								case 8:
									eo.setClassTime(value);;
									break;
								default:
									break;
								}//switch(cell)
								//가져온값 리스트에 넣기
								
							}//if
							
						}//for(cell)
						
						
					}//if(exRow!=null)
					
					//if(eo.getMajor().equals("컴퓨터공학과")  || eo.getMajor().equals("디지털콘텐츠학과") )
					if(eo.getMajor()!=null)
					list.add(eo);
					
				}
				
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(workbook!=null) workbook.close();
				if(inputExcel!=null) inputExcel.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return list;
		
	}
	public void fileSave(ArrayList<TimeObject> scheduleList)
	{
		workbook = new XSSFWorkbook();
		exSheet = workbook.createSheet();
		
		TimeObject schedule;
		for(int i=0;i<scheduleList.size();i++)
		{
			schedule=scheduleList.get(i);
			exRow=exSheet.createRow(i);
 
			exCell=exRow.createCell(0);
			exCell.setCellValue(schedule.time);
			exCell=exRow.createCell(1);
			exCell.setCellValue(schedule.mon);
			exCell=exRow.createCell(2);
			exCell.setCellValue(schedule.tue);
			exCell=exRow.createCell(3);
			exCell.setCellValue(schedule.wed);
			exCell=exRow.createCell(4);
			exCell.setCellValue(schedule.thur);
			exCell=exRow.createCell(5);
			exCell.setCellValue(schedule.fri);
		}
		try {
			System.out.println("Saving the File......");
			outputExcel=new FileOutputStream(new File("src/TIMETABLE.xlsx"));
			workbook.write(outputExcel);
 
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try {
				outputExcel.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
	}
}
