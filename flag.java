import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteCommand {
    public static void main(String[] args) {
        // Lệnh hệ thống để thực hiện
        String command = "ls"; // Thay đổi thành "dir" nếu bạn đang sử dụng Windows

        try {
            // Thực thi lệnh
            Process process = Runtime.getRuntime().exec(command);

            // Đọc đầu ra của lệnh
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Đọc lỗi nếu có
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            // Đợi lệnh thực thi xong
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
