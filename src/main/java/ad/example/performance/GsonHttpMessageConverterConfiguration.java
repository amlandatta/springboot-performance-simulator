package ad.example.performance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// This is an attempt to simulate PAS App manager issue when GSON is used and actuator enabled

@Configuration
public class GsonHttpMessageConverterConfiguration {

	@Bean
	public GsonHttpMessageConverter gsonHttpMessageConverter() {

		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		Gson gson = new GsonBuilder()
				.serializeNulls()
				.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();
		converter.setGson(gson);
		return converter;
	}
}