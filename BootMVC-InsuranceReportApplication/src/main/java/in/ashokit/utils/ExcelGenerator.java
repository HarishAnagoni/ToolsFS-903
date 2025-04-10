package in.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public void exportExcel(HttpServletResponse response,List<CitizenPlan> records,File f)throws Exception {
			
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("plans-data");
		Row headerRow=sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Termination Reason");
		int index=1;
		for(CitizenPlan plan:records) {
			Row dataRow=sheet.createRow(index);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getCitizenGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			dataRow.createCell(5).setCellValue(plan.getStarttDate());
			dataRow.createCell(6).setCellValue(plan.getEndDate());
			dataRow.createCell(7).setCellValue(plan.getTerminationDate());
			if(null!=plan.getBenifitAmout())
				dataRow.createCell(8).setCellValue(plan.getBenifitAmout());
			else
				dataRow.createCell(8).setCellValue("N/A");
			
			index++;
		}
		
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		ServletOutputStream outputStream= response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
	}
}
