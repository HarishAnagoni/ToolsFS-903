package in.ashokit.search;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchForm {
	private String planName;
	private String planStatus;
	private String citizenGender;
	private LocalDate startDt;
	private LocalDate endDt;
}
