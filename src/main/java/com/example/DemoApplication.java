package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		try {
//			final File basedir = Files.createTempDirectory("config-repo-").toFile();
//			Runtime.getRuntime().addShutdownHook(new Thread() {
//				@Override
//				public void run() {
//					try {
//						FileUtils.delete(basedir, FileUtils.RECURSIVE);
//					}
//					catch (IOException e) {
//
//					}
//				}
//			});
//			Git.cloneRepository().setURI("https://github.com/spring-cloud-samples/config-repo").
//					setDirectory(basedir).call();
//			System.out.println("Cloned repo to " + basedir);
//		}
//		catch (IOException e) {
//			throw new IllegalStateException("Cannot create temp dir", e);
//		}

		RestTemplate rest = new RestTemplate();
		String result = rest.getForObject("http://example.com", String.class);
		System.out.println(result);
	}
}
