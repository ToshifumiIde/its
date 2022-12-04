package com.example.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
        // src/main/resources/templates/以下がルートに設定される。
        // SpringMVCがファイルの拡張子を自動で補完して検索してくれる。
        // これによりファイルの拡張子に依存しないファイル設定が可能となる。
    }
}
