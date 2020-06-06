package ExceptionLianxi;

import java.util.Objects;

/*
* throw只能在方法内部使用
* throw的对象只能是Exception的子类或者本省
* Exception异常必须处理，RuntimeException可以不处理
* 处理方法可以是try{}catch(异常类名 对象名){}
* Objects判断非空
*     Objects.requireNonNull()
* throws 将方法内部抛出的异常交给调用者处理
* 在定义方法的时候调用
* 格式： public static void method() throws xxxException{
*
* }
* 注意：
* 异常必须是Exception或Exception的子类
* 可以抛出多个异常，有子父关系则只需要抛出父类异常
* 子父类异常的继承关系：
*   父类什么异常子类就是什么异常
*   子类可以不抛出异常父类异常
*   父类没有定义异常子类也不能抛出异常，只能try ... catch...
*/
public class BiJi {
    public static void main(String[] args) {
    }
}
class Fu{
    public void method1() throws Exception{

    }

    public void method2(){

    }

    public void method3() throws Exception{

    }
}
class Zi extends Fu{
    // 父类方法抛出什么异常子类也抛出什么异常
    @Override
    public void method1() throws Exception {
        super.method1();
    }
    // 父类方法没有抛出异常子类也不能抛出异常
//    @Override
//    public void method2() throws Exception {
//        super.method2();
//    }
    // 可以不抛出异常
    @Override
    public void method3(){

    }
}