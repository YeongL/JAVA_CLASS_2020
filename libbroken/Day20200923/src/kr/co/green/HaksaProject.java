package kr.co.green;

import java.util.Scanner;

class Student{
	String name;
	String age;
	String hakbun;
	public void printStudent(){

		System.out.println("나이: " + age);

		System.out.println("이름: " + name);

		System.out.println("학번: " + hakbun);

	}

}

class Professor{
	String name;
	String age;
	String classname;
	public void printProfessor(){

		System.out.println("나이: " + age);

		System.out.println("이름: " + name);

		System.out.println("과목: " + classname);

	}

}

class Manager{
	String name;
	String age;
	String area;
	public void printManager(){

		System.out.println("나이: " + age);

		System.out.println("이름: " + name);

		System.out.println("부서: " + area);

	}

}


public class HaksaProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Student s;
		s = new Student();
		
		Professor p;
		p = new Professor();
		
		Manager m;
		m = new Manager();
		
		
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
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String hakbun = input.next();
					s.age = age;
					s.name = name;
					s.hakbun = hakbun;
				}//학생
				else if(cnt==2) //교수
				{
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String classname = input.next();
					p.age = age;
					p.name = name;
					p.classname = classname;
				}//교수
				else if(cnt==3) //관리자
				{
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("부서: ");
					String area = input.next();
					m.age = age;
					m.name = name;
					m.area = area;
				}//관리자
				else if(cnt==4) //이전메뉴
				{

					continue;
				}//이전메뉴

			}//등록
			else if(number==2) //찾기
			{
				System.out.println("찾을 이름을 입력해주세요.");
				System.out.print("이름: ");
				String name = input.next();
				if(name.equals(s.name))
				{
					s.printStudent();
				}
				else if(name.equals(p.name))
				{
					p.printProfessor();
				}
				else if(name.equals(m.name))
				{
					m.printManager();
				}
				else
				{
					System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
					
				}
			}//찾기
			else if(number==3) //삭제
			{
				System.out.println("삭제할 이름을 입력해주세요.");
				System.out.print("이름: ");
				String name = input.next();
				if(name.equals(s.name))
				{
					s = new Student();
				}
				else if(name.equals(p.name))
				{
					p = new Professor();
				}
				else if(name.equals(m.name))
				{
					m = new Manager();
				}
				else
				{
					System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
					
				}
				
				System.out.println(name+"님을 삭제 하였습니다.");
				
			}//삭제
			else if(number==4) //전체출력
			{
				s.printStudent();
				p.printProfessor();
				m.printManager();
				
			}//전체출력
			else if(number==0) //종료
			{

				System.out.println("프로그램을 종료합니다.");

				System.exit(0);

			}//종료

		}//반복문의끝
	}

}
