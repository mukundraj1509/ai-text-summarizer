package com.assignment.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {
    private final WebClient webClient;
    private final String model;

    public OpenAiService(@Value("${openai.api.url}") String apiUrl,
                        @Value("${openai.api.key}") String apiKey,
                        @Value("${openai.model}") String model) {
        this.model = model;
        this.webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String summarizeText(String text) {
        try {
            Thread.sleep(1000); // Add 1 second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Map<String, Object> request = Map.of(
            "model", model,
            "messages", List.of(Map.of("role", "user", "content", "Summarize: " + text)),
            "max_tokens", 150
        );

        Map<String, Object> response = webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        return (String) message.get("content");
    }
}