package excelUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGetter {

	static String path;

	public ExcelGetter(String path) {
		this.path = path;
	}

	public static int[] numberOf_rowsAndcollumns(int index) throws IOException {

		int[] rowsAndcollumns = new int[2];
		XSSFSheet sheet = getSheet(index);
		rowsAndcollumns[0] = sheet.getPhysicalNumberOfRows();
		rowsAndcollumns[1] = sheet.getRow(0).getPhysicalNumberOfCells();

		return rowsAndcollumns;
	}

	public static String getCellData(int index, int row, int coll) throws IOException {

		XSSFSheet sheet = getSheet(index);
		XSSFRow myRow = sheet.getRow(row);
		XSSFCell cell = myRow.getCell(coll);
		CellType type = cell.getCellType();

		return cell.getCellType() == CellType.NUMERIC ? String.valueOf(cell.getNumericCellValue())
				: cell.getStringCellValue();

	}

	public static XSSFSheet getSheet(int index) throws IOException {

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		return workbook.getSheetAt(index);
	}

	public static void closeWorkbook() {

	}

	public static String trim(String text) {

		return text.endsWith(".0") ? text = text.replace(".0", "") : text;
	}

}
