import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;


public class ItratorCellRow {

	
	public static void main(String[] args) {
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.getSheetAt(0);
		for(Iterator<Row> rit = sheet.rowIterator();rit.hasNext();){
			Row row = rit.next();
			for(Iterator<Cell> cit=row.cellIterator();cit.hasNext();){
				Cell cell = cit.next();
				//do something
			}
		}
		sheet = wb.getSheetAt(0);
		for(Row row :sheet){
			for(Cell cell:row){
				//do something here
			}
		}
		Sheet sheet1 = wb.getSheetAt(1);
		for(Row row :sheet1){
			for(Cell cell: row){
				CellReference cellRef = new CellReference(row.getRowNum(),cell.getColumnIndex());
				System.out.println(cellRef.formatAsString());
				System.out.println("--");
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getRichStringCellValue().getString());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)){
						System.out.println(cell.getDateCellValue());
					}else{
						System.out.println(cell.getNumericCellValue());
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					System.out.println(cell.getCellFormula());
					break;
				default:
					System.out.println();
					break;
				}
			}
		}

	}

}
