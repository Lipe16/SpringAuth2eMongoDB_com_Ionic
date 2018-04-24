package ferreira.filipe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import ferreira.filipe.service.MyUserDetailService;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration  extends AuthorizationServerConfigurerAdapter{

	private TokenStore tokenStore = new InMemoryTokenStore();
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer ) {
		endpointsConfigurer.tokenStore(this.tokenStore)
							.authenticationManager(this.authenticationManager)
							.userDetailsService(userDetailService);
								
	}
	

	public void configure(ClientDetailsServiceConfigurer  clients) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
        clients
        .inMemory()
        .withClient("mobile")
        .authorizedGrantTypes("password", "authorization_code", "refresh_token")
        .scopes("bar", "read", "write")
        .refreshTokenValiditySeconds(2592000)
        .resourceIds("restservice")
        .secret(passwordEncoder.encode("123"))
        .accessTokenValiditySeconds(200000988);
				
		
		
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenService() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
	}
	
}
