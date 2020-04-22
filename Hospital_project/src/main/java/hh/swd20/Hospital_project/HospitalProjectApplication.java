package hh.swd20.Hospital_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Hospital_project.domain.Patient;
import hh.swd20.Hospital_project.domain.PatientRepository;
import hh.swd20.Hospital_project.domain.User;
import hh.swd20.Hospital_project.domain.UserRepository;
import hh.swd20.Hospital_project.domain.Ward;
import hh.swd20.Hospital_project.domain.WardRepository;

@SpringBootApplication
public class HospitalProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(HospitalProjectApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(HospitalProjectApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner hospitalProject(PatientRepository prepository, WardRepository wrepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save a few patients to database"); 
			
			
			
			wrepository.save(new Ward("Hammashoito")); 
			wrepository.save(new Ward("Syöpäpotilaat")); 
			wrepository.save(new Ward("Ensihoito")); 
			wrepository.save(new Ward("Leikkaussali")); 
			
			prepository.save(new Patient("Khelester", "Kholera", "Stable", 1, wrepository.findByName("Syöpäpotilaat").get(0)));
			prepository.save(new Patient("Hamuli", "Popponen", "Oof", 10, wrepository.findByName("Ensihoito").get(0)));
			prepository.save(new Patient("Nina", "Kurtti", "ICU", 9, wrepository.findByName("Leikkaussali").get(0)));
			prepository.save(new Patient("Fätface", "Smallboi", "Stable", 1, wrepository.findByName("Syöpäpotilaat").get(0)));
			prepository.save(new Patient("Tylsä", "Ihminen", "Oof", 10, wrepository.findByName("Ensihoito").get(0)));
			prepository.save(new Patient("Nina", "Nillittäjä", "ICU", 9, wrepository.findByName("Syöpäpotilaat").get(0)));
			prepository.save(new Patient("Chelester", "Smallboi3", "Stable", 1, wrepository.findByName("Ensihoito").get(0)));
			prepository.save(new Patient("Monkey", "Monkey", "Oof", 10, wrepository.findByName("Ensihoito").get(0)));
			prepository.save(new Patient("Rafael", "Al-Bashiir", "ICU", 9, wrepository.findByName("Ensihoito").get(0)));
			
			// Create users 
			User user1 = new User("user", "$2a$08$4QKKZS26cCW6by3/TR7yM.T0wG/ToijLXHsFsjz6sDJ1ZnkVzyUt.", "USER"); // password2 - Hash generated from:
			User user2 = new User("admin", "$2a$08$NUlbyfOMUrlTOuT3kE/3ie8T7LBtLxclqgNccJ7PNknfZI5VmQHGm", "ADMIN"); // password1 - https://www.dailycred.com/article/bcrypt-calculator
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all patients");
			for (Patient patient : prepository.findAll()) {
				log.info(patient.toString());
			}
			
		};
	
	}

}
