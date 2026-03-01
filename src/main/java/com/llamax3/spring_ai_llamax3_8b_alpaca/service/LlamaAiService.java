package com.llamax3.spring_ai_llamax3_8b_alpaca.service;

import com.llamax3.spring_ai_llamax3_8b_alpaca.model.TranslateModel;
import com.llamax3.spring_ai_llamax3_8b_alpaca.model.TranslatedResultResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;

@Service
public class LlamaAiService {

    @Autowired
    private OllamaChatModel chatModel;


    public TranslatedResultResponse generateResult(TranslateModel translateModel){
        String prompt = translateModel.getText();
        String template = Prompt_template(prompt, "English", "Nepali");
        ChatResponse response = chatModel.call(
                new Prompt(
                        template,
                        OllamaOptions.create()
                                .withModel("mannix/llamax3-8b-alpaca")
                ));
        TranslatedResultResponse translatedResultResponse = new TranslatedResultResponse();
        translatedResultResponse.setTranslatedText(response.getResult().getOutput().getContent());
        return translatedResultResponse;
    }

    private String Prompt_template(String query, String srcLanguage, String trgLanguage) {
        String instruction = "Translate the following sentences from " + srcLanguage + " to " + trgLanguage + ".";
        String prompt = "Below is an instruction that describes a task, paired with an input that provides further context. "
                + "Write a response that appropriately completes the request.\n"
                + "### Instruction:\n" + instruction + "\n"
                + "### Input:\n" + query + "\n### Response:";
        return prompt;
    }
}
