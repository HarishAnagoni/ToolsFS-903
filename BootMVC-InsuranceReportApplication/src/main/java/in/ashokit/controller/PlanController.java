package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.constants.ApplicationConst;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.search.SearchForm;
import in.ashokit.service.IReportService;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class PlanController {
	
	@Autowired
	private IReportService serv;

	@GetMapping("/pdf")
	public void excelExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/pdf"); //openpdf starter
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		serv.exportPDF(response);
	}
	@GetMapping("/excel")
	public void pdfExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/octet-stream"); //apache poi starter
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");
		serv.exportExcel(response);
	}
	
	
	 @GetMapping("/")
	public String welcome(@ModelAttribute("search") SearchForm searching,Map<String,Object> map) {
		 init(map);
		 return ApplicationConst.WELCOME;
	 }
	private void init(Map<String, Object> map) {
		map.put("names", serv.getPlans());		 
		 map.put("status", serv.getPstatus());
	}
	 @PostMapping("/searchplans")
	 public String getSearch(@ModelAttribute("search") SearchForm search,Map<String,Object> map)
	 {
		init(map);
		List<CitizenPlan> list= serv.citizenSearch(search);
		map.put("list", list);
		 return "welcome";
	 }
}
