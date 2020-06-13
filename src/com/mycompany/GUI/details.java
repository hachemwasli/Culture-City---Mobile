/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Film;
import com.mycompany.Service.SeanceService;
import java.util.ArrayList;
import com.mycompany.GUI.list;
import static com.mycompany.GUI.list.listFilm;
import java.io.IOException;
import java.io.OutputStream;


/**
 * GUI builder created Form
 *
 * @author Mnif
 */
public class details extends com.codename1.ui.Form {
ImageViewer img;
    private Resources theme;
    public details(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         SeanceService ss=new SeanceService();
        ArrayList<Film> list=ss.getList1("It");
        
         for(Film f : listFilm){
         Container film = new Container(new BoxLayout(BoxLayout.X_AXIS)); 

        Container lblFilm = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container detailFilm = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container imag = new Container(new FlowLayout(BoxLayout.Y_AXIS));

           img = new ImageViewer();
           EncodedImage palceHolder = EncodedImage.createFromImage(Image.createImage(2000,2000), true);
           URLImage urlImage = URLImage.createToStorage(palceHolder, f.getImage_film(), "http://localhost/codetest/web/uploads/images/"+f.getImage_film());
           img.setImage(urlImage);
           imag.add(img);
           
            Label lblimageFilm =new Label("Image : ");
            Label lblnomFilm =new Label("Film : ");
            Label lblCategorie = new Label("Categorie : ");
            Label lblDescription = new Label("Descriptin : ");

            lblFilm.add(lblnomFilm);
            lblFilm.add(lblCategorie);
            lblFilm.add(lblDescription);

            Label nom = new Label();
            Label categorie = new Label();
            SpanLabel description = new SpanLabel();

            nom.setText(String.valueOf(f.getNom_film()));
            categorie.setText(String.valueOf(f.getCategorie_film()));
            description.setText(String.valueOf(f.getDescription_film()));
            
          
            

            detailFilm.add(nom);
            detailFilm.add(categorie);
            detailFilm.add(description);

            
            

        
            film.add(lblFilm);
            film.add(detailFilm);

            Container c = new Container();
            c.add(film);
            c.add(imag);
            
            getToolbar().addCommandToLeftBar("Back", null, ev -> {
            list liste = new list(theme);
            liste.show();
            
        });

            
             gui_Box_Layout_Y_1.add(c);
            
            
        //capture
          /*   
        setToolbar(new Toolbar());
        Style s = UIManager.getInstance().getComponentStyle("Title");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);

        ImageViewer iv = new ImageViewer(icon);
      

            getToolbar().addCommandToRightBar("", icon, (ev) -> {
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
        });*/
             

         }
         
         getToolbar().addCommandToLeftBar("Back", null, ev -> {
               list liste = new list(theme);
        
                liste.show();
         
            
        });
    }
    
    

////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("font:500px; border:none; fgColor:ffffff; transparency:101; bgImage:500; margin:100px 100px 100px 100px;");
        setTitle("details");
        setName("details");
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        addComponent(gui_Box_Layout_Y_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y_1.getParent().getLayout()).setInsets(gui_Box_Layout_Y_1, "auto auto 26.23574% 24.581005%").setReferenceComponents(gui_Box_Layout_Y_1, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}