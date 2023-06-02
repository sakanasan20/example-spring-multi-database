package tw.niq.example.entity.mes;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TEMP_TC_ITB")
public class TempTcItb {

	@Id
	@Column(name = "TC_ITB03")
	private String tcItb03;
	
	@Column(name = "DEP")
	private String dep;
	
	@Column(name = "TC_ITB04")
	private String tcItb04;
	
	@Column(name = "DATE0824_NOG")
	private BigDecimal date0824Nog;
	
	@Column(name = "DATE0824_NOA")
	private BigDecimal date0824Noa;
	
	@Column(name = "DATE0824_AMR")
	private BigDecimal date0824Amr;
	
	@Column(name = "DATE0822_NOG")
	private BigDecimal date0822Nog;
	
	@Column(name = "DATE0822_NOA")
	private BigDecimal date0822Noa;
	
	@Column(name = "DATE0822_AMR")
	private BigDecimal date0822Amr;
	
}
