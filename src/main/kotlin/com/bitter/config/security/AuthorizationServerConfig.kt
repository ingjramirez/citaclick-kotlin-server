package com.bitter.config.security

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig: AuthorizationServerConfigurerAdapter() {

    val CLIENT_ID = "citaclick_client"
    val CLIENT_SECRET = "\$2a\$04\$V0LRawH5932T3paFXHGSsuRX9/MpH9siSkA5Ql7ey5uMa//s4dI/u"
    val GRANT_TYPE_PASSWORD = "password"
    val AUTHORIZATION_CODE = "authorization_code"
    val REFRESH_TOKEN = "refresh_token"
    val IMPLICIT = "implicit"
    val SCOPE_READ = "read"
    val SCOPE_WRITE = "write"
    val TRUST = "trust"
    val ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60
    val FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Bean
    fun accessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey("as466gf")
        return converter
    }

    @Bean
    fun tokenStore(): TokenStore {
        return JwtTokenStore(accessTokenConverter())
    }

    @Throws(Exception::class)
    override fun configure(configurer: ClientDetailsServiceConfigurer) {
        configurer
            .inMemory()
            .withClient(CLIENT_ID)
            .secret(CLIENT_SECRET)
            .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
            .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
            .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
                refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.tokenStore(tokenStore())
            .authenticationManager(authenticationManager)
            .accessTokenConverter(accessTokenConverter());
    }

}