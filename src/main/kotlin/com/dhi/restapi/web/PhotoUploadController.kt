package com.dhi.restapi.web

import com.dhi.restapi.model.PatientPhoto
import com.dhi.restapi.repository.PatientPhotoRepository
import org.apache.commons.lang3.RandomStringUtils
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
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
        patientPhoto.description = description
        patientPhotoRepository.save(patientPhoto)

        return "success"
    }

    @RequestMapping("view")
    fun getPhotos(@RequestParam patientId: Long): List<PatientPhoto> {
        return patientPhotoRepository.findByPatientId(patientId, PageRequest.of(0, 100, Sort(Sort.Direction.DESC, "date")))
    }

    @RequestMapping("delete/{id}")
    fun deletePhoto(@PathVariable id: Long): String {
        val get = patientPhotoRepository.findById(id).get()
        val path = get.path
        if (path != null) {
            File(path).delete()
        }
        patientPhotoRepository.delete(get)
        return "success"
    }
}