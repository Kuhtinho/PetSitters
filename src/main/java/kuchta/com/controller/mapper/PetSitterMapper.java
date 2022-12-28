package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.model.petsitter.PetSitter;

import java.util.List;
import java.util.stream.Collectors;

public class PetSitterMapper {

    public static List<PetSitterDto> mapToPetSitterDtoList(List<PetSitter> petSitters) {
        return petSitters.stream()
                .map(PetSitterMapper::mapToPetSitterDto)
                .collect(Collectors.toList());
    }

    public static PetSitterDto mapToPetSitterDto(PetSitter petSitter) {
        return PetSitterDto.builder()
                .id(petSitter.getId())
                .username(petSitter.getUsername())
                .surname(petSitter.getSurname())
                .birthdate(petSitter.getBirthdate())
                .pesel(petSitter.getPesel())
                .email(petSitter.getEmail())
                .city(petSitter.getCity())
                .street(petSitter.getStreet())
                .streetNumber(petSitter.getStreetNumber())
                .postcode(petSitter.getPostcode())
                .userDescription(petSitter.getUserDescription())
                .homeDescription(petSitter.getHomeDescription())
                .petSitterPhotoId(petSitter.getPetSitterPhotoId())
                .build();
    }

    public static PetSitter mapToPetSitter(PetSitterDto petSitterDto) {
        return PetSitter.builder()
                .username(petSitterDto.username())
                .surname(petSitterDto.surname())
                .birthdate(petSitterDto.birthdate())
                .pesel(petSitterDto.pesel())
                .email(petSitterDto.email())
                .city(petSitterDto.city())
                .street(petSitterDto.street())
                .streetNumber(petSitterDto.streetNumber())
                .postcode(petSitterDto.postcode())
                .userDescription(petSitterDto.userDescription())
                .homeDescription(petSitterDto.homeDescription())
                .petSitterPhotoId(petSitterDto.petSitterPhotoId())
                .build();
    }

}
