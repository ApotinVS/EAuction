package kz.epam.EAuction.manager;

/**
 * Created by Вит on 25.10.2016.
 */
public enum AttributesEnum {
    SING_UP("singup"),
    USER_SERVICE("userService"),
    ADMIN("admin"),
    USER_NAME("userName"),
    USER_ENTER("userEnter"),
    WELCOME("welcome"),
    ERROR_MESSAGE("errorMessage");


    private final String text;

    /**
     * @param text
     * @return
     */
    private AttributesEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

