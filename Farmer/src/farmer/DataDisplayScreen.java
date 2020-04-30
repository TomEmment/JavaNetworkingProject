/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.ss.usermodel.*;
//import static javaserver.Server1.din;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thoma
 */
public class DataDisplayScreen extends javax.swing.JFrame {
    
    int Instance = 0;
    String Choice = "";
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    String StaticData;
    String TimeData;
    String TempreatureData = "TempreatureData:";
    String HumidityData = "HumidityData:";
    String SoilPHData = "SoilPHData:";
    String WindSpeedData = "WindSpeedData:";    
    
 
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new DataDisplayScreen.IncomingReader());
         IncomingReader.start();
    }
/**
 * 
     * Creates new form DataDisplayScreen
     */
    public DataDisplayScreen(String Station) {
        initComponents();
        try     
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("Connect;FarmerJohn");
                writer.flush(); 
                writer.println("DataRequest;"+Station);
                writer.flush(); 
                isConnected = true; 
            } 
            catch (IOException ex) 
            {
                System.out.println("Cannot Connect! Try Again. \n");
            }
            
            ListenThread(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisplayTempreatureData = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        DisplaySoilPHData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ChartPannel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        WeatherStationData = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DisplayHumidityData = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DisplayWindSpeedData = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        VariableX = new javax.swing.JComboBox<>();
        VariableY = new javax.swing.JComboBox<>();
        saveText = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        saveLabel = new javax.swing.JLabel();
        fileTypeCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DisplayTempreatureData.setColumns(20);
        DisplayTempreatureData.setRows(5);
        jScrollPane2.setViewportView(DisplayTempreatureData);

        DisplaySoilPHData.setColumns(20);
        DisplaySoilPHData.setRows(5);
        jScrollPane3.setViewportView(DisplaySoilPHData);

        jLabel2.setText("Humidity Data:");

        jLabel1.setText("Tempreature Data:");

        javax.swing.GroupLayout ChartPannelLayout = new javax.swing.GroupLayout(ChartPannel);
        ChartPannel.setLayout(ChartPannelLayout);
        ChartPannelLayout.setHorizontalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        ChartPannelLayout.setVerticalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        WeatherStationData.setColumns(20);
        WeatherStationData.setRows(5);
        jScrollPane5.setViewportView(WeatherStationData);

        jLabel5.setText("Station information:");

        DisplayHumidityData.setColumns(20);
        DisplayHumidityData.setRows(5);
        jScrollPane6.setViewportView(DisplayHumidityData);

        jLabel3.setText("SoilPH Data:");

        DisplayWindSpeedData.setColumns(20);
        DisplayWindSpeedData.setRows(5);
        jScrollPane4.setViewportView(DisplayWindSpeedData);

        jLabel4.setText("Wind Speed Data");

        VariableX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "SoilPH", "WIndSpeed" }));
        VariableX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VariableXActionPerformed(evt);
            }
        });

        VariableY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "SoilPH", "WIndSpeed" }));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        saveLabel.setText("Filename:");

        fileTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Text", "Excel" }));
        fileTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileTypeComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(saveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fileTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(saveButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                                .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(181, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(VariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(VariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VariableY)
                            .addComponent(VariableX))
                        .addGap(76, 76, 76)
                        .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton)
                            .addComponent(saveLabel)
                            .addComponent(fileTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if("Text".equals(fileTypeCombo.getSelectedItem().toString())){
// collect all data
        // format username, static data, time, temperature, temp, humidity,soilph, windseed
        String fileName = saveText.getText()+".txt";
        try{
            FileWriter fout = new FileWriter(fileName,true);
            BufferedWriter x = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(x);
            pout.println(username);
            pout.println(StaticData);
            pout.println(TimeData);
            pout.println(TempreatureData);
            pout.println(HumidityData);
            pout.println(SoilPHData);
            pout.println(WindSpeedData);
            pout.close();
            x.close();
            fout.close();

        }catch(IOException e){
            
        }
            
        }else{
            // Save file to Excel
            String fileName = saveText.getText()+".xlsx";
            try {
                XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(fileName)));
            } catch (IOException ex) {
                Logger.getLogger(DataDisplayScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void fileTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileTypeComboActionPerformed

    private void VariableXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VariableXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VariableXActionPerformed

    
    
    
   
   
   public void LineChart_AWT( ) {
       
       String chartTitle = "Time Plot For selected variables";
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Time","Values",
         createDataset());
         
        
            
           ChartPannel.setLayout(new java.awt.BorderLayout());
            
            ChartPanel CP = new ChartPanel(lineChart);
            
            ChartPannel.add(CP,BorderLayout.CENTER);
                    ChartPannel.validate();
      
      
   }
   private DefaultCategoryDataset createDataset() {
       
       
      int VarX = VariableX.getSelectedIndex();
      int VarY = VariableY.getSelectedIndex();
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      
      
      if (VarX==0){
          
            if (VarY==0){
                    line_chart_dataset = ChopData(TempreatureData, TempreatureData);
                }
                if (VarY==1){
                    line_chart_dataset = ChopData(TempreatureData, HumidityData);
                }
                if (VarY==2){
                    line_chart_dataset = ChopData(TempreatureData, SoilPHData);
                }
                if (VarY==3){
                    line_chart_dataset = ChopData(TempreatureData, WindSpeedData);                    
            }
      }
      if (VarX==1){
          
            if (VarY==0){
                    line_chart_dataset = ChopData(HumidityData, TempreatureData);
                }
                if (VarY==1){
                    line_chart_dataset = ChopData(HumidityData, HumidityData);
                }
                if (VarY==2){
                    line_chart_dataset = ChopData(HumidityData, SoilPHData);
                }
                if (VarY==3){
                    line_chart_dataset = ChopData(HumidityData, WindSpeedData);                    
            }
      }           
      if (VarX==2){
          
            if (VarY==0){
                    line_chart_dataset = ChopData(SoilPHData, TempreatureData);
                }
                if (VarY==1){
                    line_chart_dataset = ChopData(SoilPHData, HumidityData);
                }
                if (VarY==2){
                    line_chart_dataset = ChopData(SoilPHData, SoilPHData);
                }
                if (VarY==3){
                    line_chart_dataset = ChopData(SoilPHData, WindSpeedData);                    
            }
      }                
      if (VarX==3){
          
            if (VarY==0){
                    line_chart_dataset = ChopData(WindSpeedData, TempreatureData);
                }
                if (VarY==1){
                    line_chart_dataset = ChopData(WindSpeedData, HumidityData);
                }
                if (VarY==2){
                    line_chart_dataset = ChopData(WindSpeedData, SoilPHData);
                }
                if (VarY==3){
                    line_chart_dataset = ChopData(WindSpeedData, WindSpeedData);                    
            }
      }     
      

      
    return line_chart_dataset;
   }
 
 
 private DefaultCategoryDataset ChopData(String VarX, String VarY) {
     DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
     
     String[] InitialXdata;
     String[] InitialYdata;
     String[] Xdata;
     String[] Ydata;
     String[] TimeDisplayData;
     String VariableXName;
     String VariableYName;
     int Amount = 0;
     int Position;
     
     InitialXdata = VarX.split(":");
     InitialYdata = VarY.split(":");
     VariableXName = InitialXdata[0];
     VariableYName = InitialYdata[0];
     Xdata = InitialXdata[1].split(",");
     Ydata = InitialYdata[1].split(",");
     TimeDisplayData = TimeData.split(",");
     
     Position = Xdata.length-12;
     
     while (Amount<10)
     {
      line_chart_dataset.addValue( Integer.parseInt(Xdata[Position]), VariableXName , TimeDisplayData[Position] );

      Amount = Amount + 1;
      Position = Position +1;
              }
     Position = Xdata.length-12;
     Amount = 0;
     while (Amount<10)
     {

      line_chart_dataset.addValue( Integer.parseInt(Ydata[Position]), VariableYName , TimeDisplayData[Position] );
      Amount = Amount + 1;
      Position = Position +1;
              }
     return line_chart_dataset;
 }
 
 
 
 
    public void printTextField() {
     DisplayTempreatureData.setText(TempreatureData);
    DisplayHumidityData.setText(HumidityData);
    DisplaySoilPHData.setText(SoilPHData);
    DisplayWindSpeedData.setText(WindSpeedData);

    }
   public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, Done = "DataSending", Done1 ="StaticData";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");
                     if (data[0].equals(Done)) 
                     {
                        TimeData = TimeData + data[1];
                        TempreatureData = TempreatureData +data[2];
                        HumidityData = HumidityData + data[3];
                        SoilPHData = SoilPHData + data[4];
                        WindSpeedData = WindSpeedData + data[5]; 
                        printTextField();
                        LineChart_AWT( );
                     } 
                     else if (data[0].equals(Done1)) 
                     {
                        username = data[1];
                         StaticData = data[2];
                        WeatherStationData.append(StaticData);
                     } 
                     else
                     {
                         System.out.println("No conditions met");
                     }
                     
                }
           }catch(IOException ex) { 
           System.out.println("Error reciving message from server");
           }
        }
    }
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDisplayScreen("WeatherStation1").setVisible(true);
          }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartPannel;
    private javax.swing.JTextArea DisplayHumidityData;
    private javax.swing.JTextArea DisplaySoilPHData;
    private javax.swing.JTextArea DisplayTempreatureData;
    private javax.swing.JTextArea DisplayWindSpeedData;
    private javax.swing.JComboBox<String> VariableX;
    private javax.swing.JComboBox<String> VariableY;
    private javax.swing.JTextArea WeatherStationData;
    private javax.swing.JComboBox<String> fileTypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JTextField saveText;
    // End of variables declaration//GEN-END:variables
}
