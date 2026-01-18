package com.assignment.ai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SummarizeRequest {
    @NotBlank(message = "Text is required")
    @Size(min = 10, max = 10000, message = "Text must be between 10 and 10000 characters")
    private String text;

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}