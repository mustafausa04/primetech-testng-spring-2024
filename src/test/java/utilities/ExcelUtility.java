package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtility {
    //what we need to do is :
    //1. open excel file
    //2. load/open excel sheet
    //3. read/open workbook
    //4. read cells

    //variables
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    //this method to open the file and read it
    /**
     * Method will open/load and excel sheet
     * @param filePath the path of the excel file
     * @param sheetName the sheet name inside the workbook : example "Sheet1" or "Sheet2"
     */
    public static void getExcelInstance(String filePath , String sheetName ){

        try {//here we will say open the work book file which is the excel file located in the (dataset) folder if you
             //can't find it throw exception
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);//this is to read name of the sheet like sheet1, sheet2 ...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //this method to count the number of rows in the excel sheet
    /**
     *
     * @return the number of rows present in the Excel Sheet
     */
    public static int getRowCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }


    //this method to count the number of columns in the excel sheet
    /**
     *
     * @return the number of column present in the Excel sheet
     */
    public static int getColCount(){
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }


    //this method is to get the value inside a specific row and column which mean inside the (cell)
    /**
     *
     * @param rowNumber the row number where the cell is located
     * @param colNumber the col number where the cell is located
     * @return the value of the cell at the specific row and col numbers
     */
    public static String getCellDataString(int rowNumber , int colNumber){
        String cellData = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();//to get the cell value
        return cellData;
    }


    //this method is to create a multi dimension array which is an array accepts different type of data string, int...
    /**
     *
     * @return two dimentional array of the excel sheet
     */
    public static Object[][] getDataSet(){
        int rowCount = ExcelUtility.getRowCount();
        int colCount = ExcelUtility.getColCount();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount ; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = getCellDataString(i,j);
                data[i][j] = cellData;
            }
        }
        return data;
    }

}
