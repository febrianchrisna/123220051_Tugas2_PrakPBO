/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author febri
 */
public class HalamanLogin extends JFrame implements ActionListener {

    JLabel judul = new JLabel("Selamat Datang!");
    JLabel judul2 = new JLabel("Silahkan masuk untuk melanjutkan.");

    JLabel labelUsername = new JLabel("Username");
    JTextField inputUsername = new JTextField();

    JLabel labelPw = new JLabel("Password");
    JPasswordField inputPw = new JPasswordField();
    JCheckBox lihatPw = new JCheckBox("Show Password");

    JLabel labelGender = new JLabel("Jenis Kelamin");
    JRadioButton rlaki = new JRadioButton("Laki-Laki");
    JRadioButton rpuan = new JRadioButton("Perempuan");

    JButton tombolLogin = new JButton("Login");

     HalamanLogin() {
        setVisible(true);
        setSize(480, 520);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(judul);
        judul.setBounds(30, 10, 200, 40);
        judul.setFont(judul.getFont().deriveFont(20f));

        add(judul2);
        judul2.setBounds(30, 35, 280, 40);
        judul2.setFont(judul2.getFont().deriveFont(13f));

        add(labelUsername);
        labelUsername.setBounds(30, 70, 100, 40);

        add(inputUsername);
        inputUsername.setBounds(30, 105, 300, 25);

        add(labelPw);
        labelPw.setBounds(30, 135, 100, 40);

        add(inputPw);
        inputPw.setBounds(30, 170, 300, 25);
        
        add(lihatPw);
        lihatPw.setBounds(30, 200, 150, 20);
        lihatPw.addActionListener(this);
        
        add(labelGender);
        ButtonGroup pilGender = new ButtonGroup();
        pilGender.add(rlaki);
        pilGender.add(rpuan);
        labelGender.setBounds(30, 220, 100, 40);

        add(rlaki);
        rlaki.setBounds(30, 245 ,100, 40);

        add(rpuan);
        rpuan.setBounds(150, 245, 100, 40);

        add(tombolLogin);
        tombolLogin.setBounds(30, 290, 300, 28);
        tombolLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource() == lihatPw){
                if(lihatPw.isSelected()){
                inputPw.setEchoChar((char)0);
            }else{
                
            }   
        }else if(e.getSource() == tombolLogin){
        try {
            String username = inputUsername.getText();
            String password = String.valueOf(inputPw.getPassword());
            String jenisKelamin = rlaki.isSelected() ? "L" : "P";
            
            if(username.isEmpty()){
                throw new Exception("Username Tidak Boleh Kosong!");
            }else if(password.isEmpty()){
                throw new Exception("Password Tidak Boleh Kosong!");
            }else if(!rlaki.isSelected() && !rpuan.isSelected()){
                throw new Exception("Jenis Kelamin Belum dipilih!");
            }

            new HalamanUtama(username, jenisKelamin);
            this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
   }
}
