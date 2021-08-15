package separation;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class TransFormCipher {

    private final Cipher cipher;
    private int mode;

    private static final Encoder encoder = Base64.getEncoder();
    private static final Decoder decoder = Base64.getDecoder();

    public TransFormCipher(int mode, SecretKeySpec keySpec, IvParameterSpec parameterSpec) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("default_cipher");
        cipher.init(mode, keySpec, parameterSpec);
        this.cipher = cipher;
        this.mode = mode;
    }

    public String encode(String plainText) throws GeneralSecurityException {
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encodeTextBytes = encoder.encode(cipher.doFinal(plainTextBytes));
        return new String(encodeTextBytes);
    }

    public String decode(String cipherText) throws GeneralSecurityException {
        byte[] cipherTextBytes = cipherText.getBytes(StandardCharsets.UTF_8);
        byte[] plainTextBytes = decoder.decode(cipher.doFinal(cipherTextBytes));
        return new String(plainTextBytes);
    }
}
