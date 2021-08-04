package org.apache.spark

import org.apache.spark.util.ClosureCleaner

object Closurist {

  def clean(t: AnyRef) = {
    ClosureCleaner.clean(t)
  }

//  def proxy(t: AnyRef) = {
//    ClosureCleaner.
//  }

}
