public enum RomanNumeral {
    I("I", 1), II("II", 2),
    III("III", 3), IV("IV", 4),
    V("V", 5), VI("VI", 6),
    VII("VII", 7), VIII("VIII", 8),
    IX("IX", 9), X("X", 10);

    private String romanKey;
    private int romanValue;

    RomanNumeral(String romanKey,int romanValue){
        this.romanKey = romanKey;
        this.romanValue = romanValue;
    }
    public String getRomanKey(){
        return this.romanKey;
    }
    public int getRomanValue(){
        return this.romanValue;
    }
}
