package com.practice.m.top.k.element;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			
		}

		public int distanceFromOrigin(){
			return (x * x ) + (y * y);
		}
	}
public class CKClosestPointToOrigin {

	public static void main(String[] args) {

		Point[] points = new Point[] {new Point(1, 3), new Point(3, 4), new Point(2, -1)};
		List<Point> result = CKClosestPointToOrigin.kClosestPointToOrigin(points, 2);
		System.out.println("Here are the k closest points to Origin");
		for(Point res : result) {
			System.out.print("[" + res.x + ", " + res.y + "] ");
		}
		System.out.println();
		Point[] points1 = new Point[] {new Point(1, 2), new Point(3, 4), new Point(2, -1), new Point(1, 1)};
		result = CKClosestPointToOrigin.kClosestPointToOrigin(points1, 3);
		System.out.println("Here are the k closest points to Origin");
		for(Point res : result) {
			System.out.print("[" + res.x + ", " + res.y + "] ");
		}

	}

	private static List<Point> kClosestPointToOrigin(Point[] points, int k) {
		PriorityQueue<Point> minHeap = new PriorityQueue<Point>((p1, p2) -> p1.distanceFromOrigin() - p2.distanceFromOrigin());
		
		for (int i = 0; i < k; i++) {
			minHeap.offer(points[i]);
		}
		for (int i = k; i < points.length; i++) {
			if(minHeap.peek().distanceFromOrigin() > points[i].distanceFromOrigin()) {
				minHeap.poll();
				minHeap.add(points[i]);
			}
		}
		return new ArrayList<>(minHeap);
	}

}
