package tw.niq.example.entity.erp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TC_SCK_FILE")
public class TcSckFile {

	@Id
	@Column(name = "TC_SCK01")
	private Long tcSck01;
	
	@Column(name = "TC_SCK02")
	private String tcSck02;
	
	@Column(name = "TC_SCK03")
	private String tcSck03;
	
}
