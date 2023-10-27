package DataTransferObject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Buyer {

	@Id
	@SequenceGenerator(initialValue = 101, allocationSize = 1, sequenceName = "buyerid", name = "buyerid")
	@GeneratedValue(generator = "buyerid")
	long buyerid;

	@Column(nullable = false)
	String name;

	@Column(nullable = false)
	String Email;

	@Column(nullable = false)
	long mob;

	@Column(nullable = false)
	Date dob;

	@Column(nullable = false)
	String gender;

	@Column(nullable = false)
	String pwd;

	public long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(long buyerid) {
		this.buyerid = buyerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
