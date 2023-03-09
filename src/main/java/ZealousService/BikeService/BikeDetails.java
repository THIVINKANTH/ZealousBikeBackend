package ZealousService.BikeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
public class BikeDetails 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	private String cusBikeno;
	private String cusName;
	private long cusContactno;
	private String cusEmail;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date cusDateofpurchase;
	@OneToMany(cascade = CascadeType.ALL,fetch  = FetchType.LAZY)
	@Nullable
	@JsonBackReference
	@JoinTable(name  = "Allrecords",joinColumns = @JoinColumn(name = "CustomerId"),inverseJoinColumns = @JoinColumn(name="Servicejobcardno"))
	private Collection<ServiceDetails> myservicedetails=new ArrayList<ServiceDetails>();
	public BikeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BikeDetails(int cusId, String cusBikeno, String cusName, long cusContactno, String cusEmail,
			Date cusDateofpurchase, Collection<ServiceDetails> myservicedetails) {
		super();
		this.cusId = cusId;
		this.cusBikeno = cusBikeno;
		this.cusName = cusName;
		this.cusContactno = cusContactno;
		this.cusEmail = cusEmail;
		this.cusDateofpurchase = cusDateofpurchase;
		this.myservicedetails = myservicedetails;
	}
	@Override
	public String toString() {
		return "BikeDetails [cusId=" + cusId + ", cusBikeno=" + cusBikeno + ", cusName=" + cusName + ", cusContactno="
				+ cusContactno + ", cusEmail=" + cusEmail + ", cusDateofpurchase=" + cusDateofpurchase
				+ ", myservicedetails=" + myservicedetails + "]";
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusBikeno() {
		return cusBikeno;
	}
	public void setCusBikeno(String cusBikeno) {
		this.cusBikeno = cusBikeno;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public long getCusContactno() {
		return cusContactno;
	}
	public void setCusContactno(long cusContactno) {
		this.cusContactno = cusContactno;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public Date getCusDateofpurchase() {
		return cusDateofpurchase;
	}
	public void setCusDateofpurchase(Date cusDateofpurchase) {
		this.cusDateofpurchase = cusDateofpurchase;
	}
	public Collection<ServiceDetails> getMyservicedetails() {
		return myservicedetails;
	}
	public void setMyservicedetails(Collection<ServiceDetails> myservicedetails) {
		this.myservicedetails = myservicedetails;
	}
	
}
