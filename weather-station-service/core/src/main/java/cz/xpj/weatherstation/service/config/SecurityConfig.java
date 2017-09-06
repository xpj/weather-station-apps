package cz.xpj.weatherstation.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("wemos").password("wemos123").roles("USER", "PUSH");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/**").hasRole("PUSH")
                .antMatchers(HttpMethod.POST, "/**").hasRole("PUSH")
                .antMatchers(HttpMethod.PATCH, "/**").hasRole("PUSH")
                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
                .and().csrf().disable();
    }
}
