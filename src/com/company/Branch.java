package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer(String customerName, double initialTransaction){
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName, initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        if(findCustomer(customerName) != null){
            Customer existingCustomer = findCustomer(customerName);
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName){
        for(int i = 0; i < this.customers.size(); i++){
            Customer existingCustomer = this.customers.get(i);
            if(existingCustomer.equals(customerName)){
                return existingCustomer;
            }
        }
        return null;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
