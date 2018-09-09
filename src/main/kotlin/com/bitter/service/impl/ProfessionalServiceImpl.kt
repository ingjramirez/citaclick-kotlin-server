package com.bitter.service.impl

import com.bitter.api.dto.UserDTO
import com.bitter.dao.enums.ErrorCodes
import com.bitter.dao.models.User
import com.bitter.dao.models.common.Error
import com.bitter.dao.models.common.ProfessionalProfile
import com.bitter.dao.repositories.UserRepository
import com.bitter.service.ProfessionalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfessionalServiceImpl : ProfessionalService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun updateProfessionalProfile(professionalId: String,
                                           professionalProfile: ProfessionalProfile): ResponseEntity<*> {

        val professional = findProfessionalById(professionalId)
        return if (!professional.isPresent)
            ResponseEntity(Error(ErrorCodes.RESOURCE_NOT_FOUND), HttpStatus.NOT_FOUND)
        else {
            val updatedProfessional = professional.get()
            updatedProfessional.profile = professionalProfile
            userRepository.save(updatedProfessional)
            ResponseEntity(UserDTO(updatedProfessional), HttpStatus.OK)
        }
    }

    private fun findProfessionalById(id: String): Optional<User?> {

        return userRepository.findById(id)
    }

}
