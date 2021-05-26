
package org.Graphics;

import java.io.Serializable;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import javax.media.opengl.GL;
import org.Graphics.Path;

/**
 *
 * @author omar-
 */
public class Worm implements Serializable{
    public static float x=-11f,y=-11f;
    public static float speed = 0.1f;
    public static boolean alive = true;
    public static Path safeRoom;
    public static boolean safeSave;
    public static int powerLevel;
    
    public static float getX() {
        return x;
    }

    public static void setX(float x) {
        Worm.x = x;
    }
    public static void resetPosition(){
        Worm.x = -11f;
        Worm.y = -11f;
    }

    public static float getY() {
        return y;
    }

    public static void setY(float y) {
        Worm.y = y;
    }

    
    public static void moveX(float c) {
        Worm.x += c;
    }
    
    public static void moveY(float c) {
        Worm.y += c;
    }
    
    public static void DrawWorm(GL gl) {
        float x0 = 5f;
        float x1 = 4f;
        float x2 = 3f;
        float x3 = 3f;
        float r0 = .75f;
        float r1 = .45f;
        float r2 = .3f;
        float r3 = .15f;
        float r4 = .12f;
        
        gl.glColor3f(1, 1, 0);
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x0;i<= x0;i+=.1f/r0){
                gl.glVertex3d(r0*cos(i), r0*sin(i),-14.9);
            }
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x1;i<= x1;i+=.1f/r1){
                gl.glVertex3d(r1*cos(i), r1*sin(i) -.8f,-14.9);
            }
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x2;i<= x2;i+=.1f/r2){
                gl.glVertex3d(r2*cos(i), r2*sin(i) -1.3f,-14.9);
            }
        gl.glEnd();
        gl.glColor3f(0f, 0.8f, 1f);
        gl.glLineWidth(7);
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(.2, .4,-14.9);
            gl.glVertex3d(.9, -.7,-14.9);
        gl.glEnd();
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(-.2, .4,-14.9);
            gl.glVertex3d(-.9, -.7,-14.9);
        gl.glEnd();
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x3;i<= x3;i+=.1f/r3){
                gl.glVertex3d(r3*cos(i) - .2, r3*sin(i) + .6,-14.9);
            }
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x3;i<= x3;i+=.1f/r3){
                gl.glVertex3d(r3*cos(i) + .2, r3*sin(i) + .6,-14.9);
            }
        gl.glEnd();
        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x3;i<= x3;i+=.1f/r4){
                gl.glVertex3d(r4*cos(i) - .2, r4*sin(i) + .69,-14.9);
            }
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            for(float i = -x3;i<= x3;i+=.1f/r4){
                gl.glVertex3d(r4*cos(i) + .2, r4*sin(i) + .69,-14.9);
            }
        gl.glEnd();
    }
    
    public static Path getPath(ArrayList<Path> paths){
        Path currentPath = null;
        for (Path path : paths) {
            if (Worm.x >= path.getCorner1().getMinX() && Worm.x <= path.getCorner2().getMaxX() && Worm.y >= path.getCorner1().getMinY() && Worm.y <= path.getCorner2().getMaxY()){
                currentPath = path ;
            }
        }
        return currentPath ;
    }
    
    public static boolean isInSafeRoom(){
        
        if (Worm.x >= safeRoom.getSafeRoom().getMinX()-2 && Worm.x <= safeRoom.getSafeRoom().getMaxX()+2 && Worm.y >= safeRoom.getSafeRoom().getMinY() && Worm.y <= safeRoom.getSafeRoom().getMaxY()){
                return true;
            }
        else return false;
        
    }
    
    
}
