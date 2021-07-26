package com.datdt.AssignmentSpringboot.sercurity;


import com.datdt.AssignmentSpringboot.sercurity.service.accountDeatailService;
import com.datdt.AssignmentSpringboot.sercurity.jwt.JwtAuthEntryPoint;
import com.datdt.AssignmentSpringboot.sercurity.jwt.JwtAuthTokenFilter;
import com.datdt.AssignmentSpringboot.sercurity.jwt.JwtUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    private final accountDeatailService accountDeatailService;

    private final JwtAuthEntryPoint unauthorizedHandler;

    private final JwtUtils jwtUtils;

    

    public WebSecurityConfig(accountDeatailService accountDeatailService,
            JwtAuthEntryPoint unauthorizedHandler, JwtUtils jwtUtils) {
        this.accountDeatailService = accountDeatailService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtUtils = jwtUtils;
    }

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter(){
        return new JwtAuthTokenFilter(jwtUtils, accountDeatailService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
                            throws Exception{
        authenticationManagerBuilder.userDetailsService(accountDeatailService).passwordEncoder(passwordEncoder());

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/admin/roles").hasRole("MANAGER")
                                .antMatchers(HttpMethod.PUT, "/categories/admin").hasRole("MANAGER")
                                .antMatchers(HttpMethod.POST, "/categories/admin").hasRole("MANAGER")
                                .antMatchers(HttpMethod.DELETE, "/categories/**").hasRole("MANAGER")
                                .antMatchers("/categories/admin").hasRole("MANAGER")

                                .antMatchers("/products/admin").hasRole("MANAGER")
                                .antMatchers("/products/customer").permitAll() 
                                .antMatchers(HttpMethod.PUT, "/products/admin").hasRole("MANAGER")
                                .antMatchers(HttpMethod.POST, "/products/admin").hasRole("MANAGER")
                                .antMatchers(HttpMethod.DELETE, "/products/**").hasRole("MANAGER")
                                // .antMatchers(HttpMethod.GET, "/products/").hasRole("MANAGER")
                                // .antMatchers(HttpMethod.GET, "/products/customer/**").hasRole("CUSTOMER")
                                
                                .antMatchers(HttpMethod.POST, "/orders").hasAnyRole("CUSTOMER", "MANAGER")
                                .antMatchers(HttpMethod.GET, "/orders").hasAnyRole("CUSTOMER", "MANAGER")
                                
                                .antMatchers(HttpMethod.POST, "/cart/**").hasRole("CUSTOMER")

                                .antMatchers(HttpMethod.POST, "/orderDetails").hasAnyRole("CUSTOMER", "MANAGER")
                                .antMatchers(HttpMethod.GET, "/orderDetails").hasAnyRole("CUSTOMER", "MANAGER")

                                .antMatchers("/accounts/**").hasAnyRole("CUSTOMER", "MANAGER")

                                .antMatchers("/public/**").permitAll().anyRequest().authenticated()
                                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/deleteSession");
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
