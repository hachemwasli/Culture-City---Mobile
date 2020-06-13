package com.mycompany.GUI;


import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;
import org.mindrot.jbcrypt.BCrypt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Inscription {

    Form f;
    TextField username;
    TextField email;
    TextField password;
    TextField nom;
    TextField prenom;
    TextField image;
    Button btnajout;
    Button login;
     public Inscription(Resources theme) {
         
         Login a = new Login(theme);
         
         
         final String salt = BCrypt.gensalt();
         Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c6 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c7 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container c8 = new Container(new BoxLayout(BoxLayout.X_AXIS));

         
         
        f = new Form("Inscription", BoxLayout.y());
        f.setUIID("formLogin");
        f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), e -> a.show());

        username = new TextField();
        username.setHint("Nom d'utilisateur");
        username.setPreferredSizeStr("36.719578mm 5.4074073mm");
        Label lusername = new Label();
        lusername.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        lusername.getAllStyles().setFgColor(0xFF0000);
        nom = new TextField();
        nom.setHint("nom");
        nom.setPreferredSizeStr("36.719578mm 5.4074073mm");
        Label lnom = new Label();
        lnom.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        lnom.getAllStyles().setFgColor(0xFF0000);
        TextField email = new TextField("", "E-Mail", 30, TextField.EMAILADDR);
        Label labelemail = new Label();
        email.setPreferredSizeStr("36.719578mm 5.4074073mm");
        labelemail.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelemail.getAllStyles().setFgColor(0xFF0000);
        TextField emailV = new TextField("", "Confirmation E-Mail", 30, TextField.EMAILADDR);
        Label labelemailV = new Label();
        emailV.setPreferredSizeStr("36.719578mm 5.4074073mm");
        labelemailV.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelemailV.getAllStyles().setFgColor(0xFF0000);
        TextField password = new TextField("", "Mot de passe", 30, TextField.PASSWORD);
        password.setPreferredSizeStr("36.719578mm 5.4074073mm");
        Label ch = new Label("Pseudo :            ");
    ch.setUIID("BlueLabel");
    Label ch1 = new Label("Email :               ");
    ch1.setUIID("BlueLabel");
    Label ch2 = new Label("Mot de passe :   ");
   ch2.setUIID("BlueLabel");
    Label ch3 = new Label("Nom :                 ");
    ch3.setUIID("BlueLabel");
    Label ch4 = new Label("Prenom :            ");
    ch4.setUIID("BlueLabel");
    Label ch5 = new Label("Image :               ");
  ch5.setUIID("BlueLabel");
      Label ch6 = new Label("Confirmer mdp : ");
    ch6.setUIID("BlueLabel");
    
      Label ch7 = new Label("Confirmer mail : ");
    ch7.setUIID("BlueLabel");
        
        
        
        Label labelPassword = new Label();
        labelPassword.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelPassword.getAllStyles().setFgColor(0xFF0000);
        TextField confirmPassword = new TextField("", "Confirmation mot de passe", 30, TextField.PASSWORD);
        Label labelRPassword = new Label();
        confirmPassword.setPreferredSizeStr("36.719578mm 5.4074073mm");
        labelRPassword.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        labelRPassword.getAllStyles().setFgColor(0xFF0000);
        
        prenom = new TextField();
        prenom.setHint("prenom");
        prenom.setPreferredSizeStr("36.719578mm 5.4074073mm");
        Label lprenom = new Label();
        lprenom.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        lprenom.getAllStyles().setFgColor(0xFF0000);
        image = new TextField();
        image.setHint("image");
        image.setPreferredSizeStr("36.719578mm 5.4074073mm");
        Label limage = new Label();
        limage.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        limage.getAllStyles().setFgColor(0xFF0000);
        
        login = new Button("Connexion");
        btnajout = new Button("S'inscrire");
        c1.add(ch);
        c1.add(username);
        
        f.add(c1);
        f.add(lusername);
        
        c2.add(ch1);
        c2.add(email);
        
        f.add(c2);
        f.add(labelemail);
        c8.add(ch7);
        c8.add(emailV);
        f.add(c8);
        f.add(labelemailV);
        c3.add(ch2);
        c3.add(password);
        
        f.add(c3);
        f.add(labelPassword);
        c7.add(ch6);
        c7.add(confirmPassword);
        f.add(c7);
        f.add(labelRPassword);
        c4.add(ch3);
        c4.add(nom);
        f.add(c4);
        f.add(lnom);
         c5.add(ch4);
        c5.add(prenom);
        f.add(c5);
        f.add(lprenom);
        c6.add(ch5);
        c6.add(image);
        
        f.add(c6);
        f.add(limage);
        f.add(btnajout);
        f.add(login);
        

        btnajout.addActionListener((l) -> {
            
             
            if (username.getText().equals("")) {
                lusername.setText("Field is empty !");
                lusername.setVisible(true);
                
            } 

            
            else  if (email.getText().equals("")) {
                labelemail.setText("Field is empty !");
                labelemail.setVisible(true);
               
            }
            else if (emailV.getText().equals("")) {
                labelemailV.setText("Field is empty !");
                labelemailV.setVisible(true);
               
            }
             else if (password.getText().equals("")) {
                labelPassword.setText("Field is empty !");
                labelPassword.setVisible(true);}
                
                else if (confirmPassword.getText().equals("")) {
                labelRPassword.setText("Field is empty !");
                labelRPassword.setVisible(true);
                            }          
                else if (email.getText().equals("") || !email.getText().contains("@") && !email.getText().contains(".")) {
                labelemailV.setText("Mail not valid !");
                labelemailV.setVisible(true);
                
            }

                else if (emailV.getText().equals("")) {
                labelemailV.setText("Field is empty !");
                labelemailV.setVisible(true);
                

            }
                else if (!email.getText().equals(emailV.getText())){
                    labelemailV.setText("Mail dont match !");
                labelemailV.setVisible(true);
                }

                else if (!password.getText().equals(confirmPassword.getText())) {
                labelRPassword.setText("Password doesn't match !");
                labelRPassword.setVisible(true);
                
                
            }
                else {
            String aa = (BCrypt.hashpw(password.getText(), salt));
            String myName = aa;
            char[] myNameChars = myName.toCharArray();
            myNameChars[2] = 'y';
            myName = String.valueOf(myNameChars);
            
            UserService ins = new UserService();
            
            User utilis = new User(username.getText(),email.getText(),myName
                    );
            
            ins.Inscription(utilis);
            //Dialog.show("Compte créee avec succès", "Bienvenue", "OK", "Cancel");
            username.setText("");
            email.setText("");
            password.setText("");
            nom.setText("");
            prenom.setText("");
            image.setText("");
            confirmPassword.setText("");
            emailV.setText("");
                }
             
        });
         login.addActionListener(e->{
            
             a.show();
        });
        
    }
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
