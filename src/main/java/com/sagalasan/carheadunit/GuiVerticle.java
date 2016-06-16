package com.sagalasan.carheadunit;

import com.sagalasan.headunit.core.Address;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by christiaan on 6/15/16.
 */
public class GuiVerticle extends AbstractVerticle
{
  @Override
  public void start(Future<Void> startFuture)
  {
    System.out.println("start()");
    vertx.setTimer(2000, handler ->
    {
      System.out.println("After 2000");
    });

    vertx.eventBus().consumer(Address.CURRENT_TIME_SERVICE, handler -> System.out.println(handler.body()));

    startFuture.complete();
  }
}
