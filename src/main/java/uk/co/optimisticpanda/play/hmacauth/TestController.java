package uk.co.optimisticpanda.play.hmacauth;

import java.util.Date;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    
	@RequestMapping("/test")
    @ResponseBody
    String home(@AuthenticationPrincipal UserAuth userauth) {
        return "TEST ROOT/ - Hello World!" + new Date().getTime() + ", userauth:" + userauth;
    }
	
	@RequestMapping("/test/aaa")
    @ResponseBody
    String home(UserAuth userauth, @RequestParam("allow") String param) {
        return "TEST ROOT/ aaa - Hello World!" + new Date().getTime() + ", userauth:" + userauth + ", param: " + param;
    }
	
	@RequestMapping("/test/bbb")
    @ResponseBody
    String home(@RequestParam("allow") String param) {
        return "TEST ROOT/ bbb - Hello World!" + new Date().getTime() + ", param: " + param;
    }
}