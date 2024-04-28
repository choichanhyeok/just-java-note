package org.example.algorithm.dfs.problem1;

import org.hibernate.result.Output;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class basicDFSExercise1 {
    private int MAX = 100000 + 10;
    private int N, M, R;
    private ArrayList<Integer>[] graph;
    private boolean[] visited;
    private int[] answer;
    private int order;

    @Test
    public void test1() throws IOException{
        // TODO 1. Input 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for (int i = 1; i <= N; i ++){
            graph[i] = new ArrayList<>();
        }
        order = 1;
        answer = new int[MAX];
        visited = new boolean[MAX];

        // TODO 1. 간선 정보를 보고 그래프의 노드들 사이의 관계 정의
        for (int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // TODO 2. 각 노드의 연결 정보를 정렬
        for (ArrayList<Integer> target: graph){
            Collections.sort(target);
        }

        br.close();

        // TODO 3. dfs를 통해 R 노드부터 시작하는 연결 노드들 방문하며 그 순서를 answer에 기록
        dfs(R);

        // TODO 4. 출력
        for (int a: answer){
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private void dfs(int idx){
        visited[idx] = true;
        answer[idx] = order;
        order ++;

        for (Integer target: graph[idx]) {
            if (!visited[target]){
                dfs(target);
            }
        }
    }
}
