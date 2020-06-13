package UI;

import javax.swing.*;
import java.awt.*;

public class LinkShip extends JFrame {
    // 程序界面宽度
    public final int WIDTH = 520;
    // 程序界面高度
    public final int HEIGHT = 500;

    //检测模块
    private JPanel mDetectPanel = new JPanel();
    private JLabel mTestP = new JLabel();
    private JLabel mTest = new JLabel("检测到卡号:");
    private JLabel mcardnumberas = new JLabel("1");
    //链接模块
    private JPanel mLinkPanel = new JPanel();
    private JLabel mLinkP = new JLabel();
    private JLabel mLink = new JLabel("已连接服务器");
    //控制模块
    private JPanel mControlPanel = new JPanel();
    private JLabel mcardnumber1 = new JLabel("卡号");
    private JLabel mitemtype1 = new JLabel("物品类型");
    private JLabel mnowaddress1 = new JLabel("现在地址");
    private JLabel msender1 = new JLabel("发货人");
    private JLabel mreceiver1 = new JLabel("收货人");
    private JLabel mbeginaddress1 = new JLabel("发货地址");
    private JLabel mfinaladdress1 = new JLabel("收获地址");
    private JLabel msendernumber1 = new JLabel("发货人联系方式");
    private JLabel mreceiveraddress1 = new JLabel("收货人联系地址");
    private JLabel mnextaddress1 = new JLabel("下一站");
    private JTextArea mcardnumbera1 = new JTextArea("1");
    private JTextArea mitemtypea1 = new JTextArea();
    private JTextArea mnowaddressa1 = new JTextArea();
    private JTextArea msendera1 = new JTextArea();
    private JTextArea mreceivera1 = new JTextArea();
    private JTextArea mbeginaddressa1 = new JTextArea();
    private JTextArea mfinaladdressa1 = new JTextArea();
    private JTextArea msendernumbera1 = new JTextArea();
    private JTextArea mreceiveraddressa1 = new JTextArea();
    private JTextArea mnextaddressa1 = new JTextArea();
    //显示模块
    private JPanel mViewPanel = new JPanel();
    private JLabel mcardnumber = new JLabel("卡号");
    private JLabel mitemtype = new JLabel("物品类型");
    private JLabel mnowaddress = new JLabel("现在地址");
    private JLabel msender = new JLabel("发货人");
    private JLabel mreceiver = new JLabel("收货人");
    private JLabel mbeginaddress = new JLabel("发货地址");
    private JLabel mfinaladdress = new JLabel("收获地址");
    private JLabel msendernumber = new JLabel("发货人联系方式");
    private JLabel mreceiveraddress = new JLabel("收货人联系地址");
    private JLabel mnextaddress = new JLabel("下一站");
    private JLabel mcardnumbera = new JLabel("1");
    private JLabel mitemtypea = new JLabel();
    private JLabel mnowaddressa = new JLabel();
    private JLabel msendera = new JLabel();
    private JLabel mreceivera = new JLabel();
    private JLabel mbeginaddressa = new JLabel();
    private JLabel mfinaladdressa = new JLabel();
    private JLabel msendernumbera = new JLabel();
    private JLabel mreceiveraddressa = new JLabel();
    private JLabel mnextaddressa = new JLabel();

    private JButton mok = new JButton("确定");


    public LinkShip(){
        initView();
        initComponents();
    }

    /**
     * 初始化窗口
     */
    private void initView() {
        // 关闭程序
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // 禁止窗口最大化
        setResizable(false);

        // 设置程序窗口居中显示
        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(p.x - WIDTH / 2, p.y - HEIGHT / 2, WIDTH, HEIGHT);
        this.setLayout(null);
        setTitle("链接主页");
    }

    /**
     * 初始化控件
     */
    private void initComponents() {
        //检测模块设置
        mDetectPanel.setBorder(BorderFactory.createTitledBorder(""));
        mDetectPanel.setBounds(0, 0, 520, 30);
        mDetectPanel.setLayout(null);
        add(mDetectPanel);

        mTestP.setBounds(10, 10, 20, 20);
        mDetectPanel.add(mTestP);

        mTest.setBounds(40, 10, 80, 20);
        mDetectPanel.add(mTest);

        mcardnumberas.setBounds(110,10,50,20);
        mDetectPanel.add(mcardnumberas);
        //链接模块设置
//        mLinkPanel.setBorder(BorderFactory.createTitledBorder("链接模块"));
//        mLinkPanel.setBounds(250, 0, 250, 40);
//        mLinkPanel.setLayout(null);
//        add(mLinkPanel);
//        mLinkP.setBounds(10, 10, 20, 20);
//        mLinkPanel.add(mLinkP);
//        mLink.setBounds(40, 10, 80, 20);
//        mLinkPanel.add(mLink);

        //控制模块设置
        mControlPanel.setBorder(BorderFactory.createTitledBorder(""));
        mControlPanel.setBounds(0, 30, 360, 440);
        mControlPanel.setLayout(null);
        add(mControlPanel);

        mcardnumber1.setBounds(60,20,100,20);
        mControlPanel.add(mcardnumber1);
        mcardnumbera1.setBounds(160,20,160,20);
        mcardnumbera1.setFocusable(false);
        mControlPanel.add(mcardnumbera1);

        mitemtype1.setBounds(60,60,100,20);
        mControlPanel.add(mitemtype1);
        mitemtypea1.setBounds(160,60,160,20);
        mControlPanel.add(mitemtypea1);

        mnowaddress1.setBounds(60, 100, 100, 20);
        mControlPanel.add(mnowaddress1);
        mnowaddressa1.setBounds(160, 100, 160, 20);
        mControlPanel.add(mnowaddressa1);

        msender1.setBounds(60, 140, 100, 20);
        mControlPanel.add(msender1);
        msendera1.setBounds(160, 140, 160, 20);
        mControlPanel.add(msendera1);

        mreceiver1.setBounds(60, 180, 100, 20);
        mControlPanel.add(mreceiver1);
        mreceivera1.setBounds(160, 180, 160, 20);
        mControlPanel.add(mreceivera1);

        mbeginaddress1.setBounds(60, 220, 100, 20);
        mControlPanel.add(mbeginaddress1);
        mbeginaddressa1.setBounds(160, 220, 160, 20);
        mControlPanel.add(mbeginaddressa1);

        mfinaladdress1.setBounds(60, 260, 100, 20);
        mControlPanel.add(mfinaladdress1);
        mfinaladdressa1.setBounds(160, 260, 160, 20);
        mControlPanel.add(mfinaladdressa1);

        msendernumber1.setBounds(60, 300, 100, 20);
        mControlPanel.add(msendernumber1);
        msendernumbera1.setBounds(160, 300, 160, 20);
        mControlPanel.add(msendernumbera1);

        mreceiveraddress1.setBounds(60, 340, 100, 20);
        mControlPanel.add(mreceiveraddress1);
        mreceiveraddressa1.setBounds(160, 340, 160, 20);
        mControlPanel.add(mreceiveraddressa1);

        mnextaddress1.setBounds(60, 380, 100, 20);
        mControlPanel.add(mnextaddress1);
        mnextaddressa1.setBounds(160, 380, 160, 20);
        mControlPanel.add(mnextaddressa1);

        mok.setBounds(80, 410, 200, 20);
        mControlPanel.add(mok);


        //显示模块设置
        mViewPanel.setBorder(BorderFactory.createTitledBorder(""));
        mViewPanel.setBounds(360, 30, 160, 440);
        mViewPanel.setLayout(null);
        add(mViewPanel);

        mcardnumber.setBounds(10,20,100,20);
        mViewPanel.add(mcardnumber);
        mcardnumbera.setBounds(10,40,100,20);
        mViewPanel.add(mcardnumbera);

        mitemtype.setBounds(10,60,100,20);
        mViewPanel.add(mitemtype);
        mitemtypea.setBounds(10,80,100,20);
        mViewPanel.add(mitemtypea);

        mnowaddress.setBounds(10, 100, 100, 20);
        mViewPanel.add(mnowaddress);
        mnowaddressa.setBounds(10, 120, 100, 20);
        mViewPanel.add(mnowaddressa);

        msender.setBounds(10, 140, 100, 20);
        mViewPanel.add(msender);
        msendera.setBounds(10, 160, 100, 20);
        mViewPanel.add(msendera);

        mreceiver.setBounds(10, 180, 100, 20);
        mViewPanel.add(mreceiver);
        mreceivera.setBounds(10, 200, 100, 20);
        mViewPanel.add(mreceivera);

        mbeginaddress.setBounds(10, 220, 100, 20);
        mViewPanel.add(mbeginaddress);
        mbeginaddressa.setBounds(10, 240, 100, 20);
        mViewPanel.add(mbeginaddressa);

        mfinaladdress.setBounds(10, 260, 100, 20);
        mViewPanel.add(mfinaladdress);
        mfinaladdressa.setBounds(10, 280, 100, 20);
        mViewPanel.add(mfinaladdressa);

        msendernumber.setBounds(10, 300, 100, 20);
        mViewPanel.add(msendernumber);
        msendernumbera.setBounds(10, 320, 100, 20);
        mViewPanel.add(msendernumbera);

        mreceiveraddress.setBounds(10, 340, 100, 20);
        mViewPanel.add(mreceiveraddress);
        mreceiveraddressa.setBounds(10, 360, 100, 20);
        mViewPanel.add(mreceiveraddressa);

        mnextaddress.setBounds(10, 380, 100, 20);
        mViewPanel.add(mnextaddress);
        mnextaddressa.setBounds(10, 400, 100, 20);
        mViewPanel.add(mnextaddressa);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkShip().setVisible(true);
            }
        });
    }
}
