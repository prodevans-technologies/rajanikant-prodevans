package com.prodevans.hadoop.secondarysort;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class MyReducer extends Reducer<MyKey, Text, Text, NullWritable> {

	private MultipleOutputs<Text, NullWritable> mul = null;

	@Override
	protected void reduce(MyKey key, Iterable<Text> values, Reducer<MyKey, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		int year = Integer.parseInt(key.getYear().toString().trim());

		for (Text val : values) {
			if (year == 2014) {
				mul.write("Year2014", val, NullWritable.get());
			}
			else if (year == 2016) {
				mul.write("Year2016", val, NullWritable.get());
			}
			else if (year == 2015) {
				mul.write("Year2015", val, NullWritable.get());
			}
			else {
				mul.write("ErrorRecord", val, NullWritable.get());
			}
			// context.write(val, NullWritable.get());
		}
	}

	@Override
	protected void cleanup(Reducer<MyKey, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		if (mul != null) {
			mul.close();
		}
	}

	@Override
	protected void setup(Reducer<MyKey, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		mul = new MultipleOutputs<Text, NullWritable>(context);
	}

}
