
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Denglu extends JFrame implements ActionListener{
	JPanel p;
	JLabel lcodeId,lpasswd,ldate,back;
	JTextField tcodeId;
	JPasswordField tpasswd;
	JButton bdenglu,bzhuce;
	Thread thread1;
	BufferedReader in;
	Socket clientSocket;
	PrintStream out;
	File file;
	ArrayList list;
public Denglu(){
	super("登陆页面");
	p=new JPanel();
	lcodeId=new JLabel("账号：");
	lpasswd=new JLabel("密码：");
	ldate=new JLabel("当前时间：");
	tcodeId=new JTextField(25);
	tpasswd=new JPasswordField(25);
	bdenglu=new JButton("登陆");
	bzhuce=new JButton("注册");
	p.setLayout(null);
	ldate.setFont(new Font("宋体",Font.BOLD,12));
	ldate.setForeground(Color.blue);
	Datethread thread1=new Datethread(ldate);
	thread1.start();
	
	bdenglu.addActionListener(this);
	bzhuce.addActionListener(this);
	
	p.add(lcodeId);
	lcodeId.setBounds(35, 30, 80, 25);
	p.add(tcodeId);
	tcodeId.setBounds(80, 30, 180, 25);
	p.add(lpasswd);
	lpasswd.setBounds(35, 65, 80, 25);
	p.add(tpasswd);
	tpasswd.setBounds(80, 65, 180, 25);
	p.add(bdenglu);
	bdenglu.setBounds(80, 102, 75, 25);
	p.add(bzhuce);
	bzhuce.setBounds(175, 102, 75, 25);
	p.add(ldate);
	ldate.setBounds(120, 140, 170, 25);
	this.add(p);
	this.setVisible(true);
	this.setSize(300,200);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	try {
		file=new File("file\\regiter.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
	new Denglu();

	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bdenglu){
			//list用于加载注册的所有信息，每一条注册记录就一个CardInfo类的对象
			//list加载了CardInfo类的对象
			list=new ArrayList();
			int temp=0;//做为标记，用于判断登录是否成功，成功是1
			//取出界面中的用户名和密码
			String codeId=tcodeId.getText();
			String passwd=new String(tpasswd.getPassword());
			if(codeId.equals("")||passwd.equals("")){
				JOptionPane.showMessageDialog(null, "帐号或密码不能为空！");
				return;
			}
			try{
				//用于读取每一条记录
				in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String tempStr="";
				//此循环的做用是：把注册的每一条记录到list中，判断登录是否成功
				while((tempStr=in.readLine())!=null){
					CardInfo card=new CardInfo();
					StringTokenizer sts=new StringTokenizer(tempStr, "|");
					String codeIds=sts.nextToken();
					String passwds=sts.nextToken();
					float moneys=Float.parseFloat(sts.nextToken());
					String qtxxs=sts.nextToken();
					//把取出的上面的信息，加到CardInfo类的对象中
					//card就是注册表中的第一条记录
					card.setCodeId(codeIds);
					card.setPasswd(passwds);
					card.setMoney(moneys);
					card.setQtxx(qtxxs);
					//加载到list中
					list.add(card);
					if(codeIds.equals(codeId)&&passwds.equals(passwd)){
						temp=1;
					}
				}
				if(temp==1){
					//编历list中所有的对象，从中确定你是用那条记录登录。
					for(int i=0;i<list.size();i++) {
						CardInfo card=(CardInfo)list.get(i);
							if(card.getCodeId().equals(codeId)) {
								new Gongneng(card,codeId,list,file);
								this.dispose();
							}
					}
				}else{
					JOptionPane.showMessageDialog(null, "登录失败，请检查帐号或密码是否正确！！");
					tcodeId.setText("");
					tpasswd.setText("");
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}finally{
				try{
					in.close();
				}catch(Exception e3){
					e3.printStackTrace();
				}
			}
		}else if(e.getSource()==bzhuce){
			new Zhuce(file);
			this.dispose();
		}
	}
}
