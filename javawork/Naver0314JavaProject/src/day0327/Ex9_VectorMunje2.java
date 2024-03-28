package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 * 강사님 풀이참고
 */

public class Ex9_VectorMunje2
{
	static Scanner sc = new Scanner(System.in);
	List<StudentDto> info = new Vector<>();//StudentDto객체를 담을 벡터
	static final String FILENAME = "c:/naver0314/studentsInfo.txt";

	//디폴트 생성자 //생성과 동시에 파일을 연다.
	public Ex9_VectorMunje2() 
	{
		//파일오픈
		readFile();//처음 객체 생성시 무조건 파일 읽어서 list에 담기
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
			//System.out.println("숫자로 입력하세요");

			//만약 문자가 입력되면 무조건 전체출력을 해보기
			menu = 3;
		}

		return menu;
	}

	//파일 읽어오기
	public void readFile()
	{
		FileReader fr = null;//파일 읽기
		BufferedReader br = null;//줄단위로 읽기

		try 
		{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			//읽어올 학생정보가 존재할 때 
			while(true)
			{
				String str = br.readLine();//한 줄씩 읽기//readLine에서 예외 발생 가능 => catch
				if(str == null)//더 이상 읽을 문자열이 없을 경우
				{
					break;
				}
				//한줄씩 읽어오기
				String []data = str.split(",");
				StudentDto dto = new StudentDto();
				dto.setName(data[0]);
				dto.setAge(Integer.parseInt(data[1]));
				dto.setJava(Integer.parseInt(data[2]));
				dto.setSpring(Integer.parseInt(data[3]));
				dto.setHtml(Integer.parseInt(data[4]));

				//info에 추가 //static vector
				info.add(dto);
			}
			System.out.println("총 " + info.size() + "명의 정보를 읽어왔어요!!");
		} 
		catch(FileNotFoundException e)//파일이 없을 경우
		{
			System.out.println("읽어올 학생 정보가 없습니다.");
			System.out.println("존재하지 않는 파일 혹은 파일경로입니다.");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//어쨌건 닫을거임
			//if로 처리하던가, try_catch하던가
			try 
			{
				br.close();
				fr.close();
			} 
			catch (NullPointerException | IOException e)//열리지 않아서 닫을것도 없음
			{
				//e.printStackTrace();
			}
			/*
			catch (IOException e)//닫기전에 예외 발생 
			{
				e.printStackTrace();
			}
			 */
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
			if(fw != null)
			{
				try 
				{
					fw.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
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

		System.out.print("학생 이름을 입력하세요 > ");
		name = sc.nextLine();
		System.out.print("나이를 입력하세요 > ");
		try 
		{
			age = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException e) 
		{
			//만약 문자가 입력시 무조건 나이는 0으로 주기
			age = 0;
		}

		System.out.print("java 성적을 입력하세요 > ");
		try 
		{
			java = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException e) 
		{
			//만약 문자가 입력시 무조건 나이는 0으로 주기
			java = 0;
		}
		System.out.print("spring 성적을 입력하세요 > ");
		try 
		{
			spring = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException e) 
		{
			//만약 문자가 입력시 무조건 나이는 0으로 주기
			spring = 0;
		}
		System.out.print("html 성적을 입력하세요 > ");
		try 
		{
			html = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException e) 
		{
			//만약 문자가 입력시 무조건 나이는 0으로 주기
			html = 0;
		}
		//입력된 정보를 바탕으로 새로운 객체를 생성
		StudentDto dto = new StudentDto(name, age, java, spring, html);
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
		
		//한명 이상을 삭제할 경우 size가 바뀌기 때문에 while 또는 마지막부터 인덱스부터 시작해야 한다.
		for(int i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			if(dto.getName().equals(name))
			{
				f = true;
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
	public void printAllStudent()//writeStudent()
	{
		int i;

		System.out.println("\t전체 멤버 명단 출력\n");
		System.out.println("번호\t이름\t나이\tjava\tspring\thtml\t총점\t평균\t등급");
		System.out.println("=".repeat(80));
		//평균은 소숫점 한자리로 출력해본다.
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);//소숫점 아래 한자리
		
		for(i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
//			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
//					(i + 1), dto.getName(), dto.getAge(), dto.getJava(), 
//					dto.getSpring(), dto.getHtml(), dto.getTotal(), dto.getAvg(), dto.getGrade());
			//println으로 출력
			System.out.println((i + 1) + "\t" + 
					dto.getName() + "\t" +
					dto.getAge() + "\t" +
					dto.getJava() + "\t"+
					dto.getSpring() + "\t" + 
					dto.getHtml() + "\t" + 
					dto.getTotal() + "\t" + 
					nf.format(dto.getAvg()) + "\t" +
					dto.getGrade());
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
		double avg = Double.parseDouble(sc.nextLine());
		
		System.out.println(avg + "점 이상인 멤버 명단 출력");
		System.out.println("번호\t이름\t나이\tjava\tspring\thtml\t총점\t평균\t등급");
		System.out.println("=".repeat(80));
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);//소숫점 아래 1자리
		
		for(i = 0; i < info.size(); i++)
		{
			StudentDto dto = info.get(i);
			if(avg <= dto.getAvg())
			{
				f = true;
//				System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", 
//						(i + 1), dto.getName(), dto.getAge(),
//						dto.getJava(), dto.getSpring(), dto.getHtml(), 
//						dto.getTotal(), dto.getAvg(), dto.getGrade());
				System.out.println((i + 1) + "\t" + 
						dto.getName() + "\t" +
						dto.getAge() + "\t" +
						dto.getJava() + "\t"+
						dto.getSpring() + "\t" + 
						dto.getHtml() + "\t" + 
						dto.getTotal() + "\t" + 
						nf.format(dto.getAvg()) + "\t" +
						dto.getGrade());
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
		
		//NumberFormat 안쓰고 출력해보기
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
		Ex9_VectorMunje2 ex = new Ex9_VectorMunje2();
		int selection;

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
				sc.close();
				System.out.println("프로그램을 저장 후 종료합니다.");
				System.exit(0);
			default:
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
}