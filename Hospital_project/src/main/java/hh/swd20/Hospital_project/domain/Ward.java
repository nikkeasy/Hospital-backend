package hh.swd20.Hospital_project.domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Ward {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long wardId;
	private String name; 
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ward")
	private List<Patient> patients; 
	
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Ward () {}
	
	public Ward(String name) {
		super(); 
		this.name = name; 
}
	
	public Long getWardId() {
		return wardId;
	}
	public void setWardId(Long wardId) {
		this.wardId = wardId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ward [wardId=" + wardId + ", name=" + name + "]";
	}
	
}
