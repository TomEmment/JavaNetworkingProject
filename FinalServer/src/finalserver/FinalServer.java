/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalserver;


import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FinalServer extends javax.swing.JFrame 
{
   ArrayList clientOutputStreams;
   ArrayList<String> users;
   ArrayList<String>  FieldList;
   String[][] StationFieldList = new String[10][20];
   String Sleep;

   public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;
       
       
       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (IOException ex) 
            {
                ServerChat.append("Unexpected error... \n");
            }

       }
       
       @Override
       public void run() 
       {
            String message, Data = "Data", Login = "Login",NewUser = "NewUser", Request ="DataRequest", Connect="Connect",DissConnect="DissConnect",Client="ClientRequest",Information="Information",FieldRequest ="FieldRequest",ChangeActive="ChangeActive",FieldData="FieldData";
            String[] data;

            String Sending ="";
            String Present;

         

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                   ServerChat.append("Received: " + message + "\n");
                    data = message.split(";");
                    

                    if (data[0].equals(Data)) 
                    {

                            SendMessage("DataSending;"+data[1]+";"+data[2]+";"+data[3]+";"+data[4]+";"+data[5]+";"+data[6]);
                           


                    } 
                    else if (data[0].equals(Login)) 
                    {
                       ServerChat.append("Attempting to login...\n");
                       Present = Log_in(data[1],data[2]);
                       ServerChat.append(Present);
                       SendMessage(Present);

                    } 
                    else if (data[0].equals(NewUser)) 
                    {
                       ServerChat.append("Attempting to login...\n");
                       Present = New_User(data[1],data[2],data[3],data[4]);
                       ServerChat.append(Present);
                       SendMessage(Present);

                    } 
                    else if (data[0].equals(Request)) 
                    {
                int Position = SleepChoice.getSelectedIndex();
                if (Position == 0)
                {
                    Sleep = "2";
                }
                if (Position == 1)
                {
                    Sleep = "5";
                }               
                if (Position == 2)
                {
                    Sleep = "10";
                }                  
                if (Position == 3)
                {
                    Sleep = "30";
                }                  
                 if (Position == 4)
                {
                    Sleep = "60";
                }  
               if (Position == 5)
                {
                    Sleep = "300";
                } 
                        SendMessage("Active;"+data[1]+";"+Sleep+";"+data[3]);

                    }
                    else if (data[0].equals(Connect)) 
                    {
                        users.add(data[1]);
                        ClientList.setText("");
                        for(int i = 0; i < users.size(); i++) {
                            ClientList.append(users.get(i));
                            ClientList.append("\n");
                        }

                    }  

                     else if (data[0].equals(DissConnect)) 
                    {
                        users.remove(data[1]);
                        ClientList.setText("");
                      for(int i = 0; i < users.size(); i++) {
                            ClientList.append(users.get(i));
                            ClientList.append("\n");
                        }
                    } 
                     else if (data[0].equals(ChangeActive)) 
                    {
                        
                        SendMessage("Deactivated;"+data[1]);
                        SendMessage("Active;"+data[2]+";"+Sleep+";"+data[4]);
                    }                           
                     else if (data[0].equals(Client)) 
                    {
                        Sending = "";
                      for(int i = 0; i < users.size(); i++) {
                            Sending = Sending + users.get(i) + ",";
                        }
                         SendMessage("ClientList;" + Sending);
                    }    
                     else if (data[0].equals(FieldRequest)) 
                    {
                        SendMessage("FieldPull;"+data[1]+";"+data[2]);

                    }  
                     else if (data[0].equals(Information)) 
                    {
                        
                        SendMessage("StaticData;"+data[1]+";"+data[2]+";"+data[3]+";"+data[4]);

                    }     
                     else if (data[0].equals(FieldData)) 
                    {
                        
                        SendMessage("FieldData;"+data[1]+";"+data[2]);

                    }   
                    else 
                    {
                        ServerChat.append("No Conditions were met. \n");
                    }
                } 
             } 
             catch (IOException | NumberFormatException ex) 
             {
                ServerChat.append("Lost a connection. \n");

             } 
	} 
    }

    public FinalServer() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ServerChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientList = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        b_start = new javax.swing.JButton();
        b_end = new javax.swing.JButton();
        SleepChoice = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ServerChat.setColumns(20);
        ServerChat.setRows(5);
        jScrollPane1.setViewportView(ServerChat);

        ClientList.setColumns(20);
        ClientList.setRows(5);
        jScrollPane2.setViewportView(ClientList);

        jLabel1.setText("Client Chat:");

        jLabel2.setText("Active Client List:");

        b_start.setText("Start");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_end.setText("End");
        b_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_endActionPerformed(evt);
            }
        });

        SleepChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Seconds", "5 Seconds", "10 Seconds", "30 Seconds", "1 Minute", "5 Minutes" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_start)
                        .addGap(40, 40, 40)
                        .addComponent(b_end)
                        .addGap(189, 189, 189)
                        .addComponent(SleepChoice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_start)
                    .addComponent(b_end)
                    .addComponent(SleepChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
        {
        ServerChat.append("Server Starting... \n");
        Thread starter = new Thread(new FinalServer.ServerStart());
        starter.start();
        
    }
    }//GEN-LAST:event_b_startActionPerformed

    private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
            try 
        {
            Thread.sleep(5000);                 //5000 milliseconds is five second.
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        ServerChat.append("Server stopping... \n");
        
    
    
    }//GEN-LAST:event_b_endActionPerformed
 
    
    

    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new FinalServer().setVisible(true);
            }
        });
    }
        public static String Log_in(String Username, String Password){
        List<String> Userdata;
        Userdata = GetUsers();
        int size = Userdata.size()-1;
        String Present = "Unsuccesfull";
        while (size >= 1){
            if ((Userdata.get(size).equals(Password))&&(Userdata.get(size-1).equals(Username))){
                Present = "Succesfull";
                System.out.println("User found");
            }
            size = size -2;
        }
        if ("Unsuccesfull".equals(Present)){
            System.out.println("Not User");
        }
        return Present;
    }
        
       
    public static String New_User(String Username, String Password,String New_Username, String New_Password){
        String Present ;
        Present = Log_in(Username, Password);
        if(Present.equals("Succesfull")){
            AddUser(New_Username, New_Password);
            return "Succesfull";
        }else{
            System.out.println("Could not add new user");
            return "Unsuccesfull";
        }
    }
    public static void AddUser(String New_Username, String New_Password){
        String User_Already_Present = Log_in(New_Username, New_Password);
        if (User_Already_Present.equals("Succesfull")){
            System.out.println("Unable to add new user as already exists");
        }
        else{
        try{
            FileWriter fout = new FileWriter("Admin.txt",true);
            BufferedWriter x = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(x);
            pout.println("");
            pout.println(New_Username);
            pout.println(New_Password);
            pout.close();
            x.close();
            fout.close();
            System.out.println("New User added!");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
    }
        
    }

        
public void SendMessage(String message) 
    {
       
        
        
    
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {

            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
                writer.flush();


            } 
            catch (Exception ex) 
            {
		ServerChat.append("Error telling everyone. \n");
            }
        } 
    }
    public static List<String> GetUsers(){
        List<String> Userdata = new ArrayList<>();
        try{
            Path path = Paths.get("Admin.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Userdata.add(line);

            }
            scanner.close();
            System.out.println("Data collected");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
        return Userdata;
    }
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  
            FieldList = new ArrayList();
            FieldList.add("End");

            try 
            {
                ServerSocket serverSock = new ServerSocket(2222);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);
				Thread listener = new Thread(new FinalServer.ClientHandler(clientSock, writer));
				listener.start();
				ServerChat.append("Got a connection. \n");
                }
            }
            catch (IOException ex)
            {
                ServerChat.append("Error making a connection. \n");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ClientList;
    private javax.swing.JTextArea ServerChat;
    private javax.swing.JComboBox<String> SleepChoice;
    private javax.swing.JButton b_end;
    private javax.swing.JButton b_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
