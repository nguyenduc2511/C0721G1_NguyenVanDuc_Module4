package transfer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import transfer.service.CalculatorService;

@Controller
public class Transfer {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/transfer")
    public String transfer(@RequestParam("usa") double money, @RequestParam("rate") double rate , Model model){
        model.addAttribute("moneyVND", calculatorService.getMoney(money, rate));
        return "result";
    }

}
