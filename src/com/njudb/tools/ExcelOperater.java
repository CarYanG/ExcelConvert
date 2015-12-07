package com.njudb.tools;

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStream;

import jxl.Cell;

import jxl.CellType;

import jxl.Sheet;

import jxl.Workbook;

import jxl.write.Label;

public class ExcelOperater

{
	public jxl.Workbook readwb = null;

	// 从excel文件读取数据；生成新的excel文件
	public void readAndWriteExcel(String inputFilepath, String outputFilepath,String columns[]) {
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

			// 获取指定单元格的对象引用

			for (int i = 0; i < rsRows; i++)
			{
				for (int j = 0; j < rsColumns; j++)

				{

					Cell cell = readsheet.getCell(j, i);

					System.out.print(cell.getContents() + " ");

				}
				System.out.println();
				
				
				

				// 利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄

				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(

						outputFilepath));

				// 读取第一张工作表

				jxl.write.WritableSheet ws = wwb.createSheet("First Sheet",0);

				Label BMBH=new Label(0,0,"BMBH");
				ws.addCell(BMBH);
				
				Label XMBH=new Label(1,0,"XMBH");
				ws.addCell(XMBH);
				
				Label EDBH=new Label(0,2,"EDBH");
				ws.addCell(EDBH);
				
				Label LURQ=new Label(0,3,"LURQ");
				ws.addCell(LURQ);
				
				Label ZY=new Label(0,4,"ZY");
				ws.addCell(ZY);
				
				Label EDJE=new Label(0,5,"EDJE");
				ws.addCell(EDJE);				
				



				wwb.write();

				wwb.close();
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			readwb.close();

		}
	}

}
