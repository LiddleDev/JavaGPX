package com.craygl.javagpx.types;

import org.w3c.dom.Node;

public class Extensions {
	Node extensionsNode;
	
	public Extensions (Node extensionsNode) {
		this.extensionsNode = extensionsNode;
	}
	
	public Node getExtensionsNode() {
		return extensionsNode;
	}
	
	public void setExtensionsNode(Node extensionsNode) {
		this.extensionsNode = extensionsNode;
	}
}
