package com.timeattack.spring0617.controller;

import com.timeattack.spring0617.dto.ClientRequestDto;
import com.timeattack.spring0617.model.Client;
import com.timeattack.spring0617.model.ClientRepository;
import com.timeattack.spring0617.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    @PostMapping("/create")
    public Long createClient(@RequestBody ClientRequestDto requestDto){
        Client client = new Client(requestDto);
        clientRepository.save(client);
        return client.getId();
    }

    @GetMapping("/read/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @PutMapping("/update/{id}")
    public Long updateClient(@PathVariable Long id, @RequestBody ClientRequestDto requestDto) {
        clientService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
        return id;
    }
}
