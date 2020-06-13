/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Film;
import com.mycompany.Entite.Seance;
import com.mycompany.Service.SeanceService;


import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mnif
 */
public class list extends Form {
   Form f ;
    
    Container c6=new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container c3=new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container c1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
     Container c5 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
    SeanceService SeanceService;
    Database db;
    static Film film = new Film();
    static ArrayList<Film> listFilm;
    public Form getF(){
    return f;
    }
    public list(Resources theme) {
        

        
        setTitle("Our Movies");
        f=new Form("affichage film");
         getToolbar().setTitle("Home");
        Toolbar tb = getToolbar();
        Container c = new Container(new FlowLayout(Component.CENTER));
        c.add(new Label("                                 "));
        c.add(new Label("                                 "));

        c.add(new Label("                                 "));

       // EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);

//        URLImage urlImage = URLImage.createToStorage(palceHolder, Login.hama.getImage(), "http://localhost/culture/web/uploads/images/" + Login.hama.getImage());

     //  Image profilePic = urlImage;

        Image mask = theme.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
      //  profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
      //  Label profilePicLabel = new Label(Login.hama.getNom(), profilePic, "SideMenuTitle");
      //  profilePicLabel.setMask(mask.createMask());

     //   Container sidemenuTop = BorderLayout.center(profilePicLabel);

     //   sidemenuTop.setUIID("SidemenuTop");

      //  getToolbar().addComponentToSideMenu(sidemenuTop);
  tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            new Home(theme).show();
        });
        tb.addMaterialCommandToSideMenu("User session", FontImage.MATERIAL_HOME, e -> {
            new ProfileUser(theme).k.show();
        });
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_SETTINGS, e -> {
      //      try {
      //          new listCommande(theme).show();
      //      } catch (IOException ex) {
      //          System.out.println("erreur");
      //      }
        });
        tb.addMaterialCommandToSideMenu("Clubs", FontImage.MATERIAL_WEB, e -> {
     ListeClub liste = new ListeClub(theme);
       liste.getF().show();
        });
        tb.addMaterialCommandToSideMenu("Shop", FontImage.MATERIAL_SETTINGS, e -> {
             HomeForm sale=new HomeForm(theme);
            sale.show();
         
        });
        tb.addMaterialCommandToSideMenu("Cinema", FontImage.MATERIAL_SETTINGS, e -> {
            list liste = new list(theme);
        
             liste.show();
      //      new HomeChayma(theme).Accueil.show();
        });
        tb.addMaterialCommandToSideMenu("Library", FontImage.MATERIAL_INFO, e -> {
          
            
          Main m = new Main(theme);
          m.show();
        });
       
        tb.addMaterialCommandToSideMenu("Account Settings", FontImage.MATERIAL_INFO, e -> {
  //          new QuestionAffichage(theme).show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_INFO, e -> {

            Login.hama = null;
            Login.lool = "";
            new Login(theme).show();

        });  
        
        c1.add(afficher(theme));
        
         Style S = UIManager.getInstance().getComponentStyle("Title");
         FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, S);
        
           TextField r = new TextField("", "Search ");
           //c5.add(r);
           
           
           c5.add(c6);
           c6.add(searchIcon);
           c6.add(r);
           r.addActionListener((evt)->{
               String s=r.getText();
               //System.out.println(s);
        
        if (r.getText()==null || r.getText().equals(""))
        {   c1.removeAll();
        refreshTheme();
         c1.add(afficher(theme));
        
         refreshTheme();
           // afficher(theme);
            
            
        }
        else{
            c1.removeAll();
            refreshTheme();
            //Recherche(s);
            c1.add(Recherche(s));
            refreshTheme();
            
        }
         } );
           c5.add(c1);
           
      //  initGuiBuilderComponents(resourceObjectInstance);
        SeanceService ss=new SeanceService();
        ArrayList<Seance> list=ss.getList();
        
        
       
        //add(c5);
 
    add(c5);     
    }
                
        public Container Recherche(String a){
        Container c = new Container();
         //ServiceCoif serviceTask = new ServiceCoif();
        Form form = new Form();
        ConnectionRequest con3 = new ConnectionRequest();
        con3.setUrl("http://localhost/codetest/web/app_dev.php/cinema/chercherfilm/"+a);
        con3.addResponseListener((NetworkEvent evt) -> {
        ArrayList<Seance> listTasks = new ArrayList<>();
            try {
                //(new String(con.getResponseData()));
                String aff=new String(con3.getResponseData());
                JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                Map<String, Object> tasks = j.parseJSON(new CharArrayReader(aff.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
        for (Map<String, Object> obj : list) {
            
                
       Container C2 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
            
         //Seance s = new Seance();

        //s.setDate_seance(new Date((((Double) ((Map<String, Object>) obj.get("date")).get("timestamp")).longValue() * 1000)));
      //Label nomFilm = new Label("Film: " + obj.get("nomFilm").toString());
        Label nomSalle = new Label("Salle: " + obj.get("salle"));
        Label film = new Label("Salle: " + obj.get("film"));
       // Label date = new Label("Date: " + obj.get("date"));
        Label date = new Label();
        //SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy h:m");
        Seance s = new Seance();
                         s.setDate_seance(new Date((((Double) ((Map<String, Object>) obj.get("date")).get("timestamp")).longValue() * 1000)));
        SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy h:m");
            date.setText(sm.format(s.getDate_seance()));
            
//date.setText(sm.format(obj.get("date")));
        
        C2.add(film);
        C2.add(nomSalle); 
        C2.add(date); 
       c.add(C2);
       
            //c3.add(C2);
           // form.add(C2);
       //  gui_Box_Layout_Y.add(c3);
            
        
        
        System.out.println(obj.get("nomFilm"));
        }
              
            } 
            catch (IOException ex) {
               
            }
            
           
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con3);  
        
        //form.show();
        return(c);
       
    }
    
    public Container afficher(Resources resourceObjectInstance)
    {
        // initGuiBuilderComponents(resourceObjectInstance);
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        SeanceService ss=new SeanceService();
        ArrayList<Seance> list=ss.getList();
       
        SeanceService = new SeanceService();

        list = SeanceService.getList();
         for(Seance s : list){
         Container seance = new Container(new BoxLayout(BoxLayout.X_AXIS)); 
         Container lblSeance = new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
         Container detailSeance = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container btns = new Container(new BoxLayout(BoxLayout.X_AXIS));
         
            Label lblnomFilm =new Label("Movie : ");
            Label lblSalle = new Label("Movie's Theater : ");
            Label lblDate = new Label("Date : ");
            Label lblVu = new Label("Consultation's number: ");
            lblSeance.add(lblnomFilm);
            lblSeance.add(lblSalle);
            lblSeance.add(lblDate);
            lblSeance.add(lblVu);
            
            Label film =new Label();
            Label salle = new Label();
            Label date = new Label();
            
            
            film.setText(String.valueOf(s.getFilm()));
            salle.setText(String.valueOf(s.getSalle()));
            SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy h:m");
            date.setText(sm.format(s.getDate_seance()));
            detailSeance.add(film);
            detailSeance.add(salle);
            detailSeance.add(date);
            //********************************************//
            try {
                    db = Database.openOrCreate("manel");
                    Cursor c1 = db.executeQuery("select count(*) from vu1 where nom='"+film.getText()+"';");
                    while (c1.next()) {
                        Row r = c1.getRow();
                        String nom = r.getString(0);
                       Label vu = new Label(nom);
                        detailSeance.add(vu);
                      
                    }

                } catch (IOException ex) {
                }
            
            //********************************************//
            Container c6=new Container(new BoxLayout(BoxLayout.X_AXIS));
            Style S = UIManager.getInstance().getComponentStyle("Title");
            FontImage icone = FontImage.createMaterial(FontImage.MATERIAL_DETAILS, S);
            c6.add(icone);
            
             Button details = new Button("Details"); 
             
             details.addActionListener( new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {

                SeanceService details = new SeanceService(); 
                listFilm = details.getList1(s.getFilm());

                 try {
            db = Database.openOrCreate("manel");

           

            db.execute("create table vu1 (nom TEXT);");
           

        } catch (IOException ex) {
        }
                 try {
                    String nom = film.getText();
                    

                    db.execute("insert into vu1 (nom) values ('"+nom+"');");
                    System.out.println("OK");

                } catch (IOException ex) {
                     System.out.println("erreur");
                }
                new details(resourceObjectInstance).show();
                
 }
            }
            );
             
             c6.add(details);
             lblSeance.add(c6);

            seance.add(lblSeance);
            seance.add(detailSeance);

             c.add(seance);
            

         }
         
           Button btn = new Button("RECOMMENDATION");
           Button btnstorage = new Button("My Notes");
                   btn.addActionListener((e)->{
            
            //send msg
                Message m = new Message("");
            
                m.setMimeType(Message.MIME_HTML);
                Display.getInstance().sendMessage(new String[] {"manelmnif96@gmail.com"}, "RECOMMENDATION", m);     
        }
);
         Style S = UIManager.getInstance().getComponentStyle("Title");
         FontImage Icon = FontImage.createMaterial(FontImage.MATERIAL_MAIL, S);
                   Container c6=new Container(new BoxLayout(BoxLayout.X_AXIS));
                   c6.add(Icon );
                   c6.add(btn);
                   
         btnstorage.addActionListener(
               (e)->{       
            try {
 
                new storage(resourceObjectInstance).show();
            } catch (IOException ex) {
            }
                    }
       );
         Style S1 = UIManager.getInstance().getComponentStyle("Title");
         FontImage Icon1 = FontImage.createMaterial(FontImage.MATERIAL_NOTES, S1);
         Container c7=new Container(new BoxLayout(BoxLayout.X_AXIS));
          c7.add(Icon1 );
          c7.add(btnstorage);
          
         
         c.add(c7);
         c.add(c6);
    return(c);
    }
                   
                   
    
    
}
