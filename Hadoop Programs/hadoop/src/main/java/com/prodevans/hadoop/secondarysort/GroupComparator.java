package com.prodevans.hadoop.secondarysort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComparator extends WritableComparator {

	protected GroupComparator() {
		super(MyKey.class, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(@SuppressWarnings("rawtypes") WritableComparable a, @SuppressWarnings("rawtypes") WritableComparable b) {
		MyKey k1 = (MyKey) a;
		MyKey k2 = (MyKey) b;
		return k1.getYear().compareTo(k2.getYear());
	}

}
