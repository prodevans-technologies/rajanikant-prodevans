package com.prodevans.hadoop.reducer_join;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, NullWritable>{


	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		String dept_name = "";
		/*Iterator<Text> it =arg1.iterator();
		
		while(it.hasNext()) {
			String record[] = it.next().toString().split(",",-1);
			if(record[0].equals("dept")) {
				dept_name = record[2];
				break;
			}
		}*/
		
		
		for(Text it : arg1) {
			String record[] = it.toString().split(",",-1);
			if(record[0].equals("dept")) {
				dept_name = record[2];
				break;
			}
		}
		
		Iterator<Text> it =arg1.iterator();
		while(it.hasNext()) {
			String arr = it.next().toString();
			String record[] = arr.split(",",-1);
			if(record[0].equals("emp")) {
				String new_rec = arr+","+ dept_name;
				
				context.write(new Text(new_rec), NullWritable.get());
				
			}
			else {
				
				context.write(new Text("Error"), NullWritable.get());
				
			}
		}
		
	}

}
