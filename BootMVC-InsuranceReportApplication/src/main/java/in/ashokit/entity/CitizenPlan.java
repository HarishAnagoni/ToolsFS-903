package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Insurance_Plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String citizenGender;
	private String planName;
	private String planStatus;
	private LocalDate starttDate;
	private LocalDate endDate;
	private Double benifitAmout;
	private String denialReason;
	private LocalDate terminationDate;
}
