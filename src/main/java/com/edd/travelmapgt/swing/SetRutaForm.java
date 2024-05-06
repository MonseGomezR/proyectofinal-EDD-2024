package com.edd.travelmapgt.swing;

import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mgome
 */
public class SetRutaForm extends javax.swing.JPanel {

    private String anterior;
    private Map<String, String> elementosEliminados;

    public SetRutaForm() {
        elementosEliminados = new HashMap<>();
        initComponents();
        cbDestino.addItem("Selecciona un Destino");
        cbOrigen.addItem("Selecciona un Origen");
        rbHoraActual.setSelected(true);
        rbHoraEspecifica.setSelected(false);
        rbHoras.add(rbHoraActual);
        rbHoras.add(rbHoraEspecifica);
        bgMejorRuta.add(gasolina);
        bgMejorRuta.add(distancia);
        bgMejorRuta.add(desgaste);
        bgMejorRuta.add(gasoDist);
        bgMejorRuta.add(desgasteDistancia);

        desgaste.setEnabled(false);
        desgasteDistancia.setEnabled(false);
        anterior = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbHoras = new javax.swing.ButtonGroup();
        radioButtonCustom3 = new com.edd.travelmapgt.swing.RadioButtonCustom();
        bgMejorRuta = new javax.swing.ButtonGroup();
        panelBorder1 = new com.edd.travelmapgt.swing.PanelBorder();
        rbHoraEspecifica = new javax.swing.JRadioButton();
        rbHoraActual = new javax.swing.JRadioButton();
        tagHorario = new javax.swing.JLabel();
        tagHora = new javax.swing.JLabel();
        espacioHoraEspecifica = new javax.swing.JTextField();
        cbDestino = new javax.swing.JComboBox<>();
        tagDestino = new javax.swing.JLabel();
        cbOrigen = new javax.swing.JComboBox<>();
        tagOrigen = new javax.swing.JLabel();
        gasolina = new com.edd.travelmapgt.swing.RadioButtonCustom();
        distancia = new com.edd.travelmapgt.swing.RadioButtonCustom();
        desgaste = new com.edd.travelmapgt.swing.RadioButtonCustom();
        gasoDist = new com.edd.travelmapgt.swing.RadioButtonCustom();
        desgasteDistancia = new com.edd.travelmapgt.swing.RadioButtonCustom();

        radioButtonCustom3.setText("radioButtonCustom1");

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        rbHoraEspecifica.setFont(new java.awt.Font("Aldo the Apache", 0, 12)); // NOI18N
        rbHoraEspecifica.setText("Especifica");
        rbHoraEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHoraEspecificaActionPerformed(evt);
            }
        });

        rbHoraActual.setFont(new java.awt.Font("Aldo the Apache", 0, 12)); // NOI18N
        rbHoraActual.setText("Actual");
        rbHoraActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHoraActualActionPerformed(evt);
            }
        });

        tagHorario.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N
        tagHorario.setForeground(new java.awt.Color(0, 0, 0));
        tagHorario.setText("Horario:");

        tagHora.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N
        tagHora.setForeground(new java.awt.Color(0, 0, 0));
        tagHora.setText("Hora");

        espacioHoraEspecifica.setText("hh : mm : ss");
        espacioHoraEspecifica.setEnabled(false);

        cbDestino.setBackground(new java.awt.Color(255, 255, 255));
        cbDestino.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        cbDestino.setForeground(new java.awt.Color(0, 0, 0));

        tagDestino.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N
        tagDestino.setForeground(new java.awt.Color(0, 0, 0));
        tagDestino.setText("Destino:");

        cbOrigen.setBackground(new java.awt.Color(255, 255, 255));
        cbOrigen.setFont(new java.awt.Font("Aldo the Apache", 0, 18)); // NOI18N
        cbOrigen.setForeground(new java.awt.Color(0, 0, 0));
        cbOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrigenItemStateChanged(evt);
            }
        });

        tagOrigen.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N
        tagOrigen.setForeground(new java.awt.Color(0, 0, 0));
        tagOrigen.setText("Origen:");

        gasolina.setBackground(new java.awt.Color(255, 204, 0));
        gasolina.setText("Gasto de Gasolina");
        gasolina.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N

        distancia.setBackground(new java.awt.Color(255, 102, 102));
        distancia.setText("Distancia");
        distancia.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N

        desgaste.setBackground(new java.awt.Color(255, 255, 51));
        desgaste.setText("Desgaste Fisico");
        desgaste.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N

        gasoDist.setBackground(new java.awt.Color(51, 204, 0));
        gasoDist.setText("Gasolina y Distancia");
        gasoDist.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N

        desgasteDistancia.setBackground(new java.awt.Color(0, 204, 153));
        desgasteDistancia.setText("Desgaste y Distancia");
        desgasteDistancia.setFont(new java.awt.Font("Aldo the Apache", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tagOrigen)
                        .addGap(12, 12, 12)
                        .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(tagDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tagHorario)
                        .addGap(17, 17, 17)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbHoraEspecifica)
                            .addComponent(rbHoraActual))
                        .addGap(31, 31, 31)
                        .addComponent(tagHora)
                        .addGap(26, 26, 26)
                        .addComponent(espacioHoraEspecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desgaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gasoDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desgasteDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tagOrigen))
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tagDestino))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tagHorario))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rbHoraEspecifica))
                    .addComponent(rbHoraActual)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(espacioHoraEspecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tagHora)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desgaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasoDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desgasteDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 120));
    }// </editor-fold>//GEN-END:initComponents

    private void rbHoraActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHoraActualActionPerformed
        espacioHoraEspecifica.setEnabled(false);
    }//GEN-LAST:event_rbHoraActualActionPerformed

    private void rbHoraEspecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHoraEspecificaActionPerformed
        espacioHoraEspecifica.setEnabled(true);
    }//GEN-LAST:event_rbHoraEspecificaActionPerformed

    private void cbOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrigenItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            if (elementosEliminados.containsKey(anterior)) {
                cbDestino.addItem(elementosEliminados.get(anterior));
                elementosEliminados.remove(anterior);
            }
            elementosEliminados.put(item, item);
            anterior = item;
            cbDestino.removeItem(item);
        }
    }//GEN-LAST:event_cbOrigenItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMejorRuta;
    public javax.swing.JComboBox<String> cbDestino;
    public javax.swing.JComboBox<String> cbOrigen;
    public com.edd.travelmapgt.swing.RadioButtonCustom desgaste;
    public com.edd.travelmapgt.swing.RadioButtonCustom desgasteDistancia;
    public com.edd.travelmapgt.swing.RadioButtonCustom distancia;
    private javax.swing.JTextField espacioHoraEspecifica;
    public com.edd.travelmapgt.swing.RadioButtonCustom gasoDist;
    public com.edd.travelmapgt.swing.RadioButtonCustom gasolina;
    private com.edd.travelmapgt.swing.PanelBorder panelBorder1;
    private com.edd.travelmapgt.swing.RadioButtonCustom radioButtonCustom3;
    private javax.swing.JRadioButton rbHoraActual;
    private javax.swing.JRadioButton rbHoraEspecifica;
    private javax.swing.ButtonGroup rbHoras;
    private javax.swing.JLabel tagDestino;
    private javax.swing.JLabel tagHora;
    private javax.swing.JLabel tagHorario;
    private javax.swing.JLabel tagOrigen;
    // End of variables declaration//GEN-END:variables
}
