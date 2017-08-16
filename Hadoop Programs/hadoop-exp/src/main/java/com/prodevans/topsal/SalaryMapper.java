package com.prodevans.topsal;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



/**
 * @author rajanikant
 *
 */
public class SalaryMapper extends Mapper<LongWritable	, Text, Text, Text> {



	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String token[] = value.toString().split(",");
		
		
		Text emp_dept = new Text(token[2]);
		context.write(emp_dept, value);
		
	}

	
	

}
