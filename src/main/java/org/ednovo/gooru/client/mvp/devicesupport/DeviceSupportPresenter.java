/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.devicesupport;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.mvp.search.event.SetDeviceDetailsEvent;
import org.ednovo.gooru.client.mvp.search.event.SetDeviceDetailsHandler;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

/**
 * 
 * @fileName : DeviceSupportPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 07-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class DeviceSupportPresenter extends Presenter<IsDeviceSupportView, DeviceSupportPresenter.IsDeviceSupportProxy>{
    
    @ProxyCodeSplit
    @NameToken(PlaceTokens.DEVICE_NOT_SUPPORTED)
    public interface IsDeviceSupportProxy extends ProxyPlace<DeviceSupportPresenter> {
    }
    /**
     * Class constructor
     * @param view instance of {@link View}
     * @param proxy instance of {@link Proxy}
     */
    @Inject
    public DeviceSupportPresenter(EventBus eventBus, IsDeviceSupportView view, IsDeviceSupportProxy proxy) {
        super(eventBus, view, proxy);
        
        addRegisteredHandler(SetDeviceDetailsEvent.TYPE, new SetDeviceDetailsHandler() {
            
            @Override
            public void setDeviceDetails(String device, String size) {
                getDeviceDetails(device, size);
            }
        });
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }
    /**
     * 
     * @function getDeviceDetails 
     * 
     * @created_date : 07-Dec-2014
     * 
     * @description
     * 
     * 
     * @parm(s) : @param device
     * @parm(s) : @param size
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
    public void getDeviceDetails(String device, String size){
        
        getView().writeToConsole("device : "+device);
        getView().writeToConsole("size : "+size);
        
        getView().setDevice(device);
        getView().setSize(size);
    }
    
}
