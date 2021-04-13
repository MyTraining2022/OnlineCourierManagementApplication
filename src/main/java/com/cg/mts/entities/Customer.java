package com.cg.mts.entities;

 

import java.util.ArrayList;
import java.util.List;

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

 

@Entity
@Table(name = "customer")
@XmlRootElement
public class Customer {
    @Id
    private int customerId;

 

    private int aadharNo;
    private String firstName;
    private String lastName;
    private int mobileNo;

 

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

 

    /*@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "accountNo")
    private BankAccount account;*/

 

    // @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
     //private List<Complaint> complaint=new ArrayList<>();

 

     @OneToMany(mappedBy = "sender")
     private List<Courier> courierSender = new ArrayList<>();

 

     @OneToMany(mappedBy = "receiver")
    private List<Courier> courierReceiver = new ArrayList<>();

 

    public Customer() {

 

    }

 

    public Customer(int customerId, int aadharNo, String firstName, String lastName, int mobileNo) {
        super();
        this.customerId = customerId;
        this.aadharNo = aadharNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }

 

    public int getCustomerId() {
        return customerId;
    }

 

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

 

    public int getAadharNo() {
        return aadharNo;
    }

 

    public void setAadharNo(int aadharNo) {
        this.aadharNo = aadharNo;
    }

 

    public String getFirstName() {
        return firstName;
    }

 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

 

    public String getLastName() {
        return lastName;
    }

 

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

 

    public int getMobileNo() {
        return mobileNo;
    }

 

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

 

    public Address getAddress() {
        return address;
    }

 

    public void setAddress(Address address) {
        this.address = address;
    }

 

    

 

    public List<Courier> getCourierSender() {
        return courierSender;
    }

 

    public void setCourierSender(List<Courier> courierSender) {
        this.courierSender = courierSender;
    }

 

    public List<Courier> getCourierReceiver() {
        return courierReceiver;
    }

 

    public void setCourierReceiver(List<Courier> courierReceiver) {
        this.courierReceiver = courierReceiver;
    }
    

 

}