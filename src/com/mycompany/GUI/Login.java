/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.codename1.media.MediaManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;
import java.io.IOException;
import java.util.ArrayList;
 

/**
 *
 * @author Zliaa
 */
public class Login extends Form {

    public static int MEMBER_ID = 0;
    public static String lool = "";

    public static User hama;

    private String url = "http://localhost/codetest/web/app_dev.php/user/login/";
    private ConnectionRequest connectionRequest;

    public Login() throws IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public Login(com.codename1.ui.util.Resources resourceObjectInstance) {

        initGuiBuilderComponents(resourceObjectInstance);

        gui_insrit.addPointerPressedListener(e -> {
            Inscription a = new Inscription(resourceObjectInstance);
            a.getF().show();
        });

        gui_mdpOublie.addPointerPressedListener(e -> {
            MdpO xxxx = new MdpO(resourceObjectInstance);
            xxxx.getF().show();
        });

        gui_connect.addActionListener(e -> {
            if (gui_txtpseudo.getText().equals("") || gui_txtmdp.getText().equals("")) {
                Dialog.show("Champs vides !", "Error", "OK", "Cancel");
            }
            connectionRequest = new ConnectionRequest();
            connectionRequest.setPost(false);
            connectionRequest.setUrl(url + gui_txtpseudo.getText() + "/" + gui_txtmdp.getText());

            System.out.println(url + gui_txtpseudo.getText() + "/" + gui_txtmdp.getText());
            connectionRequest.addResponseListener(a -> {

                try {
                    String resultat = new String(connectionRequest.getResponseData());
                    System.out.println(resultat+"544444444444444444444444444444444444444444444");
                    JSONArray jsonarray = new JSONArray(resultat);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("username");

                        final int id = jsonobject.getInt("id");
                        MEMBER_ID = id;
                    }

                    if (MEMBER_ID != 0) {

                        UserService uu = new UserService();
                        User u = new User();
                        u = uu.getU(gui_txtpseudo.getText());

                        lool = gui_txtmdp.getText();
                        hama = u;

                        //    ListeProgramme aaaa = new ListeProgramme(theme);
                        //   aaaa.getF().show();
                        Home h = new Home(resourceObjectInstance);
                        h.show();
                    } else {
                        Dialog.show("Informations incorectes", "Error", "OK", "Cancel");

                    }

                } catch (JSONException ex) {

                }

            });
            NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        });

    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.components.ImageViewer gui_logo = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Label gui_login = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_mdp = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_txtpseudo = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_txtmdp = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_connect = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_mdpOublie = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_insrit = new com.codename1.ui.Label();

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgImage:;");
        setTitle("");
        setName("Login_1");
        gui_logo.setPreferredSizeStr("63.29382mm 30.694326mm");
        gui_logo.setUIID("logo");
        gui_logo.setInlineStylesTheme(resourceObjectInstance);
        gui_logo.setInlineAllStyles("bgImage:Cit-de-la-culture3.png;");
        gui_logo.setName("logo");
        gui_login.setText("Pseudo");
        gui_login.setUIID("Login");
        gui_login.setInlineStylesTheme(resourceObjectInstance);
        gui_login.setName("login");
        com.codename1.ui.FontImage.setMaterialIcon(gui_login, "\ue853".charAt(0));
        gui_mdp.setPreferredSizeStr("inherit 7.8323455mm");
        gui_mdp.setText("Mot de passe");
        gui_mdp.setUIID("mdp");
        gui_mdp.setInlineStylesTheme(resourceObjectInstance);
        gui_mdp.setName("mdp");
        com.codename1.ui.FontImage.setMaterialIcon(gui_mdp, "\ue897".charAt(0));
        gui_txtpseudo.setUIID("txtpseudo");
        gui_txtpseudo.setInlineStylesTheme(resourceObjectInstance);
        gui_txtpseudo.setInlineAllStyles("border:0.3mm underline 0;");
        gui_txtpseudo.setName("txtpseudo");
        gui_txtmdp.setUIID("txtmdp");
        gui_txtmdp.setInlineStylesTheme(resourceObjectInstance);
        gui_txtmdp.setInlineAllStyles("border:0.3mm underline 0;");
        gui_txtmdp.setName("txtmdp");
        gui_connect.setPreferredSizeStr("72.607956mm 9.31414mm");
        gui_connect.setText("Se Connecter");
        gui_connect.setUIID("se connecter");
        gui_connect.setInlineStylesTheme(resourceObjectInstance);
        gui_connect.setInlineAllStyles("border:roundRect stroke(1.0mm 02a72f) +top-left +top-right +bottom-left +bottom-right 2.0mm; bgColor:2a72f; fgColor:ffffff; transparency:251; alignment:center;");
        gui_connect.setName("connect");
        gui_mdpOublie.setText("Mot de passe oubli\u00E9 ?");
        gui_mdpOublie.setUIID("mdpOublie");
        gui_mdpOublie.setInlineStylesTheme(resourceObjectInstance);
        gui_mdpOublie.setName("mdpOublie");
                gui_txtmdp.setConstraint(TextField.PASSWORD);

        gui_insrit.setText("Vous n'\u00EAtes pas inscrit? S'inscrire !");
        gui_insrit.setUIID("inscrit");
        gui_insrit.setInlineStylesTheme(resourceObjectInstance);
        gui_insrit.setInlineAllStyles("bgColor:2a72f; fgColor:2a72f;");
        gui_insrit.setName("insrit");
        addComponent(gui_logo);
        addComponent(gui_login);
        addComponent(gui_mdp);
        addComponent(gui_txtpseudo);
        addComponent(gui_txtmdp);
        addComponent(gui_connect);
        addComponent(gui_mdpOublie);
        addComponent(gui_insrit);
        ((com.codename1.ui.layouts.LayeredLayout) gui_logo.getParent().getLayout()).setInsets(gui_logo, "8.66426% 5.9271817mm 64.44049% 5.9271803mm").setReferenceComponents(gui_logo, "-1 -1 -1 -1").setReferencePositions(gui_logo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_login.getParent().getLayout()).setInsets(gui_login, "46.750896% auto auto 6.35055mm").setReferenceComponents(gui_login, "-1 -1 -1 -1").setReferencePositions(gui_login, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_mdp.getParent().getLayout()).setInsets(gui_mdp, "53.79069% auto 38.80861% 5.92718mm").setReferenceComponents(gui_mdp, "-1 -1 -1 -1").setReferencePositions(gui_mdp, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_txtpseudo.getParent().getLayout()).setInsets(gui_txtpseudo, "44.584843% 5.927184mm auto 43.599396%").setReferenceComponents(gui_txtpseudo, "-1 -1 -1 -1").setReferencePositions(gui_txtpseudo, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_txtmdp.getParent().getLayout()).setInsets(gui_txtmdp, "auto 5.503812mm 40.794155% 44.225365%").setReferenceComponents(gui_txtmdp, "-1 -1 -1 -1").setReferencePositions(gui_txtmdp, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_connect.getParent().getLayout()).setInsets(gui_connect, "auto 8.679085mm 27.13396% 6.3505516mm").setReferenceComponents(gui_connect, "-1 -1 -1 -1").setReferencePositions(gui_connect, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_mdpOublie.getParent().getLayout()).setInsets(gui_mdpOublie, "72.56321% auto 19.133581% 24.507042%").setReferenceComponents(gui_mdpOublie, "-1 -1 -1 -1").setReferencePositions(gui_mdpOublie, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout) gui_insrit.getParent().getLayout()).setInsets(gui_insrit, "auto auto 9.525829mm 13.521127%").setReferenceComponents(gui_insrit, "-1 -1 -1 -1").setReferencePositions(gui_insrit, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

}
