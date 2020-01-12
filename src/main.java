import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class main {
    public static void addData(String data, boolean[] arr) throws NoSuchAlgorithmException {
        String md5 = panda_utl.toHexString(panda_utl.strtoMD5(data));
        String sha256 = panda_utl.toHexString(panda_utl.strtoSHA256(data));
        String sha1 = panda_utl.toHexString(panda_utl.strtoSHA1(data));

        BigInteger md5Dec = new BigInteger(md5,16);
        BigInteger sha1Dec = new BigInteger(sha1,16);
        BigInteger sha256Dec = new BigInteger(sha256,16);

        BigInteger bf_size = BigInteger.valueOf(arr.length);

        int md5place = Integer.parseInt(String.valueOf(md5Dec.mod(bf_size)));
        int sha1place = Integer.parseInt(String.valueOf(sha1Dec.mod(bf_size)));
        int sha256place = Integer.parseInt(String.valueOf(sha256Dec.mod(bf_size)));

        arr[md5place] = true;
        arr[sha1place] = true;
        arr[sha256place] = true;
    }

    public static boolean data_exist(boolean[] arr, String data) throws NoSuchAlgorithmException {
        String md5 = panda_utl.toHexString(panda_utl.strtoMD5(data));
        String sha256 = panda_utl.toHexString(panda_utl.strtoSHA256(data));
        String sha1 = panda_utl.toHexString(panda_utl.strtoSHA1(data));

        BigInteger md5Dec = new BigInteger(md5,16);
        BigInteger sha1Dec = new BigInteger(sha1,16);
        BigInteger sha256Dec = new BigInteger(sha256,16);

        BigInteger bf_size = BigInteger.valueOf(arr.length);

        int md5place = Integer.parseInt(String.valueOf(md5Dec.mod(bf_size)));
        int sha1place = Integer.parseInt(String.valueOf(sha1Dec.mod(bf_size)));
        int sha256place = Integer.parseInt(String.valueOf(sha256Dec.mod(bf_size)));

        int[] list = {md5place,sha1place,sha256place};
        boolean flag = true;
        for (int i:list) {
            if (!arr[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        boolean[] bf_size = new boolean[100000];
        Arrays.fill(bf_size,false);

        //亂生100筆資料丟
        Random ran = new Random();
        ran.setSeed(123456789);
        for (int i = 0; i < 100; i++) {
            addData(Integer.toString(ran.nextInt(1000)),bf_size);
        }
        System.out.println(data_exist(bf_size, "600"));
        System.out.println(data_exist(bf_size, "123"));
    }

}
