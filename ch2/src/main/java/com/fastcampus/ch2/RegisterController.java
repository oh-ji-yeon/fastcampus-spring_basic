package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/add", method={RequestMetho.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() { // �ű�ȸ�� ���� ȭ��
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // spring 4.3 ����
	public String save(User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8");
			
//			return "redirect:/register/add?msg="+msg; // URL ���ۼ� (rewriting)
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
			
//			return "forward:/register/add";
		}

		// 2. db�� �ű�ȸ�� ������ ����
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
