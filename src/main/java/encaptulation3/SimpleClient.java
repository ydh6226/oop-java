package encaptulation3;

import java.util.Optional;

public class SimpleClient {

    public void verifyEmail(String token) {
        Optional<Member> optionalMember = findByToken(token);
        Member member = optionalMember.orElseThrow(BadTokenException::new);
        member.verifyEmail();
    }

    private Optional<Member> findByToken(String token) {
        return Optional.empty();
    }
}
