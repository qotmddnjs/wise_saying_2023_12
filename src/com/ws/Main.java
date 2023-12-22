package com.ws;

public class Main {//실행
	public static void main(String[] args) {
		
		Container.init();
		
		new App().run(); //실행 입력시 앱 클래스로 이동

		Container.close();
	}
}