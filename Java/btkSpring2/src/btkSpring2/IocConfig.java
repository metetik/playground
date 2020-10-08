package btkSpring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("btkSpring2")
@PropertySource("classpath:values.properties")
public class IocConfig {
	
	@Bean
	public ICustomerDal database() {
		return new OracleCustomerDal();
	}
	
	@Bean
	public ICustomerService service() {
		return new CustomerManager(database());
	}
	
	
	
}
