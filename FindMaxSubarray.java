package com;

import java.util.*;

public class FindMaxSubarray {

	public ReturnObject findMss(int[] arr, int low, int high) {

		int mid, t;
		if (low == high) {
			ReturnObject obj = new ReturnObject(low, low, arr[low - 1]);
			return obj;
		}

		Double val = Math.floor((low + high) / 2);
		mid = val.intValue();

		ReturnObject objl = findMss(arr, low, mid);
		ReturnObject objr = findMss(arr, mid + 1, high);
		ReturnObject objs = maxSpan(arr, low, mid, high);

		ArrayList<Integer> arl = new ArrayList<Integer>();
		arl.add(objl.t);
		arl.add(objr.t);
		arl.add(objs.t);

		t = Collections.max(arl);

		if (t == objl.t)
			return objl;
		else if (t == objr.t)
			return objr;
		else if (t == objs.t)
			return objs;

		return objs;
	}

	public ReturnObject maxSpan(int[] arr, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE, sum = 0, rightSum = Integer.MIN_VALUE, maxleft = 0, maxright = 0;

		for (int i = mid; i >= low; i--) {
			sum = sum + arr[i - 1];
			if (sum > leftSum) {
				leftSum = sum;
				maxleft = i;
			}
		}

		sum = 0;

		for (int i = mid + 1; i <= high; i++) {
			sum = sum + arr[i - 1];
			if (sum > rightSum) {
				rightSum = sum;
				maxright = i;
			}
		}

		ReturnObject objms = new ReturnObject(maxleft, maxright, leftSum + rightSum);

		return objms;
	}
}