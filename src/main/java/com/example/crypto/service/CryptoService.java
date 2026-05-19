package com.example.crypto.service;

import com.example.crypto.model.Crypto;

import java.util.List;

public interface CryptoService {
    void addCrypto(Crypto crypto);
    List<Crypto> getAllCryptos(String sort);
    Crypto getCryptoById(Integer id);
}
