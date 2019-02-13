public class Player
{
	static String name = "ああああ";
	static int lv = 30;		//レベル
	static int hp = 30;		//HP
	static double gold=50;		//所持金
	
	public static String getStatusString()
	{
		return("  "+name + " LV" + lv + "  HP" + hp + "  "+gold+"G");
	}
	
}
