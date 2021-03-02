//import java.util.List;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;  


public class PDFDocumentor {


	public PDFDocumentor(){

		// Creating a PdfWriter       
		String dest = "./itextExamples/temp_file.pdf";       
		PdfWriter writer = null;
		try {
			writer = new PdfWriter(dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}           

		// Creating a PdfDocument       
		PdfDocument pdf = new PdfDocument(writer);              

		// Adding a new page 
		pdf.addNewPage(); 

		// Creating a Document        
		Document document = new Document(pdf);              
		String para1 = "RANDOM PDF DOUCMENT\n Text description found in a reciept will\nbe inserted into this document";  

		String para2 = "For example:\n\n" ;
		
		//				+ "1\tBlueberry Cupcakes\tR13.00\tR13.00\n" 
		//				+ "4\tBlackforest Cake slice\tR22.00\tR88.00\n"
		//				+ "1\tChocolate Moose\tR46.00\tR92.00\n" 
		//				+ "5\tChocolate Chip Cupcakes\tR13.00\tR65.00\n";     

		// Creating Paragraphs       
		Paragraph paragraph1 = new Paragraph(para1);             
		Paragraph paragraph2 = new Paragraph(para2);              

		float [] pointColumnWidths = {50F, 150F, 150F, 150F};   
		Table table = new Table(pointColumnWidths);    
		//table.

		// Adding cells to the table       
		table.addHeaderCell(new Cell().add(new Text("QUANTITY").setBold().toString()));       
		table.addHeaderCell(new Cell().add(new Text("PRODUCT").setBold().getText()));       
		table.addHeaderCell(new Cell().add(new Text("UNIT PRICE").setBold().getText()));       
		table.addHeaderCell(new Cell().add(new Text("SUB-TOTAL").setBold().getText()));     

		for(int i = 0 ; i < 10 ; i++){
			int quantity = (int) (Math.random() * 4 + 1);
			table.addCell(new Cell().add("" + (quantity)));       
			table.addCell(new Cell().add("Product " + (i+1)));
			int price = (int)(Math.random() * 100 + 1);
			table.addCell(new Cell().add("R " + price + ".00"));       
			table.addCell(new Cell().add("R "+(price * quantity ) + ".00"));  
		}
		
		table.addCell("TOTAL : ");
	
		table.addCell("454654 ");

		Text footer = new Text("THANK YOU FOR SHOPPING AT MRS ANGELS DO-KNOT STORE!:-)").setBold();
		footer.setBold();
		
		// Creating a list
		//List list = new List();  

		// Add elements to the list       

		//		list.add( "1\tBlueberry Cupcakes\tR13.00\tR13.00\n" );
		//		list.add( "4\tBlackforest Cake slice\tR22.00\tR88.00\n");
		//		list.add( "1\tChocolate Moose\tR46.00\tR92.00\n" );
		//		list.add( "5\tChocolate Chip Cupcakes\tR13.00\tR65.00\n"); 

		// Adding paragraphs to document       
		document.add(paragraph1);       
		document.add(paragraph2); 
		document.add(table);

		// Closing the document       
		document.close();             
		System.out.println("Alright, its done. Go check"); 
	}



	public static void main(String [] args) throws Exception{
		new PDFDocumentor();
		//cpdf();
	}


	public static void cpdf() throws Exception {              
		// Creating a PdfWriter       
		String dest = "./itextExamples/temp_file.pdf";       
		PdfWriter writer = new PdfWriter(dest); 

		// Creating a PdfDocument       
		PdfDocument pdfDoc = new PdfDocument(writer);              

		// Adding a new page 
		pdfDoc.addNewPage();               

		// Creating a Document        
		Document document = new Document(pdfDoc);               

		// Closing the document    
		document.close();              
		System.out.println("PDF Created");    
	} 

	// heading 
	/*
	  ______________________________
	 |
	 | Logo
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |
	 |_______________________________|

	 */
}
