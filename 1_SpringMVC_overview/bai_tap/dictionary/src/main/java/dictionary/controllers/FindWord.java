package dictionary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FindWord {

    @RequestMapping(value = "/findWord")
    public String findWord(@RequestParam("word") String word, Model model){
        Map<String , String> stringMap = new HashMap<>();
        stringMap.put("dog", "cho");
        stringMap.put("cat","meo");
        stringMap.put("school", "truong hoc");
        stringMap.put("book","sach");
        for (String element: stringMap.keySet()){
            if (word.equals(element)){
                model.addAttribute("result", stringMap.get(element));
                break;
            }
        }
        if (!model.containsAttribute("result")){
            model.addAttribute("result","Khong co tu nay");
        }
        return "result";

    }
}
