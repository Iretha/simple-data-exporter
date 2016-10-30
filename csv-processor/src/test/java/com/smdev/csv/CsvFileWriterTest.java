package com.smdev.csv;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smdev.model.Table;

public class CsvFileWriterTest {

	private String destinationDir = null;
	private Table table = null;
	private CsvFileWriter writer = null;

	@Before
	public void setUp() {
		this.writer = new CsvFileWriter();
		File file = new File(getClass().getResource("files/comma.csv").getFile());
		CsvProps props = new CsvProps();
		props.setSeparator(',');
		try {
			this.table = new CsvFileReader().read(props, file);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		File dir = new File(getClass().getResource("files").getFile());
		this.destinationDir = dir.getAbsolutePath();
	}
	
	@Test
	public void testWriteCsvWithComma() {

		try {
			CsvProps props = new CsvProps();
			props.setName(this.destinationDir + "/comma2");
			props.setSeparator(',');
			props.setExportHeaders(true);
			//props.setEscape('\'');
			
			File file = this.writer.write(props, this.table);
			System.out.println("File => " + file.getAbsolutePath());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteCsvWithSemicolon() {

		try {
			CsvProps props = new CsvProps();
			props.setName(this.destinationDir + "/semicolon");
			props.setSeparator(';');
			props.setExportHeaders(true);
			props.setEscape('\'');
			
			File file = this.writer.write(props, this.table);
			System.out.println("File => " + file.getAbsolutePath());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testWriteCsvWithTab() {

		try {
			CsvProps props = new CsvProps();
			props.setName(this.destinationDir + "/tab");
			props.setSeparator('\t');
			props.setExportHeaders(true);
			
			File file = this.writer.write(props, this.table);
			System.out.println("File => " + file.getAbsolutePath());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testWriteTxtWithComma() {

		try {
			CsvProps props = new CsvProps();
			props.setName(this.destinationDir + "/comma");
			props.setSeparator(',');
			props.setExportHeaders(true);
			props.setTxtFileType(true);
			
			File file = this.writer.write(props, this.table);
			System.out.println("File => " + file.getAbsolutePath());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
