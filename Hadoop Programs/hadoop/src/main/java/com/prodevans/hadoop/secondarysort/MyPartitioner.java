package com.prodevans.hadoop.secondarysort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<MyKey, Text> {

	@Override
	public int getPartition(MyKey key, Text value, int numReducerTasks) {
		if (Integer.parseInt(key.getYear().toString()) == 2016) {
			return 0;
		} else if (Integer.parseInt(key.getYear().toString()) == 2015) {
			return 1;
		} else if (Integer.parseInt(key.getYear().toString()) == 2014) {
			return 2;
		} else {
			return 0;
		}
	}

}
