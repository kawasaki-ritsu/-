import java.util.*;

import java.io.*;

class Cart implements Serializable
{
	private String name;
	private String code;
	private int kazu;
	private int tanka;

	public Cart() {;}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setKazu(int kazu)
	{
		this.kazu = kazu;
	}

	public int getKazu()
	{
		return kazu;
	}

	public void setTanka(int tanka)
	{
		this.tanka = tanka;
	}

	public int getTanka()
	{
		return tanka;
	}



	public String toString(){
		return ("商品コード："+code+"　商品名:"+name+"　数量:"+kazu+"　単価:"+tanka+String.format("　金額:\\%,3d",(tanka*kazu)));
	}

}

public class Cartset

{
	public static void main(String[] args)
	{
		Date c = new Date();

		ArrayList<Cart> ary1 = new ArrayList<Cart>();


		Scanner kbd = new Scanner(System.in);
		while(true){
			Cart cart =new Cart();//インスタンス生成
			System.out.print("お買い物を続けますか？y/n:");
			String q = kbd.nextLine();
			if(q.equals("y")){
				System.out.print("商品コード＝");
				cart.setCode(kbd.nextLine());

				System.out.print("商品名＝");
				cart.setName(kbd.nextLine());

				System.out.print("個数＝");
				int kazu = kbd.nextInt();
				cart.setKazu(kazu);

				System.out.print("単価＝");
				int tanka = kbd.nextInt();
				cart.setTanka(tanka);

				ary1.add(cart);

				kbd.nextLine();

			}else if(q.equals("n")){
				System.out.println("------------お買い物かご------------");
				if(ary1.size() == 0){
					System.out.println("お買い物かごは空です");
				}else{
					for(int i = 0;i<ary1.size();i++){
						System.out.println((i+1)+")"+ary1.get(i));
					}
				}System.out.printf("現在時刻:%tY年 %tm月%td日 %tH時%tM分%tS秒\n",c,c,c,c,c,c,c);

				while(true){

					System.out.print("注文を確定,取消しますか？buy/cancel:");
					String a = kbd.nextLine();
					if(a.equals("buy")){
						System.out.print(ary1.size()+"点お買い上げありがとうございました");
						break;
					}else if(a.equals("cancel")){
						ary1.clear();
						System.out.print("注文はキャンセルされました");
						break;
					}else{
						System.out.println("記入コードが間違っています");
					}
				}break;
			}else{
				System.out.println("記入コードが間違っています");
			}
		}
	}
}