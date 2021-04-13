package com.cg.mts.entities;

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

 

@Entity
public class BankAccount {

 

    @Id
    private int accountNo;
    private String accountHolderName;
    private String accountType;

 

     @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="customerId")
    private Customer customer;

 

    public BankAccount() {

 

    }

 

    public BankAccount(int accountNo, String accountHolderName, String accountType) {
        super();
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
    }

 

    public int getAccountNo() {
        return accountNo;
    }

 

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

 

    public String getAccountHolderName() {
        return accountHolderName;
    }

 

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

 

    public String getAccountType() {
        return accountType;
    }

 

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

 

    public Customer getCustomer() {
        return customer;
    }

 

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

 

}