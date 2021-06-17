package study.springcoreprinciple.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import study.springcoreprinciple.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        var ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // Member가 bean으로 등록되있지 않다면, 아예 호출이 되지 않음
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // 호출은 되지만 해당 빈이 없다면, null로 들어옴
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // 호출은 되지만 해당 빈이 없다면, Optional.empty로 들어옴
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
