package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.PetOwnerDto;
import kuchta.com.model.petowner.PetOwner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetOwnerMapper {
    PetOwnerMapper INSTANCE = Mappers.getMapper( PetOwnerMapper.class );
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
    @Mapping(target = "petDescription", source = "petDescription")
    @Mapping(target = "petOwnerPhotoId", source = "petOwnerPhotoId")
    PetOwnerDto toPetOwnerDto(PetOwner entity);

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
    @Mapping(target = "petDescription", source = "petDescription")
    @Mapping(target = "petOwnerPhotoId", source = "petOwnerPhotoId")
    PetOwner toPetOwner(PetOwnerDto dto);
}
