package com.dhi.restapi.web

import com.dhi.restapi.model.PatientPhoto
import com.dhi.restapi.repository.PatientPhotoRepository
import org.apache.commons.lang3.RandomStringUtils
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
    private lateinit var patientPhotoRepository: PatientPhotoRepository
    @Autowired
    private lateinit var environment: Environment

    @RequestMapping("/")
    fun hello(): String {
        return "hello"
    }

    @RequestMapping("upload", method = [RequestMethod.POST])
    fun uploadPhoto(@RequestParam lat: String, @RequestParam lng: String,
                    @RequestParam description: String, @RequestParam image: MultipartFile, @RequestParam patientId: String): String {
        var defaultImageFolder = environment.getProperty("DHI_SYSTEM_IMAGE_PATH")
        if (defaultImageFolder == null) defaultImageFolder = System.getProperty("user.home")
        val parentFolder = File(defaultImageFolder, "dhi_patient_photo")
        parentFolder.mkdirs()

        val extension = "." + image.originalFilename?.split(".")?.last()
        val fileName = DateTime().toString("yyyyMMdd") + "_" + RandomStringUtils.randomAlphabetic(5) + extension

        val newFile = File(parentFolder, fileName)
        image.transferTo(newFile)

        val patientPhoto = PatientPhoto()
        patientPhoto.patientId = patientId.toLong()
        patientPhoto.lat = lat.toFloatOrNull()
        patientPhoto.lng = lng.toFloatOrNull()
        patientPhoto.path = newFile.absolutePath
        patientPhotoRepository.save(patientPhoto)

        return "success"
    }

    @RequestMapping("view")
    fun getPhotos(@RequestParam patientId: Long): Set<PatientPhoto> {
        return patientPhotoRepository.findByPatientId(patientId, PageRequest.of(0, 100, Sort(Sort.Direction.DESC, "date")))
    }
}