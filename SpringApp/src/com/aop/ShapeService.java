package com.aop;

import com.aop.model.Circle;
import com.aop.model.Triangle;

public class ShapeService {
	
	
	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	private Circle circle;
	
	private Triangle triangle;

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	
	
	
	
	

}
