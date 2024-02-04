package org.example.hashAccess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ImplHashTest {

    @DisplayName("HashAbout: 그냥 해시 테이블 생성시 배열 실제로 적용되는 걸 옵션값으로 확인")
    @Test
    protected void test1() {
        HashMap<Integer, Integer> hashMap = new HashMap<>(16, 0.7f);
        /*
         * initialCapacity: 초키 버킷의 수
         * loadFactor: 부하계수 정보, 버킷 개수와 실제 적재되고 있는 데이터의 계수를 지정가능
         *   - 부하 계수는 높을수록 충돌이 많이 일어나고 있다고 판단할 수 있음
         */
    }

    @DisplayName("implHashTest:")
    @Test
    protected void test2() {

    }

    class HashNode {
        private int key;
        private int value;
        private HashNode next;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public class HashTable {
        private HashNode[] buckets; // buckets? -> 걍 배열 (근데 이제 HashNode를 담는)
        private int numBuckets;     // 버킷 크기?
        private int size;           // 얘는 무슨 크기여

        public HashTable() {
            this.numBuckets = 10;   // 초기 버킷 수
            this.buckets = new HashNode[numBuckets];   // 버킷이라는 건 HashNode가 담긴 배열, 그러니까 걍 배열 말하는거네
            this.size = 0;
        }

        private int getBucketIndex(int key) {
            return key % numBuckets;                   // key 값, 내가 봤을 땐 hashValue가 여기 들어와야 할 거 같은데 어쨌든 key 값을 버킷 크기(배열 크기)로 모듈러 연산해서 인덱스 크기로 맞춰줘
        }

        public void put(int key, int value) {
            int bucketIndex = getBucketIndex(key);     // 키 값을 모듈러 연산해서 인덱스로 변환,
            HashNode head = buckets[bucketIndex];      // 배열에 해당 인덱스에 버킷 객체 조회

            // key를 변환한 인덱스에 헤드 노드가 존재할 경우 (** 여기가 해시 체이닝 파트 **)
            while (head != null) {
                if (head.key == key) {                 // 만약 head의 key 값과 현재 키 값이 같은 경우 value를 넣어주고 put 연산 종료
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            // 헤드 노드가 존재하지 않을 땐, 새 노드 삽입
            size++;
            head = buckets[bucketIndex];
            HashNode newNode = new HashNode(key, value);
            newNode.next = head;   // 현재 노드의 next에 현재 노드 옮기고
            buckets[bucketIndex] = newNode; // 현재 노드 위치에 방금 생성한 신규 노드 집어넣음. 늦게 들어온 놈이 앞단에 들어가네?
        }

        public int get(int key) {
            int bucketIndex = getBucketIndex(key); // 마찬가지로 진행
            HashNode head = buckets[bucketIndex];

            // 키 검색
            while (head != null) {
                if (head.key == key) {
                    return head.value;
                }
                head = head.next;
            }

            return -1; // 키를 찾지 못한 경우
        }

        // 여기에 `remove` 메서드와 기타 필요한 메서드 추가 가능

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}

