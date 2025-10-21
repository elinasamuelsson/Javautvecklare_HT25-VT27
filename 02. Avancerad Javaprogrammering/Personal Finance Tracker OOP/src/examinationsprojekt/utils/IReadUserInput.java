package examinationsprojekt.utils;

public interface IReadUserInput {
    public default String stringInput() {
        return "";
    };
    public default double doubleInput() {
        return 0;
    };
}
