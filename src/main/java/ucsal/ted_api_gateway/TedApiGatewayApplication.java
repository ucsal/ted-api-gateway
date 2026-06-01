package ucsal.ted_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TedApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TedApiGatewayApplication.class, args);
	}

}
