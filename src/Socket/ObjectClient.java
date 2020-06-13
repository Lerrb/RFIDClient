package Socket;

import model.StudentTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ObjectClient {
    public static void main(String[] args) throws IOException {
        Socket s = null;
        String ip = "127.0.0.1";
        int port = 8399;
        InputStream input = null;//字节流输出
        OutputStream output = null;//字节流输入
        ObjectInputStream objin = null;
        try {//开始访问服务器
            s = new Socket (ip, port);

            output = s.getOutputStream ();
            input = s.getInputStream ();

            objin = new ObjectInputStream (input);
            int a = objin.readInt ();
            double b = objin.readDouble ();
            StudentTest stu = (StudentTest) objin.readObject ();//readObject要转换你设定的对象
            System.out.println (a + ":" + b + ":" + stu.getName());

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}