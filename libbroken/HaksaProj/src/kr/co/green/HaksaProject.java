package kr.co.green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class HaksaProject {

	public static void main(String[] args) {
		
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String,String>>();
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		
		while(true) //반복문시작
		{
			System.out.println("======메뉴선택========");
			System.out.println("1.등록");
			System.out.println("2.찾기");
			System.out.println("3.삭제");
			System.out.println("4.전체출력");
			System.out.println("------------------");
			System.out.println("0.종료");
			System.out.println("번호를 선택해 주세요..");
			int number = input.nextInt();

			if(number==1)//등록 
			{
				System.out.println("=====메뉴선택=====");
				System.out.println("1.학생");
				System.out.println("2.교수");
				System.out.println("3.관리자");
				System.out.println("4.이전메뉴");
				System.out.println("번호를 선택해 주세요..");

				int cnt = input.nextInt();

				if(cnt==1) //학생
				{
					HashMap<String,String> studentHash = new HashMap<String,String>();
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String hakbun = input.next();
					studentHash.put("나이",age);
					studentHash.put("이름",name);
					studentHash.put("학번",hakbun);
					studentHash.put("구분","1");
					haksaList.add(studentHash);
					
				}//학생
				else if(cnt==2) //교수
				{
					HashMap<String,String> professorHash = new HashMap<String,String>();
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String classname = input.next();
					professorHash.put("나이",age);
					professorHash.put("이름",name);
					professorHash.put("과목",classname);
					professorHash.put("구분","2");
					haksaList.add(professorHash);
				}//교수
				else if(cnt==3) //관리자
				{
					HashMap<String,String> managerHash = new HashMap<String,String>();
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("부서: ");
					String area = input.next();
					managerHash.put("나이",age);
					managerHash.put("이름",name);
					managerHash.put("부서",area);
					managerHash.put("구분","3");
					haksaList.add(managerHash);
				}//관리자
				else if(cnt==4) //이전메뉴
				{

					continue;
				}//이전메뉴

			}//등록
			else if(number==2) //찾기
			{
				HashMap<String,String> findName;
				System.out.println("찾을 이름을 입력해주세요.");
				System.out.print("이름: ");
				String name = input.next();
				
				for(int i=0;i<haksaList.size();i++)
				{
					findName = (HashMap<String,String>)haksaList.get(i);
					if(findName.get("구분") == "1") {
						if(name.equals(findName.get("이름")))
						{
							System.out.println("나이:"+findName.get("나이"));
							System.out.println("이름:"+findName.get("이름"));
							System.out.println("학번:"+findName.get("학번"));
						}
					}
					else if(findName.get("구분") == "2")
					{
						if(name.equals(findName.get("이름")))
						{
							System.out.println("나이:"+findName.get("나이"));
							System.out.println("이름:"+findName.get("이름"));
							System.out.println("과목:"+findName.get("과목"));
						}
					}
					else if(findName.get("구분") == "3")
					{
						if(name.equals(findName.get("이름")))
						{
							System.out.println("나이:"+findName.get("나이"));
							System.out.println("이름:"+findName.get("이름"));
							System.out.println("부서:"+findName.get("부서"));
						}
					}
					
				}
				
			}//찾기
			else if(number==3) //삭제
			{
				System.out.println("삭제할 이름을 입력해주세요.");
				System.out.print("이름: ");
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
				
				System.out.println(name+"님을 삭제 하였습니다.");
				
			}//삭제
			else if(number==4) //전체출력
			{
				HashMap<String,String> printAll;
				for(int i=0;i<haksaList.size();i++)
				{
					printAll = (HashMap<String,String>)haksaList.get(i);
					if(printAll.get("구분") == "1") {
						System.out.println("나이:"+printAll.get("나이"));
						System.out.println("이름:"+printAll.get("이름"));
						System.out.println("학번:"+printAll.get("학번"));
						
					}
					else if(printAll.get("구분") == "2")
					{
						System.out.println("나이:"+printAll.get("나이"));
						System.out.println("이름:"+printAll.get("이름"));
						System.out.println("과목:"+printAll.get("과목"));
						
					}
					else if(printAll.get("구분") == "3")
					{
						System.out.println("나이:"+printAll.get("나이"));
						System.out.println("이름:"+printAll.get("이름"));
						System.out.println("부서:"+printAll.get("부서"));
						
					}
					
				}
				
			}//전체출력
			else if(number==0) //종료
			{

				System.out.println("프로그램을 종료합니다.");

				System.exit(0);

			}//종료

		}//반복문의끝
	}

}
