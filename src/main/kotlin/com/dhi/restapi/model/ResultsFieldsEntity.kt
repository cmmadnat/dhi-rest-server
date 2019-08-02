package com.dhi.restapi.model

import javax.persistence.*
import java.util.Objects

@Entity
@Table(name = "results_fields")
class ResultsFieldsEntity {
    @get:Id
    @get:Column(name = "id")
    var id: Long = 0
    @get:Basic
    @get:Column(name = "resultid")
    var resultid: Int? = null
    @get:Basic
    @get:Column(name = "postid")
    var postid: String? = null
    @get:Basic
    @get:Column(name = "BGS_formDate")
    var bgsFormDate: String? = null
    @get:Basic
    @get:Column(name = "BGS_formOrg")
    var bgsFormOrg: String? = null
    @get:Basic
    @get:Column(name = "BGS_formSurveyor")
    var bgsFormSurveyor: String? = null
    @get:Basic
    @get:Column(name = "ADLResult")
    var adlResult: String? = null
    @get:Basic
    @get:Column(name = "ADLScore")
    var adlScore: String? = null
    @get:Basic
    @get:Column(name = "urinaryIncontinence")
    var urinaryIncontinence: String? = null
    @get:Basic
    @get:Column(name = "fecalIncontinence")
    var fecalIncontinence: String? = null
    @get:Basic
    @get:Column(name = "takingShower")
    var takingShower: String? = null
    @get:Basic
    @get:Column(name = "usingStair")
    var usingStair: String? = null
    @get:Basic
    @get:Column(name = "dressing")
    var dressing: String? = null
    @get:Basic
    @get:Column(name = "movingIndoor")
    var movingIndoor: String? = null
    @get:Basic
    @get:Column(name = "usingToilet")
    var usingToilet: String? = null
    @get:Basic
    @get:Column(name = "offbed")
    var offbed: String? = null
    @get:Basic
    @get:Column(name = "grooming")
    var grooming: String? = null
    @get:Basic
    @get:Column(name = "eating")
    var eating: String? = null
    @get:Basic
    @get:Column(name = "BMIResult")
    var bmiResult: String? = null
    @get:Basic
    @get:Column(name = "BMIValue")
    var bmiValue: String? = null
    @get:Basic
    @get:Column(name = "height")
    var height: String? = null
    @get:Basic
    @get:Column(name = "weight")
    var weight: String? = null
    @get:Basic
    @get:Column(name = "TUGTResult")
    var tugtResult: String? = null
    @get:Basic
    @get:Column(name = "TUGTTiming")
    var tugtTiming: String? = null
    @get:Basic
    @get:Column(name = "kneeache")
    var kneeache: String? = null
    @get:Basic
    @get:Column(name = "depressionResult")
    var depressionResult: String? = null
    @get:Basic
    @get:Column(name = "depressionScore")
    var depressionScore: String? = null
    @get:Basic
    @get:Column(name = "bored")
    var bored: String? = null
    @get:Basic
    @get:Column(name = "sad")
    var sad: String? = null
    @get:Basic
    @get:Column(name = "AMTResult")
    var amtResult: String? = null
    @get:Basic
    @get:Column(name = "AMTScore")
    var amtScore: String? = null
    @get:Basic
    @get:Column(name = "testReverseCounting")
    var testReverseCounting: String? = null
    @get:Basic
    @get:Column(name = "testKingName")
    var testKingName: String? = null
    @get:Basic
    @get:Column(name = "test14October2516")
    var test14October2516: String? = null
    @get:Basic
    @get:Column(name = "testBirthdate")
    var testBirthdate: String? = null
    @get:Basic
    @get:Column(name = "testSurveyorRelative")
    var testSurveyorRelative: String? = null
    @get:Basic
    @get:Column(name = "testPlaceName")
    var testPlaceName: String? = null
    @get:Basic
    @get:Column(name = "testYear")
    var testYear: String? = null
    @get:Basic
    @get:Column(name = "testAddress")
    var testAddress: String? = null
    @get:Basic
    @get:Column(name = "testTime")
    var testTime: String? = null
    @get:Basic
    @get:Column(name = "testAge")
    var testAge: String? = null
    @get:Basic
    @get:Column(name = "eyeHealthCheckResult")
    var eyeHealthCheckResult: String? = null
    @get:Basic
    @get:Column(name = "eyeHealthCheckScore")
    var eyeHealthCheckScore: String? = null
    @get:Basic
    @get:Column(name = "amdTest")
    var amdTest: String? = null
    @get:Basic
    @get:Column(name = "glaucomaTest")
    var glaucomaTest: String? = null
    @get:Basic
    @get:Column(name = "cataractTest")
    var cataractTest: String? = null
    @get:Basic
    @get:Column(name = "1footReading")
    var oneFootReading: String? = null
    @get:Basic
    @get:Column(name = "3meterCounting")
    var threeMeterCounting: String? = null
    @get:Basic
    @get:Column(name = "mouthHealthRisk")
    var mouthHealthRisk: String? = null
    @get:Basic
    @get:Column(name = "scalingTool")
    var scalingTool: String? = null
    @get:Basic
    @get:Column(name = "scalingTeeth")
    var scalingTeeth: String? = null
    @get:Basic
    @get:Column(name = "usingToothpaste")
    var usingToothpaste: String? = null
    @get:Basic
    @get:Column(name = "brushingTeeth")
    var brushingTeeth: String? = null
    @get:Basic
    @get:Column(name = "fastingPlasmaGlucoseResult")
    var fastingPlasmaGlucoseResult: String? = null
    @get:Basic
    @get:Column(name = "FPG")
    var fpg: String? = null
    @get:Basic
    @get:Column(name = "bloodPressureResult")
    var bloodPressureResult: String? = null
    @get:Basic
    @get:Column(name = "DBP")
    var dbp: String? = null
    @get:Basic
    @get:Column(name = "SBP")
    var sbp: String? = null
    @get:Basic
    @get:Column(name = "province")
    var province: String? = null
    @get:Basic
    @get:Column(name = "district")
    var district: String? = null
    @get:Basic
    @get:Column(name = "subdistrict")
    var subdistrict: String? = null
    @get:Basic
    @get:Column(name = "alley")
    var alley: String? = null
    @get:Basic
    @get:Column(name = "homenumber")
    var homenumber: String? = null
    @get:Basic
    @get:Column(name = "gender")
    var gender: String? = null
    @get:Basic
    @get:Column(name = "age")
    var age: String? = null
    @get:Basic
    @get:Column(name = "birthdate")
    var birthdate: String? = null
    @get:Basic
    @get:Column(name = "fullname")
    var fullname: String? = null
    @get:Basic
    @get:Column(name = "question_test")
    var questionTest: String? = null
    @get:Basic
    @get:Column(name = "indoor")
    var indoor: String? = null
    @get:Basic
    @get:Column(name = "homeVisitType")
    var homeVisitType: String? = null
    @get:Basic
    @get:Column(name = "patientFullname")
    var patientFullname: String? = null
    @get:Basic
    @get:Column(name = "elderGroupResult")
    var elderGroupResult: String? = null
    @get:Basic
    @get:Column(name = "dailyLivingScore")
    var dailyLivingScore: String? = null
    @get:Basic
    @get:Column(name = "urine")
    var urine: String? = null
    @get:Basic
    @get:Column(name = "defecation")
    var defecation: String? = null
    @get:Basic
    @get:Column(name = "takingBath")
    var takingBath: String? = null
    @get:Basic
    @get:Column(name = "movement")
    var movement: String? = null
    @get:Basic
    @get:Column(name = "sitting")
    var sitting: String? = null
    @get:Basic
    @get:Column(name = "scoopingFood")
    var scoopingFood: String? = null
    @get:Basic
    @get:Column(name = "examinationDate")
    var examinationDate: String? = null
    @get:Basic
    @get:Column(name = "village_buildingName")
    var villageBuildingName: String? = null
    private var hNnumber: String? = null
    @get:Basic
    @get:Column(name = "amdEye")
    var amdEye: String? = null
    @get:Basic
    @get:Column(name = "cataractEye")
    var cataractEye: String? = null
    @get:Basic
    @get:Column(name = "glaucomaEye")
    var glaucomaEye: String? = null
    @get:Basic
    @get:Column(name = "visuoconst_score")
    var visuoconstScore: String? = null
    @get:Basic
    @get:Column(name = "writing_score")
    var writingScore: String? = null

    @Basic
    @Column(name = "HNnumber")
    fun gethNnumber(): String? {
        return hNnumber
    }

    fun sethNnumber(hNnumber: String) {
        this.hNnumber = hNnumber
    }


}
