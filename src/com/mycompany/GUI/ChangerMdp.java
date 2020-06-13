/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author user
 */
public class ChangerMdp {
    User u = new User ();
    UserService us = new UserService ();
    Button b;
    
    Form f ;
    public ChangerMdp (Resources theme){
        f = new Form("Modification", BoxLayout.y());
        ProfileUser a = new ProfileUser (theme);
        f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), e -> a.getK().show());
        f.setUIID("formLogin");
        TextField nouv = new TextField ();
         Label ch1 = new Label("Nouveau mot de passe : ");
        ch1.setUIID("BlueLabel");
        nouv.setHint("Mot de passe");
        nouv.setConstraint(TextField.PASSWORD);
        TextField nouv1 = new TextField ();
         Label ch11 = new Label("Confirmer mot de passe : ");
        ch11.setUIID("BlueLabel");
        nouv1.setHint("Confirmer mot de passe");
        nouv1.setConstraint(TextField.PASSWORD);
        
        b = new Button ("Changer");
        u = Login.hama;
    
            b.addActionListener((evt) -> {
                if (nouv.getText().equals("")||nouv1.getText().equals("")){
                    Dialog.show("Erreur", "Champs vides", "OK", "Cancel");
                }
                else if (! (nouv1.getText()).equals(nouv.getText())){
                     Dialog.show("Erreur", "les deux mdp ne sont pas identiques", "OK", "Cancel");
                }
                else {

            final String salt = BCrypt.gensalt();
            String aa = (BCrypt.hashpw(nouv.getText(), salt));
            String myName = aa;
            char[] myNameChars = myName.toCharArray();
            myNameChars[2] = 'y';
            myName = String.valueOf(myNameChars);
            u.setPassword(myName);
                us.editUser(u);
                Dialog.show("Gratz", "Mot de pass changer avec succées", "OK", "Cancel");
                }
            });
            f.add(ch1);
            f.add(nouv);
                        f.add(ch11);

            f.add(nouv1);
            f.add(b);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
