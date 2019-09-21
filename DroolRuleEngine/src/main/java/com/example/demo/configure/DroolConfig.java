package com.example.demo.configure;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolConfig {

	private KieServices kiyService=KieServices.Factory.get();
	
	private KieFileSystem getKieFileSystem() {
		KieFileSystem kieFileSystem = kiyService.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("offer.drl"));
		return kieFileSystem;
	}
	private void getKieRepository() {
		KieRepository kieRepository = kiyService.getRepository();
		kieRepository.addKieModule(new KieModule() {
			
			@Override
			public ReleaseId getReleaseId() {
				return kieRepository.getDefaultReleaseId();
			}
		});
	}
	@Bean
	public KieContainer getKieContainer() {
		System.out.println("Container created...");
		getKieRepository();
		KieBuilder kb= kiyService.newKieBuilder(getKieFileSystem());
		kb.buildAll();
		KieModule kiemodule = kb.getKieModule();
		KieContainer kieContainer = kiyService.newKieContainer(kiemodule.getReleaseId());
		return kieContainer;
	}
	@Bean
	public KieSession getKieSession() throws IOException {
		System.out.println("session created...");
		return getKieContainer().newKieSession();

	}

}
