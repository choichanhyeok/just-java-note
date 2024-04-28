package org.example.algorithm.dfs.problem1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

/*
 DFS exercise: https://www.acmicpc.net/problem/2606 문제 풀이
 타입1: 특정 노드와 연결된 노드의 개수 찾는 문제
 */
public class basicDFS {
    private boolean[][] graph;
    private boolean[] visited;
    private int N, M;
    private int answer;

    private void dfs(int idx){
        // TODO 6. visited 배열에 현재 노드의 방문 정보를 업데이트 해주고 answer을 하나 올려준다
        visited[idx] = true;
        answer ++;

        // TOOD 7. 방문한 적이 있거나 현재 노드와 연결 관계가 있는 노드의 경우 똑같이 dfs를 돌려준다.
        for (int i = 1; i <= N; i ++){
            if (visited[i] == false && graph[idx][i] == true){
                dfs(i);
            }
        }
    }

    @Test
    public void testRunner() throws IOException {
        // TODO 1. 입출력 버퍼 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO 2. N(노드의 개수), M(간선의 개수) 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        // TODO 3. 간선들을 입력 받아, 그래프 정보를 저장할 2차원 배열에 매핑
        for (int i = 0; i < M; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        br.close();

        // TODO 4. DFS를 통해 그래프를 탐색하며 연결된 노드의 개수 확인
        dfs(1);

        // TODO 5. 감염 노드 개수 출력
        bw.write(String.valueOf(answer + 1));
        bw.close();
    }
}
