package com.prodevans.topsite;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SiteMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String token[] = value.toString().split(",");
		Text site_name = new Text(token[1]);
		IntWritable site_val = new IntWritable(1);
		context.write(site_name, site_val);
	}

}
