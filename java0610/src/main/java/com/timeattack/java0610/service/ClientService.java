package com.timeattack.java0610.service;

import com.timeattack.java0610.dto.ClientRequestDto;
import com.timeattack.java0610.model.Client;
import com.timeattack.java0610.model.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public Long update(Long id, ClientRequestDto requestDto) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        client.update(requestDto);
        return id;
    }
}
