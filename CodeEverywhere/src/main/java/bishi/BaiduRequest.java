package bishi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduRequest {
    public static void main(String[] args) throws Exception {
        String url = "https://grs.hdu.edu.cn/2024/0930/c1721a271087/page.htm";
        for (int i = 0; i < 100; i++) {
            sendGetRequest(url);
            Thread.sleep(1000);
            System.out.println("Request number: " + (i + 1));
        }
    }

    private static void sendGetRequest(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        // 设置请求类型
        connection.setRequestMethod("GET");

        // 读取响应
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 可选：打印响应
//        System.out.println(response.toString());
    }
}