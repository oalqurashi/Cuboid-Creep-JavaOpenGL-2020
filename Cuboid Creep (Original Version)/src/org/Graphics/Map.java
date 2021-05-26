
package org.Graphics;

import java.io.Serializable;
import java.util.ArrayList;
import javax.media.opengl.GL;


public class Map implements Serializable{
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private static Box[][] boxes = new Box[12][13];
    private ArrayList<Path> paths = new ArrayList<Path>();
    private ArrayList<Spider> spiders = new ArrayList<Spider>();
    private ArrayList<Star> stars = new ArrayList<Star>();
    private KingSpider kingSpider;
    private float safeX;
    private float safeY;
    private float rotM = 0f,rotMax = 0;
    private int mapNum;
    
    public Map(int mapNum) {
        this.mapNum = mapNum;
        int k = 0;
        int z = 0;
        for (float i = -12; k < boxes.length; i+=2, k++) {
            for (float j = -12; z < boxes[0].length ; j+=2.15f, z++) {
                Vertex v1 = new Vertex(i, j);
                Vertex v2 = new Vertex(i, j + 2.15f);
                Vertex v3 = new Vertex(i + 2, j);
                Vertex v4 = new Vertex(i + 2, j + 2.15f);
                boxes[k][z] = new Box(v1, v2, v3 ,v4);
            }
            z=0;
        }
        walls.add(new Wall(new Vertex(-13,14.5), new Vertex(13,14.5)));
        walls.add(new Wall(new Vertex(13,14.5), new Vertex(13,-13)));
        walls.add(new Wall(new Vertex(13,-13), new Vertex(-13,-13)));
        walls.add(new Wall(new Vertex(-13,-13), new Vertex(-13,14.5)));
        
        switch(mapNum){
            
            
            
            case 1:
                
                paths.add(new Path("drawHPathNT", walls, boxes[0][0], boxes[11][0]));
                paths.add(new Path("drawVPathLL", walls, boxes[11][0], boxes[11][2]));
                paths.add(new Path("drawHPathTD", walls, boxes[1][2], boxes[11][2]));
                paths.add(new Path("drawVPathRRR" , walls, boxes[1][2], boxes[1][11], boxes[1][8]));
                
                paths.add(new Path(walls, boxes[3][7], boxes[3][8], boxes[3][9], boxes[5][9], boxes[5][8], boxes[5][7]));//safe room
                Worm.safeRoom = paths.get(paths.size()-1);

                
                paths.add(new Path("drawHPath", walls, boxes[2][8], boxes[2][8]));
                paths.add(new Path("drawHPath", walls, boxes[6][8], boxes[6][8]));
                paths.add(new Path("drawHPathDD", walls, boxes[1][11], boxes[7][11]));
                paths.add(new Path("drawVPathLLL" , walls, boxes[7][5], boxes[7][11], boxes[7][8]));
                paths.add(new Path("drawHPathDU", walls, boxes[3][5], boxes[7][5]));
                paths.add(new Path("drawVPathRR", walls, boxes[3][3], boxes[3][5]));
                paths.add(new Path("drawHPathUU", walls, boxes[4][3], boxes[11][3]));
                paths.add(new Path("drawVPathLR", walls, boxes[11][3], boxes[11][11]));
                paths.add(new Path("drawHPathND", walls, boxes[11][11], boxes[11][11]));
                
                
                spiders.add(new Spider(3,13));
                
                stars.add(new Star(-3,-11));
                stars.add(new Star(3,-11));
                stars.add(new Star(9,-11));
                
                

                
                break;
                
                
                
                
                
            case 2:
                
                paths.add(new Path("drawHPathNTT", walls, boxes[0][0], boxes[11][0], boxes[9][0]));
                paths.add(new Path("drawVPathLN", walls, boxes[11][0], boxes[11][4]));
                paths.add(new Path("drawVPathDRL", walls, boxes[9][0], boxes[9][9], boxes[9][6]));
                paths.add(new Path("drawHPathNT", walls, boxes[10][6], boxes[11][6]));
                paths.add(new Path("drawVPathLN", walls, boxes[11][6], boxes[11][9]));
                paths.add(new Path("drawHPathDD", walls, boxes[7][9], boxes[9][9]));
                paths.add(new Path("drawVPathLLR", walls, boxes[7][3], boxes[7][9], boxes[7][7]));
                paths.add(new Path("drawHPath", walls, boxes[6][7], boxes[6][7]));
                paths.add(new Path("drawHPath", walls, boxes[2][7], boxes[2][7]));
                paths.add(new Path("drawVPathLT", walls, boxes[6][1], boxes[6][2]));
                paths.add(new Path("drawHPathTDT", walls, boxes[1][3], boxes[7][3], boxes[6][3]));
                paths.add(new Path("drawHPathCT", walls, boxes[1][1], boxes[6][1]));
                paths.add(new Path("drawVPathRRRR", walls, boxes[1][3], boxes[1][11], boxes[1][7], boxes[1][10]));
                paths.add(new Path("drawHPathDN", walls, boxes[1][11], boxes[11][11]));
                paths.add(new Path("drawHPathRC", walls, boxes[1][10], boxes[6][10]));
                
                paths.add(new Path(walls, boxes[3][6], boxes[3][7], boxes[3][8], boxes[5][8], boxes[5][7], boxes[5][6]));
                Worm.safeRoom = paths.get(paths.size()-1);
                
                
                
                
                stars.add(new Star(11,-11));
                stars.add(new Star(11,2));
                stars.add(new Star(1,-9));
                
                

                spiders.add(new Spider(11,8));
                spiders.add(new Spider(11,-3));
                spiders.add(new Spider(-9,-9));
                spiders.add(new Spider(-1,11));

                break;
                
                
                
            case 3:
                
                
                paths.add(new Path(walls, boxes[4][0], boxes[4][1], boxes[4][2], boxes[7][2], boxes[7][1], boxes[7][0]));
                Worm.safeRoom = paths.get(paths.size()-1);
                
                paths.add(new Path("drawHPathNT", walls, boxes[0][0], boxes[1][0]));
                paths.add(new Path("drawVPathLR", walls, boxes[1][0], boxes[1][1]));
                paths.add(new Path("drawHPathDN", walls, boxes[1][1], boxes[3][1]));
                paths.add(new Path("drawHPathNT", walls, boxes[8][1], boxes[11][1]));
                paths.add(new Path("drawVPathLL", walls, boxes[11][1], boxes[11][5]));
                paths.add(new Path("drawHPathTTD", walls, boxes[1][5], boxes[11][5], boxes[9][5]));
                paths.add(new Path("drawVPathTL", walls, boxes[9][5], boxes[9][8]));
                paths.add(new Path("drawVPathRRR", walls, boxes[1][5], boxes[1][11], boxes[1][8]));
                paths.add(new Path("drawHPathNDD", walls, boxes[1][8], boxes[9][8], boxes[5][8]));
                paths.add(new Path("drawVPathCN", walls, boxes[5][7], boxes[5][7]));
               // paths.add(new Path("drawVPath", walls, boxes[4][9], boxes[4][11]));
                paths.add(new Path("drawHPathDN", walls, boxes[1][11], boxes[11][11]));
                
                stars.add(new Star(-3,12));
                stars.add(new Star(7,2));
                stars.add(new Star(-1,4));
                
                kingSpider = new KingSpider(-9, 0);
                
                
                ; break;
            
            case 4:
                ;
        }
    }

    public void setMapNum(int mapNum) {
        this.mapNum = mapNum;
    }

    public int getMapNum() {
        return mapNum;
    }

    

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public void setWalls(ArrayList<Wall> walls) {
        this.walls = walls;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }
    
    public void setScene(int mapNum, GL gl){
        switch(mapNum){
            case 1:drawScene1(gl); break;
            case 2:drawScene2(gl); break;
            case 3:drawScene3(gl); break;
            case 4:;
        }
    }
    public void drawScene1(GL gl){
        gl.glColor3f(0f, 0f, 0f);
        for(Wall w: walls){
            w.drawWall(gl);
        }

        for(Star s: stars){
            if (!s.isTaken){
                gl.glPushMatrix();
                    s.DrawStar(gl);
                gl.glPopMatrix();
            }
        }
        
        for(Spider s: spiders){
            gl.glPushMatrix();
                s.AIMovement(gl, walls, paths);
                s.DrawSpider(gl);
            gl.glPopMatrix();
        }
    }
    
    public void drawScene2(GL gl){
        gl.glColor3f(0f, 0f, 0f);
        for(Wall w: walls){
            w.drawWall(gl);
        }
        
        for(Star s: stars){
            if (!s.isTaken){
                gl.glPushMatrix();
                    s.DrawStar(gl);
                gl.glPopMatrix();
            }
        }
        
        for(Spider s: spiders){
            gl.glPushMatrix();
                s.AIMovement(gl, walls, paths);
                s.DrawSpider(gl);
            gl.glPopMatrix();
        }
    }
    public void drawScene3(GL gl){
        gl.glColor3f(0f, 0f, 0f);
        for(Wall w: walls){
            w.drawWall(gl);
        }
        
        for(Star s: stars){
            if (!s.isTaken){
                gl.glPushMatrix();
                    s.DrawStar(gl);
                gl.glPopMatrix();
            }
        }       
        gl.glPushMatrix();
        kingSpider.AIMovement(gl, walls, paths);
        kingSpider.drawKingSpider(gl);
        gl.glPopMatrix();
        
    }
    
    public void drawScene4(GL gl){
        gl.glColor3f(0f, 0f, 0f);
        for(Wall w: walls){
            w.drawWall(gl);
        }
        
        for(Star s: stars){
            if (!s.isTaken){
                gl.glPushMatrix();
                    s.DrawStar(gl);
                gl.glPopMatrix();
            }
        }    
        for(Spider s: spiders){
            gl.glPushMatrix();
                s.AIMovement(gl, walls, paths);
                s.DrawSpider(gl);
            gl.glPopMatrix();
        }
    }
    
    public static void DrawCube(GL gl) {
        gl.glBegin(GL.GL_QUADS); // of the color cube
        float num = 15.f;
        float numz = 15.0f;
        // Top-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, .80f, 0.0f); // green
        gl.glVertex3f(num, num, -numz);
        gl.glVertex3f(-num, num, -numz);
        gl.glVertex3f(-num, num, numz);
        gl.glVertex3f(num, num, numz);
        gl.glEnd();
        // Bottom-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(.80f, 0.2f, 0.0f); // orange
        gl.glVertex3f(num, -num, numz);
        gl.glVertex3f(-num, -num, numz);
        gl.glVertex3f(-num, -num, -numz);
        gl.glVertex3f(num, -num, -numz);
        gl.glEnd();

        // Back-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(.80f, .80f, 0.0f); // yellow
        gl.glVertex3f(num, -num, -numz);
        gl.glVertex3f(-num, -num, -numz);
        gl.glVertex3f(-num, num, -numz);
        gl.glVertex3f(num, num, -numz);
        gl.glEnd();
        // Left-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(.8f, 0.0f, 0.0f); // red
        gl.glVertex3f(-num, num, numz);
        gl.glVertex3f(-num, num, -numz);
        gl.glVertex3f(-num, -num, -numz);
        gl.glVertex3f(-num, -num, numz);
        gl.glEnd();
        // Right-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(.80f, 0.0f, 8.0f); // magenta
        gl.glVertex3f(num, num, -numz);
        gl.glVertex3f(num, num, numz);
        gl.glVertex3f(num, -num, numz);
        gl.glVertex3f(num, -num, -numz);

        gl.glEnd(); // of the color cube
// Front-face
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, 0.0f, .8f); // blue
        gl.glVertex3f(num, num, numz);
        gl.glVertex3f(-num, num, numz);
        gl.glVertex3f(-num, -num, numz);
        gl.glVertex3f(num, -num, numz);
        gl.glEnd();
    }
    
    public float getRotM() {
        return rotM;
    }
    
    public float getRotMax() {
        return rotMax;
    }

    public void incrementRotM(float rotM) {
        this.rotM += rotM;
    }

    public void incrementRotMax(float rotMax) {
        this.rotMax += rotMax;
    }

    public static Box[][] getBoxes() {
        return boxes;
    }

    public static void setBoxes(Box[][] boxes) {
        Map.boxes = boxes;
    }

    public ArrayList<Spider> getSpiders() {
        return spiders;
    }

    public void setSpiders(ArrayList<Spider> spiders) {
        this.spiders = spiders;
    }

    public KingSpider getKingSpider() {
        return kingSpider;
    }

    public void setKingSpider(KingSpider kingSpider) {
        this.kingSpider = kingSpider;
    }

    public float getSafeX() {
        return safeX;
    }

    public void setSafeX(float safeX) {
        this.safeX = safeX;
    }

    public float getSafeY() {
        return safeY;
    }

    public void setSafeY(float safeY) {
        this.safeY = safeY;
    }
    
    
}
