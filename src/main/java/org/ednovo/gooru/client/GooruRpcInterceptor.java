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

package org.ednovo.gooru.client;


import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;
import com.google.gwt.user.client.rpc.impl.Serializer;


public class GooruRpcInterceptor extends RemoteServiceProxy{
	
	private boolean isLoginCall=false;

	/**
     * Instantiates a new rpc service interceptor.
     *
     * @param moduleBaseURL the module base url
     * @param remoteServiceRelativePath the remote service relative path
     * @param serializationPolicyName the serialization policy name
     * @param serializer the serializer
     */
    public GooruRpcInterceptor(String moduleBaseURL, String remoteServiceRelativePath,
                    String serializationPolicyName, Serializer serializer) {
            super(moduleBaseURL, remoteServiceRelativePath, serializationPolicyName, serializer);
    }
    
    /**
     * Do create request callback.
     *
     * @param <T> the generic type
     * @param responseReader the response reader
     * @param methodName the method name
     * @param statsContext the stats context
     * @param callback the callback
     * @return the request callback
     * {@inheritDoc}
     */
    @Override
    protected <T> RequestCallback doCreateRequestCallback(
                    ResponseReader responseReader, String methodName,
                    RpcStatsContext statsContext, AsyncCallback<T> callback) {

            final RequestCallback doCreateRequestCallback = super.doCreateRequestCallback(responseReader, methodName, statsContext, callback);
            RequestCallback wrapped = new RequestCallback() {
                    @Override
                    public void onResponseReceived(Request request, Response response) {
                        doCreateRequestCallback.onResponseReceived(request, response);
                    }
                    @Override
                    public void onError(Request request, Throwable exception) {
                            doCreateRequestCallback.onError(request, exception);
                    }
            };
            return wrapped;
    }
    
    @Override
    protected <T> Request doInvoke(ResponseReader responseReader,
                    String methodName, RpcStatsContext statsContext,
                    String requestData, AsyncCallback<T> callback) {
    				if(methodName.contains("getUserFilterProperties")){
    					return super.doInvoke(responseReader, methodName, statsContext, requestData, callback);
    				}
    				else if(AppClientFactory.loggedInUser==null || AppClientFactory.loggedInUser.getToken()==null){
    					if(methodName.contains("getLoggedInUser")){
							return super.doInvoke(responseReader, methodName, statsContext, requestData, callback);
						}else{
							if(!isLoginCall){
								getLoginDetails();
							}
							return super.doInvoke(responseReader, methodName, statsContext, requestData, callback);
						}
    				}else{
    					return super.doInvoke(responseReader, methodName, statsContext, requestData, callback);
    				}
    }
    
    public <T> void getLoginDetails(){
    	isLoginCall=true;
    	AppClientFactory.getInjector().getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo loggedInUser) {
				AppClientFactory.loggedInUser=loggedInUser;
				AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
			}
		});
    }

	
}
