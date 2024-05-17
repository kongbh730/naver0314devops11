package anno.study.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//xml방식으로 bean 등록
/*
public class Car {
	private String carName;
	private Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public void carInfo()
	{
		System.out.println("자동차명 : " + carName);
		System.out.println("타이어 : " + tire.getTireName());
	}
}
*/

//어노테이션 식으로 bean 등록
/*
@Component //xml에 car로 등록
public class Car {
	@Value("아우디")
	private String carName;
	
	@Autowired//자동으로 찾아서 주입을 시켜줌, 이번에는 tire을 구현한 클래스가 2개이므로
	//private Tire tire;	//자동으로 찾아서 주입시켜줌, 이번에는 Tire를 구현한 클래스가 2개이므로 모호성으로 인해 오류 발생	
	private CanadaTire tire; //이 경우는 정확하게 클래스 명으로 선언을 해야만 오류 발생하지 않음
	
	public void carInfo()
	{
		System.out.println("자동차명 : " + carName);
		System.out.println("타이어 : " + tire.getTireName());
	}
}
*/

//이번에는 tire를 lombok을 이용해서 주입해보자
@Component //xml에 car로 등록
@RequiredArgsConstructor //@NonNull이 붙은 멤버변수만 생성자로 주입됨
public class Car {
	@Value("아우디")
	private String carName;
	
	@NonNull
	private CanadaTire tire; //이 경우는 정확하게 클래스 명으로 선언을 해야만 오류 발생하지 않음
	
	public void carInfo()
	{
		System.out.println("자동차명 : " + carName);
		System.out.println("타이어 : " + tire.getTireName());
	}
}





