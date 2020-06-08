package pl.wsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
	@RequestMapping("api/swagger")
	public String get() {
		return "redirect:/swagger-ui.html";
	}
}