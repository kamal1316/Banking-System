package com.wellsfargo.onlinebanking;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wellsfargo.onlinebanking.entity.Admin;
import com.wellsfargo.onlinebanking.entity.BaseSeq;
import com.wellsfargo.onlinebanking.repository.AdminRepository;
import com.wellsfargo.onlinebanking.repository.BaseSeqRepository;


@SpringBootApplication
@CrossOrigin("http://localhost:3000")
public class OnlinebankingApplication {
	
	@Autowired
	private BaseSeqRepository baseSeqRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@PostConstruct
    public void initUsers() {
		
		if(baseSeqRepo.findAll().size() == 0) {
			BaseSeq baseSeq = new BaseSeq(10000, 4000);
			baseSeqRepo.save(baseSeq);
		}
		
		if(adminRepo.findAll().size() == 0) {
			Admin admin = new Admin("admin", "admin");
			adminRepo.save(admin);
		}
    }

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingApplication.class, args);
		System.out.println("Running Online Banking System");
	}
}
