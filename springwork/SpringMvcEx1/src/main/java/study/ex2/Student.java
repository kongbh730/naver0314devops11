package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor//final이나 Nonnull이 붙은 멤버 변수만 생성자 주입
@Setter
public class Student {
	private String schoolName;
	
	@NonNull
	MyInfo myInfo;
	
	/*
	public Student(MyInfo info) {
		// TODO Auto-generated constructor stub
		myInfo = info;
	}
	
	//학교명은 setter로 주입
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	*/
	
	public void show()
	{
		System.out.println(myInfo);//toString 호출
		System.out.println("학교명 : " + schoolName);
	}
}
