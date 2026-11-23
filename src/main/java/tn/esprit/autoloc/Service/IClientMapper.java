package tn.esprit.autoloc.Service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ClientRequestDTO;
import tn.esprit.autoloc.DTO.ClientResponseDTO;
import tn.esprit.autoloc.Entities.Client;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    @Mapping(source = "idClient", target = "id")
    ClientResponseDTO todto(Client client);

    Client toEntity(ClientRequestDTO dto);
}