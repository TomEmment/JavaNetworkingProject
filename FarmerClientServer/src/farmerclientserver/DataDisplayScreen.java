/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Thoma
 */
public class DataDisplayScreen extends javax.swing.JFrame {
<<<<<<< HEAD

    int[][] data = new int[5][200];

=======
>>>>>>> parent of 35d7139... Data Initial
    int[][] data = new int[5][100];
    int Instance = 0;
    int Choice = 0;
    String Variable = "A";
    private Plot_Data Chart;
/**
     * Creates new form DataDisplayScreen
     */
    public DataDisplayScreen() {
        initComponents();
<<<<<<< HEAD
        InitializeMatrix();
        Gatherdata();
        initComponents();
=======
        Gatherdata();
>>>>>>> parent of 35d7139... Data Initial
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
        Tempreature = new java.awt.Button();
        Stop = new java.awt.Button();
        CropHeight = new java.awt.Button();
        Rainfall = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        RainfallData = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TempreatureData = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        CropHeightData = new javax.swing.JTextArea();
        Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tempreature.setActionCommand("Tempreature");
        Tempreature.setLabel("Tempreature");
        Tempreature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempreatureActionPerformed(evt);
            }
        });

        Stop.setActionCommand("Stop");
        Stop.setLabel("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        CropHeight.setActionCommand("CropHeight");
        CropHeight.setLabel("CropHeight");
        CropHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CropHeightActionPerformed(evt);
            }
        });

        Rainfall.setActionCommand("Rainfall");
        Rainfall.setLabel("Rainfall");
        Rainfall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RainfallActionPerformed(evt);
            }
        });

        RainfallData.setColumns(20);
        RainfallData.setRows(5);
        jScrollPane1.setViewportView(RainfallData);

        TempreatureData.setColumns(20);
        TempreatureData.setRows(5);
        jScrollPane2.setViewportView(TempreatureData);

        CropHeightData.setColumns(20);
        CropHeightData.setRows(5);
        jScrollPane3.setViewportView(CropHeightData);

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
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
                        .addComponent(Tempreature, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rainfall, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CropHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 354, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tempreature, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rainfall, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CropHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 198, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Update)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TempreatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempreatureActionPerformed
        Choice = 1;
        Constant_Update();
    }//GEN-LAST:event_TempreatureActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        Choice = 0;
        Constant_Update();
    }//GEN-LAST:event_StopActionPerformed

    private void CropHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CropHeightActionPerformed

        Choice = 3;
        Constant_Update();
    }//GEN-LAST:event_CropHeightActionPerformed

    private void RainfallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RainfallActionPerformed

        Choice = 2;
        Constant_Update();
    }//GEN-LAST:event_RainfallActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        Gatherdata();
    }//GEN-LAST:event_UpdateActionPerformed

<<<<<<< HEAD

private void  InitializeMatrix() {  //Change this to a data request from server
    
    int x = data[0].length - 1;
=======
    
   private int[][]  Gatherdata() {  //Change this to a data request from server
    printTextField();
       
       
    int x = data[0].length - 1;
    int test = 14;
>>>>>>> parent of 35d7139... Data Initial
    while(x>=0){

    int test = 10;
    while(x>0){

        data[0][x] = 0;
        data[1][x] = 0;
        data[2][x] = 0;
        data[3][x] = 0;
        data[4][x] = 0;
<<<<<<< HEAD


    }
    
 
   }   
}
   private void  Gatherdata() {
        
        
           //Change this to a data request from server
    
    int x = data[0].length - 1;
    int test = 14;
    while(x>=0){

=======
>>>>>>> parent of 35d7139... Data Initial
        if (x<9)
        {
            data[0][x] = test;
            data[1][x] = test;
            data[2][x] = test +5;
            data[3][x] = test +7;  
            data[4][x] = (test+10)/2;
            test = test-1;
        }
        x=x-1;
    }
    
    printTextField();
   }
   
    public void Constant_Update(){
        if(Choice == 1)  
        {
            Variable = "Tempreature";
        }
        if(Choice == 2)  
        {
            Variable = "Rainfall";
        }
        if(Choice == 3)  
        {
            Variable = "CropHeight";
        }
       // SwingUtilities.invokeLater(() -> {  
        Plot_Data Chart = new Plot_Data(Variable+" vs Time",Variable,data,Choice);  
        Chart.setSize(800, 400);  
        Chart.setLocationRelativeTo(null);  
        Chart.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Chart.setVisible(true);  
    //  });
    }
    public void printTextField() {
    int x = 0;
    int Data;
    int i;

    String Printable = "";
    String Printable1 = "";
    String Printable2 = "";
    System.out.println(data[3][0]);
    while(data[4][x]>0){
        System.out.println("We made it");
        i = 1;
        Data = data[i][x];
        Printable = Printable + ", " + Integer.toString(Data);
        i = 2;
        Data = data[i][x];
        Printable1 =  Printable1 + ", " +Integer.toString(Data);            
        i = 3;
        Data = data[i][x];
        Printable2 = Printable2 + ", " +Integer.toString(Data);
            
         x = x+1;
    }
    TempreatureData.setText(Printable);
    RainfallData.setText(Printable1);
    CropHeightData.setText(Printable2);
    String Printable;
    System.out.println(data[3][0]);
    while(data[3][x+1]>0){
        System.out.println("We made it");
        i = 1;
        Data = data[i][x];
        Printable = Integer.toString(Data);
        TempreatureData.setText(Printable);
        i = 2;
        Data = data[i][x];
        Printable = Integer.toString(Data);            
        RainfallData.setText(Printable);
        i = 3;
        Data = data[i][x];
        Printable = Integer.toString(Data);
        CropHeightData.setText(Printable);
            
         x = x+1;
    }
 

    }      

    public void Close_Chart(){
        Chart.dispose();
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDisplayScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button CropHeight;
    private javax.swing.JTextArea CropHeightData;
    private java.awt.Button Rainfall;
    private javax.swing.JTextArea RainfallData;
    private java.awt.Button Stop;
    private java.awt.Button Tempreature;
    private javax.swing.JTextArea TempreatureData;
    private javax.swing.JButton Update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
