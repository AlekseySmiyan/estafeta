package org.estafeta.directors.user;

import org.estafeta.builders.driver.Builder;
import org.estafeta.components.user.FullName;
import org.estafeta.components.user.FullNameEng;

/**
 * Created by user on 13.05.18.
 */
public class DirectorDriver {

    public void createDriver(Builder builder) {
        builder.setFullName("user1", new FullName());
        builder.setFullNameEng("user1", new FullNameEng());
    }
}
