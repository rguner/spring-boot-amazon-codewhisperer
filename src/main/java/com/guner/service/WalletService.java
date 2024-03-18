package com.guner.service;

import com.guner.entity.Wallet;
import com.guner.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WalletService {

    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet getWalletById(Long walletId) {
        Optional<Wallet> optionalWallet = walletRepository.findById(walletId);
        return optionalWallet.get();
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet updateWallet(Wallet wallet) {
        Wallet existingWallet = walletRepository.findById(wallet.getId()).get();
        existingWallet.setName(wallet.getName());
        Wallet updatedWallet = walletRepository.save(existingWallet);
        return updatedWallet;
    }

    public void deleteWallet(Long walletId) {
        walletRepository.deleteById(walletId);
    }
}
