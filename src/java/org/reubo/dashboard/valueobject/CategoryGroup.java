/*
 * CategoryGroup.java
 *
 * Created on April 13, 2006, 10:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.valueobject;

import java.util.*;
/**
 *
 * @author bhagvank
 */
public class CategoryGroup {

    private String id;
    private String name;
    private Set categories;

    /** Creates a new instance of CategoryGroup */
    public CategoryGroup() {
    }

    public String getId()
    {
       return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Set getCategories()
    {
      return categories;
    }

    public void setCategories(Set categories)
    {
        this.categories = categories;
    }
}
