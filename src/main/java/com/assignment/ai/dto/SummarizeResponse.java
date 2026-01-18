package com.assignment.ai.dto;

public class SummarizeResponse {
    private String originalText;
    private String summary;

    public SummarizeResponse(String originalText, String summary) {
        this.originalText = originalText;
        this.summary = summary;
    }

    public String getOriginalText() { return originalText; }
    public String getSummary() { return summary; }
}