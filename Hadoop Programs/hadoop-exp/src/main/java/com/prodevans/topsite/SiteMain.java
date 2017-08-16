package com.prodevans.topsite;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class SiteMain {
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Get Top Site");
		job.setJarByClass(SiteMain.class);
		job.setMapperClass(SiteMapper.class);
		job.setReducerClass(SiteReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileSystem fs = FileSystem.get(conf);
		Path rawfilepath = new Path(args[0]);
		Path mapperOutFilePath = new Path(args[1]);

		if (fs.exists(mapperOutFilePath)) {
			fs.delete(mapperOutFilePath);
		}
		
		FileInputFormat.addInputPath(job, rawfilepath);
		FileOutputFormat.setOutputPath(job, mapperOutFilePath);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
