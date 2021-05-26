/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Graphics;

import java.io.Serializable;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;

/**
 *
 * @author omar-
 */
public class Star implements Serializable {
    public float x,y;
    public boolean isTaken;

    public Star(float x,float y) {
        this.x = x;
        this.y = y;
    }
    
    public void DrawStar(GL gl) {
        this.checkWorm1();
        this.checkWorm2();
        gl.glTranslatef(x, y, 0);
        float r = .5f;
        float xc = 10f;
        gl.glColor3f(1f, 1f, 0f);
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -xc;i<= xc;i+=.1f/r){
                gl.glVertex3d(r*cos(i), r*sin(i),-14.9);
            }
        gl.glEnd(); 
        gl.glColor3f(0.5f, 0.5f, 1f);
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3f(-.2f,.3f,-14.9f);
            gl.glVertex3f(.2f,.3f,-14.9f);
            gl.glVertex3f(-.3f,0f,-14.9f);
            gl.glVertex3f(.3f,0f,-14.9f);
            gl.glVertex3f(-.2f,-.3f,-14.9f);
            gl.glVertex3f(.2f,-.3f,-14.9f);
        gl.glEnd(); 
    }
    
    private void checkWorm1(){
        if ((int) this.x == (int) Worm.x && (int) this.y ==  (int) Worm.y || (Math.abs(this.x - Worm.x) < 1 && Math.abs(this.y - Worm.y) < 1 )){
            Worm.powerLevel++;
            this.isTaken = true;
        }
    }
    private void checkWorm2(){
        if ((int) this.x == (int) Worm2.x && (int) this.y ==  (int) Worm2.y || (Math.abs(this.x - Worm2.x) < 1 && Math.abs(this.y - Worm2.y) < 1 )){
            Worm2.powerLevel++;
            this.isTaken = true;
        }
    }
    
}
