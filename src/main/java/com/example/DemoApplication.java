package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication implements CommandLineRunner{

	@Autowired
	RestClient client;

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
//		String result = rest.getForObject("http://example.com", String.class);
		String result = client.hello();
		System.out.println(result);

	}
}

@FeignClient(name = "example", url = "example.com")
@RequestMapping("/")
interface RestClient {
	@RequestMapping(method = RequestMethod.GET)
	String hello();
}
