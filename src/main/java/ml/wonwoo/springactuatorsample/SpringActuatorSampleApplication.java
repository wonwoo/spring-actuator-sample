package ml.wonwoo.springactuatorsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.web.mappings.MappingsEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class SpringActuatorSampleApplication extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers(EndpointRequest.to(HealthEndpoint.class, InfoEndpoint.class))
        .permitAll()
        .antMatchers("/**")
        .hasRole("USER")
        .and()
        .httpBasic();
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringActuatorSampleApplication.class, args);
  }
}
