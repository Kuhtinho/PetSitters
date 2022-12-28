package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.PetOwnerDto;
import kuchta.com.model.petowner.PetOwner;

public class PetOwnerMapper {

    public static PetOwner mapToPetOwner(PetOwnerDto petOwnerDto) {
        return PetOwner.builder()
                .id(petOwnerDto.id())
                .username(petOwnerDto.username())
                .surname(petOwnerDto.surname())
                .birthdate(petOwnerDto.birthdate())
                .pesel(petOwnerDto.pesel())
                .email(petOwnerDto.email())
                .city(petOwnerDto.city())
                .street(petOwnerDto.street())
                .streetNumber(petOwnerDto.streetNumber())
                .postcode(petOwnerDto.postcode())
                .userDescription(petOwnerDto.userDescription())
                .homeDescription(petOwnerDto.homeDescription())
                .petDescription(petOwnerDto.petDescription())
                .petOwnerPhotoId(petOwnerDto.petOwnerPhotoId())
                .build();
    }

    public static PetOwnerDto mapToPetOwnerDto(PetOwner petOwner) {
        return PetOwnerDto.builder()
                .id(petOwner.getId())
                .username(petOwner.getUsername())
                .surname(petOwner.getSurname())
                .birthdate(petOwner.getBirthdate())
                .pesel(petOwner.getPesel())
                .email(petOwner.getEmail())
                .city(petOwner.getCity())
                .street(petOwner.getStreet())
                .streetNumber(petOwner.getStreetNumber())
                .postcode(petOwner.getPostcode())
                .userDescription(petOwner.getUserDescription())
                .homeDescription(petOwner.getHomeDescription())
                .petDescription(petOwner.getPetDescription())
                .petOwnerPhotoId(petOwner.getPetOwnerPhotoId())
                .build();
    }
}
