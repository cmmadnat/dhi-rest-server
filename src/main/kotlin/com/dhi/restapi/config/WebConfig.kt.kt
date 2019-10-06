package com.dhi.restapi.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.io.File

@Configuration
class WebConfig : WebMvcConfigurer {

    @Autowired
    private lateinit var environment: Environment

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        var defaultImageFolder = environment.getProperty("DHI_SYSTEM_IMAGE_PATH")
        if (defaultImageFolder == null) defaultImageFolder = System.getProperty("user.home")
        val parentFolder = File(defaultImageFolder, "dhi_patient_photo")
        val fileName = "file:${parentFolder.absolutePath}/"
        registry.addResourceHandler("/patient_photo/**")
                .addResourceLocations(fileName)
    }
}
