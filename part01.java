public class part01
{
	public static void main(String[] args) throws java.io.IOException
	{
		Console.putJyosyou();	//	最初の部分表示

		putCommand();	//	コマンドを表示
		
		if( Player.hp == 0 ){
		return;
		}

		// ボスを倒しに行く
		if (Player.lv < 40){		//	レベル40未満の場合
			Console.putGameOver();	//	ゲームオーバーの表示
		}else{				//	レベルが40以上の場合
			Console.putGameClear();	//	ゲームクリアの画面を表
		}
	}

	// コマンドを表示
	public static void putCommand() throws java.io.IOException
	{
		Console.put("1.ボスを倒しに行く");
		Console.put("2.修行に行く");
		Console.put("3.宿屋に泊まる");
		
		switch( inputCommand() ){	
		case '1':{	//	1.ボスを倒しに行く
			Console.put("ボスが現れた！");
			break;
		}
		case '2':{	//	2.修行をする
			syugyou();
			break;
		}
		case '3':{	// 宿屋に泊まる
		if(Player.gold>=10){
		Player.hp = Player.lv;
		Player.gold -= 10;
		}
		
		Console.putStatus();
		putCommand();
		break;
			}
		}
	}
	
			/**
	 * 	修行する
	 */
	public static void syugyou() throws java.io.IOException
			{
			java.util.Random	r = new java.util.Random();

			//	敵出現
			int	e = r.nextInt( 10 )+1;	// 敵の数
			Console.put("敵が"+ e +"匹、現れた");

			String m ="(^o^)";
			String s ="";
			
			for(int i = 0; i<e; i=i+1){
				s=s+m;
			}
	/*
			int	i = 0;
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
			if( i < e ){	s = s+m;	i=i+1;}
	*/
			Console.put(s);
	/*	
			String s = "(^o^)";	
			switch( e ){
				case 1:{put(s);break;}
				case 2:{put(s+s);break;}
				case 3:{put(s+s+s);break;}
				case 4:{put(s+s+s+s);break;}
				case 5:{put(s+s+s+s+s);break;}
				case 6:{put(s+s+s+s+s+s);break;}
						}
	*/
			//	HPを減らす
			int	d = r.nextInt( 8 );
			Player.hp -= d;
			if( Player.hp < 0 ){
			    Player.hp = 0;
			}
		Console.put(Player.name + "は" + d + "のダメージを受けた");
		// レベル上昇
		Player.lv += e;
			
			Console.put("レベルが" + Player.lv + "になった");
			Console.putStatus();
			Console.put("HPが" + Player.hp + "になった");
			if( Player.hp == 0 ){
			Console.put("GAME OVER");
			}else{
			putCommand();
			}	
	}
	public static int inputCommand() throws java.io.IOException
	{
		int	c = System.in.read();
		if( c == 10){return( inputCommand() );}if( c == 13){ 
		return( inputCommand() );
		}
		return(c);
	}
	
	
}
