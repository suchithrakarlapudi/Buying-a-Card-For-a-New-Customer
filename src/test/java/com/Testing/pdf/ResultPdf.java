package com.Testing.pdf;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ResultPdf {

	 public static void main(String[] args) 
	 {
		 try   
		 {  
			File fileName =new File(System.getProperty("user.dir") + "/test-output/TestReport/pdf-"+System.currentTimeMillis()+".pdf");
		
			System.out.println(fileName);
			FileOutputStream fos = new FileOutputStream(fileName);
				
			Document doc = new Document();
				
			PdfWriter writer = PdfWriter.getInstance(doc, fos);
				
			doc.open();
			
			
			 PdfPTable table = new PdfPTable(3); // 3 columns.
		     table.setWidthPercentage(100);
		     
		     PdfPCell cell1 = new PdfPCell(new Paragraph("Suite"));
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell2 = new PdfPCell(new Paragraph("Passed"));
		        cell2.setPaddingLeft(10);
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell3 = new PdfPCell(new Paragraph("Failed"));
		        cell3.setPaddingLeft(10);
		        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			
		        table.addCell(cell1);
		        table.addCell(cell2);
		        table.addCell(cell3);
		 
		        doc.add(table);
		 
		        doc.close();
		        writer.close();
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
	 }
}
