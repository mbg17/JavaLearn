package AnnotationDemo;

public class Demo01 {
    public static void main(String[] args) {

    }
}


@AnnotationTest(age=11,name="陆远",p=EnumTest.P1,t=@test2,array = {1,2,3,4,5})
class TestAnnotation{

}