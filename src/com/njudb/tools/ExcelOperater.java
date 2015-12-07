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

	// ��excel�ļ���ȡ���ݣ������µ�excel�ļ�
	public void readAndWriteExcel(String inputFilepath, String outputFilepath,String columns[]) {
		try {
			// ����Workbook����, ֻ��Workbook����

			// ֱ�Ӵӱ����ļ�����Workbook

			InputStream instream = new FileInputStream(inputFilepath);

			readwb = Workbook.getWorkbook(instream);

			// Sheet���±��Ǵ�0��ʼ

			// ��ȡ��һ��Sheet��

			Sheet readsheet = readwb.getSheet(0);

			// ��ȡSheet������������������

			int rsColumns = readsheet.getColumns();

			// ��ȡSheet������������������

			int rsRows = readsheet.getRows();

			// ��ȡָ����Ԫ��Ķ�������

			for (int i = 0; i < rsRows; i++)
			{
				for (int j = 0; j < rsColumns; j++)

				{

					Cell cell = readsheet.getCell(j, i);

					System.out.print(cell.getContents() + " ");

				}
				System.out.println();
				
				
				

				// �����Ѿ�������Excel������,�����µĿ�д���Excel������

				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(

						outputFilepath));

				// ��ȡ��һ�Ź�����

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
