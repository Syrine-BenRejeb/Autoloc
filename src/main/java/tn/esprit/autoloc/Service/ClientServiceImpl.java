
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.DTO.ClientRequestDTO;
import tn.esprit.autoloc.DTO.ClientResponseDTO;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Repository.ClientRepo;
import tn.esprit.autoloc.exception.ResourceNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {

    private final IClientMapper clientMapper;
    private final ClientRepo clientRepo;

    @Override
    public Client ajouterClient(Client cl) {
        if (cl.getIdClient() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau client ne doit pas avoir d'identifiant");
        }

        return clientRepo.save(cl);
    }

    @Override
    public void supprimerClient(long idClient) {
        if (!clientRepo.existsById(idClient)) {
            throw new ResourceNotFoundException("Client", idClient);
        }

        clientRepo.deleteById(idClient);
    }

    @Override
    public List<Client> recupererClients() {
        return clientRepo.findAll();
    }

    @Override
    public Set<Client> findClients() {
        return new HashSet<>(clientRepo.findAll());
    }

    @Override
    public Client recupererClientByid(long idClient) {
        return clientRepo.findById(idClient)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client", idClient));
    }

    public Client updateClient(Client cl) {
        Client existant = clientRepo.findById(cl.getIdClient())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client", cl.getIdClient()));

        existant.setNom(cl.getNom());
        existant.setPrenom(cl.getPrenom());
        existant.setEmail(cl.getEmail());
        existant.setTelephone(cl.getTelephone());
        existant.setNumPermis(cl.getNumPermis());
        existant.setDateInscription(cl.getDateInscription());

        return clientRepo.save(existant);
    }

    @Override
    public ClientResponseDTO ajouterClientdto(ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);

        Client savedClient = clientRepo.save(client);

        return clientMapper.todto(savedClient);
    }

    @Override
    public ClientResponseDTO recupererClientdto(Long idClient) {
        Client client = clientRepo.findById(idClient)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client", idClient));

        return clientMapper.todto(client);
    }
}
