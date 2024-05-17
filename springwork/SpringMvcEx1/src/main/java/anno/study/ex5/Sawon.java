package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

//@Data
@Component
@Getter
public class Sawon {
	@Value("홍길동")
	private String name;

	@Value("서울시 송파구")
	private String addr;

	@Value("29")
	private int age;
}
