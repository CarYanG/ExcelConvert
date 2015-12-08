package com.njudb.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Templates;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;

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
			
			
			
			// �����Ѿ�������Excel������,�����µĿ�д���Excel������
			
			OutputStream outputStream = new FileOutputStream(outputFilepath);

			jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(outputStream);

			// ��ȡ��һ�Ź�����

			jxl.write.WritableSheet ws = wwb.createSheet("First Sheet",0);

			Label BMBH=new Label(0,0,"BMBH");
			ws.addCell(BMBH);
			
			Label XMBH=new Label(1,0,"XMBH");
			ws.addCell(XMBH);
			
			Label EDBH=new Label(2,0,"EDBH");
			ws.addCell(EDBH);
			
			Label LURQ=new Label(3,0,"LURQ");
			ws.addCell(LURQ);
			
			Label ZY=new Label(4,0,"ZY");
			ws.addCell(ZY);
			
			
			//��ʽ��Ϊ������
			Label EDJE=new Label(5,0,"EDJE");
			ws.addCell(EDJE);				
			

			// ��ȡָ����Ԫ��Ķ�������

			for (int i = 1; i < rsRows; i++)  
			{
				for(int j= 0;j<columns.length;j++){
					
					if (!(columns[j]==""||columns[j].equals("")) ){
						Cell cell =  readsheet.getCell(Integer.valueOf(columns[j]).intValue(), i);
						
						Label temp=new Label(j,i,cell.getContents());
						
						ws.addCell(temp);
					}

					
				}
				
			}

			wwb.write();

			wwb.close();
			outputStream.close();
			instream.close();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			readwb.close();
			
		}
	}

}
