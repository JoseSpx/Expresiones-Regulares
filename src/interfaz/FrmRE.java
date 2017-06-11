package interfaz;

import clases.Alphabet;
import clases.Lambda;
import clases.NoParentesis;
import clases.Parentesis;
import static clases.Principal.deleteSpacesFromRegularExpression;
import static clases.Principal.enterDots;
import static clases.Principal.existsParenetesis;
import static clases.Principal.validateRegularExpression;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmRE extends javax.swing.JFrame {

    ArrayList<String> listOfWords = new ArrayList<>();
    DefaultTableModel modelo;

    public FrmRE() {
        initComponents();
        setLocationRelativeTo(null);
        txtAlphabet.setText(Alphabet.ALPHABET);
        modelo = new DefaultTableModel();
        tableWords.setModel(modelo);
        modelo.addColumn("PALABRAS");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGenerarPalabras = new javax.swing.JButton();
        txtRE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWords = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAlphabet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        btnGenerarPalabras.setBackground(new java.awt.Color(0, 102, 153));
        btnGenerarPalabras.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPalabras.setText("GENERAR PALABRAS");
        btnGenerarPalabras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarPalabras.setFocusable(false);
        btnGenerarPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPalabrasActionPerformed(evt);
            }
        });

        txtRE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tableWords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableWords.setRowHeight(20);
        jScrollPane1.setViewportView(tableWords);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EXPRESIONES REGULARES");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ALFABETO:");

        txtAlphabet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAlphabet.setForeground(new java.awt.Color(255, 255, 255));
        txtAlphabet.setText("ALFABETO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(txtRE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnGenerarPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerarPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPalabrasActionPerformed
        String regularExpression = txtRE.getText();
        
        if(!regularExpression.equals("")){
            
            Boolean bandValidate;
            int numberOfWords = 20;

            regularExpression = deleteSpacesFromRegularExpression(regularExpression);
            bandValidate = validateRegularExpression(regularExpression);

            if(!bandValidate){
                JOptionPane.showMessageDialog(null,"Expresion Regular no Válida");
                return;
            }

            regularExpression = enterDots(Alphabet.ALPHABET, regularExpression);

            // verify if exits Parentesis
            Boolean existsParentesis = existsParenetesis(regularExpression);
            int i;
            
            if(existsParentesis){
                Parentesis parentesis = new Parentesis();
                listOfWords = parentesis.getMatrixResult(regularExpression);

                if(listOfWords == null){
                    JOptionPane.showMessageDialog(null,"Lista Vacia");
                    return;
                }
            }
            else{
                NoParentesis np = new NoParentesis(regularExpression);
                listOfWords = np.getMatrix();
            }

            Collections.sort(listOfWords,(String s1, String s2)->{
                int h , s1Count = 0, s2Count = 0;
                for(h = 0;h < s1.length(); h++){
                    if(String.valueOf(s1.charAt(h)).equals(Lambda.VALUE)){
                        s1Count++;
                    }
                }
                for(h = 0;h < s2.length(); h++){
                    if(String.valueOf(s2.charAt(h)).equals(Lambda.VALUE)){
                        s2Count++;
                    }
                }
                s1Count = s1.length() - s1Count;
                s2Count = s2.length() - s2Count;
                return s1Count - s2Count;
            });

            if(numberOfWords > listOfWords.size()){
                    numberOfWords = listOfWords.size();
            }

            showResults(numberOfWords);
        }else{
            JOptionPane.showMessageDialog(this, "Porfavor, complete los campos! ");
        }
    }//GEN-LAST:event_btnGenerarPalabrasActionPerformed

    public void showResults(int numberOfwords) {
        clearTable();
        int i;
        for (i = 0; i < numberOfwords ; i++) {
            modelo.addRow(new Object[]{listOfWords.get(i)});
        }
        
    }

    public void clearTable(){
        int rows =modelo.getRowCount();
        for (int i = 0;rows>i; i++) {
            modelo.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPalabras;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableWords;
    private javax.swing.JLabel txtAlphabet;
    private javax.swing.JTextField txtRE;
    // End of variables declaration//GEN-END:variables

    
}
