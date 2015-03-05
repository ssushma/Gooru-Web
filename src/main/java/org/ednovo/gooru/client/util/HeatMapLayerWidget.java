package org.ednovo.gooru.client.util;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.services.Geocoder;
import com.google.gwt.maps.client.services.GeocoderRequest;
import com.google.gwt.maps.client.services.GeocoderRequestHandler;
import com.google.gwt.maps.client.services.GeocoderResult;
import com.google.gwt.maps.client.services.GeocoderStatus;
import com.google.gwt.maps.client.visualizationlib.HeatMapLayer;
import com.google.gwt.maps.client.visualizationlib.HeatMapLayerOptions;
import com.google.gwt.maps.client.visualizationlib.WeightedLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * See <a href=
 * "https://developers.google.com/maps/documentation/javascript/layers#JSHeatMaps"
 * >HeatMapLayer API Doc</a>
 */
public class HeatMapLayerWidget extends Composite {

  private final VerticalPanel pWidget;
  private MapWidget mapWidget;
  private Geocoder geocoder;
  JsArray<WeightedLocation> arrayOfLocations=ArrayHelper.toJsArray(new WeightedLocation[] {});
  int row=0,counter=0;
  public HeatMapLayerWidget() {
    pWidget = new VerticalPanel();
    geocoder = Geocoder.newInstance();
    initWidget(pWidget);
    draw();
  }

  private void draw() {
    pWidget.clear();
    	   drawMap();
  }
 public void renderMap(){
	  // zoom out for the clouds
	 	MapOptions opts = MapOptions.newInstance();
	    opts.setDisableDefaultUi(true);
	    opts.setKeyboardShortcuts(false);
	    opts.setMapTypeControl( false);
	    opts.setPanControl(false);
	    opts.setRotateControl(false);
	    opts.setScaleControl(false);
	    opts.setScrollWheel(false);
	    opts.setZoomControl(false);
	    LatLng center = LatLng.newInstance(40.74, -73.94);
	    opts.setCenter(center);
	    mapWidget = new MapWidget(opts);
	    pWidget.add(mapWidget);
	    mapWidget.setSize("600px", "300px");
	   // mapWidget.fitBounds(processHeatData());
		// create layer
	    HeatMapLayerOptions options = HeatMapLayerOptions.newInstance();
  	    options.setOpacity(0.9);
  	    options.setGradient(getSampleGradient());
  	    options.setMaxIntensity(3);
  	    options.setMap(mapWidget);
  	    options.setRadius(10);
    	HeatMapLayer heatMapLayer = HeatMapLayer.newInstance(options);
    	heatMapLayer.setDataWeighted(arrayOfLocations);
	    // set data
 }
 public LatLngBounds processHeatData(){
	 
	 MVCArray<WeightedLocation> weightedDataPoints = MVCArray.newInstance(arrayOfLocations);
	 LatLngBounds bounds = null;
	 for (int n = 0, len = arrayOfLocations.length(); n < len; n++) {
		 WeightedLocation weightedLocation=arrayOfLocations.get(n);
		 if(bounds==null){
			 addHeadMap(weightedLocation.getLocation(),weightedLocation.getWeight());
			 bounds=LatLngBounds.newInstance(weightedLocation.getLocation(), weightedLocation.getLocation());
		 }
		 bounds.extend(weightedLocation.getLocation());
	 }
	
	 return bounds;
 }
 public void addHeadMap(LatLng latLng, double value) {
	 MVCArray<LatLng> pointarray=MVCArray.newInstance(latLng);
	 	// create layer
	    HeatMapLayerOptions options = HeatMapLayerOptions.newInstance();
	    options.setOpacity(0.9);
	    options.setGradient(getSampleGradient());
	    options.setMaxIntensity(3);
	    options.setMap(mapWidget);
	    options.setRadius(value);
	  
	    HeatMapLayer heatMapLayer = HeatMapLayer.newInstance(options);
	    // set data
	    MVCArray<LatLng> dataPoints = pointarray;
	    heatMapLayer.setData(dataPoints);
 }
  private void drawMap() {
		Map<String,String> data=new HashMap<String,String>();
		data.put("Bangalore", "3");
		data.put("Georgia", "500");
		data.put("New York", "300");
		data.put("Washington", "130");
		data.put("Colorado", "53");
		data.put("New Delhi", "953");
		GeocoderRequest geocoderRequest=GeocoderRequest.newInstance();
		for(final Map.Entry<String, String> graphVal : data.entrySet()){
			counter++;
			geocoderRequest.setAddress(graphVal.getKey());
			geocoder.geocode(geocoderRequest, new GeocoderRequestHandler() {
				@Override
				public void onCallback(JsArray<GeocoderResult> results,GeocoderStatus status) {
					WeightedLocation weighLocation=WeightedLocation.newInstance(results.get(0).getGeometry().getLocation(), Double.parseDouble(graphVal.getValue()));
					arrayOfLocations.set(row, weighLocation);
					row++;
					counter--;
					if(counter==0){
						renderMap();
					}
				}
			});
		}
  }

  /**
   * Sample gradient from <a href=
   * "https://google-developers.appspot.com/maps/documentation/javascript/examples/layer-heatmap"
   * >Google Maps Example</a>
   * 
   * @return
   */
  private JsArrayString getSampleGradient() {
    String[] sampleColors = new String[] { "rgba(0, 255, 255, 0)", "rgba(0, 255, 255, 1)", "rgba(0, 191, 255, 1)",
        "rgba(0, 127, 255, 1)", "rgba(0, 63, 255, 1)", "rgba(0, 0, 255, 1)", "rgba(0, 0, 223, 1)",
        "rgba(0, 0, 191, 1)", "rgba(0, 0, 159, 1)", "rgba(0, 0, 127, 1)", "rgba(63, 0, 91, 1)", "rgba(127, 0, 63, 1)",
        "rgba(191, 0, 31, 1)", "rgba(255, 0, 0, 1)" };
    return ArrayHelper.toJsArrayString(sampleColors);
  }

  /**
   * Sample spatial data from <a href=
   * "https://google-developers.appspot.com/maps/documentation/javascript/examples/layer-heatmap"
   * >Google Maps Example</a>
   * 
   * @return
   */
  private JsArray<LatLng> getSampleData() {
    // save a ton of space by encoding as a string
    String encodedData = "";
    return decodePath(encodedData);
  }
  /**
   * Decodes an encoded path string into a sequence of LatLngs.
   * 
   * @param encodedPath
   */
  public final static native JsArray<LatLng> decodePath(String encodedPath) /*-{
    var taxiData = [
  new  $wnd.google.maps.LatLng(37.782551, -122.445368),
  new  $wnd.google.maps.LatLng(37.782745, -122.444586),
  new  $wnd.google.maps.LatLng(37.800345, -122.422649),
  new  $wnd.google.maps.LatLng(37.799633, -122.422603),
  new  $wnd.google.maps.LatLng(37.799750, -122.421700),
  new  $wnd.google.maps.LatLng(37.799885, -122.420854),
  new  $wnd.google.maps.LatLng(37.773021, -122.413009),
  new  $wnd.google.maps.LatLng(37.772501, -122.412371),
  new  $wnd.google.maps.LatLng(37.771964, -122.411681),
  new  $wnd.google.maps.LatLng(37.751266, -122.403355)
	];
	return taxiData;
  }-*/;
  /**
   * Get (randomly_ weighted spatial data for use in tests
   * 
   * @return
   */
  @SuppressWarnings("unused")
  // here as an example of WeightedDataPoints
  private JsArray<WeightedLocation> getSampleWeightedData() {
    JsArray<LatLng> samplePoints = getSampleData();
    JsArray<WeightedLocation> sampleLocations = ArrayHelper.toJsArray(new WeightedLocation[] {});
    for (int n = 0, len = samplePoints.length(); n < len; n++) {
      sampleLocations.push(WeightedLocation.newInstance(samplePoints.get(n), 10 * Math.random()));
    }
    return sampleLocations;
  }

}