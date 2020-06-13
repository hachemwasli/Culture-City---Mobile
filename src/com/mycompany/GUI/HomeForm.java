/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;


import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
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
 *
 * @author PC
 */
public class HomeForm extends Form {
   Label nom;
    Label supp;
    Label modif;
    Button rech;
  
    Label panier;
  
    public HomeForm(Resources res) {
         super("Sales Space", BoxLayout.y());
         Image icon1 = res.getImage("/load.png");
     // Toolbar tb = new Toolbar(true);
         getToolbar().setTitle("Home");
        Toolbar tb = getToolbar();
        Container c = new Container(new FlowLayout(Component.CENTER));
        c.add(new Label("                                 "));
        c.add(new Label("                                 "));

        c.add(new Label("                                 "));

       // EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);

//        URLImage urlImage = URLImage.createToStorage(palceHolder, Login.hama.getImage(), "http://localhost/culture/web/uploads/images/" + Login.hama.getImage());

     //  Image profilePic = urlImage;

        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
      //  profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
      //  Label profilePicLabel = new Label(Login.hama.getNom(), profilePic, "SideMenuTitle");
      //  profilePicLabel.setMask(mask.createMask());

     //   Container sidemenuTop = BorderLayout.center(profilePicLabel);

     //   sidemenuTop.setUIID("SidemenuTop");

      //  getToolbar().addComponentToSideMenu(sidemenuTop);
 tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            new Home(res).show();
        });
        tb.addMaterialCommandToSideMenu("User session", FontImage.MATERIAL_HOME, e -> {
            new ProfileUser(res).k.show();
        });
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_SETTINGS, e -> {
      //      try {
      //          new listCommande(theme).show();
      //      } catch (IOException ex) {
      //          System.out.println("erreur");
      //      }
        });
        tb.addMaterialCommandToSideMenu("Clubs", FontImage.MATERIAL_WEB, e -> {
     ListeClub liste = new ListeClub(res);
       liste.getF().show();
        });
        tb.addMaterialCommandToSideMenu("Shop", FontImage.MATERIAL_SETTINGS, e -> {
            HomeForm sale=new HomeForm(res);
            sale.show();
         
        });
        tb.addMaterialCommandToSideMenu("Cinema", FontImage.MATERIAL_SETTINGS, e -> {
            list liste = new list(res);
        
        liste.show();
      //      new HomeChayma(theme).Accueil.show();
        });
            tb.addMaterialCommandToSideMenu("Library", FontImage.MATERIAL_INFO, e -> {
          
            
          Main m = new Main(res);
          m.show();
        });
       
        tb.addMaterialCommandToSideMenu("Account Settings", FontImage.MATERIAL_INFO, e -> {
  //          new QuestionAffichage(theme).show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_INFO, e -> {

            Login.hama = null;
            Login.lool = "";
            new Login(res).show();

        });

        
        
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Our Product");
        getContentPane().setScrollVisible(false);
        
      
         tb.addCommandToOverflowMenu("Filter", null, new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt) {
                        Filtrage ft=new Filtrage(res);
                        ft.getF().show();}});
         tb.addCommandToOverflowMenu("Basket", null, new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt) {
                       new PanierForm().getF().show();}});
                       
    
        Tabs swipe = new Tabs();

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("cité.jpg"), spacer1, "", "","");
        addTab(swipe, res.getImage("cité.jpg"), spacer2,"","","");
                
        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();
        
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for(int iter = 0 ; iter < rbs.length ; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }
                
//        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if(!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
        
        Component.setSameSize(radioContainer, spacer1, spacer2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));
        
        ButtonGroup barGroup = new ButtonGroup();
        RadioButton Artisanat = RadioButton.createToggle("  Artisanat", barGroup);
        Artisanat.setUIID("SelectBar");
        RadioButton art = RadioButton.createToggle("      Art  ", barGroup);
        art.setUIID("SelectBar");
        
        RadioButton other = RadioButton.createToggle("Other", barGroup);
        other.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
        
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, Artisanat, art,  other),
                FlowLayout.encloseBottom(arrow)
        ));
        Tabs tab=new Tabs();
        Container ct=new Container();
   
        Artisanat.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(Artisanat, arrow);
        });
        bindButtonSelection(Artisanat, arrow);
        bindButtonSelection(art, arrow);
      
        bindButtonSelection(other, arrow);
        
        
        
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
         Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
          Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        
        Artisanat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Artisanat");
                C.refreshTheme(true);
               // Form fh = new Form();
           
         
                
        ConnectionRequest conH = new ConnectionRequest();
        conH.setUrl("http://localhost/codetest/web/app_dev.php/vente/Artisanat");
        conH.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

              ArrayList<Article> list = new ArrayList<>();
              System.out.println(list);
              
               list.addAll(getListArt(new String(conH.getResponseData())));
          
               
                for (Article eq : getListArt(new String(conH.getResponseData()))) {
                   try {
                       addItem(eq,res,icon1);
                       list.clear();
                       
                   } catch (IOException ex) {
                    
                   }
                }
                //Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
                // C.refreshTheme();
                 Dialog ip = new InfiniteProgress().showInifiniteBlocking();
                  ip.dispose();
             
                add(C);

            }
        });
        NetworkManager.getInstance().addToQueue(conH);
        //fh.show();
            }
        });
        
        //fh.show();
            
        
        
           art.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("art");
                C.refreshTheme(true);
     ConnectionRequest conH = new ConnectionRequest();
        conH.setUrl("http://localhost/codetest/web/app_dev.php/vente/Artisanat");
        conH.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

              ArrayList<Article> list = new ArrayList<>();
              System.out.println(list);
              
               list.addAll(getListArt(new String(conH.getResponseData())));
          
               
                for (Article eq : getListArt(new String(conH.getResponseData()))) {
                   try {
                       addItem(eq,res,icon1);
                       list.clear();
                   } catch (IOException ex) {
                    
                   }
                }
               //Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 Dialog ip = new InfiniteProgress().showInifiniteBlocking();
                  ip.dispose();
             C.remove();
              revalidate();
                add(C1);
                // C.refreshTheme();
               // C.clearClientProperties();

            }
        });
        NetworkManager.getInstance().addToQueue(conH);
        //fh.show();
            }
        });
        
          
          
        
            
            other.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("other");
                C.refreshTheme(true);
             ConnectionRequest conH = new ConnectionRequest();
        conH.setUrl("http://localhost/codetest/web/app_dev.php/vente/Art");
        conH.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                // Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 //C.refreshTheme();

              ArrayList<Article> list = new ArrayList<>();
              System.out.println(list);
              
               list.addAll(getListArt(new String(conH.getResponseData())));
          
               
                for (Article eq : getListArt(new String(conH.getResponseData()))) {
                   try {
                       addItem(eq,res,icon1);
                      list.clear();
                      //C.clearClientProperties();
                   } catch (IOException ex) {
                    
                   }
                }
             //  Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
              //  C.refreshTheme();
               Dialog ip = new InfiniteProgress().showInifiniteBlocking();
             C.remove();
             C1.remove();
              ip.dispose();
              revalidate();
                add(C2);
              //  C.clearClientProperties();

            }
        });
        NetworkManager.getInstance().addToQueue(conH);
        //fh.show();
            }
        });
    
    
    }
        
     public void addItem(Article eq,Resources theme,Image icon1) throws IOException {
         
           UIBuilder  ui = new UIBuilder();
         Container ct1;
 
      Form f1 = new Form();
       refreshTheme();
         
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
              Label lprix = new Label ("Price: "+eq.getPrixarticle()+"DT");              
              f1.add(lnom);
              f1.add(lprix);
     
              Image scImage1 = img.scaled(-1, displayHeight / 3);
              ImageViewer imvo;
              imvo= new ImageViewer (scImage1);
              
              
              Container cnt = new Container (new BoxLayout (BoxLayout.X_AXIS) );
               Container cnt1 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
              cnt.add(imvo);            
            
            
            Label panier= new Label("Add to Cart");
             ShareButton s = new ShareButton (); 
      
             
             panier.getAllStyles().setFgColor(0xFF0000);
           //  cnt1.add(s);
           
             cnt1.add(panier);
            //  cnt1.add(s);
             cnt.add(cnt1);  
             f1.add(cnt);
              f1.getToolbar().addCommandToLeftBar("back",icon1,new ActionListener<ActionEvent>() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               HomeForm produit=new HomeForm(theme);
                produit.show();
            }
        });


            }

        });
               
               
               
               
               
    }
     
     
     public ArrayList<Article> getListArt(String json) {
         
        ArrayList<Article> listarts = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> arts = j.parseJSON(new CharArrayReader(json.toCharArray()));

       
            List<Map<String, Object>> list = (List<Map<String, Object>>) arts.get("root");

            for (Map<String, Object> obj : list) {
                Article carte = new Article();//id, json, status);
               carte.setIdarticle((int) Float.parseFloat(obj.get("idarticle").toString()));   
                carte.setNomarticle(obj.get("nomarticle").toString());
                carte.setImagearticle(obj.get("imagearticle").toString());
                carte.setPrixarticle((int) Float.parseFloat(obj.get("prixarticle").toString()));
                carte.setQuantitearticles((int) Float.parseFloat(obj.get("quantitearticle").toString()));    
                listarts.add(carte);

            }

        } catch (IOException ex) {
        }
        return listarts;

    }

    
    private void updateArrowPosition(Button b, Label arrow) {
        arrow.getUnselectedStyle().setMargin(LEFT, b.getX() + b.getWidth() / 2 - arrow.getWidth() / 2);
        arrow.getParent().repaint();
        
        
    }
    
    private void addTab(Tabs swipe, Image img, Label spacer, String likesStr, String commentsStr, String text) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if(img.getHeight() < size) {
           img = img.scaledHeight(size);
        }
        //Label likes = new Label(likesStr);
        //Style heartStyle = new Style(likes.getUnselectedStyle());
        //heartStyle.setFgColor(0xff2d55);
        //FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, heartStyle);
        //likes.setIcon(heartImage);
        //likes.setTextPosition(RIGHT);

        //Label comments = new Label(commentsStr);
        //FontImage.setMaterialIcon(comments, FontImage.MATERIAL_CHAT);
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
           img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        ScaleImageLabel image = new ScaleImageLabel(img);
        image.setUIID("Container");
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overlay = new Label(" ", "ImageOverlay");
        
        Container page1 = 
            LayeredLayout.encloseIn(
                image,
                overlay,
                BorderLayout.south(
                    BoxLayout.encloseY(
                            new SpanLabel(text, "LargeWhiteText"),
                            //FlowLayout.encloseIn(likes, comments),
                            spacer
                        )
                )
            );

        swipe.addTab("", page1);
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
     
       add(cnt);
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
              TextField qt=new TextField("Enetr a quantity");
               ShareButton s = new ShareButton (); 
      //  s.setText ("Partager"); 
      //  s.setTextToShare ("Ce produit est excellent"+eq.getNomarticle()); 
        
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
          //    s.getAllStyles().setFgColor(0xFF0000);
              qt.getAllStyles().setFgColor(0xFF0000);
            // jaim.getAllStyles().setFgColor(0xFF0000);
            // jaimpas.getAllStyles().setFgColor(0xFF0000);
             panier.getAllStyles().setFgColor(0xFF0000);
          
                       panier.addPointerPressedListener(new ActionListener() {
                           
                             
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                        if(qt.getText().equals(""))   
                   {
                       
                        
                       
                            Dialog.show("erreur", "Please enter a quantity", "Ok", null);
                   }
                        else
                        {
                             LigneCommande L =new LigneCommande();
                        L.setQuantitepanier(Integer.parseInt(qt.getText()));
                        L.setIdarticle(eq);
                           LignecommandeService lcs = new LignecommandeService();
                           lcs.ajouterlc(L);
                       
                            Dialog.show("Confirmation", "Article added", "Ok", null); }}
             });
            cnt1.add(lnom);
            cnt1.add(lprix);
             cnt1.add(panier);
             cnt1.add(qt);
              //cnt1.add(s);
             
             cnt.add(cnt1);  
             f1.add(cnt);
             f1.show();
           }
       });
   }
   
   
    
    private void bindButtonSelection(Button b, Label arrow) {
        b.addActionListener(e -> {
            if(b.isSelected()) {
                updateArrowPosition(b, arrow);
            }
        });
    }}

