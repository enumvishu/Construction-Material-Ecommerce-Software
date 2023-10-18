package DataTransferObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Company {

	@Id
	@SequenceGenerator(initialValue = 2023001, allocationSize = 1, sequenceName = "cusid", name = "cusid")
	@GeneratedValue(generator = "cusid")
	long id;

	@Column(nullable = false)
	String Name;

	@Column(nullable = false)
	String PAN;

	@Column(nullable = false)
	long Mobile;

	@Column(nullable = false)
	String Email;

	@Column(nullable = false)
	long Registration_No;

	@Column(nullable = false)
	String Company_Type;

	@Column(nullable = false)
	Date Registration_Date;

	@Column(nullable = false)
	String Password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getRegistration_No() {
		return Registration_No;
	}

	public void setRegistration_No(long registration_No) {
		Registration_No = registration_No;
	}

	public String getCompany_Type() {
		return Company_Type;
	}

	public void setCompany_Type(String company_Type) {
		Company_Type = company_Type;
	}

	public Date getRegistration_Date() {
		return Registration_Date;
	}

	public void setRegistration_Date(Date registration_Date) {
		Registration_Date = registration_Date;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
