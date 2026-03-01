package com.llamax3.controller;

import com.llamax3.model.TranslateModel;
import com.llamax3.model.TranslatedResultResponse;
import com.llamax3.service.LlamaAiService;
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
