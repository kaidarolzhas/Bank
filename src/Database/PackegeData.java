package Database;

import com.company.Customer;
import com.company.Info;

import java.io.Serializable;
import java.util.ArrayList;

public class PackegeData implements Serializable {
    private String operationstype;
    private Customer customer;
    private Info info;
    private ArrayList<Customer> customers;
    private ArrayList<Info> infos;

    private String login;
    private String username;
    private  double amount;

    public PackegeData(String operationstype, String login, String username, double amount) {
        this.operationstype = operationstype;
        this.login = login;
        this.username = username;
        this.amount = amount;
    }

    public PackegeData(String operationstype, String login) {
        this.operationstype = operationstype;
        this.login = login;
    }

    public PackegeData(Customer customer) {
        this.customer = customer;
    }

    public PackegeData(String operationstype, Customer customer) {
        this.operationstype = operationstype;
        this.customer = customer;
    }

    public PackegeData(String operationstype,String username,   double amount) {
        this.operationstype = operationstype;
        this.username = username;
        this.amount = amount;
    }

    public PackegeData(String operationstype, Info info) {
        this.operationstype = operationstype;
        this.info = info;
    }

    public PackegeData(String operationstype) {
        this.operationstype = operationstype;
    }

    public PackegeData(ArrayList<com.company.Customer> customers) {
        this.customers = customers;
    }

    public PackegeData() {
    }

    public void setOperationstype(String operationstype) {
        this.operationstype = operationstype;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setInfos(ArrayList<Info> infos) {
        this.infos = infos;
    }

    public ArrayList<Info> getInfos() {
        return infos;
    }

    public String getOperationstype() {
        return operationstype;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public double getAmount() {
        return amount;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
