package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {



    public static MainFrame frame;

    public static void connect(PackegeData pd){
        try{
            Socket socket = new Socket("127.0.0.1", 5555);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());


            if(pd.getOperationstype().equals("ADD_info")) {
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationstype().equals("ADD")){
                outputStream.writeObject(pd);
            }

            else if(pd.getOperationstype().equals("SEND_MONEY")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationstype().equals("LIST")){
                outputStream.writeObject(pd);
                PackegeData infoFromServer = (PackegeData)inputStream.readObject();
                ArrayList<Customer> arrayListFromServer = infoFromServer.getCustomers();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i)+ "\n";
                }

            }

            else if(pd.getOperationstype().equals("LIST_info")){
                outputStream.writeObject(pd);
                PackegeData infoFromServer = (PackegeData)inputStream.readObject();
                ArrayList<Info> arrayListFromServer = infoFromServer.getInfos();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).toString()+ "\n";
                }
                LoginedMenu.textArea.append(s);
            }
            else if(pd.getOperationstype().equals("GET CUSTOMER")){
                outputStream.writeObject(pd);
                PackegeData infoFromServer = (PackegeData)inputStream.readObject();
                Customer customer = infoFromServer.getCustomer();
                Login.customer = customer;
                SendMoney.customer = customer;
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);


    }
}
