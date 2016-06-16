package com.sagalasan.carheadunit.service;

import io.vertx.core.AbstractVerticle;

/**
 * Created by christiaan on 6/15/16.
 */
public class CurrentTimeService extends AbstractVerticle
{
  private long timerId;

  @Override
  public void start()
  {
    timerId = vertx.setPeriodic(1000, handler -> vertx.eventBus().publish(this.getClass().getName(), System.currentTimeMillis()));
  }

  @Override
  public void stop()
  {
    vertx.cancelTimer(timerId);
  }
}
