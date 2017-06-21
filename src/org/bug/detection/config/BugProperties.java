/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bug.detection.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openide.util.Exceptions;

/**
 * This class singleton instance access bug.properties file.
 * @author karayel
 */
public class BugProperties {
    private static Properties properties;

    private BugProperties() {
    }

    public static Properties getInstance() {
        InputStream input = null;
        if (properties == null) {
            try {
                properties = new Properties();
                input = ImageProperties.class.getClassLoader().getResourceAsStream("resources/bug.properties");
                if (input == null) {
                    return null;
                }
                properties.load(input);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return properties;
    }
}
