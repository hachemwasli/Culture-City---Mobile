/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.Entity.Emprunt;
import com.mycompany.Entity.Livre;
import com.mycompany.Service.ServiceEmprunt;
import com.mycompany.Service.ServiceLivre;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.FilterProxyListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;



/**
 *
 * @author ASUS X541UJ
 */
public class Livres extends Form {
    
    public Livres (Resources Theme) {
        Livre L = new Livre();
              Form f = new Form(BoxLayout.y());
        Container Livres = new Container(BoxLayout.y());
                      ServiceLivre li = new ServiceLivre();
final              ArrayList<Livre> offres = li.getListLivre();

    getToolbar().addSearchCommand(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent evt) {
                String text = (String) evt.getSource();
                if (text.length() != 0 && text != null){
                    for (int i=0; i<offres.size()*2 ; i+=2) {
                        Container container = (Container) Livres.getComponentAt(i);
                       Container a=  (Container) container.getComponentAt(1);
                       Label titre = (Label) a.getComponentAt(0);
                        if (titre.getText().toUpperCase().contains(text.toUpperCase())) {
                            container.setHidden(false);
                           container.setVisible(true);
                       } else {
                           container.setHidden(true);
                          container.setVisible(false);
                           
                       }
                    } 
                } else {
                        for (int i=0; i<offres.size()*2 ; i+=2) {
                            Container container = (Container) Livres.getComponentAt(i);
                            container.setHidden(false);
                            container.setVisible(true);
                        }
                }
                refreshTheme();
           }             
       });
    for(Livre i :li.getListLivre()){
        
        model1.addItem(i);
        
    }
     
   
        
   
    
           
       




        
 getToolbar().addCommandToOverflowMenu("My loans", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
               Emprunts e =new Emprunts(Theme);
                e.show(); 
            }
        });

        getToolbar().addCommandToOverflowMenu("Logout", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
                Main m =new Main(Theme);
                m.show(); 
            }
        });
         getToolbar().addCommandToLeftBar("back", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
              Main m =new Main(Theme);
                m.show();  
            }
        });
        ServiceLivre ls = new ServiceLivre();
       
        //user.setId("42");
        ArrayList<Livre> sl = ls.getListLivre();

        Livres.setUIID("List");
        //Livres.setScrollableY(true);
        setTitle("Library Departement");
        if (ls != null) {
            for (Livre l : sl) {

                EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xFFFFFFFF), true);
                Image img = URLImage.createToStorage(placeholder, l.getImg(), "http://localhost/projet/web/uploads/images/" + l.getImg(),
                        URLImage.RESIZE_SCALE_TO_FILL);
                Container imgC = new Container();
                imgC.add(img);
                Button emp = new Button("Loan");
                MultiButton mb = new MultiButton(l.getTitreL());
                mb.setUIID("ListLivre");
                mb.setTextLine2(l.getCopie_dispo());
                mb.setTextLine3(l.getIdCL());
                mb.setTextLine3(l.getDateEdition());
                mb.setIcon(img);
                mb.add(LEFT, img);
                
                MultiButton em = new MultiButton(l.getTitreL());
                em.add(RIGHT,emp);
                 
                 ServiceEmprunt ep = new ServiceEmprunt();

               
                //Slider note = createStarRankSlider();
                em.addActionListener(e -> {
           
        Dialog dlg = new Dialog("Book loaned");
dlg.setLayout(new BorderLayout());
// span label accepts the text and the UIID for the dialog body
int h = Display.getInstance().getDisplayHeight();
dlg.setDisposeWhenPointerOutOfBounds(true);
dlg.show(h /8 * 7, 0, 0, 0);
 
ep.AjouterEmprunt();

                    
                }
                );
               
                Livres.add(FlowLayout.encloseCenter(mb));
                Livres.add(FlowLayout.encloseCenter(em));
            
            }
            
            add(Livres);
        } else {
            //TO DO
        
    }
    
}
    protected FilterProxyListModel<String> filter;
    protected DefaultListModel model1 = new DefaultListModel();
 
     public ListModel<String> getSuggestionModel() {
         Livre l= new Livre();
            model1.addItem(l.getCopie_dispo());
            

            filter = new FilterProxyListModel<String>(model1);
            return filter;
        }

  
    
}
