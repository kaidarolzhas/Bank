package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread  {
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackegeData packegeData = null;
            while( (packegeData = (PackegeData)inputStream.readObject()) != null){
                if(packegeData.getOperationstype().equals("ADD")){
                    Customer customerClient = packegeData.getCustomer();
                    manager.addCustomer(customerClient);
                    break;

                }
                else if(packegeData.getOperationstype().equals("SEND_MONEY")){
                    String username = packegeData.getUsername();
                    Double amount = packegeData.getAmount();
                    String login = packegeData.getLogin();
                    manager.SendMoney(username,login,amount);
                    break;
                }
                else if(packegeData.getOperationstype().equals("ADD_MONEY")){
                    String username = packegeData.getUsername();
                    Double amount = packegeData.getAmount();
                    manager.addMoney(username,amount);
                    break;
                }

                else if(packegeData.getOperationstype().equals("GET CUSTOMER")){
                    Customer customer = manager.getCustomer(packegeData.getLogin());
                    PackegeData toPercussion = new PackegeData(customer);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packegeData.getOperationstype().equals("ADDSEND_info")){
                    Info infoClient = packegeData.getInfo();
                    String login = packegeData.getLogin();
                    double amount = packegeData.getAmount();
                    manager.addSendInfo(infoClient, login,amount);


                    break;
                }

                else if(packegeData.getOperationstype().equals("ADDMONEY_INFO")){
                    Info infoClient = packegeData.getInfo();
                    double amount = packegeData.getAmount();
                    manager.addMoneyInfo(infoClient,amount);
                    break;
                }
                else if(packegeData.getOperationstype().equals("LIST")){
                    ArrayList<Customer> CustomerinfoForclient = manager.getAllCustomers();
                    PackegeData toClient = new PackegeData(CustomerinfoForclient);
                    outputStream.writeObject(toClient);
                    break;
                }

                else if(packegeData.getOperationstype().equals("LIST_info")){
                    ArrayList<Info> arrayInfo = manager.getAllInfo(packegeData.getLogin());
                    PackegeData toClient = new PackegeData();
                    toClient.setInfos(arrayInfo);
                    outputStream.writeObject(toClient);
                    break;
                }


            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
