package org.example.springAop.resource;

public class AspectTestResource {
    private static boolean checked = false;

    public static void check(){
        checked = true;
    }
    public static boolean isChecked() { return checked; }
}
