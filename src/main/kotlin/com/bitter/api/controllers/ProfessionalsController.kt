package com.bitter.api.controllers

import com.bitter.dao.models.User
import com.bitter.dao.models.common.ProfessionalProfile
import com.bitter.service.ProfessionalService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/professionals")
class ProfessionalsController {

    @Autowired
    lateinit var professionalService: ProfessionalService

    @GetMapping
    @ApiImplicitParams(
        ApiImplicitParam(
            name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"
        ),
        ApiImplicitParam(
            name = "size",
            dataType = "integer",
            paramType = "query",
            value = "Number of records per page."
        ),
        ApiImplicitParam(
            name = "sort",
            allowMultiple = true,
            dataType = "string",
            paramType = "query",
            value = "Sorting criteria in the format: property(,asc|desc). "
                    + "Default sort order is ascending. " + "Multiple sort criteria are supported."
        )
    )
    fun getProfessionals(pageable: Pageable): ResponseEntity<*> {
        return professionalService.findAllProfessionals(pageable)
    }

    @GetMapping("/{id}")
    fun findProfessional(@PathVariable id:String): ResponseEntity<*> {
        return professionalService.findProfessional(id)
    }

    @PutMapping("/{professionalId}/updateProfessionalProfile")
    fun updateProfessionalProfile(@PathVariable professionalId: String,
                                  @RequestBody professionalProfile: ProfessionalProfile) : ResponseEntity<*> {
        return professionalService.updateProfessionalProfile(professionalId, professionalProfile)
    }

}