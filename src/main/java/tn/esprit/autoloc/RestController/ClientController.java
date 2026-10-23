package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Service.IClient;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final IClient iClient;

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c) {
        return iClient.ajouterClient(c);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClient.supprimerClient(id);
    }

    @GetMapping("/listClient")
    public List<Client> listClient() {
        return iClient.recupererClients();
    }

    @GetMapping("/setClient")
    public Set<Client> setClient() {
        return new HashSet<>(iClient.findClients());
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return iClient.recupererClientByid(id);
    }

}
