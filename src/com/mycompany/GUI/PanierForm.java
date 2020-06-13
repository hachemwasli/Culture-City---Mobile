/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.LigneCommande;
import com.mycompany.Service.LignecommandeService;
import com.sun.pisces.RendererBase;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PanierForm  extends Form{
     Label Panier;
    Button MCMD;
    Button Home;
    Label Nom;
    Label Quantite;
    Label Prix;
    Label Total;
    Label N;
    Label Q;
    Label Pr;
    Label T;
     Label M;
    TextArea Qant;
    
    Button Passer;
    Form f;
    private Resources theme;
    SpanLabel lb;

    public PanierForm() {
        theme = UIManager.initFirstTheme("/theme");
        f = new Form("Panier", BoxLayout.y());

           LignecommandeService SP = new LignecommandeService();
        ArrayList<LigneCommande> lis = SP.getList2();
        //f.getStyle().setBgColor(0xFF5A5F);

        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
       // Panier = new Label("your basket");
        //Panier.getAllStyles().setFgColor(0);
       // MCMD = new Button("Mes produits");
        Home = new Button("Back");
       // C1.add(Panier);
       // C1.add(MCMD);
        C1.add(Home);
        f.add(C1);
      
        Home.addActionListener(e -> {
            Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            ip.dispose();
            new HomeForm(theme).show();

        });
        Nom = new Label("Name");
        Prix = new Label("Price ");
        Quantite = new Label("Quantity");
        Total =new Label ("Total");

        C2.add(Nom);
        C2.add(Prix);
        C2.add(Quantite);
        C2.add(Total);

        f.add(C2);
        for (LigneCommande l : lis) {
            Button supp;
            
            Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            //  Nom.setText(lis.toString());

            // Prix.setText(lis.toString());
            //Total.setText(lis.toString());
            //Quantite.setText(lis.toString());
            //LigneCommande l = new LigneCommande();
            Q = new Label("" + l.getQuantitepanier() + "");
            System.out.println(l.getIdpanier());
            N = new Label("   " + l.getNomart()+"   ");
            Pr = new Label("  " + l.getPrix()+"DT"+ "  ");
            int prixt=l.getPrix()*l.getQuantitepanier();
            T=new Label(""+prixt+"DT");
            int montant=0;
            montant=montant+prixt;
            M=new Label(""+ montant);
            

            supp = new Button("Delete");
           
          

            C3.add(N);
            C3.add(Pr);
            C3.add(Q);
            C3.add(M);
            C4.add(supp);
          

            f.add(C3);
            f.add(C4);
             supp.addActionListener((e) -> {
                Dialog ip = new InfiniteProgress().showInifiniteBlocking();

                LignecommandeService p = new LignecommandeService();
                p.supplc(l);
                ip.dispose();
                C3.remove();
                C4.remove();
                f.revalidate();

            });
           
             
        }
        if (lis.size() > 0) {
            
           Passer = new Button("Confirm");
           Passer.addActionListener(e -> {
               new PaiementForm().getF().show();
           });
        /*   Button msg=new Button("msg");
              msg.addPointerPressedListener((e)->{
            
            //send msg
                Message m = new Message("");
                
                m.setMimeType(Message.MIME_HTML);
                Display.getInstance().sendMessage(new String[] {"takwa.chenab@gmail.com"}, "Vos Recommandation", m);  
                
        }
);*/
            /*  Button gui_storage=new Button("Capturer");
                Style s = UIManager.getInstance().getComponentStyle("Title");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);

        ImageViewer iv = new ImageViewer(icon);
             gui_storage.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
               String filePath = Capture.capturePhoto();
              
            if(filePath != null) {
                try {
                    DefaultListModel<Image> m = (DefaultListModel<Image>)iv.getImageList();
                   
                    Image img = Image.createImage(filePath);
                    if(m == null) {
                        m = new DefaultListModel<>(img);
                        iv.setImageList(m);
                        iv.setImage(img);
                    } else {
                        m.addItem(img);
                    }
                    m.setSelectedIndex(m.getSize() - 1);
                } catch(IOException err) {
                    Log.e(err);
                }
            }
               }
           });*/
                 
                   
            
           
            
      //  f.add(gui_storage);
            // f.add(msg);
            //f.add(M);
            f.add(Passer);
            
       // }

        /*  ConnectionRequest con = new ConnectionRequest();
            
            String url = "http://localhost/madame/web/app_dev.php/pi_mobile/alls/"+1;
            con.setUrl(url);
            
            con.addResponseListener((le) -> {
                String reponse = new String(con.getResponseData());
                System.out.println(reponse);
                //AEvenement aev = new AEvenement();
            //    lbser.setText(reponse);
            });
            NetworkManager.getInstance().addToQueueAndWait(con);
                 System.out.println("test");*/
        System.out.println("test ba3d a");

}}
      public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
