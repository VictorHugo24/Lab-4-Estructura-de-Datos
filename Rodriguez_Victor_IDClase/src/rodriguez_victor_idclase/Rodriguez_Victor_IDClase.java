package rodriguez_victor_idclase;

import javax.swing.JOptionPane;
import java.util.Random;

public final class Rodriguez_Victor_IDClase extends javax.swing.JFrame {

    Random random;
    String[] PalabrasAdivinar;
    String[] Adivinanza;
    String PalabraRandom;

    public Rodriguez_Victor_IDClase() {
        initComponents();
        random = new Random();
        PalabrasAdivinar = new String[5];
        SetearPalabras();
        mostrarAdivinanza();
        salida.setEditable(false);
    }

    void SetearPalabras() {
        for (int i = 0; i < PalabrasAdivinar.length; i++) {
            PalabrasAdivinar[i] = JOptionPane.showInputDialog("Ingrese la palabra " + (i + 1) + ":");
        }
        // Seleccionar una palabra aleatoria correctamente
        PalabraRandom = PalabrasAdivinar[random.nextInt(PalabrasAdivinar.length)];
        System.out.println(PalabraRandom);

        Adivinanza = new String[PalabraRandom.length()];
        for (int i = 0; i < PalabraRandom.length(); i++) {
            Adivinanza[i] = "-";
        }
    }

    void mostrarAdivinanza() {
        StringBuilder mostrar = new StringBuilder();
        for (String letra : Adivinanza) {
            mostrar.append(letra);
        }
        salida.setText(mostrar.toString());
    }

    void Adivinanza() {
        String intento = entrada.getText().toLowerCase();
        if (!intento.isEmpty()) {
            char IntentoAdivinanza = intento.charAt(0);

            for (int i = 0; i < PalabraRandom.length(); i++) {
                if (PalabraRandom.toLowerCase().charAt(i) == IntentoAdivinanza) {
                    Adivinanza[i] = String.valueOf(IntentoAdivinanza);
                }
            }
            mostrarAdivinanza();
        }
    }

    private void initComponents() {

        Adinivar = new javax.swing.JButton();
        entrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Adinivar.setText("Intentar");
        Adinivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdinivarActionPerformed(evt);
            }
        });

        jLabel1.setText("Su intento:");

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        jButton1.setText("Cambiar Palabras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adinivar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Adinivar)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }

    private void AdinivarActionPerformed(java.awt.event.ActionEvent evt) {
        Adivinanza();
        mostrarAdivinanza();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SetearPalabras();
        mostrarAdivinanza();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Rodriguez_Victor_IDClase().setVisible(true);
        });
    }

    private javax.swing.JButton Adinivar;
    private javax.swing.JTextField entrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea salida;

}
