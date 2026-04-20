
package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public String excelReader(String sheetName, String rowName, String columName)throws IOException
	{
		String filepath =System.getProperty("user.dir")+"/src/test/resources/saucedemo.xlsx";
		
		String cellvalue= null;
		try(FileInputStream fis=new FileInputStream(filepath); Workbook workbook=new XSSFWorkbook(fis))
		{
			Sheet sheet = workbook.getSheet(sheetName);
			int rowNum = findRowIndex(sheet,rowName);
			if(rowNum !=-1) 
			{
				Row row= sheet.getRow(rowNum);
				int cellNum= findColumnIndex(sheet,columName);
				if(cellNum != -1) 
				{
					Cell cell =row.getCell(cellNum);
					if(cell != null) 
					{
						cellvalue = cell.toString();
					}
					else
					{
						System.out.println("Cell with name "+columName +" not found un row "+rowName);
					}
				}
				else
				{
					System.out.println("Colum with name "+columName +" not found un sheet "+sheetName);
				}
			}
			else
			{
				System.out.println("Row with name "+rowName +" not found un sheet "+sheetName);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return cellvalue;
	}

	//fine row
	private int findRowIndex(Sheet sheet, String rowName) 
	{
		for(Row row: sheet) 
		{
			Cell cell= row.getCell(0);
			if(cell != null && cell.toString().equals(rowName))
			{
				return row.getRowNum();
			}
		}
			return -1;
	}
	
	//Find column
	private int findColumnIndex(Sheet sheet, String columName) 
	{
		Row headerRow = sheet.getRow(0);
		for(Cell cell: headerRow) 
		{
			if(cell != null && cell.toString().equals(columName))
			{
				return cell.getColumnIndex();
			}
		}
			return -1;
	}
	
	public static String readExcel(String sheetName, String rowName, String columName) throws IOException
	{
		ExcelReader reader = new ExcelReader();
		String cellvalue = reader.excelReader(sheetName, rowName, columName);
		return cellvalue;
	}
	
}


