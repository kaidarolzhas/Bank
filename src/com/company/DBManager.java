package com.company;

import com.company.*;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static Connection connection;


    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ncustomer?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(String name, int money){
        try {
            String sql = "UPDATE customer SET money=? WHERE username= '" + name + "'";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, money);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public double getMyMoney(String username){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer where username = '"+username + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                double money = resultSet.getInt("money");
                return money;
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return 0;
    }


    public double addMoney(String username){
        double money=0;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer where username = '"+username + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                 money = resultSet.getInt("money");

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return money;
    }

    public void addMoney(String username, double amount){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer where username = '"+username + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                double money = resultSet.getInt("money");
                statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + username + "'");
                statement.setDouble(1, money + amount);
                statement.executeUpdate();
                statement.close();

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public int SendMoney(String username, String me, double amount ) {

        try {
            String sql = "select * from  customer where username='" + username + "' ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                statement = connection.prepareStatement("select * from  customer where username='" + me + "' ");
                ResultSet resultSet0 = statement.executeQuery();
                double userMoney = resultSet.getDouble("money");
                if(resultSet0.next()) {
                    double myMoney = resultSet0.getDouble("money");

                    if (myMoney > amount) {

                        statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + username + "'");
                        statement.setDouble(1, userMoney + amount);
                        statement.executeUpdate();
                        statement.close();

                        statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + me + "'");
                        statement.setDouble(1, myMoney - amount);
                        statement.executeUpdate();
                        statement.close();



                    }
                    else {
                        return 0;
                    }
                }

            }
            else{
                return 0;

            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }

        return 1;


    }

    public Customer getCustomer(String loginn){
        Customer customer = new Customer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE username = '" + loginn + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                double money = resultSet.getInt("money");

                customer = new Customer(id, login, password, name, surname, money);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    public void addCustomer(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO customer (id, username, password, name, surname,money)" + "VALUES (NULL, ?, ?, ?, ?, ?)");
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getSurname());
            statement.setDouble(5, customer.getMoney());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addSendInfo(Info info, String login, double amount) {
        try {
            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO info (id, username, action )"
                    + "VALUES (NULL, ?, ?)");
            statement.setString(1, info.getUsername());
            statement.setString(2, info.getUsername() + " Sent " + amount + " tg to " + login);
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addMoneyInfo(Info info, double amount) {
        try {
            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO info (id, username, action )"
                    + "VALUES (NULL, ?, ?)");
            statement.setString(1, info.getUsername());
            statement.setString(2, info.getUsername() + " Got " + amount + " tg to balance");
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customersList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");
            System.out.println("Completed");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int money = resultSet.getInt("money");
                customersList.add(new Customer(id,username,password, name,surname, money));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customersList;
    }


    public ArrayList<Info> getAllInfo(String name){
        ArrayList<Info> infoList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM info WHERE username = '" + name + "'");           System.out.println("Completed");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String action = resultSet.getString("action");
                infoList.add(new Info(id,username,action));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return infoList;
    }




    public void deleteCustomer(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM visitors WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
