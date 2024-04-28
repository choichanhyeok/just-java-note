package org.example.algorithm.dfs.problem1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class basicDFSwithConnectionClusterCount {
    private boolean[][] graph;
    private boolean[] visited;
    private int N, M;
    private int answer;


    @Test
    public void testRunner() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        // TODO 1. 무방향 그래프임을 인지한 상태에서 노드간의 연결 정보를 표현하기 위한 graph 2차원 배열 채우기
        for (int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }
        br.close();

        // TODO 2. dfs를 이용해 visited 체크, 단 1부터 N 까지의 노드를 시작점으로 채우되 현재 visitied에 있는 노드의 경우는 제외한다. 그리고 각 노드를 dfs를 돌리는 시점에 answer을 ++해주어 군집의 갯수를 세준다.
        for (int i = 1; i <= N; i ++){
            if (!visited[i]) {
                dfs(i);
                answer ++;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }

    private void dfs(int idx){
        visited[idx] = true;

        for (int i = 1; i <= N; i ++){
            if (!visited[i] && graph[idx][i] == true){
                dfs(i);
            }
        }
    }



}
