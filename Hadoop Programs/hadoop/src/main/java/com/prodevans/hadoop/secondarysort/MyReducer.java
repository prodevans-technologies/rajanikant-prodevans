package com.prodevans.hadoop.secondarysort;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<MyKey, Text, Text, NullWritable> {

	@Override
	protected void reduce(MyKey arg0, Iterable<Text> values, Reducer<MyKey, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		for(Text val : values) {
			context.write(val, NullWritable.get());
		}
	}

}
