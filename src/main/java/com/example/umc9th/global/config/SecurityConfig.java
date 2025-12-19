package com.example.umc9th.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.umc9th.global.auth.AuthenticationEntryPointImpl;
import com.example.umc9th.global.auth.CustomUserDetailsService;
import com.example.umc9th.global.auth.JwtAuthFilter;
import com.example.umc9th.global.auth.JwtUtil;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtUtil jwtUtil;
	private final CustomUserDetailsService customUserDetailsService;

	private final String[] allowUris = {
		"/members/signup",
		"/members/login",
		"/swagger-ui/**",
		"/swagger-resources/**",
		"/v3/api-docs/**",
	};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(requests -> requests
				.requestMatchers(allowUris).permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			// 폼로그인 비활성화
			.formLogin(AbstractHttpConfigurer::disable)
			// JwtAuthFilter를 UsernamePasswordAuthenticationFilter
			.addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
			.csrf(AbstractHttpConfigurer::disable)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			)
			.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint()))

		;

		return http.build();
	}

	@Bean
	public JwtAuthFilter jwtAuthFilter() {
		return new JwtAuthFilter(jwtUtil, customUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPointImpl();
	}
}
