package ad.example.performance;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTraceRepository  {
	@Bean
	public InMemoryHttpTraceRepository htttpTraceRepository()
	{
	  return new InMemoryHttpTraceRepository();
	}
}
