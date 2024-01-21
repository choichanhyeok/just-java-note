package org.example.generic.reduceCodeRedanduncy;

public class CoolRedundancyCodeApplyGeneric {

    private void processEachBox(){
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();

        stringBox.setContent("Hyeok");
        integerBox.setContent(29);

        System.out.println("content: " + stringBox.getContent() + " " + integerBox.getContent());
    }

    class Box<T> {
        private T content;

        private T getContent(){
            return content;
        }

        private void setContent(T content) {
            this.content = content;
        }
    }
}
