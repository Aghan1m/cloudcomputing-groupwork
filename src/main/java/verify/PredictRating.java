package verify;

import java.io.BufferedReader;
import java.io.FileReader;

public class PredictRating {

        public static final String FILE_NAME = "/Users/Art1st/repo/groupwork/output/step3/part-r-00000";

        public static String mapScore(String userId, String itemId) throws Exception {
            String  thisLine = null;
            FileReader input = new FileReader(FILE_NAME);
            try{
                BufferedReader br = new BufferedReader(input);
                while ((thisLine = br.readLine()) != null) {
                    String str[] = thisLine.split("\t");
                    if (str[0].equals(userId) && str[1].split(":")[0].equals(itemId)) {
                        return str[1].split(":")[1];
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return "error";
        }

        public static void main(String[] args) throws Exception {
            String userId = args[0];
            String itemId = args[1];

            //A19ZYEX88K18MC	B000QQUUJ4:11.0

            String score = mapScore(userId, itemId);
            System.out.println("\n\n\n\n\n\n用户[" +userId + "]对物品["+ itemId +"]的预测打分为：" + score);
        }
}
