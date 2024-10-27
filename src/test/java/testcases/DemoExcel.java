package testcases;

import utilities.ExcelUtility;

public class DemoExcel {


    public static void main(String[] args) {

        //we will call the first method to open the file and read it and we will pass the path of the (xlsx) file and
        //in the second parameter we will pass the sheet number you have to type it exactly the same which is (sheet1)
        ExcelUtility.getExcelInstance("dataset/data.xlsx","Sheet1");

        System.out.println("Row count is : " + ExcelUtility.getRowCount());//to print rows number
        System.out.println("Col count is : " + ExcelUtility.getColCount());//to print columns number

        System.out.println(ExcelUtility.getCellDataString(0,0));//username in cell 0,0
        System.out.println(ExcelUtility.getCellDataString(1,0));//username in cell 1,0
        System.out.println(ExcelUtility.getCellDataString(2,0));//username in cell 2,0
        System.out.println("-------------------------");

        //creating variables to use for loop
        int rowCount = ExcelUtility.getRowCount();
        int colCount = ExcelUtility.getColCount();
        for (int i = 0; i < rowCount ; i++) {
            for (int j = 0; j < colCount; j++) { // i j   i j     i  j     i j     i  j   i  j
                System.out.print(ExcelUtility.getCellDataString(i,j) + "  |  "); //(0,0) (0,1)  | (1,0) , (1,1)  | (2,0) (2,1)
            }
            System.out.println();
        }

    }


}