package hive;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class FindDepartment extends UDF {
	Text result_date=new Text() ;
	public Text evaluate(String doj) throws Exception {
			
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_target = new  SimpleDateFormat("yyyy-MMM-dd");
		
		Date date_doj = sdf.parse(doj);
		
		result_date.set(sdf_target.format(date_doj));
		
		return result_date;
	}
}
