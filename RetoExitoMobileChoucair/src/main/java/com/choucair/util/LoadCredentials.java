package com.choucair.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoadCredentials {

    public static List<String> getCredentials() throws IOException {
        List<String> credentials = new ArrayList<>();
        Properties p = new Properties();
        p.load(new FileInputStream(new File("src/test/resources/file.properties")));
        credentials.add(p.getProperty("USER"));
        credentials.add(p.getProperty("PASSWORD"));
        return credentials;
    }
}
