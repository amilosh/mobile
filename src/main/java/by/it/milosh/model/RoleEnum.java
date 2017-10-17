package by.it.milosh.model;

public enum RoleEnum {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    ABONENT("ROLE_ABONENT");

    private String name;

    private RoleEnum(String type) {
        this.name = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
