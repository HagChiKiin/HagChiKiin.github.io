package com.example.tim_kiem_viec_lam.config;

import com.example.tim_kiem_viec_lam.security.AuthTokenFilter;
import com.example.tim_kiem_viec_lam.security.AuthenticationEntryPointJwt;
import com.example.tim_kiem_viec_lam.security.CustomUserDetailsService;
import com.example.tim_kiem_viec_lam.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    CustomUserDetailsService userDetailsService;

    AuthenticationEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/authentication/login", "/api/v1/authentication/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/authentication/refresh-token", "/api/v1/authentication/logout", "/api/v1/authentication/password-change" ).authenticated()
                .antMatchers(HttpMethod.GET, "/api/v1/users", "/api/v1/users/{id}").hasAnyAuthority(Roles.USER.toString(), Roles.ADMIN.toString(), Roles.RECRUITER.toString())
                .antMatchers(HttpMethod.POST, "/api/v1/jobs").hasAnyAuthority(Roles.RECRUITER.toString())
                .antMatchers(HttpMethod.PUT, "/api/v1/jobs/{id}").hasAnyAuthority(Roles.RECRUITER.toString(), Roles.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/api/v1/jobs/{id}").hasAnyAuthority(Roles.RECRUITER.toString(), Roles.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/api/v1/candidate/{id}").hasAnyAuthority(Roles.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/v1/applications/{id}").hasAnyAuthority(Roles.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/v1/applications/{id}").hasAnyAuthority(Roles.RECRUITER.toString())
                .antMatchers(HttpMethod.GET, "/applications/{id}" , "/candidate/info/{id}").hasAnyAuthority(Roles.USER.toString())
                .antMatchers(HttpMethod.GET, "/recruiter/jobs/{id}" ,"/recruiter/jobs-create", "/recruiter/jobs").hasAnyAuthority(Roles.RECRUITER.toString())
                .antMatchers(HttpMethod.GET, "/admin/companies/{id}" , "/admin/companies").hasAnyAuthority(Roles.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/api/v1/applications/update-status/{id}").hasAnyAuthority(Roles.RECRUITER.toString())
                .antMatchers(HttpMethod.GET, "/api/v1/companies/update-status/{id}").hasAnyAuthority(Roles.ADMIN.toString())
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().sameOrigin();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
