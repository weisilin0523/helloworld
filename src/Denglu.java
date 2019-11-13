
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
	super("��½ҳ��");
	p=new JPanel();
	lcodeId=new JLabel("�˺ţ�");
	lpasswd=new JLabel("���룺");
	ldate=new JLabel("��ǰʱ�䣺");
	tcodeId=new JTextField(25);
	tpasswd=new JPasswordField(25);
	bdenglu=new JButton("��½");
	bzhuce=new JButton("ע��");
	p.setLayout(null);
	ldate.setFont(new Font("����",Font.BOLD,12));
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
			//list���ڼ���ע���������Ϣ��ÿһ��ע���¼��һ��CardInfo��Ķ���
			//list������CardInfo��Ķ���
			list=new ArrayList();
			int temp=0;//��Ϊ��ǣ������жϵ�¼�Ƿ�ɹ����ɹ���1
			//ȡ�������е��û���������
			String codeId=tcodeId.getText();
			String passwd=new String(tpasswd.getPassword());
			if(codeId.equals("")||passwd.equals("")){
				JOptionPane.showMessageDialog(null, "�ʺŻ����벻��Ϊ�գ�");
				return;
			}
			try{
				//���ڶ�ȡÿһ����¼
				in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String tempStr="";
				//��ѭ���������ǣ���ע���ÿһ����¼��list�У��жϵ�¼�Ƿ�ɹ�
				while((tempStr=in.readLine())!=null){
					CardInfo card=new CardInfo();
					StringTokenizer sts=new StringTokenizer(tempStr, "|");
					String codeIds=sts.nextToken();
					String passwds=sts.nextToken();
					float moneys=Float.parseFloat(sts.nextToken());
					String qtxxs=sts.nextToken();
					//��ȡ�����������Ϣ���ӵ�CardInfo��Ķ�����
					//card����ע����еĵ�һ����¼
					card.setCodeId(codeIds);
					card.setPasswd(passwds);
					card.setMoney(moneys);
					card.setQtxx(qtxxs);
					//���ص�list��
					list.add(card);
					if(codeIds.equals(codeId)&&passwds.equals(passwd)){
						temp=1;
					}
				}
				if(temp==1){
					//����list�����еĶ��󣬴���ȷ��������������¼��¼��
					for(int i=0;i<list.size();i++) {
						CardInfo card=(CardInfo)list.get(i);
							if(card.getCodeId().equals(codeId)) {
								new Gongneng(card,codeId,list,file);
								this.dispose();
							}
					}
				}else{
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������ʺŻ������Ƿ���ȷ����");
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
