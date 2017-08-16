package com.prodevans.topsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SiteReducer extends Reducer<Text, IntWritable, Text, Text> {

	private HashMap<Integer, String> map;
	


	@Override
	protected void setup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		map = new HashMap<Integer, String>();
	}
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		int sum =0 ;
		for(IntWritable val : values)
		{
			sum += val.get();
		}
		
		map.put(sum, key.toString());
	}
	
	
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		ArrayList<Integer > ar = new  ArrayList<Integer>();
		ar.addAll(map.keySet());
		
		Collections.sort(ar, Collections.reverseOrder());
		
		for(Integer in : ar) {
			context.write(new Text(in.toString()),new Text(map.get(in)));
		}
		
	}
	
}
