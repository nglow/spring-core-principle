package study.springcoreprinciple.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 구현체가 하나만 있을때에는 인터페이스 이름뒤에 Impl이라고 붙여 사용
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
