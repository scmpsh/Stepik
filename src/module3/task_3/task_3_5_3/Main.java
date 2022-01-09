package module3.task_3.task_3_5_3;

public class Main {

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {

        Label resultOfAnalyz;

        for (TextAnalyzer analyzer : analyzers) {
            resultOfAnalyz = analyzer.processText(text);
            switch (resultOfAnalyz) {
                case SPAM:
                    return Label.SPAM;
                case NEGATIVE_TEXT:
                    return Label.NEGATIVE_TEXT;
                case TOO_LONG:
                    return Label.TOO_LONG;
                case TOO_MUCH_KEYWORDS:
                    return Label.TOO_MUCH_KEYWORDS;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {

        String[] spamWords = {"spam", "lol", "kek"};
        String[] keywords = {"dude", "hi", "oop"};
        int maxLength = 25;
        int maxNumOfKeywords = 3;

        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(spamWords);
        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(maxLength);
        TooMuchKeywords tooMuchKeywords = new TooMuchKeywords(keywords, maxNumOfKeywords);
        TextAnalyzer[] analyzers = {
//                spamAnalyzer,
//                negativeTextAnalyzer,
//                tooLongTextAnalyzer,
                tooMuchKeywords
        };

        String[] text = new String[] {
                "asdsadajhbkcjhbcjh=(dasdasdasdasd",
                "asdspamadajbadhbkcjhbcjh=(dasdasda spam das baddDJKASDKadkshjkhgchjgchgcvghcgcgvhg",
                "spam:|badsajhdjlkahsldjkhaslkjdhlaskjhkjasdjaskjashdklflsajdf",
                "dudehidudehihidudehi",
                "spam:|badsajhdjlkahsldjkhaslkjdhlaskjhkjasdjaskjashdklflsajdf",
                "I'm OK!"
        };

        int numberOfText = 1;

        for (String currentText : text) {
            System.out.println(numberOfText + ": " + checkLabels(analyzers, currentText));
            numberOfText++;
        }
    }
}
