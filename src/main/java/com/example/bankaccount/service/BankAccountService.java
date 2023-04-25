package com.example.bankaccount.service;
import com.example.bankaccount.entity.BankAccount;

public interface BankAccountService {

    BankAccount createBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountById(Long id);
    BankAccount getBankAccountByAccountNumber(String accountNumber);
    void updateBankAccountBalance(Long id, double amount);
}
