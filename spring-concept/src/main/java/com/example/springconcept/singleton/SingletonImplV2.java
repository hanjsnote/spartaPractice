package com.example.springconcept.singleton;

public class SingletonImplV2 implements Singleton {
    private static SingletonImplV2 instance;

    // private 생성자를 통해 외부에서 객체 생성을 방지
    private SingletonImplV2() {}

    // public으로 설정하여 인스턴스가 필요하면
    // getInstance 메서드를 통해 인스턴스에 접근하도록 만듦
    public static SingletonImplV2 getInstance() {
        // 인스턴스가 없을 때만 생성
        if (instance == null) {
            instance = new SingletonImplV2();
        }
        return instance;
    }
    @Override
    public void showMessage() {
        System.out.println("V2 : " + instance.toString());
    }
}
