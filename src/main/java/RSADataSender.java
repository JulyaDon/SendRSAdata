
/**
 * Created by Andrew on 09/06/17.
 */
public class RSADataSender extends DataSender {


    /**
     * Creating an instance with specified domain address, postfix and location<br>
     * entire URL wil be Domain+Postfix. Example:www.servername.net/example/add-cam
     */
    public RSADataSender() {

    }

    @Override
    public boolean SendData(String jSon) throws Exception {

        String encryptedMessage = null;

        IPublicKeyProvider keyProvider = new PKProvider("C:/Users/July/IdeaProjects/SendRSAdata/src/main/resources/public.txt");

        RSAEncrypter encrypter = new RSAEncrypter(keyProvider);

        encryptedMessage = encrypter.encrypt(jSon);

        return super.SendData(encryptedMessage);
    }

    public String encryptJSON(String jSon){
        String encryptedMessage = null;

        IPublicKeyProvider keyProvider = new PKProvider("C:/Users/July/IdeaProjects/SendRSAdata/src/main/resources/public.txt");

        RSAEncrypter encrypter = new RSAEncrypter(keyProvider);

        try {
            encryptedMessage = encrypter.encrypt(jSon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptedMessage;
    }

}
