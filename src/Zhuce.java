
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
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Zhuce extends JFrame implements ActionListener{
	JPanel p;
	JTextArea textbz;
	JLabel lcodeId,lpasswd,lsex,ldate,lsr,lyear,lmonth,lday,lah,ldz,lbz,lzs,lbt1,lbt2,lbt3,lbt4;
	JTextField tcodeId,tyear,tdz,tbz;
	JPasswordField tpasswd;
	JRadioButton r1,r2;
	String month[];
	String day[];
	JComboBox cmonth,cday;
	JCheckBox cah1,cah2,cah3;
	JButton btijiao,bfanhui;
	ButtonGroup bg;
	PrintStream out;
	Thread thread1;
	BufferedReader in,fromServer;
	PrintStream toServer;
	Socket clientSocke;
	File file;
	
	public Zhuce(File file){
		super("ע��ҳ��");
		this.file=file;
		//��������
		p=new JPanel();
		lcodeId=new JLabel("�˺ţ�");
		lpasswd=new JLabel("���룺");
		ldate=new JLabel("��ǰʱ�䣺");
		tcodeId=new JTextField(25);
		tpasswd=new JPasswordField(25);
		//�Ա𣨵�ѡ��ť��
		lsex=new JLabel("�Ա�");
		bg=new ButtonGroup();
		r1=new JRadioButton("��",true);
		r2=new JRadioButton("Ů");
		//���գ������б�
		lsr=new JLabel("���գ�");
		lyear=new JLabel("��");
		tyear=new JTextField(10);
		lmonth=new JLabel("��");
		String month[]=new String[12];
		for(int i=0;i<12;i++){
			month[i]=String.valueOf(i+1);
		}
		lday=new JLabel("��");
		String day[]=new String[31];
		for(int i=0;i<31;i++){
			day[i]=String.valueOf(i+1);
		}
		cmonth=new JComboBox(month);
		cday=new JComboBox(day);
		//���ã���ѡ��
		lah=new JLabel("���ã�");
		cah1=new JCheckBox("����");
		cah2=new JCheckBox("����");
		cah3=new JCheckBox("����");
		
		ldz=new JLabel("��ͥ��ַ��");
		tdz=new JTextField();
		
		lbz=new JLabel("����ǩ����");
		textbz=new JTextArea();
		textbz.setLineWrap(true);
		textbz.setRows(5);
		
		lbt1=new JLabel("*");
		lbt2=new JLabel("*");
		lbt3=new JLabel("*");
		lbt4=new JLabel("*");
		lzs=new JLabel("ע����*��Ϊ��д���");
		lzs.setForeground(Color.red);
		
		btijiao=new JButton("�ύ");
		bfanhui=new JButton("����");
		
		p.setLayout(null);
		ldate.setFont(new Font("����",Font.BOLD,12));
		ldate.setForeground(Color.blue);
		Datethread thread1=new Datethread(ldate);
		thread1.start();
		
		btijiao.addActionListener(this);
		bfanhui.addActionListener(this);
		
		p.add(lcodeId);
		lcodeId.setBounds(35, 30, 80, 25);
		p.add(tcodeId);
		tcodeId.setBounds(80, 30, 180, 25);
		p.add(lbt1);
		lbt1.setBounds(300, 30, 180, 25);
		p.add(lpasswd);
		lpasswd.setBounds(35, 65, 80, 25);
		p.add(tpasswd);
		tpasswd.setBounds(80, 65, 180, 25);
		p.add(lbt2);
		lbt2.setBounds(300, 65, 180, 25);
		p.add(lsex);
		lsex.setBounds(35, 100, 80, 25);
		bg.add(r1);
		bg.add(r2);
		p.add(r1);
		r1.setBounds(80, 102, 50, 20);
		p.add(r2);
		r2.setBounds(150, 102, 50, 20);
		p.add(lsr);
		lsr.setBounds(35,127,80,25);
		p.add(tyear);
		tyear.setBounds(80, 127, 35, 25);
		p.add(lyear);
		lyear.setBounds(120, 127, 20, 25);
		p.add(cmonth);
		cmonth.setBounds(145, 127, 45, 25);
		p.add(lmonth);
		lmonth.setBounds(195, 127, 20, 25);
		p.add(cday);
		cday.setBounds(220, 127, 45, 25);
		p.add(lday);
		lday.setBounds(270, 127, 20, 25);
		p.add(lbt3);
		lbt3.setBounds(300, 127, 180, 25);
		p.add(lah);
		lah.setBounds(30, 160, 70, 25);
		p.add(cah1);
		cah1.setBounds(30, 185, 80, 25);
		p.add(cah2);
		cah2.setBounds(120, 185, 80, 25);
		p.add(cah3);
		cah3.setBounds(210, 185, 80, 25);
		p.add(ldz);
		ldz.setBounds(30, 210, 70, 25);
		p.add(tdz);
		tdz.setBounds(30, 240, 250, 25);
		p.add(lbz);
		p.add(lbt4);
		lbt4.setBounds(300, 240, 180, 25);
		lbz.setBounds(30, 270, 70, 25);
		p.add(textbz);
		textbz.setBounds(30, 300, 270, 100);
		
		p.add(btijiao);
		btijiao.setBounds(80, 420, 75, 25);
		p.add(bfanhui);
		bfanhui.setBounds(165, 420, 75, 25);
		p.add(lzs);
		lzs.setBounds(160, 455, 160, 25);
		p.add(ldate);
		ldate.setBounds(140, 480, 160, 25);		
		
		this.add(p);
		this.setVisible(true);
		this.setSize(320,540);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bfanhui){
			new Denglu();
			this.dispose();
		}
		if(e.getSource()==btijiao){
			String codeId=tcodeId.getText();
			String passwd=new String(tpasswd.getPassword());
			String sex="";
			if(r1.isSelected()){
				sex=r1.getText();
			}else{
				sex=r2.getText();
			}
			String year=tyear.getText()+"��";
			String month=cmonth.getSelectedItem().toString()+"��";
			String day=cday.getSelectedItem().toString()+"��";
			String sr=year+month+day;
			String ah="";
			if(cah1.isSelected()){
				ah+=cah1.getText();
			}
			if(cah2.isSelected()){
				ah+=cah2.getText();
			}
			if(cah3.isSelected()){
				ah+=cah3.getText();
			}
			String dz=tdz.getText();
			String bz=textbz.getText().trim();
			
			String grzl=codeId+"|"+passwd+"|"+"10"+"|"+sex+"&"+sr+"&"+ah+"&"+dz+"&"+bz;
			
			if(codeId.equals("")){
				JOptionPane.showMessageDialog(null, "�ʺŲ���Ϊ��!!");
				return;
			}else if(passwd.equals("")){
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��!!");
				return;
			}else if(sex.equals("")){
				JOptionPane.showMessageDialog(null, "�Ա���Ϊ��!!");
				return;
			}else if(year.equals("��")){
				JOptionPane.showMessageDialog(null, "���ղ���Ϊ��!!");
				return;
			}else if(dz.equals("")){
				JOptionPane.showMessageDialog(null, "��ַ����Ϊ��!!");
				return;
			}
			try{
				//�����������ڶ�ȡע����Ϣ�����ж��Ƿ�����ͬ���˺�
				in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				//дע����Ϣ���ļ���
				out=new PrintStream(new FileOutputStream(file,true));
				int temp=0;//������ǣ�
				String strs="";//�Ƕ�ȡ��һ����¼
				while((strs=in.readLine())!=null){
					//���������ַ����������
					StringTokenizer st1=new StringTokenizer(strs, "|");
					
					String codeIds=st1.nextToken();
					if(codeIds.equals(codeId)){
						JOptionPane.showMessageDialog(null, "���ʺ���ע��,����������");
						tcodeId.setText("");
						tpasswd.setText("");
						return;
					}
				}
				out.println(grzl);
				out.flush();
				JOptionPane.showMessageDialog(null, "ע��ɹ������Ŀ������Ϊ��10Ԫ����");
				new Denglu();
				this.dispose();
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					out.close();
					in.close();
				}catch(Exception es){}
			}
		}
	}
}
	


