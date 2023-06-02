package tw.niq.example.entity.scm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DeliveryInspectionReport")
public class DeliveryInspectionReport {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DeliveryNo")
    private String deliveryNo;
    
    @Column(name = "FileName")
    private String fileName;

    @Column(name = "Enable")
    private String enable;
    
}
