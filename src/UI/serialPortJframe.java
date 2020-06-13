package UI;

import SerialPort.SerialPortManager;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import utils.ShowUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static SerialPort.SerialPortManager.*;
import static java.lang.System.exit;
import static java.lang.System.out;

public class serialPortJframe extends JFrame {

    // 程序界面宽度
    public final int WIDTH = 290;
    // 程序界面高度
    public final int HEIGHT = 390;

    private JLabel Port=new JLabel("端口选择：");
    private JLabel baudrates=new JLabel("波特率选择：");
    private JComboBox portJcombo;
    private JComboBox baudrateJcombo;
    private JButton openPort=new JButton("打开串口");
    private JTextArea dataView = new JTextArea();
    private JScrollPane mScrollDataView = new JScrollPane(dataView);

    SerialPortManager spm=new SerialPortManager();
    private SerialPort sport;


    public serialPortJframe(String title)
    {
        JFrame jf = new JFrame(title);
        //Container conn = jf.getContentPane();    //得到窗口的容器
        //JLabel L1 = new JLabel("Hello,world!");    //创建一个标签 并设置初始内容
        JPanel portPanel=new JPanel();

        jf.add(portPanel);
        portPanel(portPanel);

        jf.setBounds(200,200,WIDTH,HEIGHT); //设置窗口的属性 窗口位置以及窗口的大小
        jf.setVisible(true);//设置窗口可见
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
    }

    public void portPanel(JPanel jPanel){
        jPanel.setLayout(null);

        //添加端口名和波特率
        ArrayList<String> portList=new ArrayList<String>();
        portList=spm.findPorts();
        String[] strs1=portList.toArray(new String[portList.size()]);
        portJcombo = new JComboBox(strs1);

        String[] baudrate={"9600","19200","38400","57600","115200"};
        baudrateJcombo = new JComboBox(baudrate);



        Port.setBounds(50,20,80,25);
        baudrates.setBounds(50,45,80,25);
        baudrateJcombo.setBounds(130,50,80,18);
        portJcombo.setBounds(130,25,80,18);
        openPort.setBounds(50,80,100,20);
        mScrollDataView.setBounds(35, 130, 200, 120);

        addListen();


        jPanel.add(Port);
        jPanel.add(baudrates);
        jPanel.add(baudrateJcombo);
        jPanel.add(portJcombo);
        jPanel.add(openPort);
        jPanel.add(mScrollDataView);
    }

    public void addListen() {
        openPort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("打开串口".equals(openPort.getText()) && sport == null) {
                    System.out.println("打开端口");
                    try {
                        openSerialPort(e);
                    } catch (PortInUseException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("关闭端口");
                    closeSerialPort(e);
                }
            }
        });
    }

    public void openSerialPort(ActionEvent evt) throws PortInUseException {
        //获取端口名
        String comPort=(String) portJcombo.getSelectedItem();
        //获取波特率
        String bps=(String) baudrateJcombo.getSelectedItem();
        int baudrate=Integer.parseInt(bps);
        sport= openPort(comPort,baudrate);
        openPort.setText("关闭端口");
        dataView.setText("串口"+comPort+"已打开");

        addListener(sport,new DataAvailableListener(){
            @Override
            public void dataAvailable() {
                byte[] data = null;
                try {
                    if (sport == null) {
                        out.println("串口对象为空，监听失败！");
                        //ShowUtils.errorMessage("串口对象为空，监听失败！");
                    } else {
                        // 读取串口数据
                        data = readFromPort(sport);
                        out.println(new String(data));
                        dataView.append("\n"+new String(data));

                    }
                } catch (Exception e) {
                    out.println(e.toString());
                    ShowUtils.errorMessage(e.toString());
                    // 发生读取错误时显示错误信息后退出系统
                    exit(0);
                }
            }
        });
    }
    public void closeSerialPort(ActionEvent evt){
        SerialPortManager.closePort(sport);
        dataView.setText("串口已关闭" + "\r\n");
        openPort.setText("打开串口");
        sport = null;
    }

    public static void main(String[] args) {
        new serialPortJframe("窗口");        //创建窗口
    }

}
