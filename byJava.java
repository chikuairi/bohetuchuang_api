// 此处仅提供一个简单的示例，具体实现起来方案有很多，可按需开发
// !!!注意，这里使用的类名是 *Main*，如果你直接下载此文件进行运行，那么注意你应该把文件的名字设置为 *Main.java*
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        String apiUrl = "你的接口地址"; 
        String field1 = "你的API_token";
        String field2 = "url"; // 设置上传方式，这里设置为 url
        String field3 = "https://example.com/123.jpg"; // 通过url上传方式要在 uploadedFile 字段填写一个包含协议的URL

        try {
            // 准备要发送的数据
            String postData = "api_token=" + URLEncoder.encode(field1, "UTF-8") +
                    "&upload_format=" + URLEncoder.encode(field2, "UTF-8") +
                    "&uploadedFile=" + URLEncoder.encode(field3, "UTF-8");

            // 创建URL对象
            URL url = new URL(apiUrl);

            // 创建HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 设置请求方法为POST ** 发送请求方式，必须是 POST
            conn.setRequestMethod("POST");

            // 允许输出数据
            conn.setDoOutput(true);

            // 发送POST请求
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
                dos.flush();
            }

            // 获取响应结果
            int responseCode = conn.getResponseCode();
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            // 打印响应结果
            System.out.println("响应码：" + responseCode);
            System.out.println("响应内容：" + response.toString());

            // 关闭连接
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
