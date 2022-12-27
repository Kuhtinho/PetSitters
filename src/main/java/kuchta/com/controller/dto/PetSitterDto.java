package kuchta.com.controller.dto;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import java.time.LocalDate;

@Builder
public record PetSitterDto (

        Long id,
        @Length(min = 2) String username,
        @Length(min = 2) String surname,
        LocalDate birthdate,
        String city,
        @Email String email,
        @Length(min = 11, max = 12) String pesel,
        @Length(min = 5, max = 5) String postcode,
        String street,
        Integer streetNumber,
        String userDescription,
        String homeDescription,
        Long petSitterPhotoId
) {

}
