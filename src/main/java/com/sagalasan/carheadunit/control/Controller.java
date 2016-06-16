package com.sagalasan.carheadunit.control;

import com.google.inject.Inject;
import com.sagalasan.carheadunit.service.ServiceManager;
import com.sagalasan.carheadunit.service.listener.CurrentTimeListener;

/**
 * Created by christiaan on 6/11/16.
 */
public class Controller
{
  private ServiceManager serviceManager;

  private CurrentTimeListener currentTimeListener;

  public void onCurrentTimeReceived(long time) { }

  public void stopController()
  {
    serviceManager.unRegisterCurrentTimeListener(currentTimeListener);
  }

  @Inject
  public void setServiceManager(ServiceManager serviceManager)
  {
    this.serviceManager = serviceManager;
    currentTimeListener = serviceManager.registerCurrentTimeListener(this::onCurrentTimeReceived);
  }

  public ServiceManager getServiceManager()
  {
    return serviceManager;
  }
}
