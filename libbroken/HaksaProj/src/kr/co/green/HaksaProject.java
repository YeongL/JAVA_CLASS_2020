package kr.co.green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class HaksaProject {

	public static void main(String[] args) {
		
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String,String>>();
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		
		while(true) //�ݺ�������
		{
			System.out.println("======�޴�����========");
			System.out.println("1.���");
			System.out.println("2.ã��");
			System.out.println("3.����");
			System.out.println("4.��ü���");
			System.out.println("------------------");
			System.out.println("0.����");
			System.out.println("��ȣ�� ������ �ּ���..");
			int number = input.nextInt();

			if(number==1)//��� 
			{
				System.out.println("=====�޴�����=====");
				System.out.println("1.�л�");
				System.out.println("2.����");
				System.out.println("3.������");
				System.out.println("4.�����޴�");
				System.out.println("��ȣ�� ������ �ּ���..");

				int cnt = input.nextInt();

				if(cnt==1) //�л�
				{
					HashMap<String,String> studentHash = new HashMap<String,String>();
					System.out.print("����: ");
					String age = input.next();
					System.out.print("�̸�: ");
					String name = input.next();
					System.out.print("�й�: ");
					String hakbun = input.next();
					studentHash.put("����",age);
					studentHash.put("�̸�",name);
					studentHash.put("�й�",hakbun);
					studentHash.put("����","1");
					haksaList.add(studentHash);
					
				}//�л�
				else if(cnt==2) //����
				{
					HashMap<String,String> professorHash = new HashMap<String,String>();
					System.out.print("����: ");
					String age = input.next();
					System.out.print("�̸�: ");
					String name = input.next();
					System.out.print("�й�: ");
					String classname = input.next();
					professorHash.put("����",age);
					professorHash.put("�̸�",name);
					professorHash.put("����",classname);
					professorHash.put("����","2");
					haksaList.add(professorHash);
				}//����
				else if(cnt==3) //������
				{
					HashMap<String,String> managerHash = new HashMap<String,String>();
					System.out.print("����: ");
					String age = input.next();
					System.out.print("�̸�: ");
					String name = input.next();
					System.out.print("�μ�: ");
					String area = input.next();
					managerHash.put("����",age);
					managerHash.put("�̸�",name);
					managerHash.put("�μ�",area);
					managerHash.put("����","3");
					haksaList.add(managerHash);
				}//������
				else if(cnt==4) //�����޴�
				{

					continue;
				}//�����޴�

			}//���
			else if(number==2) //ã��
			{
				HashMap<String,String> findName;
				System.out.println("ã�� �̸��� �Է����ּ���.");
				System.out.print("�̸�: ");
				String name = input.next();
				
				for(int i=0;i<haksaList.size();i++)
				{
					findName = (HashMap<String,String>)haksaList.get(i);
					if(findName.get("����") == "1") {
						if(name.equals(findName.get("�̸�")))
						{
							System.out.println("����:"+findName.get("����"));
							System.out.println("�̸�:"+findName.get("�̸�"));
							System.out.println("�й�:"+findName.get("�й�"));
						}
					}
					else if(findName.get("����") == "2")
					{
						if(name.equals(findName.get("�̸�")))
						{
							System.out.println("����:"+findName.get("����"));
							System.out.println("�̸�:"+findName.get("�̸�"));
							System.out.println("����:"+findName.get("����"));
						}
					}
					else if(findName.get("����") == "3")
					{
						if(name.equals(findName.get("�̸�")))
						{
							System.out.println("����:"+findName.get("����"));
							System.out.println("�̸�:"+findName.get("�̸�"));
							System.out.println("�μ�:"+findName.get("�μ�"));
						}
					}
					
				}
				
			}//ã��
			else if(number==3) //����
			{
				System.out.println("������ �̸��� �Է����ּ���.");
				System.out.print("�̸�: ");
				String name = input.next();
				HashMap<String,String> deleteName;
				for(int i=0;i<haksaList.size();i++)
				{
					deleteName = (HashMap<String,String>)haksaList.get(i);
					if(name.equals(deleteName.get("name")))
					{
						haksaList.remove(deleteName);
					}
					
				}
				
				System.out.println(name+"���� ���� �Ͽ����ϴ�.");
				
			}//����
			else if(number==4) //��ü���
			{
				HashMap<String,String> printAll;
				for(int i=0;i<haksaList.size();i++)
				{
					printAll = (HashMap<String,String>)haksaList.get(i);
					if(printAll.get("����") == "1") {
						System.out.println("����:"+printAll.get("����"));
						System.out.println("�̸�:"+printAll.get("�̸�"));
						System.out.println("�й�:"+printAll.get("�й�"));
						
					}
					else if(printAll.get("����") == "2")
					{
						System.out.println("����:"+printAll.get("����"));
						System.out.println("�̸�:"+printAll.get("�̸�"));
						System.out.println("����:"+printAll.get("����"));
						
					}
					else if(printAll.get("����") == "3")
					{
						System.out.println("����:"+printAll.get("����"));
						System.out.println("�̸�:"+printAll.get("�̸�"));
						System.out.println("�μ�:"+printAll.get("�μ�"));
						
					}
					
				}
				
			}//��ü���
			else if(number==0) //����
			{

				System.out.println("���α׷��� �����մϴ�.");

				System.exit(0);

			}//����

		}//�ݺ����ǳ�
	}

}
