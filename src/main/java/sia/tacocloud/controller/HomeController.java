package sia.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Orlov Diga
 */
@Controller
public class HomeController {

    @GetMapping("/")  /*Обрабатывает запросы корневого пути */
    public String home() {
        return "home";  /*Возвращает имя представления*/
    }
}
