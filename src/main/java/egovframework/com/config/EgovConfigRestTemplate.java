package egovframework.com.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//추가 이유 controller에서 autowired가 안되므로 아래 클래스 추가
@Configuration
public class EgovConfigRestTemplate {
	
    @Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }    
    
    
}
