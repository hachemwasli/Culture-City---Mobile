/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Service.LignecommandeService;


/**
 *
 * @author PC
 */
public class PaiementForm {
      Form f;
    TextField carte;
    TextField mdp;
    Button conf;

    public PaiementForm() {
        f = new Form("Panier", BoxLayout.y());

        carte = new TextField();
        carte.setHint("Cart");
        carte.getAllStyles().setFgColor(0);
        mdp = new TextField();
        mdp.setHint("Password");
        mdp.getAllStyles().setFgColor(0);
        conf = new Button("Pay");
        Button retoure = new Button("Back");
        f.add(carte);
        f.add(mdp);
        f.add(conf);
        f.add(retoure);
        retoure.addActionListener(e -> {
            new PanierForm().getF().show();

        });
        conf.addActionListener((e) -> {
            String carteS = carte.getText();
            String mdpS = mdp.getText();
            Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            if (carteS.equals("") || mdpS.equals("")) {
                ip.dispose();
                InteractionDialog dlg = new InteractionDialog("Notification");
                dlg.setLayout(new BorderLayout());
                dlg.add(BorderLayout.CENTER, new SpanLabel("A field is empty! Please fill it out."));
                Button close = new Button("Close");
                close.addActionListener((ee) -> dlg.dispose());
                dlg.addComponent(BorderLayout.SOUTH, close);
                Dimension pre = dlg.getContentPane().getPreferredSize();
                dlg.show(50, 100, 30, 30);
                return;
            }
            int carteI = 0;
            try {
                carteI = Integer.parseInt(carteS);
            } catch (Exception ex) {
                ip.dispose();
                InteractionDialog dlg = new InteractionDialog("Notification");
                dlg.setLayout(new BorderLayout());
                dlg.add(BorderLayout.CENTER, new SpanLabel("Please insert numbers in the card field."));
                Button close = new Button("Close");
                close.addActionListener((ee) -> dlg.dispose());
                dlg.addComponent(BorderLayout.SOUTH, close);
                Dimension pre = dlg.getContentPane().getPreferredSize();
                dlg.show(50, 100, 30, 30);
                return;
            }
            LignecommandeService ser = new LignecommandeService();
            String retour = ser.payer(carteS, mdpS);
            if (retour.equals("ok")) {
                ip.dispose();
                InteractionDialog dlg = new InteractionDialog("Notification");
                dlg.setLayout(new BorderLayout());
                dlg.add(BorderLayout.CENTER, new SpanLabel("Payment made successfully !."));
               /* ServicePaiement spr = new ServicePaiement();
                try {
                    spr.payer("4242424242424242", 12, 19, "123", 80, "payment valide");
                } catch (AuthenticationException ex) {

                } catch (InvalidRequestException ex) {

                } catch (APIConnectionException ex) {

                } catch (CardException ex) {

                } catch (APIException ex) {

                }*/
                Button close = new Button("Close");
                close.addActionListener((ee) -> {
                    dlg.dispose();
                    new PanierForm().getF().show();
                });
                dlg.addComponent(BorderLayout.SOUTH, close);
                Dimension pre = dlg.getContentPane().getPreferredSize();
                dlg.show(50, 100, 30, 30);
            } else {
                ip.dispose();
                InteractionDialog dlg = new InteractionDialog("Notification");
                dlg.setLayout(new BorderLayout());
                dlg.add(BorderLayout.CENTER, new SpanLabel(retour));
                Button close = new Button("Close");
                close.addActionListener((ee) -> {
                    dlg.dispose();
                });
                dlg.addComponent(BorderLayout.SOUTH, close);
                Dimension pre = dlg.getContentPane().getPreferredSize();
                dlg.show(50, 100, 30, 30);
            }

        });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
