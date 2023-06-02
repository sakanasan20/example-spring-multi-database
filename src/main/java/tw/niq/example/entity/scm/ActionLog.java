package tw.niq.example.entity.scm;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ActionLog")
public class ActionLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Timestamp createdDate;
	
	@Column(name = "plant")
    private String plant;

	@Column(name = "suppliers_no")
    private String suppliersNo ;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "purchase_type" )
    private String purchaseType;
	
	@Column(name = "purchase_no")
    private String purchaseNo;
	
	@Column(name = "delivery_no")
    private String deliveryNo;
	
	@Column(name = "rec_no")
    private String recNo;
	
	@Column(name = "original_rc")
    private String originalRc;
	
	@Column(name = "new_rcs")
    private String newRcs;

	@Column(name = "dstatus")
    private String dstatus;
	
	@Column(name = "comments")
    private String comments;
	
}
