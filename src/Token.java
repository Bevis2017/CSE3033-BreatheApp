import org.apache.commons.io.FileDeleteStrategy;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
    private int userId;
    private String token;
    private boolean rememberMe;

    public static void main(String[] args) {
        Token t = new Token();
        //t.generateToken("admin");
        //t.setRememberMe(true);
        //t.saveToken();
        t.readToken();

        System.out.println("GET TOKEN: " + t.readToken() + " | User ID: " + t.getUserId());
    }

    public boolean readToken() {
        try {
            JSONParser parser = new JSONParser();
            FileReader fr = new FileReader("token.json");
            JSONObject json = (JSONObject) parser.parse(fr);
            fr.close();

            userId = Integer.parseInt(json.get("userId").toString());
            token = String.valueOf(json.get("token"));
            rememberMe = Boolean.valueOf(String.valueOf(json.get("rememberMe")));

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("[Token][readToken] Token File Not Found!");
            return false;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveToken() {
        JSONObject obj = new JSONObject();
        obj.put("userId", userId);
        obj.put("token", token);
        obj.put("rememberMe", rememberMe);

        try (FileWriter file = new FileWriter("token.json")) {
            file.write(obj.toJSONString());
            file.close();
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("JSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateToken(String email) {
        User user = new User();
        userId = user.getIdByEmail(email.trim());
        System.out.println("[Token][generateToken] User ID: " + userId);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        token = encodeMD5(email + ": " + timeStamp);
    }

    public String getToken() {
        return token;
    }

    public int getUserId() {
        System.out.println("[Token][getUserId] User ID: " + userId);
        return userId;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean remember) {
        System.out.println("Remember Me: " + remember);
        rememberMe = remember;
    }

    public void deleteToken() {
        token = null;

        File file = new File("token.json");

        if (file.delete()) {
            System.out.println("Token deleted successfully.");
        } else {
            System.out.println("Failed to delete the Token.");
            try {
                System.out.println("Using another method to delete the Token.");
                FileDeleteStrategy.FORCE.delete(file);
                System.out.println("Token deleted successfully.");
            } catch (IOException e) {
                System.out.println("Failed to delete the Token :(");
                e.printStackTrace();
            }
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
}
