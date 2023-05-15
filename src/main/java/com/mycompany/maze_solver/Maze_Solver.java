/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author yash_yj_07
 */
public class Maze_Solver extends JFrame{
    private int [][] maze= MazePoster.randomMaze();
//        {
//            {1,1,1,1,1,1,1,1,1,1,1,1,1},
//            {1,0,1,0,1,0,1,0,0,0,0,0,1},
//            {1,0,1,0,0,0,1,0,1,1,1,0,1},
//            {1,0,1,1,1,1,1,0,0,0,0,0,1},
//            {1,0,0,1,0,0,0,0,1,1,1,0,1},
//            {1,0,1,0,1,1,1,0,1,0,0,0,1},
//            {1,0,1,0,1,0,0,0,1,1,1,0,1},
//            {1,0,1,0,1,1,1,0,1,0,1,0,1},
//            {1,0,0,0,0,0,0,0,0,0,1,9,1},
//            {1,1,1,1,1,1,1,1,1,1,1,1,1}
//    };
    
    public List<Integer> path = new ArrayList<Integer>();
    
    public Maze_Solver(){
        setTitle("Maze Solver");
        
        int width = (maze[0].length+2)*50;
        int height = (maze.length+2)*50;
        setSize(width, height);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setUndecorated(true);//enable the frame decoration
        this.setBackground(new Color(0.17f,0.25f,0.11f,0.80f));
        this.getRootPane ().setBorder (BorderFactory.createMatteBorder (4, 4, 4, 4, Color.RED));
        
        this.setResizable(false);
        this.revalidate();
        
        
        //call the logic
        DFS.searchPath(maze, 1, 1, path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(50,50);

        for(int i=0; i<maze.length; i++){  
            for(int j=0; j<maze[0].length; j++){
                Color color;
                
                switch(maze[i][j]){
                    case 1: color=Color.BLACK; break;
                    case 9: color=Color.GREEN; break;
                    default: color=Color.WHITE;break;
                }
                
                g.setColor(color);
                g.fillRect(50*j, 50*i, 50, 50);
                
                g.setColor(Color.RED);
                g.drawRect(50*j, 50*i, 50, 50);
            }
        }
        
        for(int i=0; i<path.size(); i+=2){
            int pathX = path.get(i);
            int pathY = path.get(i+1);
            
            g.setColor(Color.BLUE);
            g.fillOval(50*pathX+15, 50*pathY+15, 20, 20);
        }
    }
    
    public static void main(String[] args) {
        Maze_Solver grid = new Maze_Solver();
        grid.setVisible(true);
    }
}
