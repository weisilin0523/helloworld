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
		super(card.getCodeId()+",欢迎您是用本银行的柜员机！");
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
		lts=new JLabel("请选择您需要的操作的业务:");
		lts.setForeground(Color.red);
		
		bye=new JButton("1.查询余额");
		bck=new JButton("2. 存      款 ");
		bqk=new JButton("3. 取      款 ");
		bzz=new JButton("4. 转      账 ");
		bgm=new JButton("5.修改密码");
		btc=new JButton("6. 退      出 ");
		
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
			JOptionPane.showMessageDialog(null, "您的当前可用余额为："+card.getMoney());
		}else if(e.getSource()==bck){
			new ck();
		}else if(e.getSource()==btc) {
			int ch=JOptionPane.showConfirmDialog(null,"你确定退出吗？","退出提示",
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
			lck=new JLabel("请输入存款金额：");
			tmoneys=new JTextField(20);
			tqr=new JButton("确认");
			tfh=new JButton("返回");
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
						JOptionPane.showMessageDialog(null, "输入错误，请重新输入！");
						tmoneys.setText("");
						return;
					}
					if(money<=0) {
						JOptionPane.showMessageDialog(null, "不能存小于零的钱。");
						tmoneys.setText("");
						return;
					}
					if(tmoneys.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "不能为空");
						//tmoneys.setText("");
						return;
					}
					outs=new PrintStream(new FileOutputStream(file));
					//修改账户余额
					card.setMoney(card.getMoney()+money);
					//编历list中所有的元素,找出你修改了余额的记录
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo)list.get(i);
						if(codeId.equals(cards.getCodeId())){
							list.remove(i);
							list.add(i, card);
						}
					}
					//把list中所有的记录重新写到注册文件中
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo)list.get(i);
						outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
						outs.flush();
					}
					JOptionPane.showMessageDialog(null,"存款成功");
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
			lck=new JLabel("请输入取款金额：");
			qmoneys=new JTextField(20);
			qqr=new JButton("确认");
			qfh=new JButton("返回");
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
						JOptionPane.showMessageDialog(null, "输入错误，请重新输入！");
						qmoneys.setText("");
						return;
						}
					if(money<=0) {
						JOptionPane.showMessageDialog(null, "不能取小于零的钱");
						return;
					}
					if(qmoneys.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "不能为空");
						return;
					}
					if(Float.parseFloat(qmoneys.getText())>card.getMoney()) {
						JOptionPane.showMessageDialog(null,"余额不足");
						return;
					}
					outs=new PrintStream(new FileOutputStream(file));
					//修改账户余额
					card.setMoney(card.getMoney()-money);
					//编历list中所有的元素,找出你修改了余额的记录
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo) list.get(i);
						if(codeId.equals(cards.getCodeId())){
							list.remove(i);
							list.add(i, card);
						}
					}
					//把list中所有元素写入文件中
					for(int i=0;i<list.size();i++){
						CardInfo cards=(CardInfo) list.get(i);
						outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
						outs.flush();
					}
					JOptionPane.showMessageDialog(null,"取款成功");
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
			lzId=new JLabel("请输入转账用户：");
			zId=new JTextField(20);
			lck=new JLabel("请输入转账金额：");
			zmoneys=new JTextField(20);
			zqr=new JButton("确认");
			qfh=new JButton("返回");
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
					//判断是否存在用户
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
						//把转账信息取到CardInfo中
						CardInfo zCard=new CardInfo();
						zCard.setCodeId(zCodeId);
						zCard.setPasswd(zPasswd);
						zCard.setMoney(zMoney);
						zCard.setQtxx(zQtxx);
						float money;
						try {
							money=Float.parseFloat(zmoneys.getText());
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"输入金额错误，请重新输入！");
							zmoneys.setText("");
							return;
						}
						if(money<=0) {
							JOptionPane.showMessageDialog(null, "不能取小于零的钱");
							return;
						}
						if(zmoneys.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "金额不能为空");
							return;
						}
						if(Float.parseFloat(zmoneys.getText())>card.getMoney()) {
							JOptionPane.showMessageDialog(null,"余额不足");
							return;
						}
						outs=new PrintStream(new FileOutputStream(file));
						//修改账户余额
						card.setMoney(card.getMoney()-money);
						//修改转账账户余额
						zCard.setMoney(zCard.getMoney()+money);
						//遍历list中所有的元素，找出你修改的余额的记录
						for(int i=0;i<list.size();i++) {
							CardInfo cards=(CardInfo)list.get(i);
							if(zCodeId.equals(cards.getCodeId())) {
								list.remove(i);
								list.add(i, zCard);
							}
						}
						//编历list中所有的元素,找出你修改了余额的记录
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							if(codeId.equals(cards.getCodeId())){
								list.remove(i);
								list.add(i, card);
							}
						}
						//把list中所有元素写入文件中
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
							outs.flush();
						}
						JOptionPane.showMessageDialog(null,"转账成功");
						
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"转账用户不存在，请重新输入");
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
			ljpwd=new JLabel("请输入旧密码:");
			jpwd=new JPasswordField(20);
			lck=new JLabel("请输入新密码:");
			xpwd=new JPasswordField(20);
			gqr=new JButton("确认");
			qfh=new JButton("返回");
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
						//修改账户密码
						card.setPasswd(xpasswd);
						//编历list中所有的元素,找出你修改了密码的记录
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							if(codeId.equals(cards.getCodeId())){
								list.remove(i);
								list.add(i, card);
							}
						}
						//把list中所有元素写入文件中
						for(int i=0;i<list.size();i++){
							CardInfo cards=(CardInfo) list.get(i);
							outs.println(cards.getCodeId()+"|"+cards.getPasswd()+"|"+cards.getMoney()+"|"+cards.getQtxx());
							outs.flush();
						}

						JOptionPane.showMessageDialog(null,"修改成功");
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
					JOptionPane.showMessageDialog(null, "旧密码与原来密码不相等");
				}
			}
		}
		
	}
	
}
