package com.prodevans.hadoop.map.join;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {
	public static void main(String args[]) throws Exception {
		Configuration conf = new Configuration();
		
		DistributedCache.addCacheFile(new URI(args[2]), conf);
		
		
		Job job = Job.getInstance(conf, "Map Join");
		job.setJarByClass(Main.class);
		job.setMapperClass(DeptMapper.class);
		job.setNumReduceTasks(0);
		
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		FileSystem fs = FileSystem.get(conf);
		Path rawfilepath = new Path(args[0]);
		Path mapperOutFilePath = new Path(args[1]);
		if (fs.exists(mapperOutFilePath)) {
			fs.delete(mapperOutFilePath,true);
		}
		FileInputFormat.addInputPath(job, rawfilepath);
		FileOutputFormat.setOutputPath(job, mapperOutFilePath);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
