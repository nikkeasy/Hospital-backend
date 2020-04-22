package hh.swd20.Hospital_project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import hh.swd20.Hospital_project.web.PatientController;
import hh.swd20.Hospital_project.domain.PatientRepository;

import hh.swd20.Hospital_project.web.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {

		@Test
		public void contextLoadsOther() {
			
		}
	
		// Smoketest
	
		
		@Autowired
		private PatientRepository prepository; 
		
		@Autowired
		private PatientController patientController; 
		
		@Autowired
		private UserDetailServiceImpl repository; 	
		
		
		@Test
		public void contextLoads0() throws Exception {
			assertThat(prepository).isNotNull(); 
		}
		
		@Test
		public void contextLoads1() throws Exception { 
			assertThat(patientController).isNotNull(); 
		}
		
		@Test
		public void contextLoads2() throws Exception { 
			assertThat(repository).isNotNull(); 
		}
}
