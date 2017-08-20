package com.prodevans.hadoop.secondarysort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class MyKey implements WritableComparable<MyKey> {
	private Text year;
	private Text total_marks;
	public MyKey() {
		super();
		this.year = new Text();
		this.total_marks = new Text();
	}
	public Text getYear() {
		return year;
	}
	public void setYear(Text year) {
		this.year = year;
	}
	public Text getTotal_marks() {
		return total_marks;
	}
	public MyKey(Text year, Text total_marks) {
		super();
		this.year = year;
		this.total_marks = total_marks;
	}
	public void setTotal_marks(Text total_marks) {
		this.total_marks = total_marks;
	}
	public void readFields(DataInput in) throws IOException {
		this.year.readFields(in);
		this.total_marks.readFields(in);
		
	}
	public void write(DataOutput out) throws IOException {
		this.year.write(out);
		this.total_marks.write(out);
		
	}
	public int compareTo(MyKey o) {
		if(Integer.parseInt( o.getYear().toString()) > Integer.parseInt( year.toString()) ) {
			return 1;
		}
		else if(Integer.parseInt( o.getYear().toString()) == Integer.parseInt( year.toString()) ) {
			if(Integer.parseInt( o.getTotal_marks().toString()) > Integer.parseInt(total_marks.toString()) ) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
	

}
