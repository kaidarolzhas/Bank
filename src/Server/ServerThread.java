package Server;
import com.company.Customer;
import Database.DBManager;
import com.company.Info;
import Database.PackegeData;

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
                    String me = packegeData.getMe();
                    Double amount = packegeData.getAmount();

                    manager.SendMoney(username,me,amount);
                    break;


                }
                else if(packegeData.getOperationstype().equals("ADD_info")){
                    Info infoClient = packegeData.getInfo();
                    manager.addInfo(infoClient);
                    break;
                }
                else if(packegeData.getOperationstype().equals("LIST")){
                    ArrayList<Customer> CustomerinfoForclient = manager.getAllCustomers();
                    PackegeData toClient = new PackegeData(CustomerinfoForclient);
                    outputStream.writeObject(toClient);
                    break;
                }
                else if(packegeData.getOperationstype().equals("LIST_info")){
                    ArrayList<Info> arrayInfo = manager.getAllInfo(packegeData.getMe());
                    PackegeData toClient = new PackegeData();
                    toClient.setInfos(arrayInfo);
                    outputStream.writeObject(toClient);
                    break;
                }
                else if(packegeData.getOperationstype().equals("MYMONEY")){
                    String name = packegeData.getMe();
                    manager.getMyMoney(name);
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
