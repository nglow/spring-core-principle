package study.springcoreprinciple.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import study.springcoreprinciple.annotation.MainDiscountPolicy;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;

@Component
@MainDiscountPolicy
//@Primary // 같은 이름의 등록된 Bean이 2개일때 우선권 부여
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
