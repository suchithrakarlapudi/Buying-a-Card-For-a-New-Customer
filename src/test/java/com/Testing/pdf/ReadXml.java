package com.Testing.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReadXml {
	
	 public static void main(String[] args) 
	 {
		 try   
		 {  
			  File file = new File(System.getProperty("user.dir") +"/test-output/testng-results.xml");

			    // create an instance of `JAXBContext`
			    JAXBContext context = JAXBContext.newInstance(Result.class);

			    // create an instance of `Unmarshaller`
			    Unmarshaller unmarshaller = context.createUnmarshaller();

			    // convert XML file to user object
			    Result result = (Result) unmarshaller.unmarshal(file);

			    
			    System.out.println("result------------"+result);
			    // print user object
				/*
				 * System.out.println("result------------"+result);
				 * 
				 * System.out.println("Failed:"+result.getFailed()+" , Passed :"+result.
				 * getPassed()+", Total:"+result.getTotal());
				 * 
				 * for(Suite suite : result.getSuite()) {
				 * System.out.println("name::::"+suite.getName());
				 * System.out.println("Test::::"+suite.getTest().size()); for(Test tes :
				 * suite.getTest()) { System.out.println(" test name::::"+tes.getName());
				 * System.out.println("Failed:"+result.getFailed()+" , Passed :"+result.
				 * getPassed()+", Total:"+result.getTotal()); }
				 * 
				 * }
				 */
			    
			    // Generating PDF
			    
			    File fileName =new File(System.getProperty("user.dir") + "/test-output/TestReport/CDATATestReport"+System.currentTimeMillis()+".pdf");
				
			    
				System.out.println(fileName);
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(fileName);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Document doc = new Document();
				
				PdfWriter writer = PdfWriter.getInstance(doc, fos);
					
				doc.open();
				
				
				 PdfPTable table = new PdfPTable(5);
			     table.setWidthPercentage(100);
			     
			     PdfPCell  InnerCol =new PdfPCell(new Paragraph(" Test Results Report", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD)));
				 InnerCol.setBorder(0);
				 InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
				 InnerCol.setColspan(5);
				 table.addCell(InnerCol);

				 
				InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD)));
				InnerCol.setBorder(0);
				InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
				InnerCol.setColspan(5);
				table.addCell(InnerCol);
					
					
				InnerCol =new PdfPCell(new Paragraph("Suite", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(InnerCol);
					
				InnerCol =new PdfPCell(new Paragraph("Duration", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(InnerCol);
					
				InnerCol =new PdfPCell(new Paragraph("Passed", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(InnerCol);
					
				InnerCol =new PdfPCell(new Paragraph("Failed", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(InnerCol);
					
				InnerCol =new PdfPCell(new Paragraph("Total", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(InnerCol);
			     
				for(Suite suite : result.getSuite())
				{
					 for(Test tes : suite.getTest())
				     {
						 Chunk textUnderline = new Chunk(tes.getName(),FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLUE));
						 textUnderline.setUnderline(0.5f, -1f);
						 Anchor anchor = new Anchor(textUnderline);
						 anchor.setReference("#linkTarget"+tes.getName());
						 Paragraph paragraph = new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLUE));
						 paragraph.add(anchor);
						 InnerCol =new PdfPCell(paragraph);
						 InnerCol.setBorder(Rectangle.BOX);
						 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(InnerCol);
										
						 InnerCol =new PdfPCell(new Paragraph(TimeUnit.MILLISECONDS.toSeconds(tes.getTest_duration())+" sec",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
						 InnerCol.setBorder(Rectangle.BOX);
						 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(InnerCol);
										
						 if(tes.getName().equals("Test"))
						 {
							InnerCol =new PdfPCell(new Paragraph(0+""));
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
											
							InnerCol =new PdfPCell(new Paragraph(0+""));                 
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
											
							InnerCol =new PdfPCell(new Paragraph(0+""));                 
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
						}
						else {
							Paragraph p2=new  Paragraph(result.getPassed()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL));
							InnerCol =new PdfPCell(p2);
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
										
							InnerCol =new PdfPCell(new Paragraph(result.getFailed()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
										
							InnerCol =new PdfPCell(new Paragraph(result.getTotal()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
							InnerCol.setBorder(Rectangle.BOX);
							InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
							table.addCell(InnerCol);
						}

				     }
							 
					 InnerCol =new PdfPCell(new Paragraph("Total", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
					 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
					 table.addCell(InnerCol);
							
					 InnerCol =new PdfPCell(new Paragraph(TimeUnit.MILLISECONDS.toSeconds(suite.getSuite_duration())+" sec",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
					 InnerCol.setBorder(Rectangle.BOX);
					 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
					 table.addCell(InnerCol);
							
					 Paragraph p2=new  Paragraph(result.getPassed()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL));
					 InnerCol =new PdfPCell(p2);
					 InnerCol.setBorder(Rectangle.BOX);
					 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
					 table.addCell(InnerCol);
							
					 InnerCol =new PdfPCell(new Paragraph(result.getFailed()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
					 InnerCol.setBorder(Rectangle.BOX);
					 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
					 table.addCell(InnerCol);
							
					 InnerCol =new PdfPCell(new Paragraph(result.getTotal()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));                 
					 InnerCol.setBorder(Rectangle.BOX);
					 InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
					 table.addCell(InnerCol);
				}
				
				
				
				PdfPTable InnerTable2 = new PdfPTable(2);
				InnerTable2.setWidthPercentage(100);
					
				InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
				InnerCol.setBorder(0);
				InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
				InnerCol.setColspan(2);
				InnerTable2.addCell(InnerCol);
					
				InnerCol =new PdfPCell(new Paragraph(" Details of Test Cases", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
				InnerCol.setBorder(0);
				InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
				InnerCol.setColspan(2);
				InnerTable2.addCell(InnerCol);
					
				for(Suite suite : result.getSuite())
				{
					 for(Test tes : suite.getTest())
				    {
						InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
						InnerCol.setBorder(0);
						InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						InnerCol.setColspan(2);
						InnerTable2.addCell(InnerCol);
						
						Anchor anchorTarget = new Anchor("Name of Test", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD));
						anchorTarget.setName("linkTarget"+tes.getName());
						Paragraph targetParagraph = new Paragraph();
						targetParagraph.setSpacingBefore(50);
						targetParagraph.add(anchorTarget);
						
						InnerCol =new PdfPCell(targetParagraph);
						InnerCol.setBorder(0);
						InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						InnerTable2.addCell(InnerCol);
						
						InnerCol =new PdfPCell(new Paragraph("Duration", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
						InnerCol.setBorder(0);
						InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						InnerTable2.addCell(InnerCol);
					
						
						Chunk textUnderline = new Chunk(tes.getName(),FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLUE));
						textUnderline.setUnderline(0.5f, -1f);
						Anchor anchor = new Anchor(textUnderline);
						anchor.setReference("#linkTarget"+tes.getName());
						Paragraph paragraph = new Paragraph("",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLUE));
						paragraph.add(anchor);
						
						//Paragraph p1=new  Paragraph(tes.getName(),FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL));
						InnerCol =new PdfPCell(paragraph);
						InnerCol.setBorder(Rectangle.BOX);
						InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						InnerTable2.addCell(InnerCol);
						
						InnerCol =new PdfPCell(new Paragraph(TimeUnit.MILLISECONDS.toSeconds(tes.getTest_duration())+" sec",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));
						InnerCol.setBorder(Rectangle.BOX);
						InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
						InnerTable2.addCell(InnerCol);
						
						
						if(!tes.getName().equals("Test"))
						{
							for(Class cm : tes.getClassmethod())
							{
								PdfPTable InnerTable3 = new PdfPTable(4);
								InnerTable3.setWidths(new int[] {40,10,10,40});
								InnerTable3.setWidthPercentage(100);
								
								
								InnerCol =new PdfPCell(new Paragraph("Name of Test Method", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
								InnerCol.setBorder(Rectangle.BOX);
								InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
								InnerTable3.addCell(InnerCol);
								
								InnerCol =new PdfPCell(new Paragraph("Duration", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
								InnerCol.setBorder(Rectangle.BOX);
								InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
								InnerTable3.addCell(InnerCol);
								
								InnerCol =new PdfPCell(new Paragraph("Status", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
								InnerCol.setBorder(Rectangle.BOX);
								InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
								InnerTable3.addCell(InnerCol);
								
								InnerCol =new PdfPCell(new Paragraph("Message", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
								InnerCol.setBorder(Rectangle.BOX);
								InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
								InnerTable3.addCell(InnerCol);
							
								for(TestMethod tm :cm.getTestmethod())
								{
									
									
									/*
									 * Chunk textUnderline = new
									 * Chunk(tm.getName(),FontFactory.getFont(FontFactory.HELVETICA, 11,
									 * Font.NORMAL, BaseColor.BLUE)); textUnderline.setUnderline(0.5f, -1f); Anchor
									 * anchor = new Anchor(textUnderline); anchor.setReference("#linkTarget");
									 * Paragraph paragraph = new
									 * Paragraph("",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL,
									 * BaseColor.BLUE)); paragraph.add(anchor);
									 */
									InnerCol =new PdfPCell(new Paragraph(tm.getName(),FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));
									InnerCol.setBorder(Rectangle.BOX);
									InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
									InnerTable3.addCell(InnerCol);
									
									InnerCol =new PdfPCell(new Paragraph(TimeUnit.MILLISECONDS.toSeconds(tm.getDurationms())+" sec",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));
									InnerCol.setBorder(Rectangle.BOX);
									InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
									InnerTable3.addCell(InnerCol);
									
									InnerCol =new PdfPCell(new Paragraph(tm.getTest_status(),FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));
									InnerCol.setBorder(Rectangle.BOX);
									InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
									InnerTable3.addCell(InnerCol);
									
									InnerCol =new PdfPCell(new Paragraph(tm.getException()+"",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL)));
									InnerCol.setBorder(Rectangle.BOX);
									InnerCol.setHorizontalAlignment(Element.ALIGN_LEFT);
									InnerTable3.addCell(InnerCol);
										
								}
								
								InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
								InnerCol.setBorder(0);
								InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
								InnerCol.setColspan(4);
								InnerTable3.addCell(InnerCol);
								
								InnerCol =new PdfPCell();
								InnerCol.addElement(InnerTable3);
								InnerCol.setBorder(0);
								InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
								InnerCol.setColspan(2);
								InnerTable2.addCell(InnerCol);
					    
							}
						}
				    }

				}
					
					InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
					InnerCol.setBorder(0);
					InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
					InnerCol.setColspan(2);
					InnerTable2.addCell(InnerCol);
					
					InnerCol =new PdfPCell();
					InnerCol.addElement(InnerTable2);
					InnerCol.setBorder(0);
					InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
					InnerCol.setColspan(5);
					table.addCell(InnerCol);
					
					
					PdfPTable InnerTable4 = new PdfPTable(1);
					InnerTable4.setWidthPercentage(100);

					Anchor anchorTarget = new Anchor("Screenshots");
					anchorTarget.setName("linkTargetLoginTest");
					Paragraph targetParagraph = new Paragraph();
					targetParagraph.setSpacingBefore(50);
					targetParagraph.add(anchorTarget);
					InnerCol =new PdfPCell(targetParagraph);
					InnerCol.setBorder(0);
					InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
					InnerCol.setColspan(1);
					InnerTable4.addCell(InnerCol);
					
					Image im = Image.getInstance(System.getProperty("user.dir") +"/test-output/screenshots/excelutil@Sheet1@test1.png");
					InnerTable4.addCell(im);
					
					InnerCol =new PdfPCell(new Paragraph("\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
					InnerCol.setBorder(0);
					InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
					InnerCol.setColspan(1);
					InnerTable4.addCell(InnerCol);
					
					InnerCol =new PdfPCell();
					InnerCol.addElement(InnerTable4);
					InnerCol.setBorder(0);
					InnerCol.setHorizontalAlignment(Element.ALIGN_CENTER);
					InnerCol.setColspan(5);
					table.addCell(InnerCol);
					
			 
			        doc.add(table);
			 
			        doc.close();
			        writer.close();
			    
		 }   
		 catch (JAXBException | DocumentException | IOException ex) {
			    ex.printStackTrace(); 
		 }  
		 
	}  
	 
}
