/**
 * Created by July on 15.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        //text for testing encrypting
        String t = "\"uid\": \"klhjdg1yf267i545trcusayjdyfkau56d213\"";

        //part of json that we want to encrypt
        String json = "[" +
                "{" +
                "\"uid\": \"klhjdg1yf267i545trcusayjdyfkau56d213\"," +
                "\"points\": [" +
                "{" +
                "\"x\": \"12\"," +
                "\"y\": \"23\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"13\"," +
                "\"y\": \"25\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"22\"," +
                "\"y\": \"29\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"32\"," +
                "\"y\": \"32\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}" +
                "]" +
                "}," +
                "{" +
                "\"uid\": \"klhjdg1yf267i545trcusayjdyfkau56d213\"," +
                "\"points\": [" +
                "{" +
                "\"x\": \"12\"," +
                "\"y\": \"23\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"13\"," +
                "\"y\": \"25\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"22\"," +
                "\"y\": \"29\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}," +
                "{" +
                "\"x\": \"32\"," +
                "\"y\": \"32\"," +
                "\"datetime\": 1510061227," +
                "\"type\": 1" +
                "}" +
                "]" +
                "}" +
                "]";

        //encrypted text to test sending
        //it works
        String test = "rz3B7uaz0ZjEEuLov/g80chcE9wHXA5v5+6fGHFdpHYvXBEBTV2bW2900r9hAfSEXd10HLbqDl4f8eESTH/Nr9o1/JJnJeK77DoT/U3PS3Lt0rOeNhR2K4NClpcmAcRhSiuun6jl1EP6jwwkwUEfIWhynD8wFBoU87+znR7xHR9ZePTRQdmTdc3kg5WQQQ2vTeaQvE52iuRXUVmFTh6CcgqFYahkupdEvXo/7MdsLZOwTlg8eqGOkiqxYmFc7daGz7Rk9dCHSV88VM5mDMyTN21+7RNGBkOHjf7H+HRi9OZzHRuuCaiTPeQnbBcCUHLwBgzrJt09iZjuMv9y/omKIg==keaukge2RxTqvIisrc0DuevGQqGmzLah43ViRAMwM+y/XqHqTbMtalub3LKwAWGFAAQJspmeDZc1vbxZ0gdPvNpgs21t9SfxjBOl43gGLdHYi2DvMrDaOILehsl6UV5gVWt+nIeXH69wUxGVz+AYLFcavrYzvTIX641OJOtuTLzzqXPDDIzAnl/q2jmk1uGu0VyKQ3Ffl2OB6xRfmnJU0h+EbV3ZjKm8t5NzMzh/JqJlt1dfX1XLs/UZg+x2zcFPNkFxd+DUNtA5dKp64D7gIFfEKy6+fdy43WOAuOulkreBIClwmZrM+ITSFXTP4WA6cQsZAsAfhjv0rzjOAxqLkw==EXzQfehPtV+jRtdHo2odeMa+xFnAc0D4ooFzsgm8K/QryG9/TtV37qOo1D3BdGQ4PfIRi7sG9f3ycnRvj54B7Z1X5PizylginlIQqFLrmcl3YmE0sldvjtsInumCNZh/0Nuh0AKdTDnaDMa8Nq8oXNNbvriezWm+zTOFbvp5xBbqbsDksGUx0l6msrohMmkwWOiR3zWpLUwXzqDQspeo1tXAmDqTFjgNBe6d9eYRamM0Rvz5hPGTMcgoENHPj3VB2T4j2ujqjfd9XYrX9NST9TEWmpBQ19hv6+nBCadxcx5v3Fo84yKVq9kjBR0TJCOd4Car8DoVYVZ4bM7FTVyH8w==";

        RSADataSender sender = new RSADataSender();
        String encrM = sender.encryptJSON(t);

        //json with encrypted part
        String message = "{" +
                "\"hash\":\"--some hash key--\"," +
                "\"data\":\"" + encrM + "\"}";
        System.out.println(encrM);

        DataSender send = new DataSender();
        try {
            send.SendData(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
