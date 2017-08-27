package com.prodevans.hadoop.map.join;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text> {
	private HashMap<String, String> DepartmentMap = new HashMap<String, String>();
	private BufferedReader br = null;
	private String strDeptName = "";
	private Text MapOutputKey = new Text("");
	private Text MapOutputValue = new Text("");

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		if (value.toString().length() > 0) {
			String arrEmpAttributes[] = value.toString().trim().split(",", -1);
			try {
				strDeptName = DepartmentMap.get(arrEmpAttributes[2].toString().trim());

			} finally {
				strDeptName = ((strDeptName.isEmpty()) || strDeptName.equals(null) ? "NOT-FOUND" : strDeptName);

			}

			MapOutputKey.set(arrEmpAttributes[0].toString());

			MapOutputValue.set(arrEmpAttributes[0].trim() + "," + arrEmpAttributes[1].trim() + "," + strDeptName + ","
					+ arrEmpAttributes[3].trim());
			
			
		}
		context.write(MapOutputKey, MapOutputValue);
		strDeptName = "";
		
	}

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		Path[] cacheFile = DistributedCache.getLocalCacheFiles(context.getConfiguration());

		for (Path path : cacheFile) {
			if (path.getName().toString().trim().equals("map_dept.txt")) {
				loadDepartmentHashMap(path, context);
			}
		}
	}

	private void loadDepartmentHashMap(Path path, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String strLineRead = "";
		try {
			br = new BufferedReader(new FileReader(path.toString()));

			while ((strLineRead = br.readLine()) != null) {
				String deptFieldArray[] = strLineRead.split(",");
				DepartmentMap.put(deptFieldArray[0].trim(), deptFieldArray[1].trim());
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

}
