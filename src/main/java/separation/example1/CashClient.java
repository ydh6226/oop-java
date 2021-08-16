package separation.example1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CashClient {

    private final Cryptor cryptor;
    private final RestTemplate restTemplate;

    private String post(Request request) throws Exception {
        String cipherText = cryptor.encode(toJson(request));
        String cipherResponse = restTemplate.post(cipherText);
        return cryptor.decode(cipherResponse);
    }

    private String toJson(Request request) {
        return request.toString();
    }
}
