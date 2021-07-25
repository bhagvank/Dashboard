/*
 * ServiceLocator.java
 *
 * Created on March 28, 2006, 2:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.delegate;

import org.reubo.dashboard.services.cache.*;
import org.reubo.dashboard.services.charting.*;
import java.util.*;
import java.io.*;
import org.reubo.dashboard.services.persistence.*;
import org.reubo.dashboard.services.reporting.*;
import org.reubo.dashboard.services.templating.*;
import org.reubo.dashboard.constants.*;

/**
 *
 * @author bhagvank
 */
public class ServiceLocator {
    
    private static ServiceLocator serviceLocator = new ServiceLocator();
    /** Creates a new instance of ServiceLocator */
    private ServiceLocator() {
    }
    
    public static ServiceLocator getServiceLocator()
    {
        return serviceLocator;
        
    }
    public IChartingService getChartingService(String portletName)
    {
        //u can use factory or strategy pattern to locate charting service
        IChartingService service = new JFreeChartServiceImpl();
        return service;   
    }
    
    public ICache getCachingService()
    {
        ICache cache = new CacheImpl();
        return cache;
    }
    
     public IReportingService getReportingService(String portletName)
    {
        IReportingService service = new JasperReportingService();
        return service;
    }
    
    public IRiskDashboardManager getRiskDashboardManager()
    {
        IRiskDashboardManager manager = new RiskDashboardManager();
        return manager;
    }
    
     public ITemplatingService getTemplatingService(String portletName)
    {
        ITemplatingService service = new TemplatingService();
        return service;
    }
}
