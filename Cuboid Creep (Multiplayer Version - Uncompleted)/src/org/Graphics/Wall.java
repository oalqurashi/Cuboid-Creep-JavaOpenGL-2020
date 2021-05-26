/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Graphics;

import java.io.Serializable;
import javax.media.opengl.GL;

/**
 *
 * @author Dahab
 */
public class Wall implements Serializable{

    private Vertex V1, V2;
    private String ID;
    

    public Wall(Vertex V1, Vertex V2) {
        this.V1 = V1;//new Vertex(V1.getID(), V1.getX(), V1.getY(), V1.getZ());
        this.V2 = V2;//new Vertex(V2.getID(), V2.getX(), V2.getY(), V2.getZ());
        this.ID = "none";
    }

    public Wall(String ID, Vertex V1, Vertex V2) {
        this.V1 = V1;//new Vertex(V1.getID(), V1.getX(), V1.getY(), V1.getZ());
        this.V2 = V2;//new Vertex(V2.getID(), V2.getX(), V2.getY(), V2.getZ());
        this.ID = ID;
    }


    void Print() {
        System.out.format("EdgeID= %s  V1ID= %s x= %7.3f   y=%7.3f   z=%7.3f \n",ID, V1.getID(), V1.getX(), V1.getY(), V1.getZ());
        System.out.format("EdgeID= %s  V2ID= %s x= %7.3f   y=%7.3f   z=%7.3f \n",ID, V2.getID(), V2.getX(), V2.getY(), V2.getZ());
    }

    public Vertex getV1() {
        return V1;
    }

    public Vertex getV2() {
        return V2;
    }

    @Override
    public String toString() {
        return "Edge{ID=" + ID +  "V1=" + V1 + ", V2=" + V2 + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
//    public void drawWall(GL gl) {
//        gl.glBegin(GL.GL_LINES);
//            gl.glVertex2d(V1.getX(), V1.getY());
//            gl.glVertex2d(V2.getX(), V2.getY());
//        gl.glEnd();
//    }
    
    public void drawWall(GL gl) {
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(V1.getX(), V1.getY(),-14.9f);
            gl.glVertex3d(V2.getX(), V2.getY(),-14.9f);
        gl.glEnd();
    }
}
