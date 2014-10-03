package com.cs.euler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public abstract class EulerBase {
	public abstract void resolve();

	public void print(Object... objects) {
		System.out.print(String.format("%-30s: ", this.getClass()
				.getSimpleName()));
		if (objects != null) {
			for (Object obj : objects) {
				System.out.print(obj);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public long[][] loadArrays(String filename) {
		long [][] result=null;
		try (InputStream input = new FileInputStream(filename)) {
			List<String> lines = IOUtils.readLines(input);
			int count=0;
			for(String line:lines){
				String[] numbers = line.split(" ");
				if(numbers.length>count){
					count=numbers.length;
				}
			}
			result=new long[lines.size()][count];
			
			int i=0;
			for(String line:lines){
				String[] numbers = line.split(" ");
				for(int j=0;j<numbers.length;j++){
					result[i][j]=Long.parseLong(numbers[j]);
				}
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

	}
}
