package com.example.tddstudy.book.iloveyouboss;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
public class AssertTest {

    class InsufficientFundsException extends RuntimeException{
        public InsufficientFundsException(String message){
            super(message);
        }

        private static final long serialVersionUID = 1L;
    }

    @Getter
    class Account{
        private int balance;
        private String name;

        Account(String name){
            this.name = name;
        }

        void deposit(int dollars){
            balance += dollars;
        }

        void withdraw(int dollars){
            if(balance < dollars){
                throw new InsufficientFundsException("balance only " + balance);
            }
            balance -= dollars;
        }



        public boolean hasPositiveBalance(){
            return balance > 0;
        }
    }
    private Account account;

    @BeforeEach
    public void createAccount(){
        account = new Account("an account name");
    }

    @Test
    public void hasPositiveBalance(){
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }

    @Test
    public void depositIncreasesBalance(){
        int initialBalance = account.getBalance();
        account.deposit(100);
        assertTrue(account.getBalance() > initialBalance);

        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void throwsWhenWithdrawingTooMuch(){

        assertThrows(InsufficientFundsException.class, ()->{
            account.withdraw(100);
        });
    }

}
