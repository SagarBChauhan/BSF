package com.example.bfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices;
        System.out.println("Enter the number of vertices in the graph");
        try{
            vertices = Integer.parseInt(br.readLine());
        }catch(IOException e){
            System.out.println("An error occurred");
            return;
        }
        int[][] matrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix");
        int i,j;
        for(i=0; i<vertices; i++){
            for(j=0; j<vertices; j++){
                try{
                    matrix[i][j] = Integer.parseInt(br.readLine());
                }catch (IOException e){
                    System.out.println("An error occurred");
                }
            }
        }
        int source;
        System.out.println("Enter the root vertex");
        try{
            source = Integer.parseInt(br.readLine());
        }catch(IOException e){
            System.out.println("An error occurred");
            return;
        }
        bfs(matrix,source);
    }
    static void bfs(int[][] matrix, int source){
        boolean[] visited = new boolean[matrix.length];
        visited[source-1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        System.out.println("The breadth first order is");
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            int x = queue.poll();
            int i;
            for(i=0; i<matrix.length;i++){
                if(matrix[x-1][i] == 1 && visited[i] == false){
                    queue.add(i+1);
                    visited[i] = true;
                }
            }
        }
    }
}
