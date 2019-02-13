public class Console
{
/**
	 * 	最初の表示
	 */
	public static void putJyosyou()
	{
		put("レベルを上げてボスを倒しましょう。");
		putStatus();
	}

	public static void putStatus()
	{		
	put("---------------------------------------");
	put(Player.getStatusString());
	put("---------------------------------------");			}

	
	
	/**
	 * ゲームオーバー表示
	 */
	public static void putGameOver()
	{	put(Player.name + "は敗れました");
			put("GAME OVER");
	}
	
	/**
	 * ゲームクリア表示
	 */
	public static void putGameClear()
	{	
		String s0 =Player.name + "はボスを倒しました！";
		put(s0);
		
		System.out.print("レベル" + Player.lv);
		
		if( Player.lv > 250 ){
			put("だったので弱すぎました。");
		}else if( Player.lv > 120){
			put("だったので弱すぎました。");
		}else if( Player.lv > 80){
			put("だったので余裕でした。");
		}else if( Player.lv > 50){
			put("でしたが倒せました。");
		}else{
			put("だったので苦戦しました。");
		}
		put("GAME　CLEAR!");
	}

	public static void put(String str)
	{		
		System.out.println(str);
		}
}
