package com.crm.generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * this method is used to retrieve the data from excel sheet
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 * @author Praveen
	 */
	public String getExcelData(String sheetName,int row,int cell) throws Throwable
	{
		//FileInputStream fis=new FileInputStream("./Book1.xlsx");
		FileInputStream fis=new FileInputStream(iPathConstant.EXCELFILE_PATH);
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
}
