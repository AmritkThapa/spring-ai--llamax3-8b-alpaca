package com.llamax3.spring_ai_llamax3_8b_alpaca.controller;

import com.llamax3.spring_ai_llamax3_8b_alpaca.model.TranslateModel;
import com.llamax3.spring_ai_llamax3_8b_alpaca.model.TranslatedResultResponse;
import com.llamax3.spring_ai_llamax3_8b_alpaca.service.LlamaAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AIController {

    @Autowired
    private LlamaAiService aiService;

    @PostMapping("/translate")
    public TranslatedResultResponse generate(@RequestBody TranslateModel translateModel) {
        return aiService.generateResult(translateModel);
    }
}
