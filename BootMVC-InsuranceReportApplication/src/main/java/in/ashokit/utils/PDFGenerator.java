package in.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PDFGenerator {
	
	public void exportPDF(HttpServletResponse response,List<CitizenPlan> list,File f)throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		Font fontTitle=FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(18);
		Paragraph p=new Paragraph("Customers Insurance Information",fontTitle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		p.setSpacingAfter(8);;
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");table.addCell("Name");table.addCell("Gender");table.addCell("Plan Name");table.addCell("Plan Status");
		table.addCell("Benefit Amount");
		
		
		for(CitizenPlan plan:list) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(String.valueOf(plan.getBenifitAmout()));
		}
		
		
		document.add(table);
		document.close();
	}
}
