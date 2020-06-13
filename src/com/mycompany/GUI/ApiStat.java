/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author yassmine
 */

public class ApiStat extends Form {

    /**
     * Creates a renderer for the specified colors.
     */
    
        private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(50);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {

        CategorySeries series = new CategorySeries(title);
        //ServiceRandonnee sv = new ServiceRandonnee();

        // for (double value : values) {
        //            series.add("Offre " + ++k, value);
        //        }
        
        
        Label l1 = new Label();
        ConnectionRequest con1 = new ConnectionRequest();
        con1.setUrl("http://localhost/codetest/web/app_dev.php/club1/stat");
        con1.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String value1 = new String(con1.getResponseData());
                System.out.println(value1);
                System.out.println("hhhhhhhhhhhhhh");
                l1.setText(value1);
                System.out.println(l1.getText());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con1);
        System.out.println("aaaaaaa "+l1.getText());
                double v1 = (double) Float.parseFloat(l1.getText());
        Label l2 = new Label();

        ConnectionRequest con2 = new ConnectionRequest();
        con2.setUrl("http://localhost/codetest/web/app_dev.php/club1/test");
        con2.addResponseListener(new ActionListener<NetworkEvent>() {
            public void actionPerformed(NetworkEvent evt) {
                String value2 = new String(con2.getResponseData());
                System.out.println(value2);
                      l2.setText(value2);


            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con2);
                double v2 = (double) Double.parseDouble(l2.getText());

                
           
        series.add("Club Art", v1);
        series.add("test ", v2);

      
        return series;

    }

    public Form createPieChartForm(Resources theme) {

        // Generate the values
        double[] values = new double[]{50, 99, 11, 30, 25, 60};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.BLACK};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(50);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Pourcentages", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Statistique");
        
            f.getToolbar().setTitle("Statistics");
      
        Toolbar tb = f.getToolbar();
        Container chome = new Container(new FlowLayout(Component.CENTER));
        chome.add(new Label("                                 "));
        chome.add(new Label("                                 "));

        chome.add(new Label("                                 "));
  Image mask = theme.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
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
        
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);

        // menu  cc= new menu(theme);
        //Toolbar
        Toolbar.setGlobalToolbar(true);

        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_HOME, s);

//    
//        f.getToolbar().addCommandToLeftBar("Home", icon, (e) -> {
//            
//            
//            
//            Log.p("Clicked");
//              cc.getF().show();
//  
//        
//                
//                
//                });
        return f;
        
    }
    
    }
 


