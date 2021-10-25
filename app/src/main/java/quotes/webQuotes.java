package quotes;

public class webQuotes {
    private String quoteText;
    private String quoteAuthor;

    public webQuotes(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    @Override
    public String toString() {
        return "Today's Quote:{" +
                "Quote:'" + quoteText + '\'' +
                ", author:'" + quoteAuthor + '\'' +
                '}';
    }
}