package com.prodevans.hadoop.reducer_join;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String record[] = value.toString().split(",",-1);
		
		String dept_id = record[0];
		
		context.write(new Text(dept_id), new Text("dept,"+value.toString()));
	}

}
