package com.njudb.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class DbfOperater {
	public jxl.Workbook readwb = null;
	// 从excel文件读取数据；生成新的DBF文件
	 public void readAndWriteDbf(String inputFilepath, String outputFilepath,String columns[]){
		 
		 	OutputStream outputStream = null;

	        try {  
	        	
	        	
	        	// 构建Workbook对象, 只读Workbook对象

				// 直接从本地文件创建Workbook

				InputStream instream = new FileInputStream(inputFilepath);

				readwb = Workbook.getWorkbook(instream);

				// Sheet的下标是从0开始

				// 获取第一张Sheet表

				Sheet readsheet = readwb.getSheet(0);

				// 获取Sheet表中所包含的总列数

				int rsColumns = readsheet.getColumns();

				// 获取Sheet表中所包含的总行数

				int rsRows = readsheet.getRows();
				
				
	            // 定义DBF文件字段  
	            DBFField[] fields = new DBFField[6];  
	            // 分别定义各个字段信息，setFieldName和setName作用相同,  
	            
	            // 只是setFieldName已经不建议使用  
	            fields[0] = new DBFField();  
	            // fields[0].setFieldName("emp_code");  
	            fields[0].setName("BMBH");  
	            fields[0].setDataType(DBFField.FIELD_TYPE_C);  
	            fields[0].setFieldLength(10);  
	            
	            
	            fields[1] = new DBFField();  
	            fields[1].setName("XMBH");  
	            fields[1].setDataType(DBFField.FIELD_TYPE_C);  
	            fields[1].setFieldLength(20);  
	            
	            fields[2] = new DBFField();  
	            fields[2].setName("EDBH");  
	            fields[2].setDataType(DBFField.FIELD_TYPE_C);  
	            fields[2].setFieldLength(20);  
	            
	            
	            fields[3] = new DBFField();  
	            fields[3].setName("LURQ");  
	            fields[3].setDataType(DBFField.FIELD_TYPE_C);  
	            fields[3].setFieldLength(20);  
	            
	            
	            fields[4] = new DBFField();  
	            fields[4].setName("ZY");  
	            fields[4].setDataType(DBFField.FIELD_TYPE_C);  
	            fields[4].setFieldLength(50);  
	            fields[4].setDecimalCount(2);  
	            
	            fields[5] = new DBFField();  
	            fields[5].setName("EDJE");  
	            fields[5].setDataType(DBFField.FIELD_TYPE_N);  
	            fields[5].setFieldLength(12);  
	            fields[5].setDecimalCount(2);  
	            
	            
	            
	            // DBFWriter writer = new DBFWriter(new File(path));  
	            // 定义DBFWriter实例用来写DBF文件  
	            DBFWriter writer = new DBFWriter();  
	            // 把字段信息写入DBFWriter实例，即定义表结构  
	            writer.setFields(fields);
	            
	            
	        	for (int i = 1; i < rsRows; i++)  
				{  
	        		Object[] rowData = new Object[6]; 
					for(int j= 0;j<columns.length;j++){
						
						if (!(columns[j]==""||columns[j].equals("")) ){
							Cell cell =  readsheet.getCell(Integer.valueOf(columns[j]).intValue(), i);
							rowData[j] = cell.getContents();
						}
						else{
							rowData[j]=null;
						}
					}
					 writer.addRecord(rowData);  
					
				}
//	            // 一条条的写入记录  
//	            Object[] rowData = new Object[3];  
//	            rowData[0] = "1000";  
//	            rowData[1] = "John";  
//	            rowData[2] = new Double(5000.00);  
           
	            // 定义输出流，并关联的一个文件  
	            outputStream =new FileOutputStream(outputFilepath);
	            // 写入数据  
	            writer.write(outputStream);  
	            // writer.write();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	        	readwb.close();
	            try {  
	            	outputStream.close();  
	            } catch (Exception e) {  
	            }  
	        }  
	 }
}
