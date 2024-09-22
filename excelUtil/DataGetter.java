package excelUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataGetter {

	String path = "C:\\Users\\ziksypalApi\\ljudi.xlsx";
	ExcelGetter excel = new ExcelGetter(path);
	ExcelConverter ec = new ExcelConverter(excel);

	@DataProvider(name = "provider01")
	public String[][] dataProvideras2Darray() throws IOException {

		return ec.dataAs2dArray();

	}

}
