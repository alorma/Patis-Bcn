package com.alorma.patisbcn.data;

import android.os.Handler;
import android.os.Looper;

public class UIThread implements PostExecutionThread {

  private static class LazyHolder {
    private static final UIThread INSTANCE = new UIThread();
  }

  public static UIThread getInstance() {
    return LazyHolder.INSTANCE;
  }

  private final Handler handler;

  private UIThread() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  /**
   * Causes the Runnable r to be added to the message queue.
   * The runnable will be run on the main thread.
   *
   * @param runnable {@link Runnable} to be executed.
   */
  @Override
  public void post(Runnable runnable) {
    handler.post(runnable);
  }
}