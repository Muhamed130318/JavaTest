public class Class_test {
    int age;

    public Class_test(int age){
        this.age = age;
    }

    public void bark(){
        System.out.println("WOOF");
    }

    public int humanYears(){
        return age * 7;
    }
}
