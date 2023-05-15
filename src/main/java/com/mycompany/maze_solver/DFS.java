/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.List;

/**
 *
 * @author yash_yj_07
 */
public class DFS {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        
        if(maze[y][x]==0){
            maze[y][x]=2;//using 2 as visited
            int[] dx = new int[] {-1, 0, 1, 0};
            int[] dy = new int[] {0, -1, 0, 1};
            
            for(int i=0; i<4; i++){
                if(searchPath(maze, x+dx[i], y+dy[i], path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        
        return false;//even if the element is 1(Blocker)
    }
}
