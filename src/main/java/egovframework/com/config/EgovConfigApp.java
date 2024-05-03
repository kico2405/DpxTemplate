package egovframework.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@Import({
	EgovConfigAppAspect.class,
	EgovConfigAppCommon.class,
	EgovConfigRestTemplate.class
	//EgovConfigAppTransaction.class,
})
@PropertySources({
	@PropertySource("classpath:/application.yml")
}) //CAUTION: min JDK 8
public class EgovConfigApp {

}
