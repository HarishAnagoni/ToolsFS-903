package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.CitizenPlan;

public interface CitizenRepository extends JpaRepository<CitizenPlan, Integer> {
	@Query("SELECT distinct(planName) FROM CitizenPlan")
	public List<String> getPlanNames();
	@Query("SELECT distinct(planStatus) FROM CitizenPlan")
	public List<String> getPlanStatus();
}
