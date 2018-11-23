package mypack;

public enum ControlButtonsEnum {

    STOP (0, "START", false),
    SLOWER (1, "FASTER", false),
    FURTHER (2, "CLOSER", false),
    CLEAR (3, "CLEAR", true),
    EXIT (4,"EXIT", true);

    private int value;
    private Boolean nonSwitchBool;
    private String falseText;

    ControlButtonsEnum (int value1, String falseText1, Boolean bool1){
        this.value = value1;
        this.falseText = falseText1;
        this.nonSwitchBool = bool1;
    }

    public int getValue(){
        return value;
    }

    public String getFalseText() {
        return falseText;
    }

    public Boolean getNonSwitchBool(){
        return nonSwitchBool;
    }
}
