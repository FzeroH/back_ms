package com.example.proxy_mixed

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers("/**").permitAll()
    }
}