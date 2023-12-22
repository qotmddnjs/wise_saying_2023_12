package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;// app클래스에서만 쓸수있는 정수만 들어갈수잇는 system_status변수에 1을 넣는다//
	// 시스템 실행시 while반복문에서 명령어를 "무한"반복해서 자동으로 출력하기위해?스위치 케이스 문에서 종료 종료입력시 break로
	// 빠져나오기위해?이란값을줘서 빠져나오기위해?//관리하기 편하게 하기위해

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController();//시스템 컨트롤러만 들어갈수있는 변수에 시스템 컨트롤러 객체만듬
		WiseSayingController wiseSayingController = new WiseSayingController();//와이즈 세잉 컨트롤러만 들어갈수잇는 변수에 객체 와이즈 세잉 컨트롤러 넣어줌

		while (system_status == 1) {//반복문 와일문을 이용해 반복되는 명령어를 출력하기 위해 정수만 들어갈수잇는 시스템 스테이터스 변수에 1이란 값을줘서 반복문을 만들었다.
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();//문자열만 들어갈수있는 cmd변수를 만들고 컨테이너에서 만 쓸수있는 스캐너를 get해온다그리고 다은줄로 넘어갈수있게 넥스트 라인과 앞뒤 공백을 커버해주는 trim을 넣어준다
			Rq rq = new Rq(cmd);

			switch (rq.getActionCode()) {
			case "종료":
				systemController.exit();//systemController.exit(); 는 종료입력시 시스템 컨트롤러 클래스exit 출력문 ==명언 앱 종료== 가 출력된다
				system_status = 0;
				break;//system_status = 0;은 브레이크시 와일문으로 돌아갔을떄 1이 아니게 되어서 앱이 끝나게된다종 시스템이 끝날수있게 정수만 들어가는 시스템 스테이터스 변수를 이용해 브레이크 시켜준다
			case "등록"://등록 목록 삭제 수정 입력시 wisesayingcontrooler클래스에있는 기능들에 맞게 출력된다
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			default: 
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}