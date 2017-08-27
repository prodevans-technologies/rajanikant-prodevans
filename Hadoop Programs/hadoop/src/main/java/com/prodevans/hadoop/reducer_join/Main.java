package com.prodevans.hadoop.reducer_join;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "word count");
		job.setJarByClass(Main.class);
		
		job.setReducerClass(JoinReducer.class);
		//job.setCombinerClass(JoinReducer.class);
		
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setNumReduceTasks(1);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);

		FileSystem fs = FileSystem.get(conf);
		Path rawfilepath1 = new Path(args[0]);
		Path rawfilepath2 = new Path(args[1]);
		Path mapperOutFilePath = new Path(args[2]);
		
		
		if (fs.exists(mapperOutFilePath)) {
			fs.delete(mapperOutFilePath);
		}
		
		org.apache.hadoop.mapreduce.lib.input.MultipleInputs.addInputPath(job, rawfilepath1, TextInputFormat.class,EmpMapper.class);
		org.apache.hadoop.mapreduce.lib.input.MultipleInputs.addInputPath(job, rawfilepath2, TextInputFormat.class,DeptMapper.class);
		
		FileOutputFormat.setOutputPath(job, mapperOutFilePath);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
