/*
 * PreferenceValueId.java
 *
 * Created on April 14, 2006, 10:59 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.valueobject;

import java.io.*;
/**
 *
 * @author bhagvank
 */
public class PreferenceValueId implements Serializable{
    private int reviewerId;
    private int layoutId;
    private int portletId;
    private int preferenceId;
    /**
     * Creates a new instance of PreferenceValueId
     */
    public PreferenceValueId() {
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = Integer.parseInt(reviewerId);
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = Integer.parseInt(layoutId);
    }

    public int getPortletId() {
        return portletId;
    }

    public void setPortletId(String portletId) {
        this.portletId = Integer.parseInt(portletId);
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = Integer.parseInt(preferenceId);
    }

}
