package Socket;

import model.StudentTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
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
            Scanner sc=new Scanner(System.in);
            while (true){
                System.out.println("查询物流信息：0\n开始读卡：1");
                System.out.print("请输入：");
                int in=sc.nextInt();
                if (in==0 || in==1){
                  break;
                }
                System.out.println("输入不合法");
            }

            int a = objin.readInt ();
            double b = objin.readDouble ();
            //readObject不太行，建议使用Map集合传送数据
            //StudentTest stu = (StudentTest) objin.readObject ();//readObject要转换你设定的对象
            //System.out.println (a + ":" + b + ":" + stu.getName());
            System.out.println(a+":"+b+":end");

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}