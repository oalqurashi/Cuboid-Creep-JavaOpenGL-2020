/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Graphics;

import java.io.Serializable;

/**
 *
 * @author Dahab
 */
public class Vertex implements Serializable{
    private float x,  y,  z;
    private String ID;
    
    public Vertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ID = "none";
    }
    
    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.ID = "none";
    }
    
    public Vertex(double x, double y, double z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
        this.ID = "none";
    }
    
    public Vertex(double x, double y) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float) 0;
        this.ID = "none";
    }
    
    public Vertex(String ID, float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ID = ID;
    }
    
    public Vertex(String ID, float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.ID = ID;
    }
    
    public Vertex(String ID, double x, double y, double z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
        this.ID = ID;
    }
    
    public Vertex(String ID, double x, double y) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float) 0;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Vertex{, ID=" + ID  + "x=" + x + ", y=" + y + ", z=" + z +  '}';
    }
    
    void Print(){
        System.out.format("ID=%s x= %7.3f   y=%7.3f   z=%7.3f \n", ID, x,y,z);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
