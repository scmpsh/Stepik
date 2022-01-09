package module3.task_3.task_3_5_3;

public class TooMuchKeywords extends KeywordAnalyzer {

    private String[] keywords;
    private int maxNumOfKeywords;

    public TooMuchKeywords(String[] keywords, int maxNumOfKeywords) {
        this.keywords = keywords;
        this.maxNumOfKeywords = maxNumOfKeywords;
    }

    @Override
    public Label processText(String text) {

        for (String keyword : getKeywords()) {
            if (text.toLowerCase().split(keyword.toLowerCase(), -1).length - 1 > maxNumOfKeywords) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return this.keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.TOO_MUCH_KEYWORDS;
    }
}
