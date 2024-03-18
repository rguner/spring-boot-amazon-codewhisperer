package com.guner.controller;

import com.guner.entity.Wallet;
import com.guner.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/wallets")
public class WalletController {

    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet){
        Wallet savedWallet = walletService.createWallet(wallet);
        return new ResponseEntity<>(savedWallet, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/wallets/1
    @GetMapping("{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable("id") Long walletId){
        Wallet Wallet = walletService.getWalletById(walletId);
        return new ResponseEntity<>(Wallet, HttpStatus.OK);
    }

    // http://localhost:8080/api/wallets
    @GetMapping
    public ResponseEntity<List<Wallet>> getAllWallets(){
        List<Wallet> wallets = walletService.getAllWallets();
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/wallets/1
    public ResponseEntity<Wallet> updateWallet(@PathVariable("id") Long walletId,
                                           @RequestBody Wallet wallet){
        wallet.setId(walletId);
        Wallet updatedWallet = walletService.updateWallet(wallet);
        return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWallet(@PathVariable("id") Long walletId){
        walletService.deleteWallet(walletId);
        return new ResponseEntity<>("Wallet successfully deleted!", HttpStatus.OK);
    }
}
