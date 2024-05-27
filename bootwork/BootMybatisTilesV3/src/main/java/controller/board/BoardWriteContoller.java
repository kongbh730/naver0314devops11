package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.service.ReBoardService;

@Controller
public class BoardWriteContoller {
	@Autowired
	private ReBoardService boardService;
}
