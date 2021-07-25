/*
 * BusinessDelegate.java
 *
 * Created on March 9, 2006, 4:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.delegate;

import org.reubo.dashboard.services.cache.*;
import java.awt.image.*;
import org.reubo.dashboard.services.charting.*;
import java.util.*;
import java.io.*;
import org.reubo.dashboard.services.persistence.*;
import org.reubo.dashboard.services.reporting.*;
import org.reubo.dashboard.services.templating.*;
import org.reubo.dashboard.constants.*;
import org.reubo.dashboard.services.categorymanagement.*;
import org.reubo.dashboard.services.personalization.*;
import org.reubo.dashboard.valueobject.*;
/**
 *
 * @author bhagvank
 */
public class BusinessDelegate {
    
    private ICache cachingService;
    private ITemplatingService templatingService;
    private IReportingService reportingService;
    private IChartingService chartingService;
    private IRiskDashboardManager riskDashboardManager;
    private ICategoryGroupManager categoryGroupManager;
    private IPersonalizationManager personalizationManager;
    
    public Map getHits(String period,String portletName)
    {
      return  riskDashboardManager.getHits(period,portletName);
    }
    public List getLayouts()
    {
        return getPersonalizationManager().getLayouts();
    }
    public List getPortlets()
    {
        return getPersonalizationManager().getPortlets();
    }
    
    public List getPreferences()
    {
        return getPersonalizationManager().getPreferences();
    }
    
    public Map getPreferenceValues(String reviewerId,String pageId,String portletName)
    {
        return getPersonalizationManager().getPreferenceValues(reviewerId,pageId,portletName);
    }
    
    public void setPreferenceValues(String reviewerId,String pageId,String portletName,Map preferences)
    {
        getPersonalizationManager().setPreferenceValues(reviewerId,pageId,portletName,preferences);
    }
    public List getCategoryGroups()
    {
        return categoryGroupManager.getAllCategoryGroups();
    }
    public List getCategoriesByGroup(String categoryGroup)
    {
        return new ArrayList(categoryGroupManager.getCategoriesByGroup(categoryGroup));
    }
    public List getMessageList(Map preferences,String portletName,String categoryName)
    {
        //String categoryName =(String) preferences.get("category"); 
        Map dataMap = getData(preferences,portletName,categoryName);
        
        ITemplatingService service = getTemplatingService(portletName);
        try
        {
          List list = service.getMessagesFromTemplate(dataMap,categoryName);
          return list;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }
    
    public String getPortletChart(Map preferences,String portletName,String period,String chartType,String categoryGroup)
    { 
        // todo reviewerName needs to be added
           String cacheKey =portletName+period+chartType+categoryGroup;
           
           if(preferences != null)
           {
               Iterator iterator = preferences.keySet().iterator();
               
               while(iterator.hasNext())
               {
                   String key = (String) iterator.next();
                   String value = (String)  preferences.get(key);
                   if(value != null)
                   cacheKey +=value;
               }
           }
      
           String cacheValue = (String) cachingService.getCachedObject(cacheKey);
        //TODO figure out when cache changes
        if( cacheValue == null)
         {
         Map dataMap = getData(preferences,portletName,period,categoryGroup);
         System.out.println(dataMap);
         IChartingService service = getChartingService();
         String link = service.getLink(preferences,portletName,period,dataMap,chartType,categoryGroup);
         cachingService.putCachedObject(new String(cacheKey),link);
         return link;
        }
        else
       {
            return cacheValue;
        }
    }
    
     public ByteArrayOutputStream getPortletReport(Map preferences,String portletName)
     {
         try
         {
             IReportingService service = getReportingService();
             return service.loadXML(null,null);
         }
         catch(Exception exception)
         {
             exception.printStackTrace();
         }
         return null;
     }
    public Map getData(Map preferences,String portletName,String period,String categoryGroup)
    {
        IRiskDashboardManager manager = getRiskDashboardManager();
        String reviewerName = "Administrator";
        
        List categoriesList = getCategoriesByGroup(categoryGroup);
        String categoriesStr = null;
        if(!categoryGroup.equals(IPageConstants.THREE_SIXTY_DEGREES))
        {
            categoriesStr="(";
        for(int i=0;i<categoriesList.size();i++)
        {
            Category category = (Category) categoriesList.get(i);
            String catId = category.getCategoryId();
            if(i != categoriesList.size()-1)
            {
             categoriesStr+= catId+",";
            }
            else
            {
                categoriesStr+= catId;
            }
            
        }
        categoriesStr+=")";
        System.out.println(categoryGroup+"::"+categoriesStr);
        }
        if(portletName.equals(IPortletNames.CATEGORY_COMBINATION))
        {
            
            return  manager.getAllCategories();
        }
       else if( portletName.equals(IPortletNames.USER_COUNT))
       {
            return manager.getUserCount(preferences,reviewerName,period,categoriesStr);
       } 
        else if( portletName.equals(IPortletNames.CATEGORY_COUNT))
       {
            return manager.getCategoryCount(preferences,reviewerName,period,categoriesStr);
       }
        else if( portletName.equals(IPortletNames.SRC_COUNT))
       {
            return manager.getSourceCount(preferences,reviewerName,period,categoriesStr);
       }
        else if( portletName.equals(IPortletNames.DEST_COUNT))
       {
            return manager.getDestinationCount(preferences,reviewerName,period,categoriesStr);
       }
         else if( portletName.equals(IPortletNames.PROTOCOLS))
       {
            return manager.getProtocolCount(preferences,reviewerName,period,categoriesStr);
       }
        return null;
        
    }
    public Map getData(Map preferences,String portletName,String categoryName)
    {
            IRiskDashboardManager manager = getRiskDashboardManager();
            return  manager.getDataForMessages(categoryName);
    }
    public BufferedImage getChart(String portletName)
    {
        IChartingService service = getChartingService();
       // service.getImage(portletName,"database");
        return null;
    }
    
    public IChartingService getChartingService()
    {
       return chartingService;
    }
    
    public ICache getCachingService()
    {
        return cachingService;
    }
    
     public IReportingService getReportingService()
    {
        return reportingService;
        
    }
    
    public IRiskDashboardManager getRiskDashboardManager()
    {
          return riskDashboardManager;
    }
    
   
    public ITemplatingService getTemplatingService(String portletName)
    {
        
        return templatingService;
    }
    
    public void setTemplatingService(ITemplatingService templatingService)
    {
        this.templatingService = templatingService;
    }
    
    public void setReportingService(IReportingService reportingService)
    {
        this.reportingService = reportingService;
    }
    
    public void setCachingService(ICache cachingService)
    {
        this.cachingService = cachingService;
    }
    public void setRiskDashboardManager(IRiskDashboardManager riskDashboardManager)
    {
        this.riskDashboardManager = riskDashboardManager;
    }
    public void setChartingService(IChartingService chartingService)
    {
        this.chartingService = chartingService;
    }
    
    public void setCategoryGroupManager(ICategoryGroupManager categoryGroupManager)
    {
        this.categoryGroupManager = categoryGroupManager;
    }
    
    public ICategoryGroupManager getCategoryGroupManager()
    {
        return categoryGroupManager;
    }

    public IPersonalizationManager getPersonalizationManager() {
        return personalizationManager;
    }

    public void setPersonalizationManager(IPersonalizationManager personalizationManager) {
        this.personalizationManager = personalizationManager;
    }
}
