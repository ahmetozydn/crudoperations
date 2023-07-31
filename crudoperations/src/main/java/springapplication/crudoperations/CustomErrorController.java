package springapplication.crudoperations;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*@RestController // restfull API
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError() {
        return "Oops! Something went wrong. Please try again later.";
    }
    @GetMapping("/") // runs in every start
    public String getErrorPath() {
        return "redgfh";
    }

    @GetMapping("/products") // runs in every start
    public String get() {
        return "prtdfg";
    }
}*/

