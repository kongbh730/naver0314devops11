package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component//첫글자가 소문자로 koreaTire가 아이디가 됨
public class KoreaTire implements Tire {
	@Override
	public String getTireName() {
		return "한국타이어";
	}
}
