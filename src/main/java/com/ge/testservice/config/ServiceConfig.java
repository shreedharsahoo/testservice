package com.ge.testservice.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.ge.testservice.model.User;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shreedhar sahoo
 *
 */

@Configuration
@EnableSwagger2
public class ServiceConfig {

	@Bean
	public User user() {return new User();}

	@Bean
    public Docket swaggerWordwrapApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("userinfo-api-1.0")
                .select()
                .apis(p -> {
                    if (p.produces() != null) {
                        for (MediaType mt : p.produces()) {
                            if (mt.toString().contains("vnd.ge.testservice.userinfo.v1.0+json")) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .paths(PathSelectors.any())
                .build()
                //.enableUrlTemplating(true)
                .apiInfo(new ApiInfoBuilder()
                        .version("1.0")
                        .title("User Data API")
                        .description("Documentation USer Data Operation API v1.0")
                        .build());
    }
    @Bean
    public Docket swaggerServerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Server-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/actuator/*"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(new ApiInfoBuilder()
                        .version("1.0")
                        .title("Server Actuator API")
                        .description("Documentation Server Operation API v1.0")
                        .build());
    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }
}
