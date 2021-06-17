package study.springcoreprinciple.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        var ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        var singletonBean1 = ac.getBean(PrototypeBean.class);
        var singletonBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        assertThat(singletonBean1).isNotSameAs(singletonBean2);

        // 종료 메서드를 직접 호출해 줘야함
        singletonBean1.destroy();
        singletonBean2.destroy();
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
