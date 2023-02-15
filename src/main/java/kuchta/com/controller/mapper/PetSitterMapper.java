package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.model.petsitter.PetSitter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PetSitterMapper {
    PetSitterMapper INSTANCE = Mappers.getMapper( PetSitterMapper.class );
    @Mapping(target="id", source="id")
    @Mapping(target="username", source="username")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "birthdate", source = "birthdate",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "pesel", source = "pesel")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "streetNumber", source = "streetNumber")
    @Mapping(target = "postcode", source = "postcode")
    @Mapping(target = "userDescription", source = "userDescription")
    @Mapping(target = "homeDescription", source = "homeDescription")
    @Mapping(target = "petSitterPhotoId", source = "petSitterPhotoId")
    PetSitterDto toPetSitterDto(PetSitter entity);

    @Mapping(target="id", source="id")
    @Mapping(target="username", source="username")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "birthdate", source = "birthdate",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "pesel", source = "pesel")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "streetNumber", source = "streetNumber")
    @Mapping(target = "postcode", source = "postcode")
    @Mapping(target = "userDescription", source = "userDescription")
    @Mapping(target = "homeDescription", source = "homeDescription")
    @Mapping(target = "petSitterPhotoId", source = "petSitterPhotoId")
    PetSitter toPetSitter(PetSitterDto dto);

    List<PetSitterDto> map(List<PetSitter> petSitters);
}
