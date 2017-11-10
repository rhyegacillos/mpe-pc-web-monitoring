package com.mpe.pc.webmonitoring.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Import(HibernateConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    public void setDataSource(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication().dataSource(dataSource);
        auth.inMemoryAuthentication().withUser("rhye").password("password").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/files/**").permitAll()
//                .antMatchers("/403").denyAll()
//                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/addEmployeeForm").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/listUsers").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/user").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')");


        http.authorizeRequests()
                .antMatchers("/static/**", "/webjars/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/user/showForm").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/loadTable").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
                .logout().logoutSuccessUrl("/login?logout").logoutUrl("/").invalidateHttpSession(true);
        http.rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(50000).tokenRepository(tokenRepository());
        http.exceptionHandling().accessDeniedPage("/user/denied");
    }

    private PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl token = new JdbcTokenRepositoryImpl();
        token.setDataSource(dataSource);

        return token;
    }
}
