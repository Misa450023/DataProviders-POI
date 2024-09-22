package tests;

import org.testng.annotations.Test;

import excelUtil.DataGetter;

public class TestClass {

	@Test(dataProvider = "provider01", dataProviderClass = DataGetter.class)
	public void test01(String ime, String prezime, String godine, String nacionalnost, String grad) {

		String text = "Ja se zovem " + ime + " a prezivam " + prezime + " imam " + godine + " ,izjasnjavam se kao "
				+ nacionalnost + " moj grad je " + grad;

		System.out.println(text);

	}

}
