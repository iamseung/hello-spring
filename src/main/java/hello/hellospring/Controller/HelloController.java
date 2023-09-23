package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("data", "!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // hello ${name}, 문자 그대로 내려감
    }

    /*
    @ResponseBody => Http 의 Body 부의 Data를 직접 넣어주겠다는 의미
        HTTP의 BODY에 문자 내용을 직접 변환
        viewResolver 대신에 HttmpMessageConverter가 동작
        기본 문자처리 : StringHttpMessageConverter
        기본 객체처리 : MappginJackson2HttpMessageConverter
        byte 처리 등등 기타 여러 HttpmessageConverter가 기본으로 등록되어 있음
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 객체생성
    // Property 접근 방식
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
