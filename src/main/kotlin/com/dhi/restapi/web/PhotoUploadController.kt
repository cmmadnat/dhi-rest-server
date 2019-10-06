package com.dhi.restapi.web

import org.apache.commons.lang3.RandomStringUtils
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("photo")
class PhotoUploadController {
    @Autowired
    private lateinit var environment: Environment

    @RequestMapping("upload", method = [RequestMethod.POST])
    fun uploadPhoto(@RequestParam lat: Float, @RequestParam lng: Float,
                    @RequestParam description: String, @RequestParam image: MultipartFile): String {
        var defaultImageFolder = environment.getProperty("DHI_SYSTEM_IMAGE_PATH")
        if (defaultImageFolder == null) defaultImageFolder = System.getProperty("user.home")
        val parentFolder = File(defaultImageFolder, "dhi_patient_photo")
        parentFolder.mkdirs()

        val extension = image.originalFilename?.split(".")?.last()
        val fileName = DateTime().toString("yyyyMMdd") + "_" + RandomStringUtils.randomAlphabetic(5) + extension

        val newFile = File(parentFolder, fileName)
        image.transferTo(newFile)

        return "success"
    }
}