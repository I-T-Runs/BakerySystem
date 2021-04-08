package com.bakerysystem;

import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.Ingredient;
import com.bakerysystem.Model.Order;
import com.bakerysystem.Services.CustomerService;
import com.bakerysystem.Services.CustomerServiceImpl;
import com.bakerysystem.Services.IngredientServiceImpl;
import com.bakerysystem.Services.OrderServiceImpl;
import com.bakerysystem.Services.Reporter;
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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

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
    
    public void generateReport(){
        try
    {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\adrian\\Desktop\\delivered.pdf"));
        document.open();
        
    String imageUrl = "C:\\Users\\adrian\\Desktop\\doughknotlogo.png";
    Image image2 = Image.getInstance(imageUrl);
    //image2.setAbsolutePosition(100f, 100f);
    image2.scaleAbsolute(250f, 200f);
    document.add(image2);
        
    Paragraph ordersPlaced = new Paragraph("Total Number Of Orders Placed ");
    Paragraph totalOrdersPlaced = new Paragraph("___________________________________________________________" +new Reporter().getNumOrdersPlaced());
    document.add(ordersPlaced);
    document.add(totalOrdersPlaced);

    
    document.add(new Paragraph(" "));
    Paragraph ordersDelivered = new Paragraph("Total Number Of Orders Delivered ");
    Paragraph totalOrdersDelivered = new Paragraph("___________________________________________________________" +new Reporter().getNumOrdersDelivered());
    document.add(ordersDelivered);
    document.add(totalOrdersDelivered);

    
    document.add(new Paragraph(" "));
    Paragraph ordersOutstanding = new Paragraph("Total Number Of Orders Outstanding");
    Paragraph totalOrdersOutstanding = new Paragraph("___________________________________________________________" +new Reporter().getNumOrdersOutstanding());
    document.add(ordersOutstanding);
    document.add(totalOrdersOutstanding);
   
    
    document.add(new Paragraph(" "));
    Paragraph customers = new Paragraph("Total Number Of Customers");
    Paragraph customerNum = new Paragraph("___________________________________________________________" +new CustomerServiceImpl().getAllCustomers().size());
    document.add(customers);
    document.add(customerNum);
    
        ArrayList<Order> listOfOrdersPlaced = new OrderServiceImpl().getOrdersByStatus("PREPARING");
        PdfPTable table = new PdfPTable(7); 
        table.setWidthPercentage(100); 
        table.setSpacingBefore(10f); 
        table.setSpacingAfter(10f); 
 
        //Set Column widths
        float[] columnWidths = {0.7f, 0.8f, 1f, 1f, 1f, 1f, 1f};
        table.setWidths(columnWidths);
 
        PdfPCell cell1 = new PdfPCell(new Paragraph("Order ID"));
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(5);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph("Customer ID"));
        cell2.setBorderColor(BaseColor.BLACK);
        cell2.setPaddingLeft(5);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell3 = new PdfPCell(new Paragraph("Delivery Address"));
        cell3.setBorderColor(BaseColor.BLACK);
        cell3.setPaddingLeft(15);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell4 = new PdfPCell(new Paragraph("Order Status"));
        cell4.setBorderColor(BaseColor.BLACK);
        cell4.setPaddingLeft(12);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell5 = new PdfPCell(new Paragraph("Payment Status"));
        cell5.setBorderColor(BaseColor.BLACK);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell6 = new PdfPCell(new Paragraph("Order Date"));
        cell6.setBorderColor(BaseColor.BLACK);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell7 = new PdfPCell(new Paragraph("Order Price"));
        cell7.setBorderColor(BaseColor.BLACK);
        cell7.setPaddingLeft(10);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        
        for(Order ord: listOfOrdersPlaced){
            table.addCell(""+ord.getOrderID()+"");
            table.addCell(""+ord.getCustomerId()+"");
            table.addCell(""+ord.getDeliveryAddressId()+"");
            table.addCell(""+ord.getOrderStatus()+"");
            table.addCell(""+ord.getPaymentStatus()+"");
            table.addCell(""+ord.getOrderDate()+"");
            table.addCell(""+ord.getTotalPrice()+"");
        }
        
        document.add(table);
        document.newPage();
        
        ArrayList<Order> listOfOrdersDelivered = new OrderServiceImpl().getOrdersByStatus("DELIVERED");
        PdfPTable table2 = new PdfPTable(7); 
        table2.setWidthPercentage(100); 
        table2.setSpacingBefore(10f); 
        table2.setSpacingAfter(10f); 
 
        //Set Column widths
        //float[] columnWidths2 = {0.7f, 0.8f, 1f, 1f, 1f, 1f, 1f};
        table2.setWidths(columnWidths);
 
        PdfPCell Dcell1 = new PdfPCell(new Paragraph("Order ID"));
        Dcell1.setBorderColor(BaseColor.BLACK);
        Dcell1.setPaddingLeft(5);
        Dcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Dcell2 = new PdfPCell(new Paragraph("Customer ID"));
        Dcell2.setBorderColor(BaseColor.BLACK);
        Dcell2.setPaddingLeft(5);
        Dcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Dcell3 = new PdfPCell(new Paragraph("Delivery Address"));
        Dcell3.setBorderColor(BaseColor.BLACK);
        Dcell3.setPaddingLeft(15);
        Dcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Dcell4 = new PdfPCell(new Paragraph("Order Status"));
        Dcell4.setBorderColor(BaseColor.BLACK);
        Dcell4.setPaddingLeft(12);
        Dcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Dcell5 = new PdfPCell(new Paragraph("Payment Status"));
        Dcell5.setBorderColor(BaseColor.BLACK);
        Dcell5.setPaddingLeft(10);
        Dcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Dcell6 = new PdfPCell(new Paragraph("Order Date"));
        Dcell6.setBorderColor(BaseColor.BLACK);
        Dcell6.setPaddingLeft(10);
        Dcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Dcell7 = new PdfPCell(new Paragraph("Order Price"));
        Dcell7.setBorderColor(BaseColor.BLACK);
        Dcell7.setPaddingLeft(10);
        Dcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        Dcell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        table2.addCell(Dcell1);
        table2.addCell(Dcell2);
        table2.addCell(Dcell3);
        table2.addCell(Dcell4);
        table2.addCell(Dcell5);
        table2.addCell(Dcell6);
        table2.addCell(Dcell7);
        
        for(Order ord: listOfOrdersDelivered){
            table2.addCell(""+ord.getOrderID()+"");
            table2.addCell(""+ord.getCustomerId()+"");
            table2.addCell(""+ord.getDeliveryAddressId()+"");
            table2.addCell(""+ord.getOrderStatus()+"");
            table2.addCell(""+ord.getPaymentStatus()+"");
            table2.addCell(""+ord.getOrderDate()+"");
            table2.addCell(""+ord.getTotalPrice()+"");
        }
        
        document.add(table2);
        document.newPage();
        
        ArrayList<Order> listOfCancelledOrders = new OrderServiceImpl().getOrdersByStatus("CANCELLED");
        PdfPTable table3 = new PdfPTable(7); 
        table3.setWidthPercentage(100); 
        table3.setSpacingBefore(10f); 
        table3.setSpacingAfter(10f); 
 
        //Set Column widths
        //float[] columnWidths = {0.7f, 0.8f, 1f, 1f, 1f, 1f, 1f};
        table3.setWidths(columnWidths);
 
        PdfPCell Ccell1 = new PdfPCell(new Paragraph("Order ID"));
        Ccell1.setBorderColor(BaseColor.BLACK);
        Ccell1.setPaddingLeft(5);
        Ccell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Ccell2 = new PdfPCell(new Paragraph("Customer ID"));
        Ccell2.setBorderColor(BaseColor.BLACK);
        Ccell2.setPaddingLeft(5);
        Ccell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Ccell3 = new PdfPCell(new Paragraph("Delivery Address"));
        Ccell3.setBorderColor(BaseColor.BLACK);
        Ccell3.setPaddingLeft(15);
        Ccell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Ccell4 = new PdfPCell(new Paragraph("Order Status"));
        Ccell4.setBorderColor(BaseColor.BLACK);
        Ccell4.setPaddingLeft(12);
        Ccell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Ccell5 = new PdfPCell(new Paragraph("Payment Status"));
        Ccell5.setBorderColor(BaseColor.BLACK);
        Ccell5.setPaddingLeft(10);
        Ccell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Ccell6 = new PdfPCell(new Paragraph("Order Date"));
        Ccell6.setBorderColor(BaseColor.BLACK);
        Ccell6.setPaddingLeft(10);
        Ccell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Ccell7 = new PdfPCell(new Paragraph("Order Price"));
        Ccell7.setBorderColor(BaseColor.BLACK);
        Ccell7.setPaddingLeft(10);
        Ccell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        Ccell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        table3.addCell(Ccell1);
        table3.addCell(Ccell2);
        table3.addCell(Ccell3);
        table3.addCell(Ccell4);
        table3.addCell(Ccell5);
        table3.addCell(Ccell6);
        table3.addCell(Ccell7);
        
        for(Order ord: listOfOrdersPlaced){
            table3.addCell(""+ord.getOrderID()+"");
            table3.addCell(""+ord.getCustomerId()+"");
            table3.addCell(""+ord.getDeliveryAddressId()+"");
            table3.addCell(""+ord.getOrderStatus()+"");
            table3.addCell(""+ord.getPaymentStatus()+"");
            table3.addCell(""+ord.getOrderDate()+"");
            table3.addCell(""+ord.getTotalPrice()+"");
        }
        
        document.add(table3);
        document.newPage();
 
        
        ArrayList<Ingredient> listOfIngredients = new IngredientServiceImpl().getAllIngredients();
        PdfPTable ingtable = new PdfPTable(3); 
        ingtable.setWidthPercentage(100); 
        ingtable.setSpacingBefore(10f); 
        ingtable.setSpacingAfter(10f); 
 
        //Set Column widths
        float[] ingcolumnWidths = {1f, 1f, 1f};
        ingtable.setWidths(ingcolumnWidths);
 
        PdfPCell Icell1 = new PdfPCell(new Paragraph("Ingredient ID"));
        Icell1.setBorderColor(BaseColor.BLACK);
        Icell1.setPaddingLeft(5);
        Icell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        Icell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Icell2 = new PdfPCell(new Paragraph("Ingredient Name"));
        Icell2.setBorderColor(BaseColor.BLACK);
        Icell2.setPaddingLeft(5);
        Icell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        Icell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Icell3 = new PdfPCell(new Paragraph("Quantity"));
        Icell3.setBorderColor(BaseColor.BLACK);
        Icell3.setPaddingLeft(15);
        Icell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        Icell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

        ingtable.addCell(Icell1);
        ingtable.addCell(Icell2);
        ingtable.addCell(Icell3);
       
        
        for(Ingredient ing: listOfIngredients){
            ingtable.addCell(""+ing.getIngredientId()+"");
            ingtable.addCell(""+ing.getIngredientName()+"");
            ingtable.addCell(""+ing.getQuantity()+"");
        }
        
        document.add(ingtable);
        document.newPage();
        
        ArrayList<Customer> listOfCustomers = new CustomerServiceImpl().getAllCustomers();
        PdfPTable custtable = new PdfPTable(7); 
        custtable.setWidthPercentage(100); 
        custtable.setSpacingBefore(10f); 
        custtable.setSpacingAfter(10f); 
 
        //Set Column widths
        float[] custcolumnWidths = {0.7f, 0.8f, 1f, 1f, 1f, 1f, 1f, 1f};
        custtable.setWidths(custcolumnWidths);
 
        PdfPCell Custcell1 = new PdfPCell(new Paragraph("Customer ID"));
        Custcell1.setBorderColor(BaseColor.BLACK);
        Custcell1.setPaddingLeft(5);
        Custcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Custcell2 = new PdfPCell(new Paragraph("Customer ID"));
        Custcell2.setBorderColor(BaseColor.BLACK);
        Custcell2.setPaddingLeft(5);
        Custcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Custcell3 = new PdfPCell(new Paragraph("Name"));
        Custcell3.setBorderColor(BaseColor.BLACK);
        Custcell3.setPaddingLeft(15);
        Custcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell Custcell4 = new PdfPCell(new Paragraph("Surname"));
        Custcell4.setBorderColor(BaseColor.BLACK);
        Custcell4.setPaddingLeft(12);
        Custcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Custcell5 = new PdfPCell(new Paragraph("Email"));
        Custcell5.setBorderColor(BaseColor.BLACK);
        Custcell5.setPaddingLeft(10);
        Custcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Custcell6 = new PdfPCell(new Paragraph("Telephone(home)"));
        Custcell6.setBorderColor(BaseColor.BLACK);
        Custcell6.setPaddingLeft(10);
        Custcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell Custcell7 = new PdfPCell(new Paragraph("Telephone(mobile)"));
        Custcell7.setBorderColor(BaseColor.BLACK);
        Custcell7.setPaddingLeft(10);
        Custcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
       
        PdfPCell Custcell8 = new PdfPCell(new Paragraph("ID Number"));
        Custcell8.setBorderColor(BaseColor.BLACK);
        Custcell8.setPaddingLeft(10);
        Custcell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        Custcell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        custtable.addCell(Custcell1);
        custtable.addCell(Custcell2);
        custtable.addCell(Custcell3);
        custtable.addCell(Custcell4);
        custtable.addCell(Custcell5);
        custtable.addCell(Custcell6);
        custtable.addCell(Custcell7);
        custtable.addCell(Custcell8);
        
        for(Customer cust: listOfCustomers){
            custtable.addCell(""+cust.getCustomerId()+"");
            custtable.addCell(""+cust.getFirstName()+"");
            custtable.addCell(""+cust.getLastName()+"");
            custtable.addCell(""+cust.getEmail()+"");
            custtable.addCell(""+cust.getTelephonehome()+"");
            custtable.addCell(""+cust.getTelephonemobile()+"");
            custtable.addCell(""+cust.getID()+"");
        }
        
        document.add(custtable);

        
        document.close();
        writer.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    
    }
    
    public static void main(String[] args) {
        new Reports().generateReport();
    }
}
