package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.search.SearchForm;
import jakarta.servlet.http.HttpServletResponse;

public interface IReportService {
	public List<String> getPlans();
	public List<String> getPstatus();
	public List<CitizenPlan> citizenSearch(SearchForm form);
	public boolean exportExcel(HttpServletResponse response)throws Exception;
	public boolean exportPDF(HttpServletResponse response)throws Exception;
}
