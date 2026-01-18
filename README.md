# AI Text Summarizer

Spring Boot application with OpenAI GPT-3.5-turbo integration for text summarization.

## AI Service Used
**OpenAI GPT-3.5-turbo** - Real integration with OpenAI's Chat Completions API.

## Setup

1. **Set OpenAI API Key**
   ```bash
   export OPENAI_API_KEY=your-actual-openai-api-key
   ```

2. **Run**
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### POST `/api/ai/summarize`
```json
{
  "text": "Your text to summarize (10-10000 chars)"
}
```

**Response:**
```json
{
  "originalText": "Your text...",
  "summary": "AI summary"
}
```

### GET `/api/ai/health`
Returns: `AI Text Summarizer is running`

## Sample Request
```bash
curl -X POST http://localhost:8080/api/ai/summarize \
  -H "Content-Type: application/json" \
  -d '{"text": "Artificial intelligence (AI) is intelligence demonstrated by machines..."}'
```