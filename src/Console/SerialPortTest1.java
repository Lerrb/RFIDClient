package Console;

import gnu.io.*;
import utils.ArrayUtils;
import SerialPort.SerialPortManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.TooManyListenersException;

import static SerialPort.SerialPortManager.*;
import static java.lang.System.*;

public class SerialPortTest1 {
    public static void main(String arg[]) throws PortInUseException, InterruptedException {
        SerialPortManager spm=new SerialPortManager();
        ArrayList<String> portList=new ArrayList<String>();
        portList=spm.findPorts();
        if ( portList.size()<1 ){
            out.println("未检测到串口！");
        }else {
            out.println("检测到串口");
            for (String s:portList){
                out.println(s);
            }
            Scanner sc=new Scanner(in);
            String Port="";
            while1: while (true){
                out.print("请选择开启串口:(例如COM3)");
                Port=sc.next();
                for (String s:portList){
                    if (Port.equals(s)){
                        break while1;
                    }
                }
                out.println("未能识别端口！");
            }
            int[] baudrates=new int[]{9600,19200,38400,57600,115200};
            out.print("波特率：");
            for (int i:baudrates) out.print(i+",");
            out.println();
            int baudrate=0;
            while2: while (true){
                out.print("请选择串口波特率");
                baudrate=sc.nextInt();
                for (int i:baudrates){
                    if (i==baudrate) break while2;
                }
                out.println("波特率输入错误");
            }

            SerialPort sp=openPort(Port,baudrate);
            out.println("成功开启端口"+Port+",选择串口波特率为"+baudrate);
            out.println("开始监听"+Port);

            addListener(sp,new DataAvailableListener() {

                public void dataAvailable() {
                    byte[] data = null;
                    try {
                        if (sp == null) {
                            out.println("串口对象为空，监听失败！");
                            //ShowUtils.errorMessage("串口对象为空，监听失败！");
                        } else {
                            // 读取串口数据
                            data = readFromPort(sp);
                            out.println(new String(data));
                            /*
                            // 以字符串的形式接收数据
                            if (mDataASCIIChoice.isSelected()) {
                                mDataView.append(new String(data) + "\r\n");
                            }

                            // 以十六进制的形式接收数据
                            if (mDataHexChoice.isSelected()) {
                                mDataView.append(ByteUtils.byteArrayToHexString(data) + "\r\n");
                            }
                            */
                        }
                    } catch (Exception e) {
                        out.println(e.toString());
                        //ShowUtils.errorMessage(e.toString());
                        // 发生读取错误时显示错误信息后退出系统
                        exit(0);
                    }
                }
            });
            for (int i=10;i<=60;i+=10){
                Thread.sleep(10000);
                out.println("串口监听time："+i+"s");
            }

            out.println("串口监听超时，结束。");
            spm.closePort(sp);


        }
    }

//
//    public static final ArrayList<String> findPort() {
//        // 获得当前所有可用串口
//        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
//        ArrayList<String> portNameList = new ArrayList<String>();
//        // 将可用串口名添加到List并返回该List
//        while (portList.hasMoreElements()) {
//            String portName = portList.nextElement().getName();
//            portNameList.add(portName);
//        }
//        return portNameList;
//    }
//
//    public static final SerialPort openPort(String portName, int baudrate) throws PortInUseException {
//        try {
//            // 通过端口名识别端口
//            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
//            // 打开端口，并给端口名字和一个timeout（打开操作的超时时间）
//            CommPort commPort = portIdentifier.open(portName, 2000);
//            // 判断是不是串口
//            if (commPort instanceof SerialPort) {
//                SerialPort serialPort = (SerialPort) commPort;
//                try {
//                    // 设置一下串口的波特率等参数
//                    // 数据位：8
//                    // 停止位：1
//                    // 校验位：None
//                    serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
//                            SerialPort.PARITY_NONE);
//                } catch (UnsupportedCommOperationException e) {
//                    e.printStackTrace();
//                }
//                return serialPort;
//            }
//        } catch (NoSuchPortException e1) {
//            e1.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void closePort(SerialPort serialPort) {
//        if (serialPort != null) {
//            serialPort.close();
//        }
//    }
//
//    public static void addListener(SerialPort serialPort, DataAvailableListener listener) {
//        try {
//            // 给串口添加监听器
//            serialPort.addEventListener(new SerialPortListener(listener));
//            // 设置当有数据到达时唤醒监听接收线程
//            serialPort.notifyOnDataAvailable(true);
//            // 设置当通信中断时唤醒中断线程
//            serialPort.notifyOnBreakInterrupt(true);
//        } catch (TooManyListenersException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static byte[] readFromPort(SerialPort serialPort) {
//        InputStream in = null;
//        byte[] bytes = {};
//        try {
//            in = serialPort.getInputStream();
//            // 缓冲区大小为一个字节
//            byte[] readBuffer = new byte[1];
//            int bytesNum = in.read(readBuffer);
//            while (bytesNum > 0) {
//                bytes = ArrayUtils.concat(bytes, readBuffer);
//                bytesNum = in.read(readBuffer);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                    in = null;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return bytes;
//    }
//
//    /**
//     * 串口监听
//     */
//    public static class SerialPortListener implements SerialPortEventListener {
//
//        private DataAvailableListener mDataAvailableListener;
//
//        public SerialPortListener(DataAvailableListener mDataAvailableListener) {
//            this.mDataAvailableListener = mDataAvailableListener;
//        }
//
//        public void serialEvent(SerialPortEvent serialPortEvent) {
//            switch (serialPortEvent.getEventType()) {
//                case SerialPortEvent.DATA_AVAILABLE: // 1.串口存在有效数据
//                    if (mDataAvailableListener != null) {
//                        mDataAvailableListener.dataAvailable();
//                    }
//                    break;
//
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2.输出缓冲区已清空
//                    break;
//
//                case SerialPortEvent.CTS: // 3.清除待发送数据
//                    break;
//
//                case SerialPortEvent.DSR: // 4.待发送数据准备好了
//                    break;
//
//                case SerialPortEvent.RI: // 5.振铃指示
//                    break;
//
//                case SerialPortEvent.CD: // 6.载波检测
//                    break;
//
//                case SerialPortEvent.OE: // 7.溢位（溢出）错误
//                    break;
//
//                case SerialPortEvent.PE: // 8.奇偶校验错误
//                    break;
//
//                case SerialPortEvent.FE: // 9.帧错误
//                    break;
//
//                case SerialPortEvent.BI: // 10.通讯中断
//                    //ShowUtils.errorMessage("与串口设备通讯中断");
//                    break;
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    public interface DataAvailableListener {
//        /**
//         * 串口存在有效数据
//         */
//        void dataAvailable();
//    }

}
