import connector.connector;
import encryptionUtil.Encryption;

public class Main {

    public static void main(String[] args) {

        String a = "123456";
        String b ="m499uOtSpgg=";
        try {
            System.out.println(Encryption.encryptjm(a));
            System.out.println(Encryption.encryptjm("12345"));
            System.out.println(Encryption.encryptjm("1234567"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
