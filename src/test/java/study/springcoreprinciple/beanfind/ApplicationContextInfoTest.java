package study.springcoreprinciple.beanfind;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springcoreprinciple.AppConfig;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        var beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            var beanDefinition = ac.getBeanDefinition(s);

            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                var bean = ac.getBean(s);
                System.out.println("name = " + s + " object = " + bean);
            }
        }
    }
}
