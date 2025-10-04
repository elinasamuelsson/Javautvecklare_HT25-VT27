package examinationsprojekt.models;

public enum transactionTypes {
    //earning
    SALARY("Salary"),
    GIFT("Gift"),
    OTHER_EARNING("Miscellaneous income"),

    //spending
    HOUSING("Housing"),
    FOOD("Food"),
    HEALTH("Health"),
    TRANSPORT("Transport"),
    EDUCATION("Education"),
    SHOPPING("Shopping"),
    OTHER_SPENDING("Miscellaneous spending"),
    ;

    private final String typeDescription;

    transactionTypes(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}