package com.bakerysystem;


import com.bakerysystem.Model.Order;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author keoagile
 */
public class Reports {
    
    public void generateReport(ArrayList<Order> listOfOrders){
        try
    {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\adrian\\Desktop\\delivered.pdf"));
        document.open();
        
        //Add Image
//    Image image1 = Image.getInstance("C:\\Users\\adrian\\Desktop\\picFrom.jpg");
//    //Fixed Positioning
//    image1.setAbsolutePosition(100f, 550f);
//    //Scale to new height and new width of image
//    image1.scaleAbsolute(200, 200);
//    //Add to document
//    document.add(image1);
 
    String imageUrl = "C:\\Users\\adrian\\Desktop\\doughknotlogo.png";
    Image image2 = Image.getInstance(imageUrl);
    //image2.setAbsolutePosition(100f, 100f);
    image2.scaleAbsolute(250f, 200f);
    document.add(image2);
//        
        
        PdfPTable table = new PdfPTable(7); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table
 
        //Set Column widths
        float[] columnWidths = {0.7f, 0.8f, 1f, 1f, 1f, 1f, 1f};
        table.setWidths(columnWidths);
 
        PdfPCell cell1 = new PdfPCell(new Paragraph("Order ID"));
        cell1.setBorderColor(BaseColor.BLUE);
        cell1.setPaddingLeft(5);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph("Customer ID"));
        cell2.setBorderColor(BaseColor.GREEN);
        cell2.setPaddingLeft(5);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell3 = new PdfPCell(new Paragraph("Delivery Address"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(15);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell4 = new PdfPCell(new Paragraph("Order Status"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(12);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell5 = new PdfPCell(new Paragraph("Payment Status"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell6 = new PdfPCell(new Paragraph("Order Date"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell7 = new PdfPCell(new Paragraph("Order Price"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        //To avoid having the cell border and the content overlap, if you are having thick cell borders
        //cell1.setUserBorderPadding(true);
        //cell2.setUserBorderPadding(true);
        //cell3.setUserBorderPasdding(true);
 //Headings
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        
        for(Order ord: listOfOrders){
            table.addCell(""+ord.getOrderID()+"");
            table.addCell(""+ord.getCustomerId()+"");
            table.addCell(""+ord.getDeliveryAddressId()+"");
            table.addCell(""+ord.getOrderStatus()+"");
            table.addCell(""+ord.getPaymentStatus()+"");
            table.addCell(""+ord.getOrderDate()+"");
            table.addCell(""+ord.getTotalPrice()+"");
        }
        
        document.add(table);
 
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    
    }
}
