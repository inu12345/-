import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class MyFrame extends JFrame
{
	JLabel jlMsg;
	JPanel jpChild2;
	BufferedImage biMonster;
	JLabel jlChild;
	
	public MyFrame() throws IOException
	{
		File file = new File("vx_chara08_a.png");	//ファイルを開く
		biMonster = ImageIO.read(file);		//画像読み込む
		
		setBounds(20, 40, 940, 540);	// フレーム設定
		setDefaultCloseOperation(EXIT_ON_CLOSE);//  閉じるボタン有効化
	add(createBasePanel());	//	親パネルを作成し、フレームに貼り付け
		setVisible(true);		//  フレームを表示状態へ
		
	enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);	//  キー入力の有効化
	}
	
	protected void processKeyEvent(KeyEvent e)
	{
		if(e.getID() == KeyEvent.KEY_PRESSED)
		{
			System.out.println("キー"+e.getKeyCode()+"が押されたよ");
			
			if(e.getKeyCode() == KeyEvent.VK_1)
			{
				jlMsg.setText("ボスに勝利しました。");
			}
			if(e.getKeyCode() == KeyEvent.VK_2)
			{
				jpChild2.removeAll();
				addMonster();
			}			
			if(e.getKeyCode()==java.awt.event.KeyEvent.VK_3)
			{
				jlMsg.setText("宿屋で休みました");
			}			
		}
	}
	
	/*
	 * 基盤パネルを作成
	 */
	JPanel createBasePanel() throws IOException
	{
		JPanel jp = MyLib.createPanel(Color.BLACK);
		
		//フォントを作成
		Font 	f = new Font(Font.MONOSPACED,
				Font.BOLD,
				40);

		//  レイアウト１行目
		//	パネルを作成し、親パネルに貼り付け
		JPanel jpChild = MyLib.createPanel(Color.BLUE);
		jp.add(jpChild);
		
		//	ラベルを作成し、子パネルに貼り付け
		jlChild = new JLabel(Player.getStatusString());
		jlChild.setFont(f);
		jlChild.setForeground(Color.WHITE);
		jlChild.setPreferredSize(new java.awt.Dimension(900, 60));
		jpChild.add(jlChild);
		
		//  レイアウト２行目
		//	パネルを作成し、親パネルに貼り付け
		jpChild2 = MyLib.createPanel(Color.CYAN);
		jp.add(jpChild2);


		//  選択肢をパネルに貼り付け
		JLabel jlMain = new JLabel("<html>1. ボスを倒しに行く<br>2. 修行する<br>3. 宿屋に泊まる");
		jlMain.setFont(f);
		jpChild2.add(jlMain);

		//  区切り線
		JPanel jpHR = MyLib.createPanel(Color.WHITE);
		jpHR.setPreferredSize(new java.awt.Dimension(900, 4));
		jp.add(jpHR);
		
		//  レイアウト３行目		
		//	ラベルを作成し、親パネルに貼り付け
		jlMsg = new JLabel("レベルを上げてボスを倒しましょう");
		jlMsg.setFont(f);
		jlMsg.setForeground(new Color(255, 128, 0));
		jp.add(jlMsg);		
		return(jp);
	}
	
		/*
		 * モンスターをパネルに追加。
		 */
		void addMonster()
		{
			java.util.Random  r = new java.util.Random();
			//  敵出現
			int e = r.nextInt(6)+1;
			

			int cw = 32;											//セルサイズ・幅
			int ch = 48;											//セルサイズ・高さ
			int sw = cw*4;											//表示サイズ・幅
			int sh = ch*4;											//表示サイズ・高さ

			for(int i=0; i<e; i=i+1){
		MyLib.putMonster(jpChild2, biMonster, 0, 0, cw, ch, sw, sh);	//モンスター　0-0 表示
			}
		//	HPを減らす
			int	d = r.nextInt( 8 );
			Player.hp -= d;
			if( Player.hp < 0 ){
			    Player.hp = 0;
			}

		// レベル上昇
		Player.lv += e;

		String s =
		"<html>敵が " + e + " 匹、現れた。<br>"+
		Player.name + "は" + d + "のダメージを受けた<br>";
			
	if( Player.hp == 0 ){
		s+="GAME OVER";

	}else{
		s+="レベルが" + Player.lv + "になった";

	//	putCommand();
			}

		//　メッセージ表示
	jlMsg.setText(s);

	jlChild.setText(Player.getStatusString());
	
	}
		
}
