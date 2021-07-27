package com.troymorrow.Day1;

//simple Inheritance
//class A{
//
//}
//class B extends A{
//
//}
//multi level inheritance
class A{
   public void test1(){
       System.out.println("A");
   }
}
class B extends A{
    public void test2(){
        System.out.println("B");
    }
}
class C extends B{
    public void test3(){
        System.out.println("C");
    }
}

public class Demo25 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.test1();
        c1.test2();
        c1.test3();

    }
}
