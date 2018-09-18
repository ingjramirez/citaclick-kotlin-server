package com.bitter.config.security

import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@Configuration
@EnableResourceServer
class ResourceServerConfig : ResourceServerConfigurerAdapter() {

    private val RESOURCEID = "resource_id"

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId(RESOURCEID).stateless(false)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.anonymous().disable()
            .authorizeRequests()
            .antMatchers("/users/**").access("hasRole('ADMIN')")
            .and().exceptionHandling().accessDeniedHandler(OAuth2AccessDeniedHandler())
    }


}