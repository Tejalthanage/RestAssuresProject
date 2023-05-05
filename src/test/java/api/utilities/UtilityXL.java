package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.devtools.v85.css.model.CSSStyle;

public class UtilityXL {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	public FileOutputStream fou;
	public FileInputStream fin;
	public XSSFCellStyle style;
	String path=null;
	
	 UtilityXL(String path) {
		this.path=path;
	}
	 public int getRowCount(String sheetname) throws IOException
	 {
		 fin=new FileInputStream(path);
		 workbook= new XSSFWorkbook(fin);
		 sheet=workbook.getSheet("sheet1");
		 int rowcnt=sheet.getLastRowNum();
		 workbook.close();
		 fin.close();
		 return rowcnt;
	 }
	 public int getColumnCount(String sheetname,int rowNum) throws IOException
	 {
		 fin=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fin);
		 sheet=workbook.getSheet(sheetname);
		 row=sheet.getRow(rowNum);
		 int colcnt=row.getLastCellNum();
		 workbook.close();
		 fin.close();
		 return colcnt;
	 }
	 public String getData(String sheetname,int rowcnt,int colcnt) throws IOException
	 {
		 fin=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fin);
		 sheet=workbook.getSheet(sheetname);
		 row=sheet.getRow(rowcnt);
		 cell=row.getCell(colcnt);
		 DataFormatter formatter=new DataFormatter();
		 String data;
		 try
		 {
			 data=formatter.formatCellValue(cell);
		 }
		 catch (Exception e) {
			data="";
		}
		 workbook.close();
		 fin.close();
		 return data; 
	 }

	 
	 public void setCellData(String sheetame,int rowcnt,int colcnt,String Data) throws IOException
	 {
		 fin=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fin);
		 sheet=workbook.getSheet(sheetame);
		 row=sheet.getRow(rowcnt);
		 cell=row.createCell(colcnt);
		 cell.setCellValue(Data);
		 fou=new FileOutputStream(path);
		 workbook.write(fou);
		 workbook.close();
		 fin.close();
		 fou.close();
	}
	 
	public void FillGreenColor(String sheetnane,int rwocnt,int colcnt) throws IOException
	{
		fin=new FileInputStream(path);
		workbook=new XSSFWorkbook(fin);
		sheet=workbook.getSheet(sheetnane);
		row=sheet.getRow(rwocnt);
		cell=row.getCell(colcnt);
		style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fou=new FileOutputStream(path);
		workbook.write(fou);
		workbook.close();
		fin.close();
		fou.close();
		
	}
	public void FillRedColor(String sheetnane,int rwocnt,int colcnt) throws IOException
	{
		fin=new FileInputStream(path);
		workbook=new XSSFWorkbook(fin);
		sheet=workbook.getSheet(sheetnane);
		row=sheet.getRow(rwocnt);
		cell=row.getCell(colcnt);
		style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fou=new FileOutputStream(path);
		workbook.write(fou);
		workbook.close();
		fin.close();
		fou.close();
		
	}
	
}
