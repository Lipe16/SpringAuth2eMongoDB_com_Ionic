package ferreira.filipe.config;

import java.util.Map;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ferreira.filipe.service.MyUserDetailService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    private MyUserDetailService userDetailService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
         DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
         authenticationProvider.setUserDetailsService(userDetailService);
         authenticationProvider.setPasswordEncoder(passwordEncoder());
         return authenticationProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    

    

    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    
    
    @Override
    public void configure(WebSecurity security)throws Exception{
    
        security.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers(HttpMethod.GET, "/public/**");
    }
    

    

}
