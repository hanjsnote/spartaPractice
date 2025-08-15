package com.example.springconcept.stateful;

public class StatefulSingleton {
    private static StatefulSingleton instance;

    // 상태를 나타내는 필드
    private int value;

    // private 생성자
    private StatefulSingleton() {}

    // 싱글톤 인스턴스를 반환하는 메서드
    public static StatefulSingleton getInstance() {
        if (instance == null) {
            instance = new StatefulSingleton();
        }
        return instance;
    }

    // 상태 변경 메서드
    public void setValue(int value) {
        this.value = value;
    }

    // 상태를 반환하는 메서드
    public int getValue() {
        return this.value;
    }
}
