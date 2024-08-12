package enums;

public enum Gender {
    MALE("optionsRadios5"),
    FEMALE("optionsRadios6");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getLocator() {
        return this.name;
    }
}


