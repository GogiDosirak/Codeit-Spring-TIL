package com.sprint.mission.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
        SingletonComponent testComponent1 = (SingletonComponent) context.getBean("singletonComponent"); //Bean을 가져옴
        System.out.println(testComponent1.getRandomInt());
        SingletonComponent testComponent2 = (SingletonComponent) context.getBean("singletonComponent");
        System.out.println(testComponent2.getRandomInt());// 싱글톤 객체로 생성되기 떄문에, 그 이후로는 값이 고정됨

        PrototypeComponent prototypeComponent1 = (PrototypeComponent) context.getBean("prototypeComponent");
        System.out.println(prototypeComponent1.getRandomInt());
        PrototypeComponent prototypeComponent2 = (PrototypeComponent) context.getBean("prototypeComponent");
        System.out.println(prototypeComponent2.getRandomInt()); // 프로토타입이기 때문에, 요청할 때 마다 새로운 객체가 생성됨 -> 값이 달라짐

    }

}
