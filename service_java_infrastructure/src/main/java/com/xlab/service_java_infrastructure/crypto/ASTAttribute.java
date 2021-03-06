/*
 * module: fundermental
 * file: ASTAttribute.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

public class ASTAttribute extends SimpleNode {
	private String name;

	public ASTAttribute(int id) {
		super(id);
	}

	public ASTAttribute(ParseTree p, int id) {
		super(p, id);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Attribute: " + name;
	}
}
