package org.example.hashAccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EqualsContractTest {

    @DisplayName("EqualsContractTest(1): 대칭성의 위반")
    @Test
    protected void test1(){
        // given
        Money cash = new Money(10000, "원");
        WrongVoucher voucher = new WrongVoucher(10000, "원", "한국은행");

        // when
        boolean isCashCompareWithVouncher = cash.equals(voucher);
        boolean isVouncherCompareWithCash = voucher.equals(cash);

        // then
        Assertions.assertFalse(isCashCompareWithVouncher);
        Assertions.assertTrue(isVouncherCompareWithCash);
    }

    class Money {
        int amount;
        String currencyCode;

        Money(int amount, String currencyCode) {
            this.amount = amount;
            this.currencyCode = currencyCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false; // 엄격한 클래스 관리로 인해 대칭성 위반

            Money money = (Money) o;

            if (amount != money.amount) return false;
            return currencyCode != null ? currencyCode.equals(money.currencyCode) : money.currencyCode == null;
        }

        @Override
        public int hashCode() {
            int result = amount;
            result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
            return result;
        }
    }

    class WrongVoucher extends Money {
        String store;

        WrongVoucher(int amount, String currencyCode, String store) {
            super(amount, currencyCode);
            this.store = store;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof WrongVoucher)) return false;
//            if (!super.equals(o)) return false;
//
//            WrongVoucher that = (WrongVoucher) o;
//
//            return store != null ? store.equals(that.store) : that.store == null;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Money)) return false; // getClass() 대신 instanceof 사용

            Money money = (Money) o;

            if (amount != money.amount) return false;
            return currencyCode != null ? currencyCode.equals(money.currencyCode) : money.currencyCode == null;
        }


        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (store != null ? store.hashCode() : 0);
            return result;
        }
    }
}
