package UI;

import javax.swing.*;
import java.awt.*;

public class LinkWay extends JFrame {
    // 程序界面宽度
    public final int WIDTH = 520;
    // 程序界面高度
    public final int HEIGHT = 500;

    //检测模块
    private JPanel mDetectPanel = new JPanel();
    private JLabel mTestP = new JLabel();
    private JLabel mtext1 = new JLabel("该物品从");
    private JLabel mbeginaddressa1 = new JLabel("");
    private JLabel mtext2 = new JLabel("运往");
    private JLabel mfinaladdressa1 = new JLabel("");
    private JLabel mtext3 = new JLabel("发货时间");
    private JLabel mbegintimea1 = new JLabel("");
    //链接模块
    private JPanel mLinkPanel = new JPanel();
    private JLabel mLinkP = new JLabel();
    private JLabel mLink = new JLabel("已连接服务器");
    //控制模块
    private JPanel mControlPanel = new JPanel();
    private JLabel mcardnumber1 = new JLabel("卡号");
    private JTextArea mcardnumbera1 = new JTextArea();
    private JLabel mnextaddress1 = new JLabel("下一站");
    private JTextArea mnextaddressa1 = new JTextArea();
    private JLabel mnowaddress1 = new JLabel("现在地址");
    private JTextArea mnowaddressa1 = new JTextArea();

    private JButton mok = new JButton("确定");
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


    public LinkWay() {
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

        mtext1.setBounds(30, 10, 60, 20);
        mDetectPanel.add(mtext1);
        mbeginaddressa1.setBounds(100, 10, 60, 20);
        mDetectPanel.add(mbeginaddressa1);
        mtext2.setBounds(170, 10, 60, 20);
        mDetectPanel.add(mtext2);
        mfinaladdressa1.setBounds(230, 10, 60, 20);
        mDetectPanel.add(mfinaladdressa1);
        mtext3.setBounds(300, 10, 60, 20);
        mDetectPanel.add(mtext3);
        mbegintimea1.setBounds(370, 10, 60, 20);
        mDetectPanel.add(mbegintimea1);





//        mcardnumbera1.setBounds(110,10,50,20);
//        mDetectPanel.add(mcardnumberas);
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

        mcardnumber1.setBounds(50, 60, 60, 40);
        mControlPanel.add(mcardnumber1);
        mcardnumbera1.setFocusable(false);
        mcardnumbera1.setBounds(110, 60, 200, 40);
        mControlPanel.add(mcardnumbera1);

        mnextaddress1.setBounds(50, 140, 60, 40);
        mControlPanel.add(mnextaddress1);
        mnextaddressa1.setBounds(110, 140, 200, 40);
        mControlPanel.add(mnextaddressa1);

        mnowaddress1.setBounds(50, 220, 60, 40);
        mControlPanel.add(mnowaddress1);
        mnowaddressa1.setBounds(110, 220, 200, 40);
        mControlPanel.add(mnowaddressa1);

        mok.setBounds(80, 300, 200, 40);
        mControlPanel.add(mok);

        //显示模块设置
        mViewPanel.setBorder(BorderFactory.createTitledBorder(""));
        mViewPanel.setBounds(360, 30, 160, 440);
        mViewPanel.setLayout(null);
        add(mViewPanel);

        mcardnumber.setBounds(10, 20, 80, 20);
        mViewPanel.add(mcardnumber);
        mcardnumbera.setBounds(10, 40, 80, 20);
        mViewPanel.add(mcardnumbera);

        mitemtype.setBounds(10, 60, 80, 20);
        mViewPanel.add(mitemtype);
        mitemtypea.setBounds(10, 80, 50, 20);
        mViewPanel.add(mitemtypea);

        mnowaddress.setBounds(10, 100, 80, 20);
        mViewPanel.add(mnowaddress);
        mnowaddressa.setBounds(10, 120, 100, 20);
        mViewPanel.add(mnowaddressa);

        msender.setBounds(10, 140, 80, 20);
        mViewPanel.add(msender);
        msendera.setBounds(10, 160, 100, 20);
        mViewPanel.add(msendera);

        mreceiver.setBounds(10, 180, 80, 20);
        mViewPanel.add(mreceiver);
        mreceivera.setBounds(10, 200, 100, 20);
        mViewPanel.add(mreceivera);

        mbeginaddress.setBounds(10, 220, 80, 20);
        mViewPanel.add(mbeginaddress);
        mbeginaddressa.setBounds(10, 240, 100, 20);
        mViewPanel.add(mbeginaddressa);

        mfinaladdress.setBounds(10, 260, 80, 20);
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
                new UI.LinkWay().setVisible(true);
            }
        });
    }
}