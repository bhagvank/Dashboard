/*
 * Preference.java
 *
 * Created on April 14, 2006, 10:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.valueobject;

/**
 *
 * @author bhagvank
 */
public class Preference {
    private String id;
    private String name;
    /**
     * Creates a new instance of Preference
     */
    public Preference() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
