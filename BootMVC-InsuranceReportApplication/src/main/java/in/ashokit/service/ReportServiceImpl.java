package in.ashokit.service;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repository.CitizenRepository;
import in.ashokit.search.SearchForm;
import in.ashokit.utils.EmailUtils;
import in.ashokit.utils.ExcelGenerator;
import in.ashokit.utils.PDFGenerator;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private CitizenRepository repo;
	@Autowired
	private ExcelGenerator excel;
	@Autowired
	private EmailUtils email;
	@Autowired
	private PDFGenerator pdf;
	@Override
	public List<String> getPlans() {
		
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPstatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> citizenSearch(SearchForm form) {
		System.out.println(form);
		CitizenPlan cp=new CitizenPlan();
		if(null!=form.getPlanName()&&!"".equals(form.getPlanName()))
			cp.setPlanName(form.getPlanName());
		if(null!=form.getPlanStatus()&&!"".equals(form.getPlanStatus()))
			cp.setPlanStatus(form.getPlanStatus());
		if(null!=form.getCitizenGender()&&!"".equals(form.getCitizenGender()))
			cp.setCitizenGender(form.getCitizenGender());
		Example<CitizenPlan> ex=Example.of(cp);
		List<CitizenPlan> list=repo.findAll(ex);
		
		return list;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response)throws Exception {
		File f=new File("plans.xls");
		List<CitizenPlan> records=repo.findAll();
		excel.exportExcel(response, records,f);
		
		String subject="Test Mail Excel";
		String body="<h2>This is Testing Excel based export download<h2>";
		String to="harish.anagoni@gmail.com";
		email.send(subject, body, to,f);
		
		f.delete();
		
		return true;
	}

	@Override
	public boolean exportPDF(HttpServletResponse response)throws Exception {
		File f=new File("plans.pdf");
		List<CitizenPlan> list=repo.findAll();
		pdf.exportPDF(response, list,f);
		
		String subject="Test Mail PDF";
		String body="<h2>This is Testing PDF based export download<h2>";
		String to="harish.anagoni@gmail.com";
		email.send(subject, body, to,f);
		
		return true;
	}

}
