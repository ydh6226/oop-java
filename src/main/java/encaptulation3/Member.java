package encaptulation3;

public class Member {

    private int emailStatus;

    public void verifyEmail() {
        if (emailStatus == 2) {
            throw new AlreadyVerifiedException();
        }
        emailStatus = 1;
    }
}
