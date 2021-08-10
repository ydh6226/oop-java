package encaptulation.example3;


import java.util.Optional;

public class SimpleClient {

    public void verifyEmail(String token) {
        new Member();
        Optional<Member> optionalMember = findByToken(token);
        encaptulation.example3.Member member = optionalMember.orElseThrow(BadTokenException::new);
        member.verifyEmail();
    }

    private Optional<Member> findByToken(String token) {
        return Optional.empty();
    }
}
