package com.assignment.ai.controller;

import com.assignment.ai.dto.SummarizeRequest;
import com.assignment.ai.dto.SummarizeResponse;
import com.assignment.ai.service.OpenAiService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class TextSummarizerController {
    private final OpenAiService openAiService;

    public TextSummarizerController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/summarize")
    public SummarizeResponse summarizeText(@Valid @RequestBody SummarizeRequest request) {
        String summary = openAiService.summarizeText(request.getText());
        return new SummarizeResponse(request.getText(), summary);
    }

    @GetMapping("/health")
    public String health() {
        return "AI Text Summarizer is running";
    }
}