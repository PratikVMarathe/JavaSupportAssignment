import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX: Expected validation failure. Log at WARN instead of printing a stack trace.
                logger.warn("Validation failed: document is null");
                return null;
            }

            String content = doc.extractContent();

            if (content.isEmpty()) {
                // FIX: Expected validation failure. Log at WARN instead of printing a stack trace.
                logger.warn("Validation failed: empty document content");
                return null;
            }

            return runValidationRules(content);

        } catch (Exception e) {
            // FIX: Log unexpected runtime errors using SLF4J instead of printStackTrace().
            logger.error("Unexpected error during document validation", e);
            return null;
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException when validation fails.
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: Log unexpected batch processing errors instead of silently swallowing them.
                logger.error("Unexpected error while validating document in batch", e);
            }
        }
    }
}
