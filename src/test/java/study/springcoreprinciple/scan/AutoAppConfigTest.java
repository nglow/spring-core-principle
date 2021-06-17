package study.springcoreprinciple.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springcoreprinciple.AutoAppConfig;
import study.springcoreprinciple.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        var ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        var memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
