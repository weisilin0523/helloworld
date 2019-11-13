import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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



public class Gongneng extends JFrame implements ActionListener{
	JPanel p,p1,p2;
	JLabel lts,lback;
	JLabel l1,l2,l3,l4,l5,l6,l7;//welcome
	String codeId;
	PrintStream out=null,outs=null;
	BufferedReader in=null;
	float moneys;
	JButton bck,bqk,bye,bzz,bgm,btc;
	CardInfo card;
	File file;
	ArrayList list;
	public Gongneng(CardInfo card,String codeId,ArrayList list,File file){
		super(card.getCodeId()+",��ӭ�����ñ����еĹ�Ա����");
		this.card=card;
		this.codeId=codeId;
		this.list=list;
		this.file=file;
		l1=new JLabel(new ImageIcon("image/AF1.gif"));
		l2=new JLabel(new ImageIcon("image/AF2.gif"));
		l3=new JLabel(new ImageIcon("image/AF3.gif"));
		l4=new JLabel(new ImageIcon("image/AF4.gif"));
		l5=new JLabel(new ImageIcon("image/AF5.gif"));
		l6=new JLabel(new ImageIcon("image/AF6.gif"));
		l7=new JLabel(new ImageIcon("image/AF7.gif"));
		p1=new JPanel();
		p1.setBackground(new Color(055,155,255));
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		
		lback=new JLabel(new ImageIcon("image/TL1.gif"));
		p2=new JPanel();
		p2.add(lback);
		p2.setBackground(new Color(055,155,255));
		
		p=new JPanel();
		p.setLayout(null);
		lts=new JLabel("��ѡ������Ҫ�Ĳ�����ҵ��:");
		lts.setForeground(Color.red);
		
		bye=new JButton("1.��ѯ���");
		bck=new JButton("2. ��      �� ");
		bqk=new JButton("3. ȡ      �� ");
		bzz=new JButton("4. ת      �� ");
		bgm=new JButton("5.�޸�����");
		btc=new JButton("6. ��      �� ");
		
		bye.addActionListener(this);
		bck.addActionListener(this);
		bqk.addActionListener(this);
		bzz.addActionListener(this);
		bgm.addActionListener(this);
		btc.addActionListener(this);
		
		p.setBackground(new Color(055,155,255));
		p.add(p1);
		p1.setBounds(110, 5, 230, 25);
		p.add(lts);
		lts.setBounds(105, 35, 230, 25);
		p.add(p2);
		p2.setBounds(135, 70, 280, 280);
		p.add(bye);
		bye.setBounds(10, 80, 110,50);
		p.add(bck);
		bck.setBounds(10, 175, 110, 50);
		p.add(bqk);
		bqk.setBounds(10, 275, 110, 50);
		p.add(bzz);
		bzz.setBounds(425, 80, 110, 50);
		p.add(bgm);
		bgm.setBounds(425, 175, 110, 50);
		p.add(btc);
		btc.setBounds(425, 275, 110, 50);
		
		this.add(p);
		
		this.setVisible(true);
		this.setSize(550,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bye){
			JOptionPane.showMessageDialog(null, "���ĵ�ǰ�������Ϊ��"+card.getMoney());
		}else if(e.getSource()==bck){
			new ck();
		}else if(e.getSource()==btc) {
			int ch=JOptionPane.showConfirmDialog(null,"��ȷ���˳���","�˳���ʾ",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(ch==0){
				try{
					System.exit(1);
				}catch(Exception ex){}
			}
		}
		else if(e.getSource()==bqk){
			new qk();
		}
		else if(e.getSource()==bzz) {
			new zz();
		}
		else if(e.getSource()==bgm) {
			new gm();
		}
	}
	class  ck extends JFrame implements ActionListener{
		JPanel yep;
		JLabel lck;
		JTextField tmoneys;
		JButton tqr,tfh;
		String moneys;
		public ck(){
			yep=new JPanel();
			yep.setLayout(null);
			lck=new JLabel("���������");
			tmoneys=new JTextField(20);
			tqr=new JButton("ȷ��");
			tfh=new JButton("����");
			tqr.addActionListener(this);
			yep.add(lck);
			lck.setBounds(70, 30, 120, 30);
			yep.add(tmoneys);
			tmoneys.setBounds(70, 65, 120, 30);
			yep.add(tqr);
			tqr.setBounds(85, 105, 80, 30);
			this.add(yep);
			this.setVisible(true);
			this.setSize(260,200);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==tqr){
				try{
					float money=0;
					try {
						money=Float.parseFloat(tmoneys.getText());
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "����������������룡");
						tmoneys.setText("");
						return;
					}
					if(money<=0) {
						JOptionPane.showMessageDialog(null, "���ܴ�С�����Ǯ��");
						tmoneys.setText("");
						return;
					}
					if(tmoneys.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "����Ϊ��");
						//tmoneys.setText("");
						return;
					}
					outs=new PrintStream(new FileOutputStream(file));
					//�޸��˻����
					card.setMoney(card.getMoney()+money);
					//����list�����е�Ԫ��,�ҳ����޸������ļ�¼
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo)list.get(i);
						if(codeId.equals(cards.getCodeId())){
							list.remove(i);
							list.add(i, card);
						}
					}
					//��list�����еļ�¼����д��ע���ļ���
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo)list.get(i);
						outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
						outs.flush();
					}
					JOptionPane.showMessageDialog(null,"���ɹ�");
					this.dispose();
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(outs!=null) {
						outs.close();}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}	
			}
			
		}
	}
	
	class  qk extends JFrame implements ActionListener{

		JPanel yep;
		JLabel lck;
		JTextField qmoneys;
		JButton qqr,qfh;
		String moneys;
		public qk(){
			yep=new JPanel();
			yep.setLayout(null);
			lck=new JLabel("������ȡ���");
			qmoneys=new JTextField(20);
			qqr=new JButton("ȷ��");
			qfh=new JButton("����");
			qqr.addActionListener(this);
			yep.add(lck);
			lck.setBounds(70, 30, 120, 30);
			yep.add(qmoneys);
			qmoneys.setBounds(70, 65, 120, 30);
			yep.add(qqr);
			qqr.setBounds(85, 105, 80, 30);
			this.add(yep);
			this.setVisible(true);
			this.setSize(260,200);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==qqr) {
				try {
					float money;
					try {
					money=Float.parseFloat(qmoneys.getText());
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "����������������룡");
						qmoneys.setText("");
						return;
						}
					if(money<=0) {
						JOptionPane.showMessageDialog(null, "����ȡС�����Ǯ");
						return;
					}
					if(qmoneys.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "����Ϊ��");
						return;
					}
					if(Float.parseFloat(qmoneys.getText())>card.getMoney()) {
						JOptionPane.showMessageDialog(null,"����");
						return;
					}
					outs=new PrintStream(new FileOutputStream(file));
					//�޸��˻����
					card.setMoney(card.getMoney()-money);
					//����list�����е�Ԫ��,�ҳ����޸������ļ�¼
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo) list.get(i);
						if(codeId.equals(cards.getCodeId())){
							list.remove(i);
							list.add(i, card);
						}
					}
					//��list������Ԫ��д���ļ���
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo) list.get(i);
						outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
						outs.flush();
					}
					JOptionPane.showMessageDialog(null,"ȡ��ɹ�");
					this.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try{
						if(outs!=null) {
						outs.close();}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			
		}
		
	}

	class zz extends JFrame implements ActionListener{

		JPanel yep;
		JLabel lck;
		JLabel lzId;
		JTextField zId;
		JTextField zmoneys;
		JButton zqr,qfh;
		String moneys;
		public zz(){
			yep=new JPanel();
			yep.setLayout(null);
			lzId=new JLabel("������ת���û���");
			zId=new JTextField(20);
			lck=new JLabel("������ת�˽�");
			zmoneys=new JTextField(20);
			zqr=new JButton("ȷ��");
			qfh=new JButton("����");
			zqr.addActionListener(this);
			yep.add(lzId);
			lzId.setBounds(90,20,120,30);
			yep.add(zId);
			zId.setBounds(90, 50, 120, 30);
			yep.add(lck);
			lck.setBounds(90, 90, 120, 30);
			yep.add(zmoneys);
			zmoneys.setBounds(90, 125, 120, 30);
			yep.add(zqr);
			zqr.setBounds(105, 165, 80, 30);
			this.add(yep); 
			this.setVisible(true);
			this.setSize(300,250);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==zqr) {
				String zCodeId=zId.getText();
				String zPasswd=null;
				float zMoney = 0;
				String zQtxx=null;
				boolean temp=false;
				try {
					in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					String tempstr="";
					//�ж��Ƿ�����û�
					while ((tempstr=in.readLine())!=null) {
						StringTokenizer str=new StringTokenizer(tempstr,"|");
						String codeIds=str.nextToken();
						if(zCodeId.equals(codeIds)) {
							zPasswd=str.nextToken();
							zMoney=Float.parseFloat(str.nextToken());
							zQtxx=str.nextToken();
							temp=true;
						}
					}
					if(temp==true) {
						//��ת����Ϣȡ��CardInfo��
						CardInfo zCard=new CardInfo();
						zCard.setCodeId(zCodeId);
						zCard.setPasswd(zPasswd);
						zCard.setMoney(zMoney);
						zCard.setQtxx(zQtxx);
						float money;
						try {
							money=Float.parseFloat(zmoneys.getText());
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"������������������룡");
							zmoneys.setText("");
							return;
						}
						if(money<=0) {
							JOptionPane.showMessageDialog(null, "����ȡС�����Ǯ");
							return;
						}
						if(zmoneys.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "����Ϊ��");
							return;
						}
						if(Float.parseFloat(zmoneys.getText())>card.getMoney()) {
							JOptionPane.showMessageDialog(null,"����");
							return;
						}
						outs=new PrintStream(new FileOutputStream(file));
						//�޸��˻����
						card.setMoney(card.getMoney()-money);
						//�޸�ת���˻����
						zCard.setMoney(zCard.getMoney()+money);
						//����list�����е�Ԫ�أ��ҳ����޸ĵ����ļ�¼
						for(int i=0;i<list.size();i++) {
							CardInfo cards=(CardInfo)list.get(i);
							if(zCodeId.equals(cards.getCodeId())) {
								list.remove(i);
								list.add(i, zCard);
							}
						}
						//����list�����е�Ԫ��,�ҳ����޸������ļ�¼
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							if(codeId.equals(cards.getCodeId())){
								list.remove(i);
								list.add(i, card);
							}
						}
						//��list������Ԫ��д���ļ���
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
							outs.flush();
						}
						JOptionPane.showMessageDialog(null,"ת�˳ɹ�");
						
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"ת���û������ڣ�����������");
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						if(outs!=null){
						outs.close();
						}
						if(in!=null) {
						in.close();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}

	class gm extends JFrame implements ActionListener{

		JPanel yep;
		JLabel lck;
		JLabel ljpwd;
		JPasswordField jpwd;
		JPasswordField xpwd;
		JButton gqr,qfh;
		String moneys;
		public gm(){
			yep=new JPanel();
			yep.setLayout(null);
			ljpwd=new JLabel("�����������:");
			jpwd=new JPasswordField(20);
			lck=new JLabel("������������:");
			xpwd=new JPasswordField(20);
			gqr=new JButton("ȷ��");
			qfh=new JButton("����");
			gqr.addActionListener(this);
			yep.add(ljpwd);
			ljpwd.setBounds(90,20,120,30);
			yep.add(jpwd);
			jpwd.setBounds(90, 50, 120, 30);
			yep.add(lck);
			lck.setBounds(90, 90, 120, 30);
			yep.add(xpwd);
			xpwd.setBounds(90, 125, 120, 30);
			yep.add(gqr);
			gqr.setBounds(105, 165, 80, 30);
			this.add(yep); 
			this.setVisible(true);
			this.setSize(300,250);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==gqr) {
				String jpasswd=jpwd.getText();
				if(jpasswd.equals(card.getPasswd())) {
					try {
						String xpasswd=xpwd.getText();
						outs=new PrintStream(new FileOutputStream(file));
						//�޸��˻�����
						card.setPasswd(xpasswd);
						//����list�����е�Ԫ��,�ҳ����޸�������ļ�¼
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							if(codeId.equals(cards.getCodeId())){
								list.remove(i);
								list.add(i, card);
							}
						}
						//��list������Ԫ��д���ļ���
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
							outs.flush();
						}

						JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
						this.dispose();
						
					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}finally {
						try{
							if(outs!=null) {
							outs.close();}
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
					
				
				}else{
					JOptionPane.showMessageDialog(null, "��������ԭ�����벻���");
				}
			}
		}
		
	}
	
}
