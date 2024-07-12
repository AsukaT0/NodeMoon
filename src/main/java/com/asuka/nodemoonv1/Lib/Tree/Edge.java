package com.asuka.nodemoonv1.Lib.Tree;

import com.almasb.fxgl.core.math.Vec2;
import com.asuka.nodemoonv1.Lib.MyScene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Edge {
    private Vec2 size;
    private ArrayList<Image> images;
    private Group fullObj;
    Button conn0;
    Button main;
    Button conn1;


    private Button rendButton(int index, int w, int h){
        Button button = new Button();
        ImageView imageView = new ImageView(images.get(index));
        imageView.setFitHeight(h);
        imageView.setFitWidth(w);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: #FFFFFF00;");

    return button;}

    public Edge(
            String imagePath,
            float width,float height){

        images.add(new Image(String.valueOf(MyScene.class.getResource("/com/asuka/nodemoonv1/images/structure/pages.png"))));

        size = new Vec2(width,height);


    }

    public Vec2 getSize(){return size;}
    public float getHeight(){return size.y;}
    public float getWidth(){return size.x;}

    public void setSize(Vec2 vec){size = vec;}
    public void setHeight(float val){size.y = val;}
    public void setWidth(float val){size.x = val;}

    public Image getMainImg() {return images.get(1);}
    public void setMainImg(String path){
        if(images.size()>1) images.add(new Image(path));
        else images.set(1,new Image(path));}
}
