package org.estafeta.users;

import org.estafeta.components.user.FullName;
import org.estafeta.components.user.FullNameEng;

/**
 * Created by Aleksey Smiyan on 13.05.18.
 */
public class UserDriverNew {

    private FullName fullName;
    private FullNameEng fullNameEng;

    public UserDriverNew (FullName fullName, FullNameEng fullNameEng) {
        this.fullName = fullName;
        this.fullNameEng = fullNameEng;
    }

    public String getLastName() {
        return fullName.getLastName();
    }

    public String getFirstName() {
        return fullName.getFirstName();
    }

    public String getSecondName() {
        return fullName.getSecondName();
    }

    public String getLastNameEng() {
        return fullNameEng.getLastNameEng();
    }

    public String getFirstNameEng() {
        return fullNameEng.getFirstNameEng();
    }

    public String getSecondNameEng() {
        return fullNameEng.getSecondNameEng();
    }

    @Override
    public String toString() {
        return "FullName: " + getLastName() + " " + getFirstName() + " " + getSecondName()
                + "\nFullNameEnglish: " + getLastNameEng() + " " + getFirstNameEng() + " " + getSecondNameEng();
    }
}
