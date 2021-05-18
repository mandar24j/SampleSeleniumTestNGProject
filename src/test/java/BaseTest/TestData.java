package BaseTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestData {
    static String excelDataLocation = "src//test//resources//ExcelTestDataFiles//SecurityAdminTestData.xlsx";
    private static FileInputStream fsIP;
    private static XSSFWorkbook wb;
    private static XSSFSheet worksheet;

    @DataProvider(parallel = false)
    public static Object[][] AddEntitySuccessfully(Method m) {


        Object[][] arrayObject = getExcelData(excelDataLocation, "Entity", m.getName());

        return arrayObject;
    }

    @DataProvider(parallel = false)
    public static Object[][] ErrorWhileAddingEntity(Method m) {


        Object[][] arrayObject = getExcelData(excelDataLocation, "Entity", m.getName());

        return arrayObject;
    }

    static Object[][] getExcelData(String excelPath, String sheetName, String testCaseName) {
        String[][] arrayExcelData = null;
        try {
            fsIP = new FileInputStream(excelPath);
            wb = new XSSFWorkbook(fsIP);
            worksheet = wb.getSheet(sheetName);

            int totalNoOfCols = worksheet.getRow(0).getPhysicalNumberOfCells();
            int totalNoOfRows = worksheet.getPhysicalNumberOfRows();
            System.out.println("Columns " + totalNoOfCols);
            System.out.println("Rows " + totalNoOfRows);
            arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols - 1];

            for (int i = 1; i < totalNoOfRows; i++) {
                if (worksheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                    for (int j = 1; j < totalNoOfCols; j++) {
                        if (worksheet.getRow(i).getCell(j) != null) {
                            worksheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                            arrayExcelData[i - 1][j - 1] = worksheet.getRow(i).getCell(j).getStringCellValue();
                        }
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
}
