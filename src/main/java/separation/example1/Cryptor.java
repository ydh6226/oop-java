package separation.example1;

import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

@RequiredArgsConstructor
public class Cryptor {

    private SecretKeySpec keySpec;
    private IvParameterSpec ivParameterSpec;

    private static final Encoder encoder = Base64.getEncoder();
    private static final Decoder decoder = Base64.getDecoder();

    public String encode(String plainText) throws GeneralSecurityException {
        Cipher cipher = createCipher(Cipher.ENCRYPT_MODE);
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encodeTextBytes = encoder.encode(cipher.doFinal(plainTextBytes));
        return new String(encodeTextBytes);
    }

    public String decode(String cipherText) throws GeneralSecurityException {
        Cipher cipher = createCipher(Cipher.DECRYPT_MODE);
        byte[] cipherTextBytes = cipherText.getBytes(StandardCharsets.UTF_8);
        byte[] plainTextBytes = decoder.decode(cipher.doFinal(cipherTextBytes));
        return new String(plainTextBytes);
    }

    private Cipher createCipher(int mode) throws GeneralSecurityException{
        Cipher cipher = Cipher.getInstance("default_cipher");
        cipher.init(mode, keySpec, ivParameterSpec);
        return cipher;
    }
}
