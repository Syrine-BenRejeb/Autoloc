package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.DTO.ClientRequestDTO;
import tn.esprit.autoloc.DTO.ClientResponseDTO;
import tn.esprit.autoloc.Entities.Client;

import java.util.List;
import java.util.Set;

public interface IClient {
    Client ajouterClient(Client cl);
    public void supprimerClient(long idClient);
    List<Client> recupererClients();
    Set<Client> findClients();
    Client recupererClientByid(long idClient);
    ClientResponseDTO ajouterClientdto(ClientRequestDTO dto);
    ClientResponseDTO recupererClientdto(Long idClient);
}
