package com.dhi.restapi.config

import com.dhi.restapi.repository.StaffRepository
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.security.web.util.matcher.RequestMatcher


@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var myUserDetailService: UserDetailsService

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder(12)

    override fun userDetailsService(): UserDetailsService {
        return myUserDetailService
    }

    public override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder())
    }

    @Configuration
    class AuthorizationServer : AuthorizationServerConfigurerAdapter() {
        @Autowired
        lateinit var passwordEncoder: BCryptPasswordEncoder
        @Autowired
        lateinit var authenticationManager: AuthenticationManager

        override fun configure(clients: ClientDetailsServiceConfigurer) {
            clients.inMemory()
                    .withClient("my-client").secret(passwordEncoder.encode(("secret")))
                    .autoApprove(true)
                    .scopes("user_info")

        }

        override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
            endpoints.authenticationManager(authenticationManager)
                    .tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter())
        }

        override fun configure(security: AuthorizationServerSecurityConfigurer) {
            security.tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients()
        }

        @Bean
        fun tokenStore(): TokenStore {
            return JwtTokenStore(accessTokenConverter())
        }

        @Bean
        fun accessTokenConverter(): JwtAccessTokenConverter {
            val converter = JwtAccessTokenConverter()
            converter.setSigningKey("123")
            return converter
        }

        @Bean
        @Primary
        fun tokenServices(): DefaultTokenServices {
            val defaultTokenServices = DefaultTokenServices()
            defaultTokenServices.setTokenStore(tokenStore())
            defaultTokenServices.setSupportRefreshToken(true)
            return defaultTokenServices

        }
    }
}

@Component
class MyUserDetailService : UserDetailsService {
    @Autowired
    lateinit var staffRepository: StaffRepository

    override fun loadUserByUsername(p0: String?): UserDetails {
        if (p0 != null) {

            val user = staffRepository.findByUname(p0)
            if (user.isPresent) {
                val get = user.get()
                return User(get.uname, get.pwd, listOf(SimpleGrantedAuthority("ROLE_USER")))
            }

        }
        throw UsernameNotFoundException("Username not found")
    }

}

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    @Autowired
    lateinit var tokenServices: DefaultTokenServices

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.tokenServices(tokenServices)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/patient_photo/**").permitAll()
                .antMatchers("/**").authenticated()


    }
//    override fun configure(web: WebSecurity) {
//        web.ignoring().antMatchers("/patient_photo/**")
//    }

}