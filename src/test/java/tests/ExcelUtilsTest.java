package tests;

public class ExcelUtilsTest {
    public static void main(String[] args) {
        String excelSheetPath = "/testData/data.xlsx";
        String currentDir = System.getProperty("user.dir");
        String filename = (currentDir + excelSheetPath);
        String sheetName="Data";
        ExcelUtils excelUtils=new ExcelUtils(filename,sheetName);
        excelUtils.getRowCount();
        excelUtils.getCellCount(1,0);
        excelUtils.getCellCount(1,1);
        excelUtils.getCellCount(1,2);
    }
}
