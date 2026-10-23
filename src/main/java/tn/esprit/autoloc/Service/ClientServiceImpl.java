package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.service.registry.HttpServiceGroupConfigurer;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Repository.ClientRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl  implements IClient {
    private final ClientRepo clientRepo;

    @Override
    public Client ajouterClient(Client cl) {
        return null;
    }

    @Override
    public void supprimerClient(long idClient) {

    }

    @Override
    public List<Client> recupererClients() {
        return List.of();
    }

    @Override
    public Set<Client> findClients() {
        return Set.of();
    }

    @Override
    public Client recupererClientByid(long idClient) {
        return null;
    }
}
