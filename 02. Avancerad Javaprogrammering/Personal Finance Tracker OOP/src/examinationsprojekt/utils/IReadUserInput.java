package examinationsprojekt.utils;

public interface IReadUserInput {
    default String stringInput() {
        return "";
    }

    ;

    default double doubleInput() {
        return 0;
    }

    ;

    default int intInput() {
        return 0;
    }
}
