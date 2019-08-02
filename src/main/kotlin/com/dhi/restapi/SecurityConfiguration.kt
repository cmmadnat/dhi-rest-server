package com.dhi.restapi

import com.dhi.restapi.repository.StaffRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var myUserDetailService: UserDetailsService

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder(12)

    override fun userDetailsService(): UserDetailsService {
        return myUserDetailService
    }

}

@Component
class MyUserDetailService : UserDetailsService {
    @Autowired
    lateinit var staffRepository: StaffRepository
    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    override fun loadUserByUsername(p0: String?): UserDetails {
        if (p0 != null) {
            val user = staffRepository.findByUname(p0).get()
            return User(user.uname, user.pwd, listOf(SimpleGrantedAuthority("ROLE_USER")))

        } else throw
        UsernameNotFoundException("Username not found")
    }

}