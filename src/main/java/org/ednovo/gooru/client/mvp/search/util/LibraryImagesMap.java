package org.ednovo.gooru.client.mvp.search.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.Constants;

import com.google.gwt.core.client.GWT;

public class LibraryImagesMap {
	   private static LibraryImagesMap libraryNames =null;
	   static Map<String, List<String>> mapObj=new LinkedHashMap<String, List<String>>();
	   private static MessageProperties i18n = GWT.create(MessageProperties.class);
	   private LibraryImagesMap(){
		   	mapObj.put(PlaceTokens.RUSD_LIBRARY, Arrays.asList(i18n.GL0532(),PlaceTokens.RUSD_LIBRARY,"rusdLogo"));
		   	mapObj.put(PlaceTokens.SAUSD_LIBRARY, Arrays.asList(i18n.GL1898(), PlaceTokens.SAUSD_LIBRARY,"sausdLogo"));
		   	mapObj.put(PlaceTokens.VALVERDE, Arrays.asList(i18n.GL2061(), PlaceTokens.VALVERDE,"valverdeLogo"));
		   	mapObj.put(PlaceTokens.ASPIRE_EPACS, Arrays.asList(i18n.GL3228(),PlaceTokens.ASPIRE_EPACS,"epacsLogo"));
		   	mapObj.put(PlaceTokens.GEOEDUCATION, Arrays.asList(i18n.GL2041(),PlaceTokens.GEOEDUCATION,"natgeoLogo"));
		   	mapObj.put(PlaceTokens.FTE, Arrays.asList(i18n.GL2029(),PlaceTokens.FTE,"fteLogo"));
		   	mapObj.put(PlaceTokens.NGC, Arrays.asList(i18n.GL2030(),PlaceTokens.NGC,"ngcLogo"));
		   	mapObj.put(PlaceTokens.CCST_Cal_TAC, Arrays.asList(i18n.GL2179(),PlaceTokens.CCST_Cal_TAC,"ccstLogo"));
		   	
		   	mapObj.put(PlaceTokens.CORE_LIBRARY, Arrays.asList(i18n.GL2108(),PlaceTokens.CORE_LIBRARY,"coreLogo"));
			mapObj.put(PlaceTokens.LPS, Arrays.asList(i18n.GL2053(), PlaceTokens.LPS,"lpsLogo"));
			mapObj.put(PlaceTokens.LUSD, Arrays.asList(i18n.GL2181(), PlaceTokens.LUSD,"lusdLogo"));			
			mapObj.put(PlaceTokens.SUSD, Arrays.asList(i18n.GL2058(), PlaceTokens.SUSD,"susdLogo"));		 
			mapObj.put(PlaceTokens.AUTODESK, Arrays.asList(i18n.GL2027(),PlaceTokens.AUTODESK,"autodeskLogo"));
			
			
			
			mapObj.put(PlaceTokens.ESYP, Arrays.asList(i18n.GL2174(),PlaceTokens.ESYP,"esypLogo"));
			
			mapObj.put(PlaceTokens.LESSONOPOLY, Arrays.asList(i18n.GL2032(),PlaceTokens.LESSONOPOLY,"lessonopolyLogo"));
			mapObj.put(PlaceTokens.LIFEBOARD, Arrays.asList("Lifeboard",PlaceTokens.LIFEBOARD,"lifeboardLogo"));
			mapObj.put(PlaceTokens.FINCAPINC, Arrays.asList(i18n.GL2033(),PlaceTokens.FINCAPINC,"cfciLogo"));
			
			mapObj.put(PlaceTokens.ONR, Arrays.asList(i18n.GL2028(),PlaceTokens.ONR,"onrLogo"));
			mapObj.put(PlaceTokens.PSDPAL, Arrays.asList(i18n.GL2034(),PlaceTokens.PSDPAL,"psdLogo"));
			mapObj.put(PlaceTokens.TICAL, Arrays.asList(i18n.GL3227(),PlaceTokens.TICAL,"ticalLogo"));
			mapObj.put(PlaceTokens.WSPWH, Arrays.asList(i18n.GL2031(),PlaceTokens.WSPWH,"wspwhLogo"));
			mapObj.put(PlaceTokens.YOUTHVOICES, Arrays.asList(i18n.GL2040(),PlaceTokens.YOUTHVOICES,"youthvoicesLogo"));
	   }
	   public static LibraryImagesMap getInstance( ) {
		   if(libraryNames == null) {
			   libraryNames = new LibraryImagesMap();
		    }
		    return libraryNames;
	   }
	   protected Map<String, List<String>> getLibraryMap() {
		  return mapObj;
	   }
}
