package com.example.crypto.controller;

import com.example.crypto.model.Crypto;
import com.example.crypto.service.CryptoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> addCrypto(@RequestBody Crypto crypto) {
        cryptoService.addCrypto(crypto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Crypto uspesne pridano");
    }

    @GetMapping
    public ResponseEntity<List<Crypto>> getAllCryptos(@RequestParam(required = false) String sort) {
        List<Crypto> result = cryptoService.getAllCryptos(sort);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCryptoBodyId(@PathVariable Integer id) {
        Crypto crypto = cryptoService.getCryptoById(id);

        if (crypto == null){
            //return ResponseEntity.notFound().build();
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Crypto s id="+id+" neexistuje");
        }
        return  ResponseEntity.ok(crypto);
        // return cryptoService.getCryptoById(id);
    }

}
