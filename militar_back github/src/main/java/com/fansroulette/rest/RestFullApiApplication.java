package com.fansroulette.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.oauth2.sdk.http.HTTPRequest;

@SpringBootApplication
public class RestFullApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullApiApplication.class, args);
	}

	/*@Configuration
	public class SecurityConfiguration {

		@Bean
		public WebSecurityCustomizer webSecurityCustomizer() {
			return (web) -> web.ignoring()
			.auth
			.requestMatchers("/usuarios")
			.requestMatchers("/inicio")
			.anyRequest().authenticated();
		}
	}*/

	/*@Configuration
	@EnableWebSecurity
	public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/inicio")
                .anyRequest().authenticated()
            );
        return http.build();
    }

}*/
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {

		http
			.authorizeHttpRequests(authorize -> authorize        
			.requestMatchers("/*").permitAll()                           
				.requestMatchers(HttpMethod.GET, "/usuario/*", "/usuarios", "/apodo/*", "/perfil/*").permitAll()  
				// .requestMatchers("/db/**").access(AuthorizationManagers.allOf(AuthorityAuthorizationManager.hasRole("ADMIN"), AuthorityAuthorizationManager.hasRole("DBA")))   
				//.anyRequest().denyAll()     
				//.requestMatchers(HttpMethod.POST, "/crear_usuario")  
				.anyRequest().denyAll()                                   
			);
		http.httpBasic();
		http.csrf().disable();
		return http.build();

	}
}
