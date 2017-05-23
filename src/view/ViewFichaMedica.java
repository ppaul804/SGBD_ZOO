package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.FichaMedicaDAO;
import model.bean.FichaMedica;

/**
 * Tela do sistema de ficha médica do animal
 * 
 * @author Pedro Paul
 */
public class ViewFichaMedica extends javax.swing.JFrame {

    /**
     * Construtor da classe. Creates new form NewJFrame
     */
    public ViewFichaMedica() {
        initComponents();
        setLocationRelativeTo(null); // Deixa o Frame Centralizado
        setResizable(false); // Não deixa mudar o tamanho da tela

        DefaultTableModel modeloFichaMedica = (DefaultTableModel) jtFichaMedica.getModel();
        jtFichaMedica.setRowSorter(new TableRowSorter(modeloFichaMedica));
        
        lerTabelaFichaMedica();
        
    }
    
    private void lerTabelaFichaMedica(){
        DefaultTableModel modelFichaMedica = (DefaultTableModel)jtFichaMedica.getModel();
        modelFichaMedica.setRowCount(0);
        FichaMedicaDAO fichaDAO = new FichaMedicaDAO();
        for (FichaMedica f : fichaDAO.ler()) {
            modelFichaMedica.addRow(new Object[]{
                f.getCodigo_FichaMedica(),
                f.getCodigo_Animal(),
                f.getDataNascimento_FichaMedica(),
                f.getDataEntradaZoo_FichaMedica(),
                f.getEstadoSaude_FichaMedica(),
                f.getPeso_FichaMedica(),
                f.getAltura_FichaMedica()
            });
        }//fim for
    }//fim metodo
    
    private void lerTabelaFichaMedicaPeloCodigo(int codigo_FichaMedica) {
        DefaultTableModel modelFichaMedica = (DefaultTableModel) jtFichaMedica.getModel();
        modelFichaMedica.setNumRows(0);
        FichaMedicaDAO fichaDAO = new FichaMedicaDAO();
        for (FichaMedica f : fichaDAO.lerPorCodigo(codigo_FichaMedica)) {
            modelFichaMedica.addRow(new Object[]{
                f.getCodigo_FichaMedica(),
                f.getCodigo_Animal(),
                f.getDataNascimento_FichaMedica(),
                f.getDataEntradaZoo_FichaMedica(),
                f.getEstadoSaude_FichaMedica(),
                f.getPeso_FichaMedica(),
                f.getAltura_FichaMedica()
            });                        
        }
    }
    
    private void limparCamposTabelaFichaMedica(){
        tfCodAnimal.setText("");
        tfNascimento.setText("");
        tfEntrada.setText("");
        cbEstadoSaude.setSelectedItem(null);
        tfPeso.setText("");
        tfAltura.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpSistemaFichaMedica = new javax.swing.JTabbedPane();
        jpFichaMedica = new javax.swing.JPanel();
        spFichaMedica = new javax.swing.JScrollPane();
        jtFichaMedica = new javax.swing.JTable();
        jlCodAnimal = new javax.swing.JLabel();
        tfCodAnimal = new javax.swing.JTextField();
        jlNascimento = new javax.swing.JLabel();
        tfNascimento = new javax.swing.JTextField();
        jlEntrada = new javax.swing.JLabel();
        tfEntrada = new javax.swing.JTextField();
        jlEstadoSaude = new javax.swing.JLabel();
        cbEstadoSaude = new javax.swing.JComboBox();
        jlPeso = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        jlAltura = new javax.swing.JLabel();
        tfAltura = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbPesquisar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jlCodFicha = new javax.swing.JLabel();
        tfCodFicha = new javax.swing.JTextField();
        jpAnimais = new javax.swing.JPanel();
        jpFuncionarios = new javax.swing.JPanel();
        jpProcedimentos = new javax.swing.JPanel();
        jpFornecedores = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Ficha Médica");
        setPreferredSize(new java.awt.Dimension(1024, 500));

        jtFichaMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Ficha", "Cód Animal", "Nascimento", "Entrada", "Estado Saúde", "Peso", "Altura"
            }
        ));
        spFichaMedica.setViewportView(jtFichaMedica);

        jlCodAnimal.setText("Código do Animal");

        jlNascimento.setText("Data de Nascimento");

        jlEntrada.setText("Data de Entrada");

        jlEstadoSaude.setText("Estado de Saúde");

        cbEstadoSaude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Atenção", "Grave" }));

        jlPeso.setText("Peso");

        jlAltura.setText("Altura");

        jbInserir.setText("Inserir");
        jbInserir.setToolTipText("Digite dos dados nescessários e clique para inserir no banco");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.setToolTipText("Pesquisa a ficha pelo código digitado");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Selecione uma ficha na tabela e clique para excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jlCodFicha.setText("Código da Ficha");

        javax.swing.GroupLayout jpFichaMedicaLayout = new javax.swing.GroupLayout(jpFichaMedica);
        jpFichaMedica.setLayout(jpFichaMedicaLayout);
        jpFichaMedicaLayout.setHorizontalGroup(
            jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAltura)
                                    .addComponent(jlPeso)
                                    .addComponent(jlEstadoSaude))
                                .addGap(36, 36, 36)
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfPeso)
                                    .addComponent(tfAltura)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpFichaMedicaLayout.createSequentialGroup()
                                        .addComponent(cbEstadoSaude, 0, 92, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))))
                            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNascimento)
                                    .addComponent(jlCodAnimal)
                                    .addComponent(jlEntrada))
                                .addGap(18, 18, 18)
                                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jlCodFicha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spFichaMedica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpFichaMedicaLayout.setVerticalGroup(
            jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spFichaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodAnimal)
                            .addComponent(tfCodAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNascimento)
                            .addComponent(tfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEntrada)
                            .addComponent(tfEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEstadoSaude)
                            .addComponent(cbEstadoSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPeso)
                            .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpFichaMedicaLayout.createSequentialGroup()
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbInserir)
                            .addComponent(jlCodFicha)
                            .addComponent(tfCodFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAtualizar)
                            .addComponent(jbExcluir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFichaMedicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAltura)
                    .addComponent(tfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jpFichaMedicaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfAltura, tfPeso});

        tpSistemaFichaMedica.addTab("Ficha Médica", jpFichaMedica);

        javax.swing.GroupLayout jpAnimaisLayout = new javax.swing.GroupLayout(jpAnimais);
        jpAnimais.setLayout(jpAnimaisLayout);
        jpAnimaisLayout.setHorizontalGroup(
            jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jpAnimaisLayout.setVerticalGroup(
            jpAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        tpSistemaFichaMedica.addTab("Cadastro de Animais", jpAnimais);

        javax.swing.GroupLayout jpFuncionariosLayout = new javax.swing.GroupLayout(jpFuncionarios);
        jpFuncionarios.setLayout(jpFuncionariosLayout);
        jpFuncionariosLayout.setHorizontalGroup(
            jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jpFuncionariosLayout.setVerticalGroup(
            jpFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        tpSistemaFichaMedica.addTab("Cadastro de Funcionários", jpFuncionarios);

        javax.swing.GroupLayout jpProcedimentosLayout = new javax.swing.GroupLayout(jpProcedimentos);
        jpProcedimentos.setLayout(jpProcedimentosLayout);
        jpProcedimentosLayout.setHorizontalGroup(
            jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jpProcedimentosLayout.setVerticalGroup(
            jpProcedimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        tpSistemaFichaMedica.addTab("Procedimentos", jpProcedimentos);

        javax.swing.GroupLayout jpFornecedoresLayout = new javax.swing.GroupLayout(jpFornecedores);
        jpFornecedores.setLayout(jpFornecedoresLayout);
        jpFornecedoresLayout.setHorizontalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jpFornecedoresLayout.setVerticalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        tpSistemaFichaMedica.addTab("Fornecedores", jpFornecedores);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSistemaFichaMedica)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpSistemaFichaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        try {
            //criar o objeto da classe FichaMedica
            FichaMedica ficha = new FichaMedica(
                Integer.parseInt(tfCodAnimal.getText()),
                tfNascimento.getText(),
                tfEntrada.getText(),
                cbEstadoSaude.getSelectedItem().toString(),
                Float.parseFloat(tfPeso.getText()),
                Float.parseFloat(tfAltura.getText())
            );
            //Pegar os textos e mandar pro banco
            FichaMedicaDAO.inserir(ficha);
            //Limpeza dos Campos
            limparCamposTabelaFichaMedica();
            //atualiza a tabela FichaMedica
            lerTabelaFichaMedica();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }//fim try catch
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            FichaMedica ficha = new FichaMedica();
            FichaMedicaDAO fichaDAO = new FichaMedicaDAO();

            ficha.setCodigo_FichaMedica(
                    (int)jtFichaMedica.getValueAt(
                            jtFichaMedica.getSelectedRow(), 0
                    )
            );
            
            fichaDAO.excluir(ficha);

            limparCamposTabelaFichaMedica();

            lerTabelaFichaMedica();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        try {
            //Cria os objetos da ficha a ser buscada
            FichaMedica ficha = new FichaMedica();
            //Pega o código digitado para busca
            ficha.setCodigo_FichaMedica(Integer.parseInt(tfCodFicha.getText()));
            lerTabelaFichaMedicaPeloCodigo(ficha.getCodigo_FichaMedica());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jbPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFichaMedica().setVisible(true); // Deixa o Frame visível
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbEstadoSaude;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlCodAnimal;
    private javax.swing.JLabel jlCodFicha;
    private javax.swing.JLabel jlEntrada;
    private javax.swing.JLabel jlEstadoSaude;
    private javax.swing.JLabel jlNascimento;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JPanel jpAnimais;
    private javax.swing.JPanel jpFichaMedica;
    private javax.swing.JPanel jpFornecedores;
    private javax.swing.JPanel jpFuncionarios;
    private javax.swing.JPanel jpProcedimentos;
    private javax.swing.JTable jtFichaMedica;
    private javax.swing.JScrollPane spFichaMedica;
    private javax.swing.JTextField tfAltura;
    private javax.swing.JTextField tfCodAnimal;
    private javax.swing.JTextField tfCodFicha;
    private javax.swing.JTextField tfEntrada;
    private javax.swing.JTextField tfNascimento;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTabbedPane tpSistemaFichaMedica;
    // End of variables declaration//GEN-END:variables

}