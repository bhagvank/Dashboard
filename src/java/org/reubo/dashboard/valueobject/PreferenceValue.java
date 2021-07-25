/*
 * PreferenceValue.java
 *
 * Created on April 14, 2006, 10:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.valueobject;

/**
 *
 * @author bhagvank
 */
public class PreferenceValue {
    private String value;
    private PreferenceValueId valueId;
    /**
     * Creates a new instance of PreferenceValue
     */
    public PreferenceValue() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PreferenceValueId getValueId() {
        return valueId;
    }

    public void setValueId(PreferenceValueId valueId) {
        this.valueId = valueId;
    }

}
