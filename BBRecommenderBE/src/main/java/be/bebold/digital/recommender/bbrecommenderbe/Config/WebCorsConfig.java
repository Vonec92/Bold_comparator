package be.bebold.digital.recommender.bbrecommenderbe.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for enabling cross-origin resource sharing (CORS) for a
 * Spring Web MVC application.
 * This class implements the {@link WebMvcConfigurer} interface and overrides
 * its {@link #addCorsMappings(CorsRegistry)}
 * method to configure the allowed origins and HTTP methods for CORS requests.
 */
@Configuration
@EnableScheduling
public class WebCorsConfig implements WebMvcConfigurer {

    /**
     * Configures the allowed origins and HTTP methods for CORS requests for the
     * entire application.
     * All requests matching the specified mapping pattern ("/**") will be allowed
     * to originate from
     * the specified origin ("http://localhost:4200") and use the specified HTTP
     * methods ("GET", "POST", "PUT", "DELETE").
     *
     * @param registry the {@link CorsRegistry} object to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://localhost:81" ,"http://64.227.74.138:81", "http://beboldrecommender.ddns.net:81")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
