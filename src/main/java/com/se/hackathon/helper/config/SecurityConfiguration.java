package com.se.hackathon.helper.config;

import com.se.hackathon.helper.security.JwtAuthenticationEntryPoint;
import com.se.hackathon.helper.security.jwt.JWTFilter;
import com.se.hackathon.helper.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] SWAGGER_UI_URL = { //
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/demo/",
            "/communication/",
            "/info/",
            "/images/*",
            "/images//",
            "/webjars/**",
            "/csrf"
    };

    private final JwtAuthenticationEntryPoint jwtEntryPoint;


    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    private final CustomUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private JWTFilter jwtFilter;

    public SecurityConfiguration(JwtAuthenticationEntryPoint jwtEntryPoint, CustomUserDetailsService userDetailsService) {
        this.jwtEntryPoint = jwtEntryPoint;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/i18n/**")
                .antMatchers("/content/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .csrf()
            .disable()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)

                .and()
            .authorizeRequests()
            .antMatchers("/api/admin/*").hasRole("ADMIN")
            .antMatchers("/api/organiser/*").hasAnyRole("ADMIN", "ORGANISER")
            .antMatchers("/api/trainer/*").hasAnyRole("ADMIN", "TRAINER")
            .antMatchers("/api/user/*").hasAnyRole("ADMIN", "USER","TRAINER", "ORGANISER")
            .antMatchers("/**/api/auth/**").permitAll()
            // TODO : for test
            .antMatchers("/images/**").permitAll()



            .antMatchers(SWAGGER_UI_URL).permitAll()
        .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // @formatter:on
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
