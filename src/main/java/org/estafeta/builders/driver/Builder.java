package org.estafeta.builders.driver;

import org.estafeta.components.user.FullName;
import org.estafeta.components.user.FullNameEng;

/**
 * Created by driver on 13.05.18.
 */
public interface Builder {

    public void setFullName(String user, FullName fullName);
    public void setFullNameEng(String user, FullNameEng fullNameEng);
}
