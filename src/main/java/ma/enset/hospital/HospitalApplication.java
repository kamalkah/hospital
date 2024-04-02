package ma.enset.hospital;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			PatientRepository patientRepository
			){
			return args->{
				Stream.of("kamal","lotfi","jasser")
						.forEach(name->{
							Patient patient=new Patient();
							patient.setNom(name);
							patient.setDateNaissance(new Date());
							patient.setMalade(false);
							patientRepository.save(patient);
						});



			};
	}

}
