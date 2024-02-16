package org.example.solid.singleResponsibilityPrinciple;

public class basicBadSrpCase {

    /**
     * 아래 코드가
     */
    class Employee {
        String name;
        String positon;

        Employee(String name, String position) {
            this.name = name;
            this.positon = position;
        }

        // * 초과 근무 시간을 계산하는 메서드 (두 팀에서 공유하여 사용)
        void calculateExtraHour() {                      /* problem occur !!!: if i have to change calculateExtrHour */
            // ...
        }

        // * 급여를 계산하는 메서드 (회계팀에서 사용)
        void calculatePay() {
            // ...
            this.calculateExtraHour();
            // ...
        }

        // * 근무시간을 계산하는 메서드 (인사팀에서 사용)
        void reportHours() {
            // ...
            this.calculateExtraHour();
            // ...
        }

        // * 변경된 정보를 DB에 저장하는 메서드 (기술팀에서 사용)
        void saveDababase() {
            // ...
        }
    }


    // 각 메서드를 사용하는 주체는 여러곳인데, 하나의 클래스에서 다 같이 사용되다 보니까 어떤 문제가 발생해 `calculateExtraHour`를 수정하게 됐을 때
    // 특정 팀의 요구로 저 메서드가 수정됐을 경우 다른 곳에서도 우후죽순 문제가 발생할 것이다.

    // 그러니까 하나의 클래스에 다양한 책임이 들어왔을 때 그 내부적으로 공유해서 사용하는 메서드가 생길 수 있는데 이 경우 문제가 발생할 수 있다.
    // 예컨대 해당 클래스에서 제공하는 calculateExtraHour()의 책임 자체가 여러곳에 있어서 문제가 생기는고, 사실 저 클래스 안에 여러 메서드가 각각의
    // 다른 도메인의 책임을 갖는 것 뿐 아니라 클래스 외부에서 특정 메서드를 여기 저기 도메인에서 쓰는 경우에 그렇다.

    // 클래스를 최대한 범용적으로 쓰지말고 국소적으로 사용하라.
    // 책임이 여러개라는 것 -> 해당 클래스를 호출하는 다른 목적의 클래스가 많다는 것

    // 특히 api에 대해서, 이런 문제가 많이 쓰인다.


    // 결론: 하나의 클래스에서 여러 엑터에 대한 지원을 할 경우! 문제가 발생
    // -> 파사드를 이용해 해결 가능 ?????
}
