package utility;

        	import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;

    public class ExcelUtils {

        		private static XSSFSheet ExcelWSheet;

        		private static XSSFWorkbook ExcelWBook;

        		private static XSSFCell Cell;

        		private static XSSFRow Row;

    		//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    		public static void setExcelFile(String Path,String SheetName) throws Exception {

       			try {

           			// Open the Excel file

					FileInputStream ExcelFile = new FileInputStream(Path);

					// Access the required test data sheet

					ExcelWBook = new XSSFWorkbook(ExcelFile);

					ExcelWSheet = ExcelWBook.getSheet(SheetName);

					} catch (Exception e){

						throw (e);

					}

			}

    		//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    	    public static String getCellData(int RowNum, int ColNum) throws Exception{

       			try{

          			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

          			String CellData = Cell.getStringCellValue();

          			return CellData;

          			}catch (Exception e){

						return"";

          			}

		    }

    	    public static void setCellStyle(int rowNumber, int cellNumber) throws Exception {

    	    	XSSFSheet sheet = ExcelWBook.getSheetAt(0);
    	    	XSSFRow row = sheet.getRow(rowNumber);
    	    	XSSFCell cell = row.getCell(cellNumber);
//    			XSSFCellStyle my_style = ExcelWBook.createCellStyle();
//    			my_style.setBorderBottom(XSSFCellStyle.BORDER_THICK);
//    			my_style.setBorderColor(BorderSide.BOTTOM, new XSSFColor(Color.RED));
    	    	
    	                                    
    	         // Create cell style 
    	        //CellStyle style= ExcelWBook.createCellStyle();;
    	        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    	        //style.setAlignment(CellStyle.ALIGN_CENTER);
    	        // Setting font to style
    	        XSSFCellStyle style = ExcelWBook.createCellStyle();
    	        style.setBorderBottom(XSSFCellStyle.BORDER_THICK);
    			style.setBorderColor(BorderSide.BOTTOM, new XSSFColor(Color.RED));
    	        
    	        
    	        // Setting cell style
    	        cell.setCellStyle(style);
    	    }
    	    
    	    
    	    //This method is to write in the Excel cell, Row num and Col num are the parameters

    		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

       			try{
          			Row  = ExcelWSheet.getRow(RowNum);
          			
          			if(Row == null){
          				
          				Row = ExcelWSheet.createRow(RowNum);
          			}

					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
					

					if (Cell == null) {

						Cell = Row.createCell(ColNum);

						Cell.setCellValue(Result);

						} else {

							Cell.setCellValue(Result);

						}

          // Constant variables Test Data path and Test Data file name

          				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

          				ExcelWBook.write(fileOut);

          				fileOut.flush();

 						fileOut.close();

						}catch(Exception e){

							throw (e);

					}

				}

	}
