package com.example.springconcept.singleton;

public class SingletonImpl implements Singleton {
    private static SingletonImpl instance;

    // private 생성자를 통해 외부에서 객체 생성을 방지
    private SingletonImpl() {}

    // public으로 설정하여 인스턴스가 필요하면
    // getInstance 메서드를 통해 인스턴스에 접근하도록 만듦
    public static SingletonImpl getInstance() {
        // 인스턴스가 없을 때만 생성
        if (instance == null) {
            instance = new SingletonImpl();
        }
        return instance;
    }

    @Override
    public void showMessage() {
        System.out.println(instance.toString());
    }

}
