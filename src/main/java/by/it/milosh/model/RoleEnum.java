package by.it.milosh.model;

public enum RoleEnum {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    ABONENT("ROLE_ABONENT");

    private String type;

    private RoleEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
