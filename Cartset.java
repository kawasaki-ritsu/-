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
		return ("���i�R�[�h�F"+code+"�@���i��:"+name+"�@����:"+kazu+"�@�P��:"+tanka+String.format("�@���z:\\%,3d",(tanka*kazu)));
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
			Cart cart =new Cart();//�C���X�^���X����
			System.out.print("���������𑱂��܂����Hy/n:");
			String q = kbd.nextLine();
			if(q.equals("y")){
				System.out.print("���i�R�[�h��");
				cart.setCode(kbd.nextLine());

				System.out.print("���i����");
				cart.setName(kbd.nextLine());

				System.out.print("����");
				int kazu = kbd.nextInt();
				cart.setKazu(kazu);

				System.out.print("�P����");
				int tanka = kbd.nextInt();
				cart.setTanka(tanka);

				ary1.add(cart);

				kbd.nextLine();

			}else if(q.equals("n")){
				System.out.println("------------������������------------");
				if(ary1.size() == 0){
					System.out.println("�������������͋�ł�");
				}else{
					for(int i = 0;i<ary1.size();i++){
						System.out.println((i+1)+")"+ary1.get(i));
					}
				}System.out.printf("���ݎ���:%tY�N %tm��%td�� %tH��%tM��%tS�b\n",c,c,c,c,c,c,c);

				while(true){

					System.out.print("�������m��,������܂����Hbuy/cancel:");
					String a = kbd.nextLine();
					if(a.equals("buy")){
						System.out.print(ary1.size()+"�_�������グ���肪�Ƃ��������܂���");
						break;
					}else if(a.equals("cancel")){
						ary1.clear();
						System.out.print("�����̓L�����Z������܂���");
						break;
					}else{
						System.out.println("�L���R�[�h���Ԉ���Ă��܂�");
					}
				}break;
			}else{
				System.out.println("�L���R�[�h���Ԉ���Ă��܂�");
			}
		}
	}
}