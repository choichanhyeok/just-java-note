package org.example.generic.reduceCodeRedanduncy;

public class BadRedundancyCodeNotApplyGeneric {

    private void processEachBox() {
        StringBox stringBox = new StringBox();
        stringBox.setContent("Hi");

        IntegerBox integerBox = new IntegerBox();
        integerBox.setContent(100);

        System.out.println("content: " + stringBox.getContent() + " " + integerBox.getContent());
    }

    class StringBox {
        private String content;

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    class IntegerBox {
        private Integer content;

        public void setContent(Integer content) {
            this.content = content;
        }

        public Integer getContent() {
            return content;
        }
    }
}