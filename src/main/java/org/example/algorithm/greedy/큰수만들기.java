package org.example.algorithm.greedy;


// https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
class 큰수만들기 {
    public String solution(String number, int k) {
        char[] numberArray = number.toCharArray();
        StringBuilder answerBuilder = new StringBuilder();

        // TODO 1. 숫자의 총 길이 N을 구한다.
        int n = number.length();

        // TODO 2. 탐색해야 하는 인덱스의 최대 값을 지정한다. : 현재 위치에서 +k 까지만 탐색해야 할 범위이기에 최데 n-k 까지 기준 인덱스로 사용한다.
        int targetSize = n - k;


        // TODO 3.
        int startIdx = 0;
        for (int i = 0; i < targetSize; i ++){
            char maxValue = '0';
            for (int j = startIdx; j <= i + k; j ++){
                if (maxValue < numberArray[j]){
                    maxValue = numberArray[j];
                    startIdx = j + 1;
                }
            }
            answerBuilder.append(Character.toString(maxValue));
        }

        return answerBuilder.toString();
    }
}
