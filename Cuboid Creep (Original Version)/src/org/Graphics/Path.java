/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Graphics;

import java.io.Serializable;
import java.util.ArrayList;

public class Path implements Serializable{
    
    private Box corner1;
    private Box corner2;
    private Box safeRoom;
    private String tag;
    public Path(String tag, ArrayList<Wall> walls, Box box1, Box box2){
        this.tag = tag;
        if (tag.equals("drawHPath")){
            this.corner1 = box1;
            this.corner2 = box2;
            Wall w1 = new Wall(box1.getV1(), box2.getV3());
            Wall w2 = new Wall(box1.getV2(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
        }
        else if (tag.equals("drawHPathD")){
            this.corner1 = box1;
            this.corner2 = box2;
            Wall w1 = new Wall(box1.getV2(), box2.getV4());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
        }
        else if (tag.equals("drawHPathNT")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV3());
            Wall w2 = new Wall(box1.getV2(), box2.getV2());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawHPathCT")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV3());
            Wall w2 = new Wall(box1.getV2(), box2.getV2());
            Wall w3 = new Wall(box1.getV1(), box1.getV2());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
            
        }
        else if (tag.equals("drawHPathTD")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV1());
            Wall w2 = new Wall(box1.getV4(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawHPathDD")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV4());
            Wall w2 = new Wall(box1.getV3(), box2.getV1());
            walls.add(w1);
            walls.add(w2);
        }
        else if (tag.equals("drawHPathND")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV4());
            walls.add(w1);
        }
        else if (tag.equals("drawHPathDU")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawHPathDN")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV4());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawHPathRC")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV4(), box2.getV4());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            Wall w3 = new Wall(box2.getV3(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        else if (tag.equals("drawHPathUU")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
        
        }
        else if (tag.equals("drawHPathTT")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV3());
            Wall w2 = new Wall(box1.getV4(), box2.getV2());
            walls.add(w1);
            walls.add(w2);
        
        }
        else if (tag.equals("drawVPath")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV1());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathCN")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            Wall w3 = new Wall(box1.getV1(), box1.getV3());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
            
        }
        
        else if (tag.equals("drawVPathL")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
        }
        else if (tag.equals("drawVPathTL")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV1());
            Wall w2 = new Wall(box1.getV4(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
        }

        else if (tag.equals("drawVPathNR")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathNL")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV1());
            Wall w2 = new Wall(box1.getV4(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathRR")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV2());
            Wall w2 = new Wall(box1.getV4(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathLL")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV1());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathLR")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            
        }
        else if (tag.equals("drawVPathLN")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            Wall w3 = new Wall(box2.getV2(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
            
        }
        else if (tag.equals("drawVPathLT")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV2());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            
        }
    }
    
    
    
    public Path(String tag, ArrayList<Wall> walls, Box box1, Box box2, Box box3){
        if (tag =="drawVPathRRR"){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV2());
            Wall w2 = new Wall(box1.getV4(), box3.getV3());
            Wall w3 = new Wall(box3.getV4(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        
        else if (tag =="drawVPathLLL"){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box3.getV1());
            Wall w2 = new Wall(box1.getV3(), box2.getV4());
            Wall w3 = new Wall(box3.getV2(), box2.getV1());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        else if (tag =="drawVPathLLR"){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box3.getV1());
            Wall w2 = new Wall(box1.getV3(), box2.getV3());
            Wall w3 = new Wall(box3.getV2(), box2.getV2());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        else if (tag =="drawHPathNTT"){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV3());
            Wall w2 = new Wall(box1.getV2(), box3.getV2());
            Wall w3 = new Wall(box3.getV4(), box2.getV2());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        else if (tag.equals("drawVPathDRL")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV2(), box2.getV1());
            Wall w2 = new Wall(box1.getV4(), box3.getV3());
            Wall w3 = new Wall(box2.getV2(), box2.getV4());
            Wall w4 = new Wall(box3.getV4(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
            walls.add(w4);
            
        }
        else if (tag.equals("drawHPathTDT")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box3.getV1());
            Wall w2 = new Wall(box3.getV3(), box2.getV3());
            Wall w3 = new Wall(box1.getV4(), box2.getV2());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        
        }else if (tag.equals("drawHPathTTD")){
            
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV1());
            Wall w2 = new Wall(box1.getV4(), box3.getV2());
            Wall w3 = new Wall(box3.getV4(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        
        }
         else if (tag.equals("drawHPathNDD")){
            
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV3(), box3.getV1());
            Wall w2 = new Wall(box1.getV4(), box2.getV4());
            Wall w3 = new Wall(box3.getV3(), box2.getV1());
           // Wall w4 = new Wall(box1.getV3(), box1.getV2());
            
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
          //  walls.add(w4);
        
        }
        
        
    }
    
    public Path(String tag, ArrayList<Wall> walls, Box box1, Box box2, Box box3, Box box4){
        if (tag.endsWith("drawVPathRRRR")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV1(), box2.getV2());
            Wall w2 = new Wall(box1.getV4(), box3.getV3());
            Wall w3 = new Wall(box3.getV4(), box4.getV3());
          //  Wall w4 = new Wall(box4.getV4(), box2.getV3());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
        else if (tag.endsWith("drawHPathDTDD")){
            this.corner1 = box1;
            this.corner2 = box2;
            
            Wall w1 = new Wall(box1.getV3(), box4.getV1());
            Wall w2 = new Wall(box4.getV3(), box2.getV1());
            Wall w3 = new Wall(box1.getV2(), box3.getV2());
            Wall w4 = new Wall(box3.getV4(), box2.getV4());
            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
            walls.add(w4);
        }
    }
    
    
    
    public Path(ArrayList<Wall> walls, Box box1, Box box2, Box box3, Box box4,Box box5, Box box6){
        
        Vertex v1 = new Vertex(99, 99);
        Vertex v2 = new Vertex(99, 99);
        Vertex v3 = new Vertex(99 , 99);
        Vertex v4 = new Vertex(99, 99);
        this.corner1 = new Box(v1, v2, v3 ,v4);
        this.corner2 = new Box(v1, v2, v3 ,v4);
        
        this.safeRoom = new Box(box1.getV1(), box3.getV2(), box6.getV3(), box4.getV4());
        
        Wall w1 = new Wall(box1.getV1(), box2.getV1());
        Wall w2 = new Wall(box2.getV2(), box3.getV2());
        Wall w3 = new Wall(box3.getV2(), box4.getV4());
        Wall w4 = new Wall(box4.getV4(), box5.getV4());
        Wall w5 = new Wall(box5.getV3(), box6.getV3());
        Wall w6 = new Wall(box6.getV3(), box1.getV1());
        
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
        
    }

    public Box getCorner1() {
        return corner1;
    }


    public Box getCorner2() {
        return corner2;
    }

    public Box getSafeRoom() {
        return safeRoom;
    }

    public String getTag() {
        return tag;
    }
}
