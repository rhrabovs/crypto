package com.example.crypto.controller;

import com.example.crypto.model.Crypto;
import com.example.crypto.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {
    private final CryptoService cryptoService;

    //konstruktor
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping("")
    public String addCrypto(@RequestBody Crypto crypto) {
        cryptoService.addCrypto(crypto);
        return "Crypto uspesne pridano";
    }

    @GetMapping
    public List<Crypto> getAllCryptos(@RequestParam(required = false) String sort) {
        return cryptoService.getAllCryptos(sort);
    }

    @GetMapping("/{id}")
    public Crypto getCryptoBodyId(@PathVariable Integer id) {
        return cryptoService.getCryptoById(id);
    }

}
