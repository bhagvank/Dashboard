/*
 * DashboardController.java
 *
 * Created on April 4, 2006, 1:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.dashboard.controller;

import org.reubo.dashboard.constants.IChartConstants;
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

import org.springframework.web.bind.RequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import org.reubo.dashboard.delegate.BusinessDelegate;
import org.reubo.dashboard.constants.*;
import org.reubo.dashboard.valueobject.*;
/**
 *
 * @author bhagvank
 */
public class DashboardController extends MultiActionController{
    
    private BusinessDelegate delegate;
    /** Creates a new instance of DashboardController */
    public DashboardController() {
    }
    
    public ModelAndView handleWelcome(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
               System.out.println("inside handleWelcome");
               
		return new ModelAndView("welcome",new HashMap());
	}
    
    public ModelAndView handleNewPortlets(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
               System.out.println("inside handle New Portlets");
               
               String portletName = request.getParameter("portletName");
               String period = request.getParameter("period");
               String categoryGroup = request.getParameter("categoryGroup");
               Map preferences = (Map) request.getAttribute("preferences");
               String chartType = request.getParameter(IPreferences.CHART_TYPE);
               String fieldCount = request.getParameter(IPreferences.FIELD_COUNT);
               String sortOrder = request.getParameter(IPreferences.SORT_ORDER);
               
               if(preferences == null)
               {
                   preferences = new HashMap();
                   preferences.put(IPreferences.FIELD_COUNT,fieldCount);
                   preferences.put(IPreferences.SORT_ORDER,sortOrder);
                   preferences.put(IPreferences.CHART_TYPE,chartType);
               }
               String link = null;
               Map dataMap = null;
               Map hitMap = null;
               if(portletName != null)
               {
                   hitMap = delegate.getHits(period,portletName);
               if(!chartType.equals(IChartConstants.TABLE_VIEW))
               {
                 link = delegate.getPortletChart(preferences,portletName,period,chartType,categoryGroup);
               }
               else
               {
                   dataMap = delegate.getData(preferences,portletName,period,categoryGroup);
               }
               }
               HashMap map = new HashMap();
               map.put("image",link);
               map.put("portletName",portletName);
               map.put("period",period);
               map.put("categoryGroup",categoryGroup);
               map.put("chartType",chartType);
               map.put("dataMap",dataMap);
               map.put("fieldCount",fieldCount);
               map.put("sortOrder",sortOrder);
               map.put("hitMap",hitMap);
		return new ModelAndView("ViewNewPortlets","model",map);
	}
    public ModelAndView handleAlerts(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
		return new ModelAndView("ViewAlerts",new HashMap());
	}
    public ModelAndView handleTrends(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
		return new ModelAndView("ViewHighLevelTrends",new HashMap());
	}
    public ModelAndView handleReports(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
		return new ModelAndView("ViewNewReports",new HashMap());
	}
     public ModelAndView handleHeader(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
                Map map = new HashMap();
               map.put("categoryGroups",delegate.getCategoryGroups());
		return new ModelAndView("header","model",map);
	}
     
    public ModelAndView handlePreferences(HttpServletRequest request, HttpServletResponse response)
    {
          Map map = new HashMap();
            map.put("layouts",delegate.getLayouts());
            map.put("portlets",delegate.getPortlets());
            map.put("preferences",delegate.getPreferences());
         //   map.put("values",delegate.getPreferenceValues());
            Map prefs = new HashMap();
            List list = delegate.getPreferences();
            for(int i=0; i< list.size();i++)
            {
                Preference preference = (Preference) list.get(i);
                prefs.put(preference.getName(),preference.getId());
            }
            
         String action = request.getParameter("action");
         
         if(action != null && action.equals("update"))
         {
            String layout = request.getParameter("layout");
            String portlet = request.getParameter("portlet");
            String viewType = request.getParameter("viewType");
            String fieldCount = request.getParameter("fieldCount");
            String categoriesList = request.getParameter("categoriesList");
            Map preferences = new HashMap();
            preferences.put(prefs.get("viewType"),viewType);
            preferences.put(prefs.get("fieldCount"),fieldCount);
            preferences.put(prefs.get("categoriesList"),categoriesList);
            
            System.out.println(preferences);
            delegate.setPreferenceValues("1",layout,portlet,preferences);
         }
            return new ModelAndView("Preferences","model",map);
    }
     
     /* public ModelAndView handleRequest(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
            
                Map map = new HashMap();
               // map.put("list",baseDAO.getList());
                ArrayList list = new ArrayList();
                list.add("test1"); 
                list.add("test2");
                list.add("test3");
                list.add("test4");
                map.put("list", list);
                map.put("now", "sfsadk");
            
		return new ModelAndView("test", "model", map);
                
              //  return new ModelAndView()
                
	} */
     
        public void setDelegate(BusinessDelegate delegate)
        {
            this.delegate = delegate;
        }
        public BusinessDelegate getDelegate()
        {
            return delegate;
        }
}
