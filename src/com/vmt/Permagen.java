package com.vmt;

public class Permagen {
    /**
     * http://www.infoq.com/articles/Java-PERMGEN-Removed
     *
     * With the advent of JDK8, we no longer have the PermGen.
     * No, the metadata information is not gone, just that the
     * space where it was held is no longer contiguous to the Java heap.
     * The metadata has now moved to native memory to an area
     * known as the “Metaspace”.
     *
     * The move to Metaspace was necessary since the PermGen was
     * really hard to tune. There was a possibility that the metadata could
     * move with every full garbage collection. Also, it was difficult to
     * size the PermGen since the size depended on a lot of factors such
     * as the total number of classes, the size of the constant pools,
     * size of methods, etc.
     */
}
