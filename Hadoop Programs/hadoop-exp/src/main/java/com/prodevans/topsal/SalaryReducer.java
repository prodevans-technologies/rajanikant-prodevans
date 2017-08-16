package com.prodevans.topsal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SalaryReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text arg0, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
		
		HashMap<Long, String> data =new HashMap<Long,String>();
		
		for (Text val : values) {
			String arr[] = val.toString().split(",");
			data.put(Long.parseLong(arr[3].trim()), val.toString());
		}
		
		ArrayList<Long> keys = new ArrayList<Long>();
		keys.addAll(data.keySet());
		
		Collections.sort(keys, Collections.reverseOrder());
		int count =0;
		while(count != 3) {
			context.write(new Text(keys.get(count).toString()), new Text(data.get(keys.get(count))));
			count ++;
		}
		
		
	}

}
