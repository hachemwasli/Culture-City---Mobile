/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.Entity.Article;
import com.mycompany.Entity.LigneCommande;
import com.mycompany.Service.LignecommandeService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Filtrage  {
    Form f=new Form(new FlowLayout(CENTER,CENTER));
    
    
    public Filtrage(Resources theme){
          Image icon1 = theme.getImage("/load.png");
           Toolbar tb = new Toolbar(true);
        f.setToolbar(tb);
          f.getToolbar().addCommandToLeftBar("back",icon1,new ActionListener<ActionEvent>() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               HomeForm ft=new HomeForm(theme);
               ft.show();
                
            }
        });
        
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        f.setTitle("Filter By Price");
        Button filtre=new Button("Filter :");
         Slider s=new Slider();
         s.setEditable(true);
         s.setMinValue(40);
         s.setMaxValue(200);
          s.addActionListener(new ActionListener() {
                                   @Override
                                    public void actionPerformed(ActionEvent evt) {
                                     //lab.setText(""+s.getProgress()); 
                                            System.out.println(s.getProgress());
                                           
                                            filtre.setText("Filter : " +s.getProgress());
                                           
                                    }
                                });
          c.add(s);
                               
                                c.add(filtre);
                                f.add(c);
                    filtre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                boolean d;
                d =Dialog.show("Price", "Do you want to choose the price "+s.getProgress(), "Yes", "No");
               
                
                
                     ConnectionRequest conF = new ConnectionRequest();
       // ConnectionRequest con2 = new ConnectionRequest();
        conF.setUrl("http://localhost/codetest/web/app_dev.php/vente/Prix/"+s.getProgress());
       // con2.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/produitSearch/"+re.getText());
        conF.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

               ArrayList<Article> list = new ArrayList<>();
               list.addAll(getListEtudiant(new String(conF.getResponseData())));
          
                System.out.println(list);
                for (Article eq : getListEtudiant(new String(conF.getResponseData()))) {
                   try {
                       addItem(eq,theme,icon1);
                       list.clear();
                   } catch (IOException ex) {
                    
                   }
                }
                Container C = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             
                f.add(C);
 f.show();
            }
        });
              NetworkManager.getInstance().addToQueue(conF);
       
            
              
            }
        });                          
          
    
    
    }
     public ArrayList<Article> getListEtudiant(String json) {
         
        ArrayList<Article> listEtudiants = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

       
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Article carte = new Article();//id, json, status);
               carte.setIdarticle((int) Float.parseFloat(obj.get("idarticle").toString()));   
                carte.setNomarticle(obj.get("nomarticle").toString());
                carte.setImagearticle(obj.get("imagearticle").toString());
                carte.setPrixarticle((int) Float.parseFloat(obj.get("prixarticle").toString()));
                carte.setQuantitearticles((int) Float.parseFloat(obj.get("quantitearticle").toString()));    
                listEtudiants.add(carte);

            }

        } catch (IOException ex) {
        }
        return listEtudiants;

    }
      public void addItem(Article eq,Resources theme,Image icon1) throws IOException {
         
           UIBuilder  ui = new UIBuilder();
         Container ct1;
 
      Form f1 = new Form();
       f.refreshTheme();
         
    EncodedImage imc;
    Image img;
    ImageViewer imv;
   String url="http://localhost/codetest/web/images/"+eq.getImagearticle();
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
      Label  nom = new Label(eq.getNomarticle());
     Label supp = new Label("Voir plus");
    imc = EncodedImage.create("/load.png");
            
        img=URLImage.createToStorage(imc,""+eq.getNomarticle(), url, URLImage.RESIZE_SCALE);
             int displayHeight = Display.getInstance().getDisplayHeight();
        ScaleImageLabel scaleImageLabel = new ScaleImageLabel(img);
        Image scImage = img.scaled(-1, displayHeight / 10);
         imv= new ImageViewer(scImage);
        supp.getAllStyles().setFgColor(0xFF0000);

        
           addButton(theme,scImage, eq,nom.getText(), false, 26, 32);
            C2.add(imv); 
       C2.add(nom);
        C3.add(supp);
       
        
       
        

   
        supp.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
             f1.show();
              Label lnom = new Label ("Name: "+eq.getNomarticle());
             
            
              
            
              Label lprix = new Label ("Price:  "+eq.getPrixarticle()+"DT");
              
              f1.add(lnom);
              
             
            
              f1.add(lprix);
     
              Image scImage1 = img.scaled(-1, displayHeight / 3);
              ImageViewer imvo;
              imvo= new ImageViewer (scImage1);
              
              
              Container cnt = new Container (new BoxLayout (BoxLayout.X_AXIS) );
               Container cnt1 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
              cnt.add(imvo);            
         //   Label jaim = new Label("J'aime");
          //   Label jaimpas= new Label("J'aime pas");
            Label panier= new Label("Add to Cart");
         /*    ShareButton s = new ShareButton (); 
        s.setText ("Partager"); 
        s.setTextToShare ("Ce produit est excellent"+eq.getNomarticle()); */
           
           //  jaim.getAllStyles().setFgColor(0xFF0000);
             //s.getAllStyles().setFgColor(0xFF0000);
           //  jaimpas.getAllStyles().setFgColor(0xFF0000);
             panier.getAllStyles().setFgColor(0xFF0000);
          //   cnt1.add(s);
            // cnt1.add(jaimpas);
             cnt1.add(panier);
           //   cnt1.add(s);
             cnt.add(cnt1);  
             f1.add(cnt);
              f1.getToolbar().addCommandToLeftBar("back",icon1,new ActionListener<ActionEvent>() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               Filtrage ft=new Filtrage(theme);
               ft.getF().show();
                
            }
        });


            }

        });
               
               
               
               
               
    }
     
       private void addButton(Resources res,Image img, Article eq,String title, boolean liked, int likeCount, int commentCount) {
        UIBuilder  ui = new UIBuilder();
         Container ct1;
  
       int height = Display.getInstance().convertToPixels(11.5f);
       int width = Display.getInstance().convertToPixels(14f);
       Button image = new Button(img.fill(width, height));
       image.setUIID("Label");
       Container cnt = BorderLayout.west(image);
       cnt.setLeadComponent(image);
       TextArea ta = new TextArea(title);
       ta.setUIID("NewsTopLine");
       ta.setEditable(false);
       Label v = new Label("              ");
    
     Label pr = new Label( eq.getPrixarticle()+ " DT" );
      // likes.setTextPosition(RIGHT);
       if(!liked) {
           //FontImage.setMaterialIcon(likes, FontImage.MATERIAL_RATE_REVIEW);
       } else {
           Style s = new Style(pr.getUnselectedStyle());
           s.setFgColor(0xff2d55);
           //FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, s);
         //  likes.setIcon(heartImage);
       }
      // Label comments = new Label(commentCount + " Comments", "NewsBottomLine");
      // FontImage.setMaterialIcon(likes,FontImage.MATERIAL_RATE_REVIEW);*/
       
       
     cnt.add(BorderLayout.CENTER, 
               BoxLayout.encloseY(
                       ta,
                       BoxLayout.encloseX(pr)
               ));
     
       f.add(cnt);
       image.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
                   Form f1 = new Form();
       Toolbar tf2 = new Toolbar(false);
                        f1.setToolbar(tf2);
                        f1.getToolbar().getStyle().setBgColor(0xD3D3D3);
                        //f1.getToolbar().getStyle().setBgTransparency(250);
                        f1.getToolbar().setTitle("Details");
                        
                        f1.getToolbar().addCommandToLeftBar("back", res.getImage("back-command.png"), new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                
                                HomeForm produit = new HomeForm(res); // Logger.getLogger(AboutForm.class.getName()).log(Level.SEVERE, null, ex);
                                produit.show();
                            }
                        }); 

                        
              
              Label lnom = new Label ("Name: "+eq.getNomarticle());
             
             
              Label lprix = new Label ("Price: "+eq.getPrixarticle()+"DT");
      
             // f1.add(lnom);
            
            
              //f1.add(lprix);
   
                int displayHeight = Display.getInstance().getDisplayHeight();
              Image scImage1 = img.scaled(-1, displayHeight / 5);
              ImageViewer imvo;
              imvo= new ImageViewer (scImage1);
              
              
              Container cnt = new Container (new BoxLayout (BoxLayout.X_AXIS) );
               Container cnt1 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
              cnt.add(imvo);  
              
            //Label jaim = new Label("J'aime");
            
    
            
            
                 //  Label evaluer= new Label("Evaluer Produit");
  
           
             //Label jaimpas= new Label("J'aime pas");
            Label panier= new Label("Add to Cart");
              TextField qt=new TextField("Enter quantity");
               ShareButton s = new ShareButton (); 
       /* s.setText ("Partager"); 
        s.setTextToShare ("Ce produit est excellent"+eq.getNomarticle()); */
        
            /*  panier.addPointerPressedListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent evt) {
                         LigneCommande L =new LigneCommande();
                        L.setQuantitepanier(Integer.parseInt(qt.getText()));
                        L.setIdarticle(eq);
                           LignecommandeService lcs = new LignecommandeService();
                           lcs.ajouterlc(L);
                           
                         
                       }
                   });*/
             // s.getAllStyles().setFgColor(0xFF0000);
              qt.getAllStyles().setFgColor(0xFF0000);
            // jaim.getAllStyles().setFgColor(0xFF0000);
            // jaimpas.getAllStyles().setFgColor(0xFF0000);
             panier.getAllStyles().setFgColor(0xFF0000);
           

             
               /* jaim.addPointerPressedListener(new ActionListener(){
           
            
           
          public void actionPerformed(ActionEvent evt) {
                
            ConnectionRequest con1 = new ConnectionRequest();
               con1.setUrl("http://localhost/codeteste/web/app_dev.php/vente/article/"+eq.getIdarticle());
               
                System.out.println(1);

                
            con1.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

            String x=new String(con1.getResponseData());
                System.out.println(new String(con1.getResponseData()));
                //int y= Integer.parseInt(x);
              int y=(int) Float.parseFloat(x);
                System.out.println("x est" +x);
                System.out.println("y est" +y);
                
                
                  if(x.equals("0"))
              {
                  boolean j;
              
                  j =Dialog.show("Mention j'aime", "Vous avez déjà effectué un j'aime sur ce produit ", "ok",null);

              }
                       
                  if(x.equals("1"))
              {
                  boolean j;
              
                  j =Dialog.show("Mention j'aime", "j'aime effectué ", "ok",null);

              }
//                      else if(y==1)
//              {
//                  boolean j;
//              
//                  j =Dialog.show("Mention j'aime", "Vous avez déjà effectué un j'aime sur ce produit, Vous ne pouvez plus renouveler ", "ok",null);
//
//              }
            }
        });
        NetworkManager.getInstance().addToQueue(con1);


             
          }
            });*/
              
               
         /* jaimpas.addPointerPressedListener(new ActionListener(){
           
            
           
          public void actionPerformed(ActionEvent evt) {
                
            ConnectionRequest con1 = new ConnectionRequest();
               con1.setUrl("http://localhost/codetest/web/app_dev.php/vente/article/"+eq.getIdarticle());
                System.out.println("ok");
               

                
            con1.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                 String x=new String(con1.getResponseData());
                System.out.println(new String(con1.getResponseData()));
   int y= Integer.parseInt(x);
              
                System.out.println("x est" +x);
                System.out.println("y est" +y);
    
                
                      if(x.equals("0"))
              {
                  boolean j;
              
                  j =Dialog.show("Mention j'aime pas", "Vous avez déjà effectué un j'aime pas sur ce produit ", "ok",null);

              }
                       
                  if(x.equals("1"))
              {
                  boolean j;
              
                  j =Dialog.show("Mention j'aime pas", "j'aime pas effectué ", "ok",null);

              }

            }
        });
        NetworkManager.getInstance().addToQueue(con1);


             
          }
            });*/
          
                       panier.addPointerPressedListener(new ActionListener() {
                           
                             
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                        if(qt.getText().equals(""))   
                   {
                       
                        
                       
                            Dialog.show("error", "Choose the Quantity", "Ok", null);
                   }
                        else
                        {
                             LigneCommande L =new LigneCommande();
                        L.setQuantitepanier(Integer.parseInt(qt.getText()));
                        L.setIdarticle(eq);
                           LignecommandeService lcs = new LignecommandeService();
                           lcs.ajouterlc(L);
                     
               
               

                
           
                        
                       
                            Dialog.show("Confirmation", "Article added", "Ok", null);

           

           
        
                     
                 }}
             });
             
                               
       
              
            // cnt1.add(evaluer);
            cnt1.add(lnom);
            cnt1.add(lprix);
             cnt1.add(panier);
             cnt1.add(qt);
              cnt1.add(s);
             
             cnt.add(cnt1);  
             f1.add(cnt);//To change body of generated methods, choose Tools | Templates.
             f1.show();
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
