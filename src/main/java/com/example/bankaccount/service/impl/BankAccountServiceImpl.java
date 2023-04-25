package com.example.bankaccount.service.impl;

import com.example.bankaccount.entity.BankAccount;
import com.example.bankaccount.repository.BankAccountRepository;
import com.example.bankaccount.service.BankAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found"));
    }

    @Override
    public BankAccount getBankAccountByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found"));
    }

    @Override
    @Transactional
    public void updateBankAccountBalance(Long id, double amount) {
        BankAccount bankAccount = getBankAccountById(id);
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        bankAccountRepository.save(bankAccount);
    }
}
