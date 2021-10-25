package quotes;
public class Quotes {
    private String author;
    private String text;
//that what im said like tamplte :
    //there is a get and set for author ,
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        //here the qoute after u get the text :
        String qoute ="Today's Quote: " +
                "Quote: " + text +
                "author: " + author ;
        return qoute ;
    }
}