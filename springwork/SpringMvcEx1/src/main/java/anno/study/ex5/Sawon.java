package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

//@Data
@Component
@Getter
public class Sawon {
	@Value("ȫ�浿")
	private String name;

	@Value("����� ���ı�")
	private String addr;

	@Value("29")
	private int age;
}
