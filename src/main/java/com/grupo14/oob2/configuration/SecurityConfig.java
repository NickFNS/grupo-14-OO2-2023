package com.grupo14.oob2.configuration;
import com.grupo14.oob2.services.UserService;
import com.grupo14.oob2.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
    }

    String[] resources = new String[]{
            "/include/**","/css/**","/img/**"
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and() .formLogin() .loginPage("/login").loginProcessingUrl("/loginprocess")
                .usernameParameter("name") .passwordParameter("password")
                .defaultSuccessUrl("/index").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // Especifica la URL de logout
                .logoutSuccessUrl("/login") // URL a la que se redirige después del logout exitoso
                .invalidateHttpSession(true) // Invalida la sesión HTTP existente
                .deleteCookies("JSESSIONID") // Elimina las cookies específicas (en este caso, JSESSIONID)
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
