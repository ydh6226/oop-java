package separation;

import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@RequiredArgsConstructor
public class CashClient {

    private final SecretKeySpec keySpec;
    private final IvParameterSpec ivParameterSpec;
    private final RestTemplate restTemplate;

    private String post(Request request) throws Exception {
        TransFormCipher encryptCipher = new TransFormCipher(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
        String cipherText = encryptCipher.encode(toJson(request));
        String cipherResponse = restTemplate.post(cipherText);

        TransFormCipher decodeCipher = new TransFormCipher(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        return decodeCipher.decode(cipherResponse);
    }


    private String toJson(Request request) {
        return request.toString();
    }
}
