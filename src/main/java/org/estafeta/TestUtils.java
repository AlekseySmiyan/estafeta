package org.estafeta;

import org.estafeta.builders.driver.UserDriverBuilder;
import org.estafeta.directors.user.DirectorDriver;

/**
 * Created by Aleksey Smiyan on 12.05.18.
 */
public class TestUtils {
    public static void main(String[] args) {
        DirectorDriver directorDriver = new DirectorDriver();
        UserDriverBuilder userDriverBuilder = new UserDriverBuilder();
        directorDriver.createDriver(userDriverBuilder);
        System.out.println(userDriverBuilder.getUserDriver());
    }
}
