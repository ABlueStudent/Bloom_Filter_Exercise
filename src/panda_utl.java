import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class panda_utl {
    //hash成sha256 sha1 md5
    static byte[] strtoSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
        return msgDigest.digest(input.getBytes());
    }
    static byte[] strtoSHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
        return msgDigest.digest(input.getBytes());
    }
    static byte[] strtoMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        return msgDigest.digest(input.getBytes());
    }

    //轉成16進位 https://www.itread01.com/content/1548614166.html
    static String toHexString(byte[] hash) {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        char[] result = new char[hash.length*2];

        int index = 0;
        for (byte b: hash) {
            result[index++] = hexDigits[b >>>4 & 0xf]; // >>>4 == /16 0xf 只取個位數 >>>是會補0的，應該...可以改用>>吧，我不知道(#
            result[index++] = hexDigits[b & 0xf];
        }

        return new String(result);
    }
}
