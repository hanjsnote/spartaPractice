package com.example.springconcept.stateful;

public class MainApp {
    public static void main(String[] args) {
        // 클라이언트 1: 싱글톤 인스턴스를 가져와서 상태를 설정
        StatefulSingleton client1 = StatefulSingleton.getInstance();
        client1.setValue(42);
        System.out.println("클라이언트 1이 설정한 값: " + client1.getValue());

        // 클라이언트 2: 동일한 싱글톤 인스턴스를 사용해 상태를 변경
        StatefulSingleton client2 = StatefulSingleton.getInstance();
        client2.setValue(100);
        System.out.println("클라이언트 2가 설정한 값: " + client2.getValue());

        // 클라이언트 1이 다시 값을 확인
        System.out.println("클라이언트 1이 다시 확인한 값: " + client1.getValue());
    }
}
