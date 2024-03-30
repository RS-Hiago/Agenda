package Telas;
import Conexao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class TelaContatos extends javax.swing.JFrame {
    Connection Conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaContatos() {
      initComponents();
      Conexao = ModuloConexao.conectar();
    }

private void adicionar() {
    
    if (preencher()) {
        if (inserir()) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
    }
}

private boolean preencher() {
    return
           !txt_nome.getText().isEmpty() && 
           !txt_ddd.getText().isEmpty() && 
           !txt_celular.getText().isEmpty() && 
           !txt_email.getText().isEmpty() && 
           !txt_nas.getText().isEmpty() && 
           !txt_cpf.getText().isEmpty() && 
           !txt_endereco.getText().isEmpty() && 
           !txt_cidade.getText().isEmpty() && 
           !txt_estado.getText().isEmpty();
}

private boolean inserir() {
    String sql = "INSERT INTO dados_pessoais (nome, ddd, celular, email, mes_nascimento, cpf, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try {
        pst = Conexao.prepareStatement(sql);
        pst.setString(1, txt_nome.getText());
        pst.setString(2, txt_ddd.getText());
        pst.setString(3, txt_celular.getText());
        pst.setString(4, txt_email.getText());
        pst.setString(5, txt_nas.getText());
        pst.setString(6, txt_cpf.getText());
        pst.setString(7, txt_endereco.getText());
        pst.setString(8, txt_cidade.getText());
        pst.setString(9, txt_estado.getText());
        int adicionado = pst.executeUpdate();
        return adicionado > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e.getMessage());
        return false;
    }
}


private void limparCampos() {
    txt_nome.setText(null);
    txt_email.setText(null);
    txt_celular.setText(null);
    txt_ddd.setText(null);
    txt_nas.setText(null);
    txt_cpf.setText(null);
    txt_endereco.setText(null);
    txt_cidade.setText(null);
    txt_estado.setText(null);
}

private void visualizar() {
    String id = JOptionPane.showInputDialog(null, "Digite o ID do usuário que deseja visualizar:");

    if (id != null) {
        String sql = "SELECT * FROM dados_pessoais WHERE id = ?";
        try {
            pst = Conexao.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String ddd = rs.getString("ddd");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String mesNascimento = rs.getString("mes_nascimento");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");

                String userData = "Nome: " + nome + "\n" +
                                  "DDD: " + ddd + "\n" +
                                  "Celular: " + celular + "\n" +
                                  "Email: " + email + "\n" +
                                  "Mês de Nascimento: " + mesNascimento + "\n" +
                                  "CPF: " + cpf + "\n" +
                                  "Endereço: " + endereco + "\n" +
                                  "Cidade: " + cidade + "\n" +
                                  "Estado: " + estado;

                JOptionPane.showMessageDialog(null, userData);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar usuário: " + e.getMessage());
        }
    }
}

private void alterar() {
    String id = JOptionPane.showInputDialog(null, "Digite o ID do usuário que deseja alterar:");
    
    if (id != null) {
        String sql = "UPDATE dados_pessoais SET nome=?, ddd=?, celular=?, email=?, mes_nascimento=?, cpf=?, endereco=?, cidade=?, estado=? WHERE id=?";
        
        try {
            pst = Conexao.prepareStatement(sql);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_ddd.getText());
            pst.setString(3, txt_celular.getText());
            pst.setString(4, txt_email.getText());
            pst.setString(5, txt_nas.getText());
            pst.setString(6, txt_cpf.getText());
            pst.setString(7, txt_endereco.getText());
            pst.setString(8, txt_cidade.getText());
            pst.setString(9, txt_estado.getText());
            pst.setString(10, id);
            
            int alterado = pst.executeUpdate();
            if (alterado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: " + e.getMessage());
        }
    }
}


private void apagar() {
    String id = JOptionPane.showInputDialog(null, "Digite o ID do usuário que deseja excluir:");
    
    if (id != null ) {
        String sql = "DELETE FROM dados_pessoais WHERE id=?";

        try {
            pst = Conexao.prepareStatement(sql);
            pst.setString(1, id);
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário apagado com sucesso");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar usuário: " + e.getMessage());
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txt_senha2 = new javax.swing.JTextField();
        txt_senha3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        adcionar = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        apagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ddd = new javax.swing.JTextField();
        txt_nas = new javax.swing.JTextField();
        txt_cpf = new javax.swing.JTextField();
        txt_endereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel10.setText("Celular");

        jLabel11.setText("Endereço");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Seja bem-vindo!!!");

        adcionar.setText("Adcionar");
        adcionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcionarActionPerformed(evt);
            }
        });

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        apagar.setText("Apagar");
        apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarActionPerformed(evt);
            }
        });

        jLabel3.setText("Email");

        jLabel4.setText("Celular");

        jLabel6.setText("Mês de nascimento ");

        jLabel7.setText("CPF\t");

        jLabel8.setText("Endereço");

        txt_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfActionPerformed(evt);
            }
        });

        jLabel9.setText("DDD");

        jLabel13.setText("Estado");

        jLabel12.setText("Cidade");

        jLabel14.setText("Adicione um novo contato à sua agenda!");

        jLabel15.setText("Preencha os campos como desejar :)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(txt_email)
                            .addComponent(txt_celular)
                            .addComponent(txt_cidade))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_ddd)
                                .addComponent(txt_nas)
                                .addComponent(txt_cpf)
                                .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(adcionar)
                        .addGap(18, 18, 18)
                        .addComponent(visualizar)
                        .addGap(18, 18, 18)
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(apagar)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_ddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adcionar)
                    .addComponent(visualizar)
                    .addComponent(editar)
                    .addComponent(apagar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adcionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcionarActionPerformed
    adicionar();
    }//GEN-LAST:event_adcionarActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
    visualizar();
    }//GEN-LAST:event_visualizarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
    alterar();
    }//GEN-LAST:event_editarActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
    apagar();
    }//GEN-LAST:event_apagarActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adcionar;
    private javax.swing.JButton apagar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_ddd;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_nas;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_senha2;
    private javax.swing.JTextField txt_senha3;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
