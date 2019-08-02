package com.dhi.restapi

import com.dhi.restapi.repository.StaffRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletResponse


@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var myUserDetailService: UserDetailsService

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder(12)

    override fun userDetailsService(): UserDetailsService {
        return myUserDetailService
    }

    public override fun configure(http: HttpSecurity) {
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint { _, response, _ -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED) }
                .and().authorizeRequests().antMatchers("/**").authenticated().and().httpBasic()
    }


    public override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder())
    }

    @Configuration
    class AuthorizationServer : AuthorizationServerConfigurerAdapter() {
        @Autowired
        lateinit var passwordEncoder: BCryptPasswordEncoder

        override fun configure(clients: ClientDetailsServiceConfigurer) {
            clients.inMemory()
                    .withClient("my-client").secret(passwordEncoder.encode(("secret")))
                    .autoApprove(true).authorizedGrantTypes(AuthorizationGrantType.CLIENT_CREDENTIALS.value).scopes("user_info")

        }


        override fun configure(security: AuthorizationServerSecurityConfigurer) {
            security.tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients()
        }
    }
}

@Component
class MyUserDetailService : UserDetailsService {
    @Autowired
    lateinit var staffRepository: StaffRepository

    override fun loadUserByUsername(p0: String?): UserDetails {
        if (p0 != null) {
            val user = staffRepository.findByUname(p0).get()
            return User(user.uname, user.pwd, listOf(SimpleGrantedAuthority("ROLE_USER")))

        } else throw
        UsernameNotFoundException("Username not found")
    }

}
