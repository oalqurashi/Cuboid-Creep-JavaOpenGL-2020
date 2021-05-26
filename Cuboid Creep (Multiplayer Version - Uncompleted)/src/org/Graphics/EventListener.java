package org.Graphics;


import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


public class EventListener implements GLEventListener, KeyListener , Serializable {
    int moveUp = -1;
    int moveDown = -1;
    int moveLeft = -1;
    int moveRight = -1;
    int moveUp2 = -1;
    int moveDown2 = -1;
    int moveLeft2 = -1;
    int moveRight2 = -1;
    int space = -1;
    float rot = 270, rot2 = 270, z = -5, goal = 11.5f;
    int mapNum = 1;
    Map map;
    GLU glu = new GLU();
    
    
    public static void main(String[] args) {
        Frame frame = new Frame("JOGL1");
        GLCanvas canvas = new GLCanvas();
        
        final Animator a = new Animator(canvas);
        EventListener obj = new EventListener();
        
        canvas.addGLEventListener(obj);
        canvas.addKeyListener(obj);
        frame.add(canvas);
        frame.setSize(1000, 1000);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {               
                        System.exit(0);
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        a.start();
    }
    
    public void init(GLAutoDrawable drawable){
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        
        GL gl = drawable.getGL();
        
        map = new Map(1);
        mapNum = map.getMapNum();
        
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        // Enable VSync
        gl.setSwapInterval(1);
        //gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens. 
    }


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        
        glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(55.0f, h, 1.0, 50.0);
        glu.gluLookAt(0, 0, 10, 0, 0, 0, 0, 1, 0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -5f);
    }

    public void display(GLAutoDrawable drawable) {
        if(mapNum == 5)
        {
            mapNum = 1;
            map = new Map(mapNum);
            save();
        }
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //Worm death
        if (Worm.isInSafeRoom()||Worm2.isInSafeRoom()){
            Worm.safeSave = true;
            Worm2.safeSave = true;
        }
        if (!Worm.alive){
            Worm.x =-11;
            Worm.y =-11;
            Worm.alive = true;
        }
        if (!Worm2.alive){
            Worm2.x =-11;
            Worm2.y =-11;
            Worm2.alive = true;
        }
        
        if (space ==0 && ((Worm.safeSave || Worm.powerLevel > 0)||(Worm2.safeSave || Worm2.powerLevel > 0))){
            Thread thread = new Thread(){

                    public void run() {
                        
                        if (Worm.powerLevel >0||Worm2.powerLevel >0){
                            Worm.powerLevel -=1;
                            Worm2.powerLevel -=1;
                        }
                            
                        
                        if (Worm.safeSave||Worm2.safeSave){
                            Worm.safeSave = false;
                            Worm2.safeSave = false;
                        }
                            
                        
                        Worm.speed = .5f;
                        Worm2.speed = .5f;
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Worm.speed = 0.1f;
                        Worm2.speed = .1f;
                        
                    }
                };
            thread.start();
            
        }

        if((Worm.x < goal||Worm2.x < goal) && map.getRotM() >= map.getRotMax()){
            gl.glPushMatrix();
                gl.glRotatef(map.getRotM(), 0, 1, 0);
                Map.DrawCube(gl);
                gl.glRotatef(-map.getRotM(), 0, 1, 0);
                map.setScene(mapNum, gl);
            gl.glPopMatrix();
            gl.glPushMatrix();
                playerMovement1(gl, map.getWalls());
                Worm.DrawWorm(gl);
            gl.glPopMatrix();
            gl.glPushMatrix();
                playerMovement2(gl, map.getWalls());
                Worm2.DrawWorm(gl);
            gl.glPopMatrix();
        } else {
            gl.glPushMatrix();
                gl.glRotatef(map.getRotM(), 0, 1, 0);
                Map.DrawCube(gl);
            gl.glPopMatrix();
            Worm.resetPosition();
            Worm2.resetPosition();
            map.incrementRotM(1f);
            rot = 270;
        }
        if(map.getRotM() > map.getRotMax() ){
            float tempRotMax = map.getRotMax() + 90;
            mapNum +=1;
            System.out.println(mapNum);
            map = new Map(mapNum);
            map.incrementRotMax(tempRotMax);
            save();
        }
    }
    
    public boolean collision(ArrayList<Wall> walls, float newX,float newY){
        float yMax = newY + .7f;
        float yMin = newY - .7f;
        float xMax = newX + .7f;
        float xMin = newX - .7f;
        
        Vertex v1 = new Vertex(xMin,yMax); //top left
        Vertex v2 = new Vertex(xMax,yMax); //top right
        Vertex v3 = new Vertex(xMax,yMin); //bottom right
        Vertex v4 = new Vertex(xMin,yMin); //bottom left
        
        Wall top = new Wall(v1,v2); // top
        Wall right = new Wall(v2,v3); // right
        Wall bottom = new Wall(v3,v4); // bottom
        Wall left = new Wall(v4,v1); // left
        
        boolean collisionTop;
        boolean collisionBottom;
        boolean collisionLeft;
        boolean collisionRight;
        boolean collision = false;

        for(Wall w: walls){
            collisionTop = w.getV1().getY() <= top.getV1().getY() || w.getV2().getY() <= top.getV2().getY();
            collisionBottom = w.getV1().getY() >= bottom.getV1().getY() || w.getV2().getY() >= bottom.getV2().getY();
            collisionLeft = w.getV1().getX() >= left.getV1().getX() || w.getV2().getX() >= left.getV2().getX();
            collisionRight = w.getV1().getX() <= right.getV1().getX() || w.getV2().getX() <= right.getV2().getX();
            collision = collisionTop && collisionBottom && collisionLeft && collisionRight;
            if(collision){
                break;
            }
        }
       // System.err.println("----- Collision: " + collision);
        return collision;
    }
    
    public void playerMovement1(GL gl, ArrayList<Wall> walls){
        switch(moveLeft){
            case 0:if(!collision(walls,Worm.x-Worm.speed,Worm.y)){
                Worm.moveX(-Worm.speed);
                rot = 90;
            }break; // left
        }
        switch(moveRight){
            case 0:if(!collision(walls,Worm.x+Worm.speed,Worm.y)){
                Worm.moveX(Worm.speed);
                rot = 270;
            }break; // right
        }
        switch(moveUp){
            case 0:if(!collision(walls,Worm.x,Worm.y+Worm.speed)){
                Worm.moveY(Worm.speed);
                rot = 0;
            }break; // up
        }
        switch(moveDown){
            case 0:if(!collision(walls,Worm.x,Worm.y-Worm.speed)){
                Worm.moveY(-Worm.speed);
                rot = 180;
            }break; // down
        }
        gl.glTranslatef(Worm.x, Worm.y, 0);
        gl.glRotatef(rot, 0, 0, 1);
    }
    public void playerMovement2(GL gl, ArrayList<Wall> walls){
        switch(moveLeft2){
            case 0:if(!collision(walls,Worm2.x-Worm2.speed,Worm2.y)){
                Worm2.moveX(-Worm2.speed);
                rot2 = 90;
            }break; // left
        }
        switch(moveRight2){
            case 0:if(!collision(walls,Worm2.x+Worm2.speed,Worm2.y)){
                Worm2.moveX(Worm2.speed);
                rot2 = 270;
            }break; // right
        }
        switch(moveUp2){
            case 0:if(!collision(walls,Worm2.x,Worm2.y+Worm2.speed)){
                Worm2.moveY(Worm2.speed);
                rot2 = 0;
            }break; // up
        }
        switch(moveDown2){
            case 0:if(!collision(walls,Worm2.x,Worm2.y-Worm2.speed)){
                Worm2.moveY(-Worm2.speed);
                rot2 = 180;
            }break; // down
        }
        gl.glTranslatef(Worm2.x, Worm2.y, 0);
        gl.glRotatef(rot2, 0, 0, 1);
    }
    
    public void save() {
        System.out.println("Serialization started");
        try{
            FileOutputStream fos=new FileOutputStream("abc.ser");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            FileOutputStream fos2=new FileOutputStream("abc2.ser");
            ObjectOutputStream oos2=new ObjectOutputStream(fos2);
            oos.writeObject(map);
            oos2.writeObject(new Integer(mapNum));
        }catch(IOException e){
            System.err.println("IOException!!!");
        }
        System.out.println("Serialization ended");
    }
    
    
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent ke) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 38:moveUp = 0;break;
            case 37:moveLeft = 0;break;
            case 40:moveDown = 0;break;
            case 39:moveRight = 0;break;
            case KeyEvent.VK_W:moveUp2 = 0;break;
            case KeyEvent.VK_A:moveLeft2 = 0;break;
            case KeyEvent.VK_S:moveDown2 = 0;break;
            case KeyEvent.VK_D:moveRight2 = 0;break;
            case 32:space =0;break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case 38:moveUp = -1;break;
            case 37:moveLeft = -1;break;
            case 40:moveDown = -1;break;
            case 39:moveRight = -1;break;
            case KeyEvent.VK_W:moveUp2 = -1;break;
            case KeyEvent.VK_A:moveLeft2 = -1;break;
            case KeyEvent.VK_S:moveDown2 = -1;break;
            case KeyEvent.VK_D:moveRight2 = -1;break;
            case 32:space = -1;break;
        }
    }
}

