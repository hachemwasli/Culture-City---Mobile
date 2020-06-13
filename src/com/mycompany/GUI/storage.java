/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * GUI builder created Form
 *
 * @author Mnif
 */
public class storage extends com.codename1.ui.Form {

    public storage() throws IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public storage(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException {

        initGuiBuilderComponents(resourceObjectInstance);
        list a = new list(resourceObjectInstance);
        getToolbar().addCommandToLeftBar("Back", null, e -> a.show());
     //   Form hi = new Form("Storage", new BoxLayout(BoxLayout.Y_AXIS));
             getToolbar().addCommandToRightBar("+", null, e -> {
             TextField tf = new TextField("", "File Name", 20, TextField.ANY);
             TextArea body = new TextArea(5, 20);
             body.setHint("File Body");
             Command ok = new Command("OK");
             Command cancel = new Command("Cancel");
             Command result = Dialog.show("File Name", BorderLayout.north(tf).add(BorderLayout.CENTER, body), ok, cancel);
             if(ok == result) {
                 try(OutputStream os = Storage.getInstance().createOutputStream(tf.getText());) {
                     os.write(body.getText().getBytes("UTF-8"));
                     createFileEntry(this, tf.getText());
                    getContentPane().animateLayout(250);
                 } catch(IOException err) {
                 }
             }
         });
         for(String file : Storage.getInstance().listEntries()) {

            createFileEntry(this, file);
         }

       //  hi.show();
    }
    
    private void createFileEntry(Form hi , String file) {
       Label fileField = new Label(file);
       Button delete = new Button();
       Button view = new Button();
       FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
       FontImage.setMaterialIcon(view, FontImage.MATERIAL_OPEN_IN_NEW);
       Container content = BorderLayout.center(fileField);
       int size = Storage.getInstance().entrySize(file);
       content.add(BorderLayout.EAST, BoxLayout.encloseX(new Label(size + "bytes"), delete, view));
       delete.addActionListener(e -> {
           Storage.getInstance().deleteStorageFile(file);
           refreshTheme();
           content.setY(hi.getWidth());
           refreshTheme();
           hi.getContentPane().animateUnlayoutAndWait(150, 255);
           refreshTheme();
           hi.removeComponent(content);
           refreshTheme();
           hi.getContentPane().animateLayout(150);
           refreshTheme();
           
       });
       refreshTheme();
       view.addActionListener(e -> {
           try(InputStream is = Storage.getInstance().createInputStream(file);) {
               String s = Util.readToString(is, "UTF-8");
               Dialog.show(file, s, "OK", null);
           } catch(IOException err) {
           }
       });
       
       
         
          gui_Box_Layout_Y.add(content);
          
          
}

////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("My Notes");
        setName("My Notess");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "auto 0.0mm 0.0mm auto").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}