package org.estafeta.components.user;

/**
 * Created by Aleksey Smiyan on 13.05.18.
 */
public class FullName {

    private String lastName;
    private String firstName;
    private String secondName;

    public String getLastName() {
        return lastName;
    }

    public FullName setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public FullName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public FullName setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }
}
