package org.estafeta.builders.driver;

import org.estafeta.components.user.FullName;
import org.estafeta.components.user.FullNameEng;
import org.estafeta.users.UserDriverNew;
import org.estafeta.utils.ExcelReader;
import org.estafeta.utils.PropertiesReader;

import java.io.File;

/**
 * Created by Aleksey Smiyan on 13.05.18.
 */
public class UserDriverBuilder implements Builder{

    private FullName fullName;
    private FullNameEng fullNameEng;
    private ExcelReader excel = new ExcelReader(new File(PropertiesReader.getProperties("drivers.excel")), "sheet1");

    @Override
    public void setFullName(String user, FullName fullName) {
        this.fullName = fullName;
        fullName.setLastName(excel.readCellValue(user, "lastName"))
                .setFirstName(excel.readCellValue(user, "firstName"))
                .setSecondName(excel.readCellValue(user, "secondName"));
    }

    @Override
    public void setFullNameEng(String user, FullNameEng fullNameEng) {
        this.fullNameEng = fullNameEng;
        fullNameEng.setLastNameEng(excel.readCellValue(user, "englishLastName"))
                   .setFirstNameEng(excel.readCellValue(user, "englishFirstName"))
                   .setSecondNameEng(excel.readCellValue(user, "englishSecondName"));
    }

    public UserDriverNew getUserDriver() {
        return new UserDriverNew(fullName, fullNameEng);
    }
}
