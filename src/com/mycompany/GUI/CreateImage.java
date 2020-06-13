/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;

/**
 *
 * @author Jawher
 */
public class CreateImage {
     public static ImageViewer createImg(String name,int width,int height)
    {
     ImageViewer img= new ImageViewer();
        EncodedImage palceHolder = EncodedImage.createFromImage(Image.createImage(width,height), true);
            URLImage urlImage = URLImage.createToStorage(palceHolder, name, "http://localhost/codetest/web/uploads/images/" + name);
            img.setImage(urlImage);
            return img;       
    }
}
