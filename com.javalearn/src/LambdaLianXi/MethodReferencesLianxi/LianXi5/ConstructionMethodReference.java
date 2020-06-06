package LambdaLianXi.MethodReferencesLianxi.LianXi5;
/*
* 通过对象名::new来引用
* */
public class ConstructionMethodReference {
    public static void main(String[] args) {
        printPerson("陆远",Person::new);
    }

    public static void printPerson(String name ,PersonBulider pd){
        Person person = pd.createPerson(name);
        System.out.println(person);
    }
}
