package com.dhi.restapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableAuthorizationServer
@EnableSwagger2
class RestApiApplication

fun main(args: Array<String>) {
    runApplication<RestApiApplication>(*args)
}
