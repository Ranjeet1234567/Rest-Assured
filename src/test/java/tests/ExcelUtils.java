package tests;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;


public class ExcelUtils {
    protected static XSSFWorkbook workbook;
    protected static XSSFSheet sheet;

    public ExcelUtils(String filename, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of row : " + rowCount);
    }
    public static void getCellCount(int rowNumber, int columnNumber) {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
        System.out.println(value);
    }
}
