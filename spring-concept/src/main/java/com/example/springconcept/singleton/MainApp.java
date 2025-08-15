package com.example.springconcept.singleton;

public class MainApp {
    public static void main(String[] args) {
        // 첫 번째 싱글톤 인스턴스 요청, 구현클래스.getInstance();
        Singleton instance1 = SingletonImpl.getInstance();
        instance1.showMessage(); // 인스턴스 주소값 출력

        // 두 번째 싱글톤 인스턴스 요청, 구현클래스.getInstance();
        Singleton instance2 = SingletonImpl.getInstance();
        instance2.showMessage(); // 인스턴스 주소값 출력

        // 다른 구현체로 바꾸려면 DIP, OCP 위반
        Singleton instance3 = SingletonImplV2.getInstance();
        instance3.showMessage();
    }
}
