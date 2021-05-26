/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Graphics;

import java.io.Serializable;
import javax.media.opengl.GL;


public class Box implements Serializable {
    
    private Vertex v1 = null;
    private Vertex v2 = null;
    private Vertex v3 = null;
    private Vertex v4 = null;

    public Box(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    public Vertex getV3() {
        return v3;
    }

    public void setV3(Vertex v3) {
        this.v3 = v3;
    }

    public Vertex getV4() {
        return v4;
    }

    public void setV4(Vertex v4) {
        this.v4 = v4;
    }
    
    
    public void drawBox(GL gl){
        Wall w1 = new Wall(this.getV1(), this.getV2());
        Wall w2 = new Wall(this.getV3(), this.getV4());
        Wall w3 = new Wall(this.getV1(), this.getV3());
        Wall w4 = new Wall(this.getV2(), this.getV4());
        
        w1.drawWall(gl);
        w2.drawWall(gl);
        w3.drawWall(gl);
        w4.drawWall(gl);
    }
    
    
    public float getMinX(){
        float x = v1.getX();
        
        if (x > v2.getX()){
            x = v2.getX();
        }
        else if (x > v3.getX()){
            x = v3.getX();
        }
        else if (x > v4.getX()){
            x = v4.getX();
        }
        
        
        return x;
    }
    
    public float getMinY(){
        float y = v1.getY();
        
        if (y > v2.getY()){
            y = v2.getY();
        }
        else if (y > v3.getY()){
            y = v3.getY();
        }
        else if (y > v4.getY()){
            y = v4.getY();
        }
        
        
        return y;
    }
    
    public float getMaxX(){
        float x = v1.getX();
        
        if (x < v2.getX()){
            x = v2.getX();
        }
        else if (x < v3.getX()){
            x = v3.getX();
        }
        else if (x < v4.getX()){
            x = v4.getX();
        }
        
        
        return x;
    }
    
     public float getMaxY(){
        float y = v1.getY();
        
        if (y < v2.getY()){
            y = v2.getY();
        }
        else if (y < v3.getY()){
            y = v3.getY();
        }
        else if (y < v4.getY()){
            y = v4.getY();
        }
        return y;
    }
}
