package hh.swd20.Hospital_project.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {
		@Id	
	    @GeneratedValue(strategy=GenerationType.AUTO)

	
		private Long id; 
		private String firstName; 
		private String lastName; 
		private String p_status; 
		private int t_urgency;
		
			@ManyToOne
		    @JsonIgnore
		    @JoinColumn(name = "wardId")
		    private Ward ward;

		
		
		
		public Patient() {
			super();
		
		}
		public Patient(String firstName, String lastName, String p_status, int t_urgency, Ward ward) {
			super();
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.p_status = p_status;
			this.t_urgency = t_urgency;
			this.ward = ward; 
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getP_status() {
			return p_status;
		}
		public void setP_status(String p_status) {
			this.p_status = p_status;
		}
		public int getT_urgency() {
			return t_urgency;
		}
		public void setT_urgency(int t_urgency) {
			this.t_urgency = t_urgency;
		} 
		
		public Ward getWard() {
			return ward;
		}

		public void setWard(Ward ward) {
			this.ward = ward;
		}
		
		@Override
		public String toString() {
			if (this.ward != null)
				return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", p_status=" + p_status + " ward =" + this.getWard() + "]";		
			else
				return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", p_status=" + p_status + "]";
		}
	}
		
