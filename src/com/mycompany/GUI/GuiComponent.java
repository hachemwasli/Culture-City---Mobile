package com.mycompany.GUI;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


class Connexion extends Form  {
    public Connexion(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_label1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setUIID("idPa");
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Connexion");
        setName("Connexion");
        gui_Label.setPreferredSizeStr("26.719578mm 7.4074073mm");
        gui_Label.setText("Nom d'utilisateur :");
        gui_Label.setUIID("idN");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_label1.setPreferredSizeStr("25.925926mm inherit");
        gui_label1.setText("Mot de passe :");
        gui_label1.setUIID("idP");
                gui_label1.setInlineStylesTheme(resourceObjectInstance);
        gui_label1.setName("label1");
        gui_Text_Field.setHint("Nom d'utilisateur");
        gui_Text_Field.setText("TextField");
        gui_Text_Field.setUIID("idNu");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setName("Text_Field");
        gui_Text_Field.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue853".charAt(0), gui_Text_Field.getUnselectedStyle()));
        gui_Text_Field_1.setPreferredSizeStr("54.232803mm inherit");
        gui_Text_Field_1.setText("TextField");
                gui_Text_Field_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Text_Field_1.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_Text_Field_1.getUnselectedStyle()));
        addComponent(gui_Label);
        addComponent(gui_label1);
        addComponent(gui_Text_Field);
        addComponent(gui_Text_Field_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "22.439024% auto auto 3.1746035mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_label1.getParent().getLayout()).setInsets(gui_label1, "39.02439% 0.0mm auto 0.0mm").setReferenceComponents(gui_label1, "-1 0 -1 0 ").setReferencePositions(gui_label1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Field.getParent().getLayout()).setInsets(gui_Text_Field, "0.0mm auto auto 28.38983%").setReferenceComponents(gui_Text_Field, "0 -1 -1 -1").setReferencePositions(gui_Text_Field, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Field_1.getParent().getLayout()).setInsets(gui_Text_Field_1, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Text_Field_1, "-1 2 1 2 ").setReferencePositions(gui_Text_Field_1, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
}
//-- DON'T EDIT ABOVE THIS LINE!!!
