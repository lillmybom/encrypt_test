package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:addctx2.xml");
		ChangePasswordService cps =
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword("abc@abc.com", "0x1.9ae7c5013fe8cp-3", "123");
			System.out.println("암호를 변경하였습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인하세요");
		}
	}
}
