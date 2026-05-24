package com.example.crypto.service;

import com.example.crypto.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {
    private final List<Crypto> portfolio = new ArrayList<>();

    public CryptoServiceImpl() {
        portfolio.add(new Crypto(1,"Bitcoin","BTC",90000.0,0.5));
        portfolio.add(new Crypto(2,"Ethereum","ETH",3000.0,2.0));
        portfolio.add(new Crypto(3,"Solana","SOL",150.0,10.0));
    }

    @Override
    public void addCrypto(Crypto crypto) {
        portfolio.add(crypto);
    }

    @Override
    public List<Crypto> getAllCryptos(String sort) {

        // pokud je vstup null nebo prazdna hodnota
        if (sort == null || sort.isBlank()) {
            return portfolio;
        }

        // ok,  povolime jen vymenovane hodnoty
        List<String> allowed = List.of("name","price","quantity");

        // napsal tam nekdo neco jineho, nez jsem povolil? koncime
        if (!allowed.contains(sort)){
            throw new IllegalArgumentException("Neplatny parametr trideni. Povolene hodnoty jsou: name, price, quantity");
        }

        // razeni podla povolenych hodnot
        return switch (sort) {
            case "name" -> portfolio.stream()
                    .sorted(Comparator.comparing(Crypto::getName))
                    .toList();
            case "price" -> portfolio.stream()
                    .sorted(Comparator.comparing(Crypto::getPrice))
                    .toList();
            case "quantity" -> portfolio.stream()
                    .sorted(Comparator.comparing(Crypto::getQuantity))
                    .toList();
            default -> portfolio;
        };
    }

    @Override
    public Crypto getCryptoById(Integer id) {
        return portfolio.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
