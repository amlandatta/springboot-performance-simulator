package ad.example.performance;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(appRequestMatcher()).permitAll()
                .and().authorizeRequests()
                .requestMatchers((request) -> request.getServletPath().equals("/")).permitAll()
                .and().authorizeRequests()
                .requestMatchers(endpointRequestMatcher()).permitAll()
                .and().authorizeRequests()
                .anyRequest().denyAll();
    }

    private RequestMatcher endpointRequestMatcher() {
        return EndpointRequest.to("metrics", "prometheus");
    }
    

    private RequestMatcher appRequestMatcher() {
        return (request) -> request.getServletPath().startsWith("/actuator") ||
        		request.getServletPath().startsWith("/simulate") ||
        		request.getServletPath().startsWith("/health") ;
    }
}
