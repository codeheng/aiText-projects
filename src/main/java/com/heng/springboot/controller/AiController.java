package com.heng.springboot.controller;

import com.heng.springboot.utils.AiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AiController {

    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public String picToWord(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.picToWords(file);
        return res;
    }
}