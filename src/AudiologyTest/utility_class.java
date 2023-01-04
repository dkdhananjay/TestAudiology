package AudiologyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utility_class 
{
	
	public String getdata(String row, String col) throws Exception, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\Documents\\selenium files\\data.xlsx");
		String data=WorkbookFactory.create(file).getSheet("data").getRow(0).getCell(0).getStringCellValue();
//		String data = sh.getRow(0).getCell(1).getStringCellValue();
		return data;
		
		
	}  
		
		
	

}
