package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/*
 * 1. 학생정보 추가 : 이름 나이 3과목 점수 입력
 * 2. 학생정보 삭제 : 이름으로 찾아서 삭제 : 없으면 메세지 출력
 * 3. 전체 출력 : 번호, 이름, Java, Spring, Html, 총점, 평균, 등급 출력
 * 4. 평균으로 검색 : 평균값을 입력하면 그 평균값 이상의 학생들만 출력//90입력하면 90이상만 출력
 * 5. 이름으로 검색 : 입력한 이름을 포함하고 있으면 출력 : (contains)는 true, false로 반환됨
 * 6. 저장 후 종료
 */

public class Ex9_VectorMunje 
{
	static Scanner sc = new Scanner(System.in);
	Vector<StudentDto> info = new Vector<>();//StudentDto객체를 담을 벡터
	static final String FILENAME = "c:/naver0314/studentsInfo.txt";

	//디폴트 생성자 //생성과 동시에 파일을 연다.
	public Ex9_VectorMunje() 
	{
		//파일오픈
		readFile();
	}

	public int getMenu()
	{
		int menu = 0;
		System.out.println("1. 학생정보 추가\n2. 학생정보 삭제\n3. 전체 출력\n4. 평균으로 검색\n5. 이름으로 검색\n6. 저장 후 종료");
		System.out.println("=".repeat(80));
		System.out.print("메뉴 입력 > ");

		try 
		{
			menu = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException e) //숫자만 입력받아야 하는데 문자열로 입력된 경우 예외
		{
			System.out.println("숫자로 입력하세요");
		}

		return menu;
	}

	//파일 읽어오기
	public void readFile()
	{
		FileReader fr = null;
		BufferedReader br = null;

		try 
		{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while(true)
			{
				String str = br.readLine();//한 줄씩 읽기
				if(str == null)//더 이상 읽을 문자열이 없을 경우
				{
					break;
				}
				//한줄씩 읽어오기
				String []a = str.split(",");
				StudentDto dto = new StudentDto();
				dto.setName(a[0]);
				dto.setAge(Integer.parseInt(a[1]));
				dto.setJava(Integer.parseInt(a[2]));
				dto.setSpring(Integer.parseInt(a[3]));
				dto.setHtml(Integer.parseInt(a[4]));
				info.add(dto);
			}
			System.out.println("총 " + info.size() + "명의 정보를 읽어왔어요!!");
		} 
		catch(FileNotFoundException e)//파일이 없을 경우
		{
			System.out.println("존재하지 않는 파일 혹은 파일경로입니다.");
		}
		catch (IOException e) //파일은 있는데 읽어들이는데 예외발생
		{
			e.printStackTrace();
		}
		finally
		{
			//어쨌건 닫을거임
			try 
			{
				br.close();
				fr.close();
			} 
			catch (NullPointerException e)//열리지 않아서 닫을것도 없음
			{
				e.printStackTrace();
			}
			catch (IOException e)//닫기전에 예외 발생 
			{
				e.printStackTrace();
			}
		}
	}

	//파일 저장하기
	public void saveFile()
	{
		FileWriter fw = null;
		try 
		{
			fw = new FileWriter(FILENAME);
			for(StudentDto dto : info)
			{
				String s = dto.getName()+ "," +
						dto.getAge()+ "," +
						dto.getJava()+ "," +
						dto.getSpring()+ "," +
						dto.getHtml()+ "\n";
				fw.write(s);
			}
			System.out.println("총 " + info.size() + "명의 정보를 파일에 저장했습니다.");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fw.close();
			}
			catch(IOException | NullPointerException e)
			{
				e.printStackTrace();
			}
		}
	}

	//학생정보 추가
	public void addStudent()
	{
		String name;
		int age;
		int java;
		int spring;
		int html;

		System.out.print("이름을 입력하세요 > ");
		name = sc.nextLine();
		System.out.print("나이를 입력하세요 > ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("java 성적을 입력하세요 > ");
		java = Integer.parseInt(sc.nextLine());
		System.out.print("spring 성적을 입력하세요 > ");
		spring = Integer.parseInt(sc.nextLine());
		System.out.print("html 성적을 입력하세요 > ");
		html = Integer.parseInt(sc.nextLine());
		//입력된 정보를 바탕으로 새로운 객체를 생성
		StudentDto dto = new StudentDto(name, age, java, spring, html);//
		info.add(dto);
		System.out.println(info.size() + "번째 학생의 정보를 추가하였습니다.");
		System.out.println("=".repeat(80));

		return;
	}

	//학생정보 삭제
	public void deleteStudent()
	{
		boolean f = false;
		System.out.print("삭제할 학생의 이름을 입력해주세요 > ");
		String name = sc.nextLine();
		
		for(int i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			if(dto.getName().equals(name))
			{
				f = true;
				//삭제
				info.remove(i);
				break;
			}
		}
		if(f)
		{
			System.out.println(name + " 학생의 정보를 삭제하였습니다.");
		}
		else
		{
			System.out.println(name + " 학생은 명단에 없습니다.");
		}
		System.out.println("=".repeat(80));

		return;
	}

	//전체출력
	public void printAllStudent()
	{
		int i;

		System.out.println("\t전체 멤버 명단 출력\n");
		System.out.println("번호\t이름\t나이\tjava\tspring\thtml\t총점\t평균\t등급");
		System.out.println("=".repeat(80));
		for(i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
					(i + 1), dto.getName(), dto.getAge(), dto.getJava(), 
					dto.getSpring(), dto.getHtml(), dto.getTotal(), dto.getAvg(), dto.getGrade());
			//			System.out.println((i + 1) + "\t" + 
			//					dto.getName() + "\t" +
			//					dto.getAge() + "\t" +
			//					dto.getJava() + "\t"+
			//					dto.getSpring() + "\t" + 
			//					dto.getHtml() + "\t" + 
			//					dto.getTotal() + "\t" + 
			//					dto.getAvg() + "\t" +
			//					dto.getGrade());
		}
		System.out.println("=".repeat(80));

		return;
	}

	//평균으로 검색
	public void searchWithAvg()
	{
		int i;
		boolean f = false;

		System.out.print("평균점수를 입력하세요 > ");
		double avg = Integer.parseInt(sc.nextLine());
		System.out.println(avg + "점 이상인 멤버 명단 출력");
		System.out.println("번호\t이름\t나이\tjava\tspring\thtml\t총점\t평균\t등급");
		System.out.println("=".repeat(80));
		for(i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			if(avg <= dto.getAvg())
			{
				f = true;
				System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
						(i + 1), dto.getName(), dto.getAge(),
						dto.getJava(), dto.getSpring(), dto.getHtml(), 
						dto.getTotal(), dto.getAvg(), dto.getGrade());
			}
		}
		if(!f)
		{
			System.out.println(avg + "점 이상인 학생은 없습니다.");
		}
		System.out.println("=".repeat(80));

		return;
	}

	//이름으로 검색
	public void searchWithName()
	{
		int i;
		boolean f = false;

		System.out.print("찾고 싶은 이름 또는 포함된 글자를 입력하세요 > ");
		String partialName = sc.nextLine();
		System.out.println(partialName + "이 이름에 포함된 멤버 명단 출력");
		System.out.println("번호\t이름\t나이\tjava\tspring\thtml\t총점\t평균\t등급");
		System.out.println("=".repeat(80));
		for(i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			if(dto.getName().contains(partialName))
			{
				f = true;
				System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
						(i + 1), dto.getName(), dto.getAge(),
						dto.getJava(), dto.getSpring(), dto.getHtml(), 
						dto.getTotal(), dto.getAvg(), dto.getGrade());
			}
		}
		if(!f)
		{
			System.out.println("\"" + partialName + "\"이 이름에 포함된 학생은 없습니다.");
		}
		System.out.println("=".repeat(80));

		return;
	}

	public static void main(String[] args) 
	{
		Ex9_VectorMunje ex = new Ex9_VectorMunje();
		int selection;

		Loop:
			while(true)
			{
				selection = ex.getMenu();
				switch(selection)
				{
				case 1: //학생정보 추가
					ex.addStudent();
					break;
				case 2: //학생정보 삭제
					ex.deleteStudent();
					break;
				case 3: //전체 출력
					ex.printAllStudent();
					break;
				case 4: //평균으로 검색
					ex.searchWithAvg();
					break;
				case 5://이름으로 검색
					ex.searchWithName();
					break;
				case 6://저장 후 종료
					ex.saveFile();
					break Loop;
				default:
					System.out.println("없는 메뉴입니다.");
				}
			}

		System.out.println("프로그램을 저장 후 종료합니다.");
		sc.close();
	}
}