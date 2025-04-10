package in.nt.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repository.CitizenRepository;
@Component
public class LoadData implements CommandLineRunner {

	@Autowired
	private CitizenRepository repo;
	@Override
	public void run(String... args) throws Exception {
		try {
			CitizenPlan c1=new CitizenPlan();
			c1.setCitizenName("Harish");c1.setCitizenGender("male");c1.setPlanName("food");c1.setPlanStatus("approved");c1.setStarttDate(LocalDate.now());c1.setEndDate(LocalDate.now().plusMonths(6));c1.setBenifitAmout(500000.0);
			CitizenPlan c2=new CitizenPlan();
			c2.setCitizenName("Ramesh");c2.setCitizenGender("female");c2.setPlanName("food");c2.setPlanStatus("approved");c2.setStarttDate(LocalDate.now());c2.setEndDate(LocalDate.now().plusMonths(6));c2.setBenifitAmout(300000.0);
			CitizenPlan c3=new CitizenPlan();
			c3.setCitizenName("Suresh");c3.setCitizenGender("male");c3.setPlanName("food");c3.setPlanStatus("rejected");c3.setStarttDate(LocalDate.now());c3.setEndDate(LocalDate.now().plusMonths(6));c3.setBenifitAmout(100000.0);
			CitizenPlan c4=new CitizenPlan();
			c4.setCitizenName("Rajesh");c4.setCitizenGender("female");c4.setPlanName("food");c4.setPlanStatus("rejected");c4.setStarttDate(LocalDate.now());c4.setEndDate(LocalDate.now().plusMonths(6));c4.setBenifitAmout(400000.0);
			CitizenPlan c5=new CitizenPlan();
			c5.setCitizenName("Shyam");c5.setCitizenGender("male");c5.setPlanName("cash");c5.setPlanStatus("approved");c5.setStarttDate(LocalDate.now());c5.setEndDate(LocalDate.now().plusMonths(6));c5.setBenifitAmout(250000.0);
			CitizenPlan c6=new CitizenPlan();
			c6.setCitizenName("Krishna");c6.setCitizenGender("female");c6.setPlanName("cash");c6.setPlanStatus("approved");c6.setStarttDate(LocalDate.now());c6.setEndDate(LocalDate.now().plusMonths(6));c6.setBenifitAmout(310000.0);
			CitizenPlan c7=new CitizenPlan();
			c7.setCitizenName("Kumar");c3.setCitizenGender("male");c7.setPlanName("cash");c7.setPlanStatus("rejected");c7.setStarttDate(LocalDate.now());c7.setEndDate(LocalDate.now().plusMonths(6));c7.setBenifitAmout(410000.0);
			List<CitizenPlan> list=List.of(c1,c2,c3,c4,c5,c6,c7);
			repo.saveAll(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
