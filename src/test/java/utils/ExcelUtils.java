package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    //to get the excel row count
    public  static void main(String[] args){
        getRowCount();
        getCellData();
    }

    //to get the dat from excel
    public static void getCellData(){

        try {

            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(1).getCell(1));

           // String value =  sheet.getRow(1).getCell(0).getStringCellValue();
            System.out.println(value);

        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

    }

    public static void getRowCount(){
        try {

            String excelPath = "./data/TestData.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows :" + rowCount);

        }catch (Exception exp){

            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

    }
}
