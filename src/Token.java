import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.security.provider.MD5;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
    private String token;

    public void readToken() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader("token.json"));

            token = String.valueOf(json.get("token"));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToken() {
        JSONObject obj = new JSONObject();
        obj.put("token", token);

        try (FileWriter file = new FileWriter("token.json")) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateToken(String email) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        token = encodeMD5(email + ": " + timeStamp);
    }

    public String getToken() {
        return token;
    }

    public void deleteToken() {
        token = null;

        File file = new File("token.json");

        if (file.delete()) {
            System.out.println("Token deleted successfully.");
        } else {
            System.out.println("Failed to delete the Token.");
        }

    }

    private String encodeMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes(Charset.forName("UTF-8")));
            StringBuffer sb = new StringBuffer();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            //
        }
        return null;
    }

    public static void main(String[] args) {
        Token t = new Token();
        t.generateToken("admin");
        t.saveToken();
        t.readToken();

        System.out.println("GET TOKEN: " + t.getToken());
    }
}
