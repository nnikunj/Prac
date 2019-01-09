package com.paranike.common;

@FunctionalInterface
public interface NodeInfoProcessor<T> {

	public void processNode(T nodeInfo);
}
