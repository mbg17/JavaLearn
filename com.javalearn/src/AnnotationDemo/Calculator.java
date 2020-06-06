package AnnotationDemo;

public class Calculator {
    @Check
    public void add(){
        System.out.println((1+1)+"==="+2);
    }
    @Check
    public void sub(){
        System.out.println((1+1)+"==="+2);
    }
    @Check
    public void div(){
        System.out.println((1/0)+"==="+0);
    }
    @Check
    public void ride(){
        System.out.println((1+1)+"==="+2);
    }

    public void show(){
        System.out.println("show");
    }
}
